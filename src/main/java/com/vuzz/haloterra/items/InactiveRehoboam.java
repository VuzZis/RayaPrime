package com.vuzz.haloterra.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;

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

public class InactiveRehoboam extends Item implements Implant {

    public int ticks = 0;

	public InactiveRehoboam() {
		super(
            new Item.Properties()
            .group(RayaMod.MOD_GROUP)
            .defaultMaxDamage(100000)
            .maxDamage(100000)
            .setNoRepair()
            .rarity(Rarity.EPIC)
        );
	}

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int tick, boolean bool) {
        ticks++;
        if(!stack.hasTag()) stack.setTag(new CompoundNBT());
        stack.getTag().putFloat("max_energy",99998f);
        PlayerEntity player = (PlayerEntity) entity;
        if(player.getFoodStats().getFoodLevel() > 1 && stack.getTag().getFloat("energy") < 99950) {
            if(ticks % 100 == 0) {
                stack.getTag().putFloat("energy",stack.getTag().getFloat("energy")+1000f);
                player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel()-1);
            }
        }
        if(stack.getTag().getFloat("energy") > stack.getTag().getFloat("max_energy")) stack.getTag().putFloat("energy",stack.getTag().getFloat("max_energy"));
        if(stack.getTag().getFloat("energy") < 0) stack.getTag().putFloat("energy",0);
        stack.setDamage(100000-((int) stack.getTag().getFloat("energy")+1));


        super.inventoryTick(stack, world, entity, tick, bool);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if(context.getWorld().isRemote) return super.onItemUseFirst(stack, context);

        if(context.getPlayer().isSneaking()) 
        {

        } 
        else 
        {
            if(!stack.hasTag()) stack.setTag(new CompoundNBT());
            if(!context.getPlayer().getTags().contains("uniquegen")) {
                context.getPlayer().sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".nogen"),Util.DUMMY_UUID);
            } else 
            {
                if(stack.getTag().getFloat("energy") < 10) {
                    context.getPlayer().sendStatusMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".notenoughenergy"), true);
                    return super.onItemUseFirst(stack, context);
                }
                EntityType<RehoboamEntity> raya = ModEntityTypes.REHOBOAM.get();
                RehoboamEntity rayaEntity = (RehoboamEntity) raya.spawn((ServerWorld) context.getWorld(), stack, context.getPlayer(), context.getPlayer().getPosition(), 
                    SpawnReason.DISPENSER, false, false);
                    
                context.getPlayer().getPersistentData().putBoolean("hasrehoboam", true);
                rayaEntity.getPersistentData().putFloat("energy", stack.getTag().getFloat("energy"));
                rayaEntity.getPersistentData().putFloat("max_energy", stack.getTag().getFloat("max_energy"));
                rayaEntity.getPersistentData().putUniqueId("owneruuid", context.getPlayer().getUniqueID());
                rayaEntity.getPersistentData().putBoolean("canUseEnergy", true);
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
                +"Rehoboam D. Calhoun"
            )
        );
        super.addInformation(stack, world, text, tooltip);
    }

    
}
