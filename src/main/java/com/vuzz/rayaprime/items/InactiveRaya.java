package com.vuzz.rayaprime.items;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.entities.ModEntityTypes;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
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
        
        if(!stack.hasTag()) stack.setTag(new CompoundNBT());
        stack.getTag().putFloat("max_energy",19998f);
        if(stack.getTag().getFloat("energy") > stack.getTag().getFloat("max_energy")) stack.getTag().putFloat("energy",stack.getTag().getFloat("max_energy"));
        if(stack.getTag().getFloat("energy") < 0) stack.getTag().putFloat("energy",0);
        stack.setDamage(20000-((int) stack.getTag().getFloat("energy")+1));


        super.inventoryTick(stack, world, entity, tick, bool);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if(context.getWorld().isRemote) return super.onItemUseFirst(stack, context);

        if(context.getPlayer().isSneaking()) 
        {
            stack.getTag().putFloat("energy",stack.getTag().getFloat("max_energy"));
        } 
        else 
        {
            if(!stack.hasTag()) stack.setTag(new CompoundNBT());
            if(context.getPlayer().getPersistentData().getBoolean("hasraya")) {
                context.getPlayer().sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".no_two_rayas"),Util.DUMMY_UUID);
            } else 
            {
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
