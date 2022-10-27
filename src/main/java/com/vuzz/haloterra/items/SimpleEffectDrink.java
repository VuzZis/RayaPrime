package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SimpleEffectDrink extends Item {

    public int time = 0;
    public Effect effect;
    public int power = 0;

    public SimpleEffectDrink(Effect effect,int time,int power,boolean isSecret) {
        super(
            new Item.Properties()
                .food(
                    new Food.Builder()
                        .setAlwaysEdible()
                        .hunger(0)
                        .saturation(3)
                        .build()
                )
                .maxStackSize(1)
                .group(isSecret ? null : RayaMod.MOD_GROUP)
        );
        this.effect = effect;
        this.time = time;
        this.power = power;
    }

    public SimpleEffectDrink(Effect effect,int time,int power) {
        super(
            new Item.Properties()
                .food(
                    new Food.Builder()
                        .setAlwaysEdible()
                        .hunger(0)
                        .saturation(3)
                        .build()
                )
                .maxStackSize(1)
                .group(RayaMod.MOD_GROUP)
        );
        this.effect = effect;
        this.time = time;
        this.power = power;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
        entity.addPotionEffect(new EffectInstance(effect,time,power));
        stack.shrink(1);
        return stack.isEmpty() ? new ItemStack(ModItems.CUP.get()): stack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 25;
    }
    
    @Override
    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }
    
}
