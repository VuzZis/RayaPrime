package com.vuzz.rayaprime.events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
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
                float pmRaw = (float) (killedHp/2.25*(event.getEntity().getEntityWorld().getRandom().nextFloat()+0.5f));
                int pmToGive = (int) pmRaw;
                int pmClient = Minecraft.getInstance().player.getPersistentData().getInt("pm");
                int pmServer = player.getPersistentData().getInt("pm");
                player.getPersistentData().putInt("pm", pmServer+pmToGive);
                Minecraft.getInstance().player.getPersistentData().putInt("pm", pmServer+pmToGive);
                //player.sendMessage(new StringTextComponent("pm give "+pmToGive+" "+cap.pm),Util.DUMMY_UUID);
                String ablob = new TranslationTextComponent("title."+RayaMod.MOD_ID+".ablob").getString();
                player.sendStatusMessage(new StringTextComponent(ablob+pmToGive+" "+new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()), true);
            }
        }
    }
}
