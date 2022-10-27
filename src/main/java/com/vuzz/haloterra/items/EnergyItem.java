package com.vuzz.haloterra.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.items.marker.Implant;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class EnergyItem extends Item {

    float energyGives = 0;

    public EnergyItem(float energyGives) {
        super(
            new Item.Properties()
                .maxStackSize(16)
                .isImmuneToFire()
                .group(RayaMod.MOD_GROUP)
            );
        this.energyGives = energyGives;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity player, int ticks,
            boolean bool) {
        
        if(!stack.hasTag()) stack.setTag(new CompoundNBT());
        CompoundNBT nbt = stack.getTag();
        nbt.putFloat("energyGives",energyGives);

        PlayerEntity playerEntity = (PlayerEntity) player;

        if(playerEntity.getHeldItemOffhand() == stack && !world.isRemote && playerEntity.isSneaking()) {
            ItemStack mainItem = playerEntity.getHeldItemMainhand();
            if(mainItem.getItem() instanceof Implant) {
                if(!mainItem.hasTag()) mainItem.setTag(new CompoundNBT());
                CompoundNBT implantNbt = mainItem.getTag();
                float energy = implantNbt.getFloat("energy");
                float maxEnergy = implantNbt.getFloat("max_energy");
                if(energy+energyGives <= maxEnergy) {
                    implantNbt.putFloat("energy",energy+energyGives);
                    stack.shrink(1);
                }
            }
        }

        super.inventoryTick(stack,world,player,ticks,bool);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> text,
            ITooltipFlag tooltip) {
        text.add(
            new StringTextComponent(
                new TranslationTextComponent("tooltip.haloterra.energy")
                    .getString()
                +" "+energyGives+"\n"+new TranslationTextComponent("tooltip.haloterra.energyuse").getString()
            )
        );
        super.addInformation(stack, world, text, tooltip);
    }
    
}
