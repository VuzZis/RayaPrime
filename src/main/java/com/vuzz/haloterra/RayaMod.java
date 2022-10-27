package com.vuzz.haloterra;

import com.vuzz.haloterra.blocks.ModBlocks;
import com.vuzz.haloterra.config.HaloTerraCommonConfig;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.render.RayaPrimeRenderer;
import com.vuzz.haloterra.entities.render.BeyondtoRenderer;
import com.vuzz.haloterra.entities.render.OcubladeRenderer;
import com.vuzz.haloterra.entities.render.OculusRender;
import com.vuzz.haloterra.entities.render.PlauntRenderer;
import com.vuzz.haloterra.gui.containers.ModContainers;
import com.vuzz.haloterra.gui.screens.ChargePadScreen;
import com.vuzz.haloterra.gui.screens.RayaPrimeScreen;
import com.vuzz.haloterra.items.ModItems;
import com.vuzz.haloterra.networking.ClientProxy;
import com.vuzz.haloterra.networking.ServerProxy;
import com.vuzz.haloterra.networking.IProxy;
import com.vuzz.haloterra.networking.Networking;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RayaMod.MOD_ID)
public class RayaMod {

    public static final String MOD_ID = "haloterra";
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
    
    public RayaMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Networking.register();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModContainers.register(eventBus);
        ModEffects.register(eventBus);
        ModLoadingContext.get().registerConfig(Type.COMMON,HaloTerraCommonConfig.SPEC,"haloterra-common.toml");
        eventBus.addListener(this::doClientStuff);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RAYA_PRIME.get(), RayaPrimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BEYONDTO.get(), BeyondtoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.OCULUS.get(), OculusRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.OCUBLADE.get(), OcubladeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PLAUNT.get(), PlauntRenderer::new);
        event.enqueueWork(() -> {
            clientSetup(event);
            ScreenManager.registerFactory(ModContainers.RAYA_PRIME_CONTAINER.get(), RayaPrimeScreen::new);
            ScreenManager.registerFactory(ModContainers.CHARGE_PAD_CONTAINER.get(), ChargePadScreen::new);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.MR_TOMATO.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.MR_TOMATO_GOLD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COMPUTER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAPES.get(), RenderType.getCutout());
    }

}
