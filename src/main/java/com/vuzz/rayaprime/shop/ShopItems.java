package com.vuzz.rayaprime.shop;

import java.util.ArrayList;

import com.vuzz.rayaprime.items.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class ShopItems {
    public static ArrayList<ItemStack> getItems() {

        ArrayList<ItemStack> shopItems = new ArrayList<ItemStack>();
        addItem(shopItems, Items.APPLE, 8); //1
        addItem(shopItems, Items.IRON_ORE, 8); //2
        addItem(shopItems, Items.WHEAT_SEEDS, 16); //3
        addItem(shopItems, Items.BONE, 4); //4
        addItem(shopItems, ModItems.LITHIUM_ORE, 8); //5
        addItem(shopItems, ModItems.LEAD_ORE, 8); //6
        addItem(shopItems, Items.OAK_LOG, 16); //7
        addItem(shopItems, Items.SPRUCE_LOG, 16); //8
        addItem(shopItems, Items.BIRCH_LOG, 16); //9
        addItem(shopItems, Items.DIAMOND, 1); //10
        addItem(shopItems, Items.CACTUS, 4); //11
        addItem(shopItems, Items.LAVA_BUCKET, 1); //12
        addItem(shopItems, Items.DIRT, 32); //13
        addItem(shopItems, Items.COAL, 10); //14
        addItem(shopItems, Items.SPAWNER, 1); //15
        addItem(shopItems, Items.ANVIL, 1); //15
        addItem(shopItems, Items.BASALT, 1); //15
        return shopItems;

    }

    public static ArrayList<Number> getPrices() {
        
        ArrayList<Number> shopPrices = new ArrayList<Number>();
        addPrice(shopPrices,8); //1
        addPrice(shopPrices,20); //2
        addPrice(shopPrices,8); //3
        addPrice(shopPrices,10); //4
        addPrice(shopPrices,30); //5
        addPrice(shopPrices,15); //6
        addPrice(shopPrices,10); //7
        addPrice(shopPrices,10); //8
        addPrice(shopPrices,10); //9
        addPrice(shopPrices,60); //10
        addPrice(shopPrices,10); //11
        addPrice(shopPrices,6); //12
        addPrice(shopPrices,15); //13
        addPrice(shopPrices,8); //14
        addPrice(shopPrices,1000); //15
        addPrice(shopPrices,1000); //15
        addPrice(shopPrices,1000); //15
        return shopPrices;
    }

    public static void addItem(ArrayList<ItemStack> array, Item itemRegistry, int count) {
        ItemStack stack = new ItemStack(itemRegistry);
                stack.setCount(count);
        array.add(stack);
    }

    public static void addItem(ArrayList<ItemStack> array, RegistryObject<Item> itemRegistry, int count) {
        ItemStack stack = new ItemStack(itemRegistry.get());
                stack.setCount(count);
        array.add(stack);
    }

    public static void addPrice(ArrayList<Number> array, int price) {
        array.add(price);
    }
}
