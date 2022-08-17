package com.vuzz.rayaprime.shop;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShopItems {
    public final ArrayList<Number> shopPrices = new ArrayList<Number>();

    public static ArrayList<ItemStack> getItems() {

        ArrayList<ItemStack> shopItems = new ArrayList<ItemStack>();
        ItemStack apples = new ItemStack(Items.APPLE);
                apples.setCount(16);
        shopItems.add(apples);

        return shopItems;
    }

    public static ArrayList<Number> getPrices() {
        
        ArrayList<Number> shopPrices = new ArrayList<Number>();
        shopPrices.add(10);

        return shopPrices;
    }
}
