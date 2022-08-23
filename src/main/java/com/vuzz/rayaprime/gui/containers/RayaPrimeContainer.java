package com.vuzz.rayaprime.gui.containers;

import java.util.ArrayList;
import com.vuzz.rayaprime.gui.SlotLocked;
import com.vuzz.rayaprime.shop.ShopItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class RayaPrimeContainer extends Container {

    public final PlayerEntity playerEntity;
    private final PlayerInventory playerInventory;
    private final IInventory shopInv = new Inventory(15);
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();

    public RayaPrimeContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ModContainers.RAYA_PRIME_CONTAINER.get(), windowId);
        this.playerEntity = player;
        this.playerInventory = playerInventory;

        for(int i = 0; i < 15; i++) {
            int xBox = i % 5;
            int yBox = (int) Math.floor(i/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            SlotLocked slot = new SlotLocked(shopInv,i,11+xBox-40+1,6+yBox+6);
            if(i < shopItems.size()) {
                ItemStack stackForShop = shopItems.get(i);
                slot.putStack(stackForShop);
            }
            addSlot(
                slot
            );
        };
        
    }

    @Override
    public boolean canInteractWith(PlayerEntity arg0) {
        return true;
    }
    
}
