package com.vuzz.haloterra.entities.custom;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.UUID;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.gui.containers.RayaPrimeContainer;
import com.vuzz.haloterra.items.ModItems;

import net.minecraft.command.arguments.EntityAnchorArgument.Type;

public class OculusEntity extends ShoulderRidingEntity implements IFlyingAnimal {

    private int ticksPast;
    private float curEnergy = 1;
    private LivingEntity owner;
    private UUID ownerUuid;

    private static float energyConsumtion = 0.01f;
    private static float walkingConsumtion = 0.02f;
    private static float flySpeed = 0.4f;

    private static final int STAY_DISTANCE = 30;
    private static final int TELEPORT_DISTANCE = 100;

    private int lastHungerCheck = 0;
    private int lastDurabilityCheck = 0;

    public LivingEntity getOwner() {
        return owner;
    }

    public OculusEntity(EntityType<? extends ShoulderRidingEntity> entity, World world) {
        super(entity,world);
        this.moveController = new FlyingMovementController(this, 2, false);
    }

    @Override
    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        if(player == owner) {
            if(player.isSneaking()) {
                System.out.println("at clicking");
                returnAsImplant();
            } else {
            }
        }
        return super.getEntityInteractionResult(player,hand);
    }

    private void returnAsImplant() {
        CompoundNBT nbt = getPersistentData();
        if(owner instanceof PlayerEntity) {
            System.out.println("at return");
            PlayerEntity player = (PlayerEntity) owner;
            ItemStack item = new ItemStack(ModItems.INACTIVE_OCULUS.get());
            if(player.canPickUpItem(item)) {
                item.setTag(nbt);
                player.addItemStackToInventory(item);
                player.getPersistentData().putBoolean("hasoculus", false);
                remove();
            } else {
                remove();
                item.setTag(nbt);
                player.dropItem(item, false);
                player.getPersistentData().putBoolean("hasoculus", false);
                //player.sendStatusMessage(new TranslationTextComponent("warning."+RayaMod.MOD_ID+".nospace"), true);
            }
        } 
    }

    @Override public boolean canChangeDimension() {return true;}
    @Override public boolean canDespawn(double a) {return false;}
    @Override public boolean canBeLeashedTo(PlayerEntity player) {return false;}
    @Override public AgeableEntity createChild(ServerWorld world, AgeableEntity arg1) {return null;}
    @Override public boolean isNoDespawnRequired() {return true;}
    @Override protected boolean isAdult() {return true;}

    public void setOwnerUUID(UUID ownerUuid) {
        this.ownerUuid = ownerUuid;
    }
    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    public void setEnergy(float cuEnergy) {
        this.curEnergy = cuEnergy;
    }

    public float getEnergy() {
        return curEnergy;
    }

    private void performTalks(int tick) {
        if(tick % 40 == 0 && owner instanceof PlayerEntity) {
            //owner.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".disabling"),Util.DUMMY_UUID);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public void tick() {
        super.tick();
        CompoundNBT nbt = getPersistentData();
        if(nbt.getBoolean("canUseEnergy")) setOwnerUUID(nbt.getUniqueId("owneruuid"));
        if(getOwnerUUID() instanceof UUID) setOwner(world.getPlayerByUuid(getOwnerUUID()));
        if(!(owner instanceof PlayerEntity)) return;
            if(owner.isPotionActive(ModEffects.HYBERNATION.get()))
            {    
                PlayerEntity player = (PlayerEntity) owner;
                owner.sendMessage(new TranslationTextComponent("message.oculus"+".disabling"),Util.DUMMY_UUID);
                System.out.println("at hybernation");
                returnAsImplant();
            }
            if(nbt.getBoolean("canUseEnergy") && curEnergy <= 0) returnAsImplant();
            curEnergy = nbt.getFloat("energy");
            lookAt(Type.EYES,new Vector3d(owner.getPosX(),owner.getPosYEye(),owner.getPosZ()));
            double distanceBetween = getDistanceSq(getOwner());
            ((FlyingPathNavigator) getNavigator()).setCanSwim(false);
            ((FlyingPathNavigator) getNavigator()).setCanEnterDoors(true);
            ((FlyingPathNavigator) getNavigator()).setCanOpenDoors(true);
            setNoGravity(true);
            if (distanceBetween > TELEPORT_DISTANCE) 
                setPosition(owner.getPosX(), owner.getPosY(), owner.getPosZ());
            else
            if(distanceBetween > STAY_DISTANCE) {
                curEnergy -= walkingConsumtion;
                getNavigator().tryMoveToXYZ(getOwner().getPosX()-2d, getOwner().getPosYEye(), getOwner().getPosZ()-2d, 2);
            }
            else {
                setMotion(0, clamp(getOwner().getPosYEye()-getPosY(),-0.2,0.2), 0);
                getNavigator().clearPath();
            }
                

            PlayerEntity player = (PlayerEntity) owner;
            if((ticksPast - lastHungerCheck >= 600) && player.getFoodStats().getFoodLevel() < 10) {
                owner.sendMessage(new TranslationTextComponent("message.oculus"+".lowfood"),Util.DUMMY_UUID);
                lastHungerCheck = ticksPast;
            }

            performTalks(ticksPast);
            curEnergy -= energyConsumtion;
            nbt.putFloat("energy",curEnergy);
            ticksPast++;
    }

    private UUID getOwnerUUID() {
        return ownerUuid;
    }

    @Override
    protected FlyingPathNavigator createNavigator(World worldIn) {
        return new FlyingPathNavigator(this, worldIn);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        if(damageSource != DamageSource.OUT_OF_WORLD) {
            CompoundNBT nbt = getPersistentData();
            curEnergy = nbt.getFloat("energy");
            if(curEnergy > damage/4) {
                curEnergy -= damage/4;
                System.out.println("at damage");
                return false;
            }
        }
        return true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,100.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, flySpeed)
                .createMutableAttribute(Attributes.ARMOR,5000000D)
                .createMutableAttribute(Attributes.ARMOR_TOUGHNESS,5000000D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED,flySpeed);
    }

    protected double clamp(double val,double min,double max) {
        return Math.max(min,Math.min(max,val));
    }
}
