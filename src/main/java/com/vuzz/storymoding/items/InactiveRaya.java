package com.vuzz.storymoding.items;

import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.effects.ModEffects;
import com.vuzz.storymoding.entities.ModEntityTypes;
import com.vuzz.storymoding.entities.custom.RayaPrimeEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class InactiveRaya extends Item {

    public int ticks = 0;

	public InactiveRaya() {
		super(
            new Item.Properties()
            .group(StoryModing.MOD_GROUP)
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
        if(player.getFoodStats().getFoodLevel() > 1) {
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

        } 
        else 
        {
            if(!stack.hasTag()) stack.setTag(new CompoundNBT());
            if(/*context.getPlayer().getPersistentData().getBoolean("hasraya")*/false) {
                context.getPlayer().sendMessage(new TranslationTextComponent("message."+StoryModing.MOD_ID+".no_two_rayas"),Util.DUMMY_UUID);
            } else 
            {
                if(context.getPlayer().isPotionActive(ModEffects.HYBERNATION.get())) return super.onItemUseFirst(stack, context);
                if(stack.getTag().getFloat("energy") < 10) {
                    context.getPlayer().sendStatusMessage(new TranslationTextComponent("message."+StoryModing.MOD_ID+".notenoughenergy"), true);
                    return super.onItemUseFirst(stack, context);
                }
                EntityType<RayaPrimeEntity> raya = ModEntityTypes.RAYA_PRIME.get();
                RayaPrimeEntity rayaEntity = (RayaPrimeEntity) raya.spawn((ServerWorld) context.getWorld(), stack, context.getPlayer(), context.getPlayer().getPosition(), 
                    SpawnReason.DISPENSER, false, false);
                    
                context.getPlayer().getPersistentData().putBoolean("hasraya", true);
                rayaEntity.getPersistentData().putFloat("energy", stack.getTag().getFloat("energy"));
                rayaEntity.getPersistentData().putFloat("max_energy", stack.getTag().getFloat("max_energy"));
                rayaEntity.owner = context.getPlayer();
                rayaEntity.owneruuid = context.getPlayer().getUniqueID();
                rayaEntity.getPersistentData().putUniqueId("owneruuid", context.getPlayer().getUniqueID());
                rayaEntity.getPersistentData().putBoolean("canUseEnergy", true);
                stack.shrink(1);
            }
        }
        return super.onItemUseFirst(stack, context);
    }

    
}
