package com.vuzz.storymoding.entities;

import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.entities.custom.RayaPrimeEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
        = DeferredRegister.create(ForgeRegistries.ENTITIES, StoryModing.MOD_ID);
    
    public static final RegistryObject<EntityType<RayaPrimeEntity>> RAYA_PRIME =
        ENTITY_TYPES.register("raya_prime",
            () -> EntityType.Builder.create(RayaPrimeEntity::new,
                    EntityClassification.AMBIENT).size(0.75f,0.75f)
                .build(new ResourceLocation(StoryModing.MOD_ID, "raya_prime").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
