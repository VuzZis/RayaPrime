package com.vuzz.rayaprime.containers;

import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;

import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class RayaPrimeContainer extends Container {

    private final PlayerEntity playerEntity;
    private final PlayerInventory playerInventory;
    private final RayaPrimeEntity raya;

    public RayaPrimeContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, RayaPrimeEntity raya) {
        super(ModContainers.RAYA_PRIME_CONTAINER.get(), windowId);
        this.playerEntity = player;
        this.playerInventory = playerInventory;
        this.raya = raya;
        for(int i = 0; i < 15; i++) {
            int xBox = i % 5;
            int yBox = (int) Math.floor(i/3);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            addSlot(
                new Slot(raya.shopInv,i,11+xBox-40,11+yBox-40)
            );
        };
    }

    @Override
    public boolean canInteractWith(PlayerEntity arg0) {
        return true;
    }
    
}
