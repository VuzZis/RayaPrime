package com.vuzz.haloterra.entities;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import com.vuzz.haloterra.entities.custom.OculusEntity;
import com.vuzz.haloterra.entities.custom.PlauntEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
        = DeferredRegister.create(ForgeRegistries.ENTITIES, RayaMod.MOD_ID);
    
    public static final RegistryObject<EntityType<RayaPrimeEntity>> RAYA_PRIME =
        ENTITY_TYPES.register("raya_prime",
            () -> EntityType.Builder.create(RayaPrimeEntity::new,
                    EntityClassification.AMBIENT).size(0.75f,0.75f)
                .build(new ResourceLocation(RayaMod.MOD_ID, "raya_prime").toString()));

    public static final RegistryObject<EntityType<OculusEntity>> OCULUS =
        ENTITY_TYPES.register("oculus",
            () -> EntityType.Builder.create(OculusEntity::new,
                    EntityClassification.AMBIENT).size(0.8f,1.3f)
                .build(new ResourceLocation(RayaMod.MOD_ID, "oculus").toString()));

    public static final RegistryObject<EntityType<RehoboamEntity>> REHOBOAM =
        ENTITY_TYPES.register("rehoboam",
            () -> EntityType.Builder.create(RehoboamEntity::new,
                    EntityClassification.AMBIENT).size(1.3f,1.3f)
                .build(new ResourceLocation(RayaMod.MOD_ID, "rehoboam").toString()));

    public static final RegistryObject<EntityType<PlauntEntity>> PLAUNT =
        ENTITY_TYPES.register("plaunt",
            () -> EntityType.Builder.create(PlauntEntity::new,
                    EntityClassification.AMBIENT).size(0.8f,1.3f)
                .build(new ResourceLocation(RayaMod.MOD_ID, "plaunt").toString()));

    public static final RegistryObject<EntityType<BeyondtoEntity>> BEYONDTO =
    ENTITY_TYPES.register("beyondto",
        () -> EntityType.Builder.create(BeyondtoEntity::new,
                EntityClassification.AMBIENT).size(0.55f,1.5f)
            .build(new ResourceLocation(RayaMod.MOD_ID, "beyondto").toString()));

    public static final RegistryObject<EntityType<OcubladeEntity>> OCUBLADE =
    ENTITY_TYPES.register("ocublade",
        () -> EntityType.Builder.create(OcubladeEntity::new,
                EntityClassification.MISC).size(0.1f,0.1f)
            .build(new ResourceLocation(RayaMod.MOD_ID, "ocublade").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
