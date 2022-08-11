package com.vuzz.rayaprime.items;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.entities.ModEntityTypes;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;

import javafx.stage.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
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
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if(context.getWorld().isRemote) return super.onItemUseFirst(stack, context);

        if(net.minecraft.client.gui.screen.Screen.hasShiftDown()) 
        {

        } 
        else 
        {
            if(!stack.hasTag()) stack.setTag(new CompoundNBT());
            EntityType<RayaPrimeEntity> raya = ModEntityTypes.RAYA_PRIME.get();
            RayaPrimeEntity rayaEntity = (RayaPrimeEntity) raya.spawn((ServerWorld) context.getWorld(), stack, context.getPlayer(), context.getPlayer().getPosition(), 
                SpawnReason.DISPENSER, false, false);
            rayaEntity.getPersistentData().putFloat("energy", stack.getTag().getFloat("energy"));
            rayaEntity.owner = context.getPlayer();
            rayaEntity.owneruuid = context.getPlayer().getUniqueID();
            System.out.println("mespawning");
            stack.shrink(1);
        }
        return super.onItemUseFirst(stack, context);
    }

    
}
