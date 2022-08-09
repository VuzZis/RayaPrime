package com.vuzz.rayaprime.entities.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class RayaPrimeEntity extends FlyingEntity {

    public static int animation = 0;

    public RayaPrimeEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,30.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.35D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED,0.35D);

    }

    @Override
	public void registerGoals() {
		super.registerGoals();
	}

    protected double clamp(double val,double min,double max) {
        return Math.max(min,Math.min(max,val));
    }

    @Override
    public void tick() {
        super.tick();    
    }
}
