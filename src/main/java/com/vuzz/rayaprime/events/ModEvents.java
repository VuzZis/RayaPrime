package com.vuzz.rayaprime.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.biome.Biome;
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
import net.minecraftforge.event.TickEvent.RenderTickEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.capability.CapabilityPM;
import com.vuzz.rayaprime.capability.CapabilityPMProvider;
import com.vuzz.rayaprime.capability.PM;
import com.vuzz.rayaprime.effects.ModEffects;
import com.vuzz.rayaprime.world.gen.ModOreGeneration;

@Mod.EventBusSubscriber(modid = RayaMod.MOD_ID)
public class ModEvents {

    public static final ResourceLocation PM_ID = new ResourceLocation(RayaMod.MOD_ID, "pm");
 
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
                player.addPotionEffect(new EffectInstance(ModEffects.HYBERNATION.get(), 20000000, 1, false, false, false, player.getActivePotionEffect(ModEffects.HYBERNATION.get())));
            } else {
                player.removePotionEffect(ModEffects.HYBERNATION.get());
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
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if(!event.getPlayer().getEntityWorld().isRemote) return;
        event.getOriginal().getCapability(CapabilityPM.INSTANCE).ifPresent(oldPm ->
            event.getPlayer().getCapability(CapabilityPM.INSTANCE).ifPresent(newPm -> {
                newPm.setPm(oldPm.getPm());
            })
        );
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
