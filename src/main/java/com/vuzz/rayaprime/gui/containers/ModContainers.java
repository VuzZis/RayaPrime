package com.vuzz.rayaprime.gui.containers;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.vuzz.rayaprime.RayaMod;

public class ModContainers {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);
    public static final RegistryObject<ContainerType<RayaPrimeContainer>> RAYA_PRIME_CONTAINER = CONTAINERS.register("raya_prime_container", 
    () -> IForgeContainerType.create((windowId,inv,data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new RayaPrimeContainer(windowId,world,pos,inv,inv.player);
    }));

    public static void register(IEventBus eventbus) {
        CONTAINERS.register(eventbus);
    }
}
