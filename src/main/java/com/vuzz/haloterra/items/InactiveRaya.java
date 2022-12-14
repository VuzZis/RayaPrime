package com.vuzz.haloterra.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.vuzz.haloterra.items.marker.Implant;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class InactiveRaya extends Item implements Implant {

    public int ticks = 0;

	public InactiveRaya() {
		super(
            new Item.Properties()
            .group(RayaMod.MOD_GROUP)
            .defaultMaxDamage(20000)
            .maxDamage(20000)
            .setNoRepair()
            .rarity(Rarity.EPIC)
        );
	}

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int tick, boolean bool) {
        ticks++;
        if(!stack.hasTag()) stack.setTag(new CompoundNBT());
        stack.getTag().putFloat("max_energy",19998f);
        PlayerEntity player = (PlayerEntity) entity;
        if(player.getFoodStats().getFoodLevel() > 1 && stack.getTag().getFloat("energy") < 19950) {
            if(ticks % 400 == 0) {
                stack.getTag().putFloat("energy",stack.getTag().getFloat("energy")+70f);
                player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel()-1);
            }
        }
        if(stack.getTag().getFloat("energy") > stack.getTag().getFloat("max_energy")) stack.getTag().putFloat("energy",stack.getTag().getFloat("max_energy"));
        if(stack.getTag().getFloat("energy") < 0) stack.getTag().putFloat("energy",0);
        stack.setDamage(20000-((int) stack.getTag().getFloat("energy")+1));


        super.inventoryTick(stack, world, entity, tick, bool);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if(context.getWorld().isRemote) return super.onItemUseFirst(stack, context);
        if(context.getPlayer().isSneaking()) 
        {
            if(!stack.hasTag()) stack.setTag(new CompoundNBT());
            CompoundNBT nbt = stack.getTag();
            int anim = nbt.getInt("anim");
            String[] faces = new String[] {
                "anims.haloterra.default",
                "anims.haloterra.uwu",
                "anims.haloterra.error",
                "anims.haloterra.done",
                "anims.haloterra.loading",
                "anims.haloterra.attention",
                "anims.haloterra.sad",
                "anims.haloterra.smug",
                "anims.haloterra.angry",
                "anims.haloterra.wtf",
                "anims.haloterra.happy",
                "anims.haloterra.thinking",
                "anims.haloterra.sad2"
            };
            anim++;
            if(anim >= faces.length) anim = 0;
            nbt.putInt("anim",anim);
            context.getPlayer().sendStatusMessage(
                new StringTextComponent(
                    new TranslationTextComponent("anims.haloterra.anim").getString() + 
                    new TranslationTextComponent(faces[anim]).getString()
                ),
                true
            );
        } 
        else 
        {
            if(!stack.hasTag()) stack.setTag(new CompoundNBT());
            if(!context.getPlayer().getTags().contains("uniquegen")) {
                context.getPlayer().sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".nogen"),Util.DUMMY_UUID);
            } else 
            {
                if(context.getPlayer().isPotionActive(ModEffects.HYBERNATION.get())) return super.onItemUseFirst(stack, context);
                if(stack.getTag().getFloat("energy") < 10) {
                    context.getPlayer().sendStatusMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".notenoughenergy"), true);
                    return super.onItemUseFirst(stack, context);
                }
                EntityType<RayaPrimeEntity> raya = ModEntityTypes.RAYA_PRIME.get();
                RayaPrimeEntity rayaEntity = (RayaPrimeEntity) raya.spawn((ServerWorld) context.getWorld(), stack, context.getPlayer(), context.getPlayer().getPosition(), 
                    SpawnReason.DISPENSER, false, false);
                    
                context.getPlayer().getPersistentData().putBoolean("hasraya", true);
                rayaEntity.getPersistentData().putFloat("energy", stack.getTag().getFloat("energy"));
                rayaEntity.getPersistentData().putFloat("max_energy", stack.getTag().getFloat("max_energy"));
                rayaEntity.getPersistentData().putUniqueId("owneruuid", context.getPlayer().getUniqueID());
                rayaEntity.getPersistentData().putBoolean("canUseEnergy", true);
                rayaEntity.getPersistentData().putInt("anim", stack.getTag().getInt("anim"));
                Minecraft.getInstance().world.getEntityByID(rayaEntity.getEntityId()).getPersistentData().putInt("anim", stack.getTag().getInt("anim"));
                stack.shrink(1);
            }
        }
        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> text,
            ITooltipFlag tooltip) {
        text.add(
            new StringTextComponent(
                new TranslationTextComponent("tooltip.haloterra.name")
                    .getString()
                +"Raya D. Aber"+"\n"+new TranslationTextComponent("tooltip.haloterra.rayaprime").getString()
            )
        );
        super.addInformation(stack, world, text, tooltip);
    }

    
}
