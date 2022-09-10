package com.vuzz.rayaprime.entities.custom;

import java.util.UUID;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.gui.containers.RayaPrimeContainer;
import com.vuzz.rayaprime.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.command.arguments.EntityAnchorArgument.Type;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BeyondtoEntity extends FlyingEntity {

    public static int animation = 0;
    public static final float speed = 0.2f;
    private float energy = 0;
    private int ticks = 0;
    private int lastHungerCheck = 0;

    public LivingEntity owner;
    public UUID owneruuid;

    public BeyondtoEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,100.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.35D)
                .createMutableAttribute(Attributes.ARMOR,5000000D)
                .createMutableAttribute(Attributes.ARMOR_TOUGHNESS,5000000D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED,0.35D);

    }

    @Override
	public void registerGoals() {
		super.registerGoals();
	}

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        if(damageSource == DamageSource.OUT_OF_WORLD) return true;
        CompoundNBT nbt = getPersistentData();
        energy = nbt.getFloat("energy");
        if(energy > damage) {
            nbt.putFloat("energy",energy-damage);
            return false;
        }
        return true;
    }

    protected double clamp(double val,double min,double max) {
        return Math.max(min,Math.min(max,val));
    }

    @Override
    protected ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        if(player.isSneaking()) {
            CompoundNBT nbt = getPersistentData();
            if(owner == player) {
                ItemStack item = new ItemStack(ModItems.INACTIVE_BEYONDTO.get());
                if(player.canPickUpItem(item)) {
                    item.setTag(nbt);
                    player.addItemStackToInventory(item);
                    player.getPersistentData().putBoolean("hasbeyondto", false);
                    remove();
                } else {
                    player.sendStatusMessage(new TranslationTextComponent("warning."+RayaMod.MOD_ID+".nospace"), true);
                }
            } 
        } else {
           
            CompoundNBT nbt = getPersistentData(); 
            energy = nbt.getFloat("energy");
            if(owner == player && energy >= 0 && nbt.getBoolean("canUseEnergy")) {
                //INamedContainerProvider containerProvider = createContainerProvider(player.getEntityWorld(),player.getPosition());

                //NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider,getPosition());
            }
        }
        return super.getEntityInteractionResult(player, hand);
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        BeyondtoEntity entity = this;
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

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean canDespawn(double p_213397_1_) {
        return false;
    }

    @Override
    public void tick() {
        super.tick();   
        stopRiding();
        CompoundNBT nbt = getPersistentData();
        energy = nbt.getFloat("energy");
        if(nbt.getBoolean("canUseEnergy")) {
            owneruuid = nbt.getUniqueId("owneruuid");
        }
        setHealth(100f);

        if(energy <= 0 && nbt.getBoolean("canUseEnergy")) {
            
            if(owner instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) owner;
                ItemStack item = new ItemStack(ModItems.INACTIVE_BEYONDTO.get());
                if(player.canPickUpItem(item)) {
                    remove();
                    item.setTag(nbt);
                    player.addItemStackToInventory(item);
                    player.getPersistentData().putBoolean("hasbeyondto", false);
                } else {
                    player.sendStatusMessage(new TranslationTextComponent("warning."+RayaMod.MOD_ID+".nospace"), true);
                }
                
            }
        }
        if(owneruuid instanceof UUID) {
            
            if(getEntityWorld().getPlayerByUuid(owneruuid) instanceof PlayerEntity)
                owner = getEntityWorld().getPlayerByUuid(owneruuid);
        }
        if(owner != null) {
            if(owner.getEntityWorld() != getEntityWorld()) setWorld(owner.getEntityWorld());
            if(getEntityWorld().isRemote) {
                ClientPlayerEntity player = Minecraft.getInstance().player;
            }
            double distance = getDistanceSq(owner);
            lookAt(Type.EYES, owner.getPositionVec());

            PlayerEntity player = (PlayerEntity) owner;
            if((ticks - lastHungerCheck >= 1200) && player.getFoodStats().getFoodLevel() < 10) {
                owner.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".lowfood"),Util.DUMMY_UUID);
                lastHungerCheck = ticks;
            }


            if(energy <= 0 && nbt.getBoolean("canUseEnergy")) return;
            if(player.getHealth() <= 10) {
                nbt.putInt("phase", 1);
                double step = 360/20;
                double angle = ticks % 20;
                double x = (double) (owner.getPosX()+Math.sin(Math.toRadians(angle*step))*1.2);
                double z = (double) (owner.getPosZ()+Math.cos(Math.toRadians(angle*step))*1.2);
                setPosition(x,owner.getPosY()+0.7,z);
            }
            else {
                nbt.putInt("phase", 0);
                if (distance >= 60) {
                    setPosition(owner.getPosX(), owner.getPosY()+1.1, owner.getPosZ());
                }
                else if(distance >= 20) {
                    setMotion(
                        new Vector3d(
                            -clamp(getPosX()-owner.getPosX(),-speed,speed), 
                            -clamp(getPosY()-(owner.getPosY()+1.0+Math.sin(ticks/40)/1.25),-speed,speed), 
                            -clamp(getPosZ()-owner.getPosZ(),-speed,speed)
                        )
                    );
                } 
            }
        }
        if(energy >= 0 && nbt.getBoolean("canUseEnergy")) {
            energy -= 0.125f;
            
        }
        nbt.putFloat("energy", energy);
        ticks++;
    }
}
