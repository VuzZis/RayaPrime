package com.vuzz.haloterra.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.OculusEntity;
import com.vuzz.haloterra.entities.custom.PlauntEntity;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
@Mod.EventBusSubscriber(modid = RayaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RAYA_PRIME.get(), RayaPrimeEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.BEYONDTO.get(), BeyondtoEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.OCULUS.get(), OculusEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.OCUBLADE.get(), OcubladeEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.PLAUNT.get(), PlauntEntity.setCustomAttributes().create());
    }
}
