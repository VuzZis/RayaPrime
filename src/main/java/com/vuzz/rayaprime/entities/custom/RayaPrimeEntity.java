package com.vuzz.rayaprime.entities.custom;

import java.util.UUID;

import javax.lang.model.type.TypeKind;

import com.vuzz.rayaprime.items.ModItems;

import net.minecraft.command.arguments.EntityAnchorArgument.Type;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class RayaPrimeEntity extends FlyingEntity {

    public static int animation = 0;
    public static final float speed = 0.1f;
    private float energy = 0;

    public LivingEntity owner;
    public UUID owneruuid;

    public RayaPrimeEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,100.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.35D)
                .createMutableAttribute(Attributes.ARMOR,500D)
                .createMutableAttribute(Attributes.ARMOR_TOUGHNESS,500D)
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
        CompoundNBT nbt = getPersistentData();
        energy = nbt.getFloat("energy");
        setHealth(100f);
        /*if(energy < -2) {
            setHealth(-50f);
            if(owner instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) owner;
                ItemStack item = new ItemStack(ModItems.INACTIVE_IMPLANT.get());
                item.setTag(nbt);
                player.addItemStackToInventory(item);
                System.out.println("medeing");
            }
        }*/
        if(owneruuid instanceof UUID) {
            if(getEntityWorld().getPlayerByUuid(owneruuid) instanceof PlayerEntity)
                owner = getEntityWorld().getPlayerByUuid(owneruuid);
        }
        if(owner != null) {
            double distance = getDistanceSq(owner);
            lookAt(Type.EYES, owner.getPositionVec());

            if (distance >= 20) {
                setPosition(owner.getPosX(), owner.getPosY()+1.1, owner.getPosZ());
            }
            else if(distance >= 10) {
                setMotion(
                    new Vector3d(
                        -clamp(getPosX()-owner.getPosX(),-speed,speed), 
                        -clamp(getPosY()-(owner.getPosY()+1.1),-speed,speed), 
                        -clamp(getPosZ()-owner.getPosZ(),-speed,speed)
                    )
                );
            } 
        }
        energy -= 0.1f;
        nbt.putFloat("energy", energy);
    }
}
