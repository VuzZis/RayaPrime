package com.vuzz.haloterra.entities.custom;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class OcubladeEntity extends ShoulderRidingEntity implements IFlyingAnimal {

    private int ticksPast = 0;

    public double targetX = 0;
    public double targetY = 0;
    public double targetZ = 0;

    public double startX = 0;
    public double startY = 0;
    public double startZ = 0;

    public OcubladeEntity(EntityType<? extends ShoulderRidingEntity> entity, World world) {
        super(entity,world);
    }

    @Override public boolean canChangeDimension() {return true;}
    @Override public boolean canDespawn(double a) {return false;}
    @Override public boolean canBeLeashedTo(PlayerEntity player) {return false;}
    @Override public AgeableEntity createChild(ServerWorld world, AgeableEntity arg1) {return null;}
    @Override public boolean isNoDespawnRequired() {return true;}
    @Override protected boolean isAdult() {return true;}

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if(ticksPast > 40) remove();
        List<LivingEntity> targetList = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(getPosX() - 0.8, getPosY() - 0.1, getPosZ() - 0.8, getPosX() + 0.8, getPosY() + 0.1, getPosZ() + 0.8));
        List<LivingEntity> followList = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(getPosX() - 10, getPosY() - 10, getPosZ() - 10, getPosX() + 10, getPosY() + 10, getPosZ() + 10));
        followList.forEach((f) -> {
            if(f.getClassification(true) == EntityClassification.MONSTER) {
                double distanceX = getPosX()-f.getPosX();
                double distanceY = getPosY()-(f.getPosYEye()-0.2);
                double distanceZ = getPosZ()-f.getPosZ();
                setMotion(
                    new Vector3d(
                        -clamp(distanceX,-0.3,0.3), 
                        -clamp(distanceY,-0.3,0.3), 
                        -clamp(distanceZ,-0.3,0.3)
                    )
                );
            }
        });
        targetList.forEach((e) -> {
            if(e.getClassification(true) == EntityClassification.MONSTER) {
                e.addPotionEffect(new EffectInstance(Effects.WITHER,20,2));
                e.attackEntityFrom(DamageSource.GENERIC, 2);
                e.attackEntityAsMob(this);
            }
        });
        ticksPast++;
        super.tick();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,100.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0)
                .createMutableAttribute(Attributes.ARMOR,5000000D)
                .createMutableAttribute(Attributes.ARMOR_TOUGHNESS,5000000D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED,0);
    }

    protected double clamp(double val,double min,double max) {
        return Math.max(min,Math.min(max,val));
    }
}
