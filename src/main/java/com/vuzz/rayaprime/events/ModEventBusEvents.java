package com.vuzz.rayaprime.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.entities.ModEntityTypes;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;
@Mod.EventBusSubscriber(modid = RayaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RAYA_PRIME.get(), RayaPrimeEntity.setCustomAttributes().create());
    }
}
