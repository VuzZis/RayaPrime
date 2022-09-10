package com.vuzz.rayaprime.effects;

import com.vuzz.rayaprime.RayaMod;

import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModEffects {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, MODID);
    public static final RegistryObject<Effect> HYBERNATION = EFFECTS.register("hybernation", 
        () -> new EffectHybernation());

	public static void register(IEventBus eventBus) {
		EFFECTS.register(eventBus);
	}
}
