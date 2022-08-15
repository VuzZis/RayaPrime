package com.vuzz.rayaprime.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class RayaPrimeContainer extends Container {

    private final PlayerEntity playerEntity;
    private final IItemHandler playerInventory;

    public RayaPrimeContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ModContainers.RAYA_PRIME_CONTAINER.get(), windowId);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);
    }

    @Override
    public boolean canInteractWith(PlayerEntity arg0) {
        return true;
    }
    
}
