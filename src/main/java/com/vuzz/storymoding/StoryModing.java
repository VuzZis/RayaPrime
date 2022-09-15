package com.vuzz.storymoding;

import com.vuzz.storymoding.blocks.ModBlocks;
import com.vuzz.storymoding.effects.ModEffects;
import com.vuzz.storymoding.entities.ModEntityTypes;
import com.vuzz.storymoding.entities.render.RayaPrimeRenderer;
import com.vuzz.storymoding.gui.containers.ModContainers;
import com.vuzz.storymoding.gui.screens.RayaPrimeScreen;
import com.vuzz.storymoding.items.ModItems;
import com.vuzz.storymoding.networking.ClientProxy;
import com.vuzz.storymoding.networking.ServerProxy;
import com.vuzz.storymoding.networking.IProxy;
import com.vuzz.storymoding.networking.Networking;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(StoryModing.MOD_ID)
public class StoryModing {

    public static final String MOD_ID = "storymoding";
    public static final IProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);;

    public static final ItemGroup MOD_GROUP = new ItemGroup(MOD_ID) {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.INACTIVE_IMPLANT.get());
        }
        
    };

    /*public static final ItemGroup CLOTHS_GROUP = new ItemGroup(MOD_ID+"clothes") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.INACTIVE_IMPLANT.get());
        }
    };*/
    
    public StoryModing() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Networking.register();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModContainers.register(eventBus);
        ModEffects.register(eventBus);
        eventBus.addListener(this::doClientStuff);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RAYA_PRIME.get(), RayaPrimeRenderer::new);
        event.enqueueWork(() -> {
            //ScreenManager.registerFactory(ModContainers.RAYA_PRIME_CONTAINER.get(), storymodingScreen::new);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.MR_TOMATO.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.MR_TOMATO_GOLD.get(), RenderType.getCutout());
    }

}
