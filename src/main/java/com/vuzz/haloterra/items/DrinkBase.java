package com.vuzz.haloterra.items;

import javax.jws.soap.SOAPBinding.Use;

import com.vuzz.haloterra.RayaMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DrinkBase extends Item {
    
    private int power = 0;
    private int time = 0;

    public DrinkBase(int power,int time) {
        super(
            new Item.Properties()
                .food(
                    new Food.Builder()
                        .setAlwaysEdible()
                        .hunger(0)
                        .saturation(5)
                        .build()
                ).group(RayaMod.MOD_GROUP)
        );
        this.power = power;
        this.time = time;
	}
	
	public SoundEvent getDrinkingSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
        entity.addPotionEffect(new EffectInstance(Effects.NAUSEA,time,power));
        stack.shrink(1);
        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE): stack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 22;
    }
    
    @Override
    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }

}
