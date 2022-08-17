package com.vuzz.rayaprime;

import com.vuzz.rayaprime.blocks.ModBlocks;
import com.vuzz.rayaprime.entities.ModEntityTypes;
import com.vuzz.rayaprime.entities.render.RayaPrimeRenderer;
import com.vuzz.rayaprime.gui.containers.ModContainers;
import com.vuzz.rayaprime.gui.screens.RayaPrimeScreen;
import com.vuzz.rayaprime.items.ModItems;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RayaMod.MOD_ID)
public class RayaMod {

    public static final String MOD_ID = "rayaprime";

    public static final ItemGroup MOD_GROUP = new ItemGroup(MOD_ID) {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.INACTIVE_IMPLANT.get());
        }
        
    };
    
    public RayaMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModContainers.register(eventBus);
        eventBus.addListener(this::doClientStuff);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RAYA_PRIME.get(), RayaPrimeRenderer::new);
        event.enqueueWork(() -> {
            ScreenManager.registerFactory(ModContainers.RAYA_PRIME_CONTAINER.get(), RayaPrimeScreen::new);
        });
    }

    private void setup(final FMLClientSetupEvent event) {

    }

}
