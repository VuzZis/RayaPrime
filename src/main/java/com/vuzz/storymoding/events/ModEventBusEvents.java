package com.vuzz.storymoding.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.entities.ModEntityTypes;
import com.vuzz.storymoding.entities.custom.RayaPrimeEntity;
@Mod.EventBusSubscriber(modid = StoryModing.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RAYA_PRIME.get(), RayaPrimeEntity.setCustomAttributes().create());
    }
}
