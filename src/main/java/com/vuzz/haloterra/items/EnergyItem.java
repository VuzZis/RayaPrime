package com.vuzz.haloterra.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vuzz.haloterra.RayaMod;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> text,
            ITooltipFlag tooltip) {
        text.add(
            new StringTextComponent(
                new TranslationTextComponent("tooltip.haloterra.energy")
                    .getString()
                +" "+energyGives
            )
        );
        super.addInformation(stack, world, text, tooltip);
    }
    
}
