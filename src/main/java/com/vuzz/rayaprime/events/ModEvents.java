package com.vuzz.rayaprime.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.capabilities.attacher.CapabilityPM;
import com.vuzz.rayaprime.capabilities.provider.CapabilityProviderPlayers;
import com.vuzz.rayaprime.capabilities.storage.player.PM;

@Mod.EventBusSubscriber(modid = RayaMod.MOD_ID)
public class ModEvents {
    public static final ResourceLocation PM_ID = new ResourceLocation(RayaMod.MOD_ID, "pm");

    @SubscribeEvent
    public static void onFMLCommonSetup(FMLCommonSetupEvent event) {
        CapabilityPM.register();
    }

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        event.getEntityLiving().getMaxHealth();
        if(!event.getEntity().getEntityWorld().isRemote) {
            Entity killer = event.getSource().getTrueSource();
            if(killer != null && killer instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) killer;
                float killedHp = event.getEntityLiving().getMaxHealth();
                float pmRaw = killedHp/2*(event.getEntity().getEntityWorld().getRandom().nextFloat()+0.5f);
                int pmToGive = (int) pmRaw;
                LazyOptional<PM> capability = player.getCapability(CapabilityPM.INSTANCE);;
                if(capability.resolve().isPresent()) {
                    PM cap = capability.resolve().get();
                    cap.pm += pmToGive;
                    player.sendMessage(new StringTextComponent("pm give "+pmToGive+" "+cap.pm),Util.DUMMY_UUID);
                    player.sendStatusMessage(new TranslationTextComponent("com.vuzz."+RayaMod.MOD_ID+".addpm").appendString(" "+pmToGive), true);;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) event.addCapability(PM_ID, new CapabilityProviderPlayers());
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(CapabilityPM.INSTANCE).ifPresent(oldPM ->
            event.getPlayer().getCapability(CapabilityPM.INSTANCE).ifPresent(newPM ->
                    newPM.pm = oldPM.pm
            )
        );
    }    
}
