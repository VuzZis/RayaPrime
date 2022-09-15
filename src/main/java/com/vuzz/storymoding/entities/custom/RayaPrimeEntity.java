package com.vuzz.storymoding.entities.custom;

import java.util.UUID;

import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.effects.ModEffects;
import com.vuzz.storymoding.gui.containers.RayaPrimeContainer;
import com.vuzz.storymoding.items.ModItems;

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

public class RayaPrimeEntity extends FlyingEntity {

    public static int animation = 0;
    public static final float speed = 0.1f;
    private float energy = 0;
    private int ticks = 0;
    private int lastHungerCheck = 0;
    private int lastDurabilityCheck = 0;

    public LivingEntity owner;
    public UUID owneruuid;

    public RayaPrimeEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
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
        if(damageSource != DamageSource.OUT_OF_WORLD) {
            CompoundNBT nbt = getPersistentData();
            energy = nbt.getFloat("energy");
            if(energy > damage*2) {
                nbt.putFloat("energy",energy-damage*2);
                return false;
            }
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
                    //player.sendStatusMessage(new TranslationTextComponent("warning."+StoryModing.MOD_ID+".nospace"), true);
                }
            } 
        } else {
           
            CompoundNBT nbt = getPersistentData(); 
            energy = nbt.getFloat("energy");
            if(owner == player && energy >= 0 && nbt.getBoolean("canUseEnergy")) {
                INamedContainerProvider containerProvider = createContainerProvider(player.getEntityWorld(),player.getPosition());

                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider,getPosition());
            }
        }
        return super.getEntityInteractionResult(player, hand);
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

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean canDespawn(double p_213397_1_) {
        return false;
    }

    @Override
    public void onRemovedFromWorld() {
        if(owner != null) {
            setWorld(owner.getEntityWorld());
        }
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

        if(energy <= 0 && nbt.getBoolean("canUseEnergy")) {
            
            if(owner instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) owner;
                ItemStack item = new ItemStack(ModItems.INACTIVE_IMPLANT.get());
                if(player.canPickUpItem(item)) {
                    remove();
                    item.setTag(nbt);
                    player.addItemStackToInventory(item);
                    player.getPersistentData().putBoolean("hasraya", false);
                } else {
                    //player.sendStatusMessage(new TranslationTextComponent("warning."+StoryModing.MOD_ID+".nospace"), true);
                    remove();
                    item.setTag(nbt);
                    player.dropItem(item, false);
                    player.getPersistentData().putBoolean("hasraya", false);
                }
                
            }
        }
        if(owneruuid instanceof UUID) {
            
            if(getEntityWorld().getPlayerByUuid(owneruuid) instanceof PlayerEntity)
                owner = getEntityWorld().getPlayerByUuid(owneruuid);
        }
        if(owner != null) {
            if(owner instanceof PlayerEntity && owner.isPotionActive(ModEffects.HYBERNATION.get())) {
                PlayerEntity player = (PlayerEntity) owner;
                ItemStack item = new ItemStack(ModItems.INACTIVE_IMPLANT.get());
                owner.sendMessage(new TranslationTextComponent("message."+StoryModing.MOD_ID+".disabling"),Util.DUMMY_UUID);
                if(player.canPickUpItem(item)) {
                    remove();
                    item.setTag(nbt);
                    player.addItemStackToInventory(item);
                    player.getPersistentData().putBoolean("hasraya", false);
                } else {
                    remove();
                    item.setTag(nbt);
                    player.dropItem(item, false);
                    player.getPersistentData().putBoolean("hasraya", false);
                }
                
            }
            if(owner.getEntityWorld() != getEntityWorld()) setWorld(owner.getEntityWorld());
            if(getEntityWorld().isRemote) {
                ClientPlayerEntity player = Minecraft.getInstance().player;
                player.getPersistentData().putInt("pm", owner.getPersistentData().getInt("pm"));
            }
            double distance = getDistanceSq(owner);
            lookAt(Type.EYES, owner.getPositionVec());
            if(energy == 60 || energy == 59) {
                owner.sendMessage(new TranslationTextComponent("message."+StoryModing.MOD_ID+".lowbattery"),Util.DUMMY_UUID);
            }
            PlayerEntity player = (PlayerEntity) owner;
            if((ticks - lastHungerCheck >= 600) && player.getFoodStats().getFoodLevel() < 10) {
                owner.sendMessage(new TranslationTextComponent("message."+StoryModing.MOD_ID+".lowfood"),Util.DUMMY_UUID);
                lastHungerCheck = ticks;
            }
            ItemStack stackForCheck = player.getHeldItemMainhand();
            
            if((ticks - lastDurabilityCheck >= 300) && (stackForCheck.getDamage()*100/(stackForCheck.getMaxDamage()+1)) >= 90) {
                owner.sendMessage(new TranslationTextComponent("message."+StoryModing.MOD_ID+".lowdurability"),Util.DUMMY_UUID);
                lastDurabilityCheck = ticks;
            }


            if(energy <= 0 && nbt.getBoolean("canUseEnergy")) return;
            if (distance >= 30) {
                setPosition(owner.getPosX(), owner.getPosY()+1.1, owner.getPosZ());
            }
            else if(distance >= 10) {
                setMotion(
                    new Vector3d(
                        -clamp(getPosX()-owner.getPosX(),-speed,speed), 
                        -clamp(getPosY()-(owner.getPosY()+1.1+Math.sin(ticks/20)*3),-speed,speed), 
                        -clamp(getPosZ()-owner.getPosZ(),-speed,speed)
                    )
                );
            } 
        }
        if(energy >= 0 && nbt.getBoolean("canUseEnergy")) {
            energy -= 0.1f;
            
        }
        nbt.putFloat("energy", energy);
        ticks++;
    }
}
