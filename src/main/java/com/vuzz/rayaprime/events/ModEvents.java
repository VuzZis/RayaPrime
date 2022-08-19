package com.vuzz.rayaprime.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
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
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import com.vuzz.rayaprime.RayaMod;

@Mod.EventBusSubscriber(modid = RayaMod.MOD_ID)
public class ModEvents {

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
                float pmRaw = killedHp/2*(event.getEntity().getEntityWorld().getRandom().nextFloat()+0.5f);
                int pmToGive = (int) pmRaw;
                player.getPersistentData().putInt("pm",Minecraft.getInstance().player.getPersistentData().getInt("pm"));
                player.getPersistentData().putInt("pm",player.getPersistentData().getInt("pm")+pmToGive);
                Minecraft.getInstance().player.getPersistentData().putInt("pm", player.getPersistentData().getInt("pm"));
                //player.sendMessage(new StringTextComponent("pm give "+pmToGive+" "+cap.pm),Util.DUMMY_UUID);
                player.sendStatusMessage(new StringTextComponent("§b+"+pmToGive+" "+new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()), true);;
            }
        }
    }
}
