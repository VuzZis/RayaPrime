package com.vuzz.rayaprime.entities.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RayaPrimeEntity extends ParrotEntity {

    public static int animation = 0;

    public RayaPrimeEntity(EntityType<? extends ParrotEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new RayaPrimeMovementController(this, 10, false);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,30.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.35D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED,0.35D);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1,new LookAtGoal(this, PlayerEntity.class, 6.0F));   
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 0;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    protected double clamp(double val,double min,double max) {
        return Math.max(min,Math.min(max,val));
    }

    @Override
    public void tick() {
        super.tick();
        
        if(getOwner() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) getOwner();
            double motionX = clamp(getPosX()-player.getPosX(),-0.4d,0.4d);
            double motionY = clamp(getPosY()-player.getPosY(),-0.4d,0.4d);
            double motionZ = clamp(getPosZ()-player.getPosZ(),-0.4d,0.4d);
            setMotion(
                motionX,
                motionY,
                motionZ
            );
        }
        
    }

}
