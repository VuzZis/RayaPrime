package com.vuzz.haloterra.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.items.marker.Implant;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Gcu extends Item {

    public int ticks = 0;

	public Gcu() {
		super(
            new Item.Properties()
            .group(RayaMod.MOD_GROUP)
            .rarity(Rarity.EPIC)
        );
	}

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if(context.getWorld().isRemote) return super.onItemUseFirst(stack, context);

        if(context.getPlayer().getTags().contains("uniquegen")) 
        {
            
        } 
        else 
        {
            context.getPlayer().addTag("uniquegen");
            context.getPlayer().addPotionEffect(new EffectInstance(Effects.BLINDNESS,200,1));
            stack.shrink(1);
        }
        return super.onItemUseFirst(stack, context);
    }

    
}
