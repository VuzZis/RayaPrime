package com.vuzz.rayaprime.items;

import com.vuzz.rayaprime.RayaMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

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
    
}
