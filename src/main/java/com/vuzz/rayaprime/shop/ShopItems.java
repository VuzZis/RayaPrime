package com.vuzz.rayaprime.shop;

import java.util.ArrayList;

import com.vuzz.rayaprime.items.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShopItems {
    public static ArrayList<ItemStack> getItems() {

        ArrayList<ItemStack> shopItems = new ArrayList<ItemStack>();
        addItem(shopItems, Items.APPLE, 16); //1
        addItem(shopItems, Items.STONE, 16); //2
        addItem(shopItems, Items.BONE, 8); //3
        addItem(shopItems, Items.OAK_LOG, 12); //4
        addItem(shopItems, Items.BIRCH_LOG, 12); //5
        addItem(shopItems, Items.SPRUCE_LOG, 12); //6
        addItem(shopItems, Items.COAL, 20); //7
        addItem(shopItems, Items.DIAMOND, 1); //8
        addItem(shopItems, Items.IRON_ORE, 10); //9
        addItem(shopItems, Items.ANDESITE, 16); //10
        addItem(shopItems, Items.NETHERITE_SCRAP, 1); //11
        addItem(shopItems, Items.REDSTONE, 16); //12
        addItem(shopItems, ModItems.INACTIVE_BEYONDTO.get(), 1); //13
        return shopItems;

    }

    public static ArrayList<Number> getPrices() {
        
        ArrayList<Number> shopPrices = new ArrayList<Number>();
        addPrice(shopPrices,10); //1
        addPrice(shopPrices,20); //2
        addPrice(shopPrices,8); //3
        addPrice(shopPrices,25); //4
        addPrice(shopPrices,25); //5
        addPrice(shopPrices,25); //6
        addPrice(shopPrices,30); //7
        addPrice(shopPrices,60); //8
        addPrice(shopPrices,32); //9
        addPrice(shopPrices,12); //10
        addPrice(shopPrices,130); //11
        addPrice(shopPrices,30); //12
        addPrice(shopPrices,100); //13
        addPrice(shopPrices,120); //14

        return shopPrices;
    }

    public static void addItem(ArrayList<ItemStack> array, Item itemRegistry, int count) {
        ItemStack stack = new ItemStack(itemRegistry);
                stack.setCount(count);
        array.add(stack);
    }
    public static void addPrice(ArrayList<Number> array, int price) {
        array.add(price);
    }
}
