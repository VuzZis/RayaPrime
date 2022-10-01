package com.vuzz.rayaprime.events;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.TickEvent.RenderTickEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import java.util.ArrayList;
import java.util.Random;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.blocks.ModBlocks;
import com.vuzz.rayaprime.capability.CapabilityPM;
import com.vuzz.rayaprime.capability.CapabilityPMProvider;
import com.vuzz.rayaprime.capability.PM;
import com.vuzz.rayaprime.effects.ModEffects;
import com.vuzz.rayaprime.items.ModItems;
import com.vuzz.rayaprime.world.gen.ModOreGeneration;

@Mod.EventBusSubscriber(modid = RayaMod.MOD_ID)
public class ModEvents {

    public static final ResourceLocation PM_ID = new ResourceLocation(RayaMod.MOD_ID, "pm");
    public static final ResourceLocation PROGRESS_ID = new ResourceLocation(RayaMod.MOD_ID, "progress");
 
    private static BlockState lookingAt(PlayerEntity player, boolean isFluid) {
        ArrayList<String> list = new ArrayList<String>();
        RayTraceResult block = player.pick(20.0D,0.0F,isFluid);

        if(block.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult)block).getPos();
            BlockState blockState = player.world.getBlockState(blockpos);
            return blockState;
        }
        return null;
    }

    private static BlockPos lookingAtPos(PlayerEntity player, boolean isFluid) {
        ArrayList<String> list = new ArrayList<String>();
        RayTraceResult block = player.pick(20.0D,0.0F,isFluid);

        if(block.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult)block).getPos();
            return blockpos;
        }
        return null;
    }

    @SubscribeEvent
    public static void onRightClickItem(RightClickItem event) {
        {/* Halo
        if(!event.getEntity().getEntityWorld().isRemote)
        if(event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ServerWorld world = (ServerWorld) event.getWorld();
            BlockPos blockPos = event.getPos();
            ItemStack stack = event.getItemStack();
            BlockState blockState = lookingAt(player,false);
            Block block = blockState.getBlock();

            if(block == ModBlocks.COMPUTER.get() && stack.getItem() == Items.DIAMOND_SWORD) {
                Random random = new Random();
                int percentage = (int) (random.nextFloat() * 100);
                if(percentage <= 10) {
                    LazyOptional<PM> capL = PM.get(player);
                    if(capL.resolve().isPresent()) {
                        PM cap = capL.resolve().get();
                        int percentageForD = (int) (percentage/0.3);
                        cap.setProgress(cap.getProgress()+1);
                        if(percentageForD <= 25) {
                            player.sendMessage(new TranslationTextComponent("story."+RayaMod.MOD_ID+".computer_1"), Util.DUMMY_UUID);
                        } else if (percentageForD <= 50) {
                            player.sendMessage(new TranslationTextComponent("story."+RayaMod.MOD_ID+".computer_2"), Util.DUMMY_UUID);
                        } else if (percentageForD <= 75) {
                            player.sendMessage(new TranslationTextComponent("story."+RayaMod.MOD_ID+".computer_3"), Util.DUMMY_UUID);
                        } else {
                            player.sendMessage(new TranslationTextComponent("story."+RayaMod.MOD_ID+".computer_4"), Util.DUMMY_UUID);
                        }
                        stack.setDamage(stack.getDamage()+1);

                        String noteName = "";
                        String noteAchieve = (new TranslationTextComponent("story."+RayaMod.MOD_ID+".achievenote")).getString();

                        switch(cap.getProgress()) {
                            case 1:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.3")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 2:
                                player.setHealth(0);
                            break;
                            case 3:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.1")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 4:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.4")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 5:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.2")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 6:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.7")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 7:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.5")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 8:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.6")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 9:
                                noteName = ":D";
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                            case 10:
                                noteName = (new TranslationTextComponent("note."+RayaMod.MOD_ID+".chapter1.8")).getString();
                                player.sendMessage(new StringTextComponent(noteAchieve+noteName), Util.DUMMY_UUID);
                            break;
                        }

                        player.attackEntityFrom(DamageSource.MAGIC, 3f);
                    };
                } else {
                    player.attackEntityFrom(DamageSource.MAGIC, 6f);
                    player.sendMessage(new TranslationTextComponent("story."+RayaMod.MOD_ID+".computer_0"), Util.DUMMY_UUID);
                }
                world.removeBlock(lookingAtPos(player, false), false);
            }
        }*/
        }
    }

    @SubscribeEvent
    public static void onLivingUpdateEvent(LivingUpdateEvent event) {
        if(!event.getEntity().getEntityWorld().isRemote)
        if(event.getEntity() instanceof PlayerEntity) {
            CompoundNBT nbt = event.getEntity().getPersistentData();
            PlayerEntity player = (PlayerEntity) event.getEntity();
            Biome biome = player.getEntityWorld().getBiome(player.getPosition());
            float temperaturePlayer = nbt.getFloat("temperature");
            float difference = biome.getTemperature() - temperaturePlayer;
            float useDifference = difference / 200;
            player.getPersistentData().putFloat("temperature", temperaturePlayer+useDifference);
            float temperature = temperaturePlayer+useDifference;
            if(temperaturePlayer >= 1.7 || temperaturePlayer <= -0.7) {
                player.addPotionEffect(new EffectInstance(ModEffects.HYBERNATION.get(), 2, 0, false, false, false, player.getActivePotionEffect(ModEffects.HYBERNATION.get())));
            }
        }
    }

    @SubscribeEvent
    public static void onFMLCommonSetup(FMLCommonSetupEvent event) {
        CapabilityPM.register();
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) event.addCapability(PM_ID, new CapabilityPMProvider());
        //if(event.getObject() instanceof PlayerEntity) event.addCapability(PROGRESS_ID, new CapabilityPMProvider());
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if(!event.getPlayer().getEntityWorld().isRemote) return;
        PM.get(event.getOriginal()).ifPresent(oldPm -> {
            System.out.println(oldPm.getPm());
            PM.get(event.getPlayer()).ifPresent(newPm -> {
                System.out.println(newPm.getPm());
                newPm.setPm(oldPm.getPm());
                newPm.setProgress(oldPm.getProgress());
            });
        });
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        sync(event.getPlayer());
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        sync(event.getPlayer());
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        sync(event.getPlayer());
    }

    private static void sync(PlayerEntity player) {
        if(player instanceof ServerPlayerEntity) {
            PM.get(player).ifPresent(cap -> {
                cap.setPm(cap.getPm());
                cap.setProgress(cap.getProgress());
                cap.sync((ServerPlayerEntity) player);
            });
        }
    }

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
    }

    @SubscribeEvent
    public static void onPlayerWakeUpEvent(PlayerWakeUpEvent event) {
        if(!event.getEntity().getEntityWorld().isRemote) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if(player.getPersistentData().getBoolean("hasraya")) {
                player.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".wakeup"),Util.DUMMY_UUID);
            }
        }
    }


    @SubscribeEvent
    public static void onPlayerDestroyItemEvent(PlayerDestroyItemEvent event) {
        if(!event.getEntity().getEntityWorld().isRemote) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if(player.getPersistentData().getBoolean("hasraya")) {
                //player.sendMessage(new TranslationTextComponent("message."+RayaMod.MOD_ID+".itembroke"),Util.DUMMY_UUID);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        event.getEntityLiving().getMaxHealth();
        if(!event.getEntity().getEntityWorld().isRemote) {
            Entity killer = event.getSource().getTrueSource();
            if(killer != null && killer instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) killer;
                if(player.getPersistentData().getInt("try") <= 3) {
                    player.getPersistentData().putInt("try",player.getPersistentData().getInt("try")+1);
                    return;
                }
                player.getPersistentData().putInt("try",0);
                float killedHp = event.getEntityLiving().getMaxHealth();
                float pmRaw = (float) (killedHp/2.25*(event.getEntity().getEntityWorld().getRandom().nextFloat()+0.5f));
                int pmToGive = (int) pmRaw;
                LazyOptional<PM> capability =  PM.get(player);
                if(capability.resolve().isPresent()) {
                    PM cap = capability.resolve().get();
                    cap.setPm(cap.getPm()+pmToGive);
                    cap.sync((ServerPlayerEntity) player);
                }
                //player.sendMessage(new StringTextComponent("pm give "+pmToGive+" "+cap.pm),Util.DUMMY_UUID);
                String ablob = new TranslationTextComponent("title."+RayaMod.MOD_ID+".ablob").getString();
                player.sendStatusMessage(new StringTextComponent(ablob+pmToGive+" "+new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()), true);
            }
        }
    }
}
