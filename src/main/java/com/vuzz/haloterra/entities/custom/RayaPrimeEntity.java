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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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

import net.minecraft.client.Minecraft;
import net.minecraft.command.arguments.EntityAnchorArgument.Type;

public class RayaPrimeEntity extends ShoulderRidingEntity implements IFlyingAnimal {

    private int ticksPast;
    private float curEnergy = 1;
    private LivingEntity owner;
    private UUID ownerUuid;

    private static float energyConsumtion = 0.05f;
    private static float walkingConsumtion = 0.1f;
    private static float flySpeed = 0.3f;

    private static final int STAY_DISTANCE = 15;
    private static final int TELEPORT_DISTANCE = 60;

    private int lastHungerCheck = 0;
    private int lastDurabilityCheck = 0;
    private int lastHealthCheck = 0;

    public int anim = 0;

    public LivingEntity getOwner() {
        return owner;
    }

    public RayaPrimeEntity(EntityType<? extends ShoulderRidingEntity> entity, World world) {
        super(entity,world);
        this.moveController = new FlyingMovementController(this, 1, false);
    }

    @Override
    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        if(player == owner) {
            if(player.isSneaking()) {
                System.out.println("at clicking");
                returnAsImplant();
            } else {
                CompoundNBT nbt = getPersistentData(); 
                if(owner == player && getEnergy() >= 0 && nbt.getBoolean("canUseEnergy")) {
                    INamedContainerProvider containerProvider = createContainerProvider(player.getEntityWorld(),player.getPosition());
                    NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider,getPosition());
                }   
            }
        }
        return super.getEntityInteractionResult(player,hand);
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        RayaPrimeEntity entity = this;
        return new INamedContainerProvider() {

            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new RayaPrimeContainer(i,worldIn,pos,playerInventory,playerEntity);
            }

            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent(" ");
            }
            
        };
    }

    private void returnAsImplant() {
        CompoundNBT nbt = getPersistentData();
        if(owner instanceof PlayerEntity) {
            System.out.println("at return");
            PlayerEntity player = (PlayerEntity) owner;
            ItemStack item = new ItemStack(ModItems.INACTIVE_IMPLANT.get());
            if(player.canPickUpItem(item)) {
                item.setTag(nbt);
                player.addItemStackToInventory(item);
                player.getPersistentData().putBoolean("hasraya", false);
                remove();
            } else {
                remove();
                item.setTag(nbt);
                player.dropItem(item, false);
                player.getPersistentData().putBoolean("hasraya", false);
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
            if(getEntityWorld().isRemote) {
                nbt.putInt("anim",anim);
            } else {
                anim = nbt.getInt("anim");
                if(Minecraft.getInstance().world.getEntityByID(getEntityId()) != null)
                    Minecraft.getInstance().world.getEntityByID(getEntityId()).getPersistentData().putInt("anim", anim);
            }
            if(owner.isPotionActive(ModEffects.HYBERNATION.get()))
            {    
                PlayerEntity player = (PlayerEntity) owner;
                owner.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".disabling"),Util.DUMMY_UUID);
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
                getNavigator().tryMoveToXYZ(getOwner().getPosX()-2d, getOwner().getPosYEye(), getOwner().getPosZ()-2d, 1.3);
            }
            else {
                setMotion(0, clamp((getOwner().getPosYEye()-getPosY()-0.4)*1.1,-0.2,0.2)*1.1+Math.sin(ticksPast/4)/5, 0);
                getNavigator().clearPath();
            }

            PlayerEntity player = (PlayerEntity) owner;
            if((ticksPast - lastHungerCheck >= 600) && player.getFoodStats().getFoodLevel() < 10) {
                owner.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".lowfood"),Util.DUMMY_UUID);
                lastHungerCheck = ticksPast;
            }
            ItemStack stackForCheck = player.getHeldItemMainhand();
            
            if((ticksPast - lastDurabilityCheck >= 300) && (stackForCheck.getDamage()*100/(stackForCheck.getMaxDamage()+1)) >= 90) {
                owner.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".lowdurability"),Util.DUMMY_UUID);
                lastDurabilityCheck = ticksPast;
            }

            if((ticksPast - lastHealthCheck >= 600) && (player.getHealth()<=4)) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED,300,1));
                owner.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".adrenaline"),Util.DUMMY_UUID);
                lastHealthCheck = ticksPast;
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
            if(curEnergy > damage*2) {
                curEnergy -= damage*2;
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
