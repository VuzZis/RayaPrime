package com.vuzz.rayaprime.shop;

import java.util.ArrayList;

import com.vuzz.rayaprime.items.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShopItems {
    public final ArrayList<Number> shopPrices = new ArrayList<Number>();

    public static ArrayList<ItemStack> getItems() {

        ArrayList<ItemStack> shopItems = new ArrayList<ItemStack>();
        ItemStack apples = new ItemStack(Items.APPLE); //1
                apples.setCount(16);
        shopItems.add(apples);

        ItemStack logs = new ItemStack(Items.STONE); //2
                logs.setCount(16);
        shopItems.add(logs);

        ItemStack bones = new ItemStack(Items.BONE); //3
                bones.setCount(8);
        shopItems.add(bones);

        ItemStack oaklog = new ItemStack(Items.OAK_LOG); //4
                oaklog.setCount(12);
        shopItems.add(oaklog);

        ItemStack coal = new ItemStack(Items.COAL); //5
                coal.setCount(20);
        shopItems.add(coal);

        ItemStack diamond = new ItemStack(Items.DIAMOND); //6
                diamond.setCount(1);
        shopItems.add(diamond);

        ItemStack iron_ore = new ItemStack(Items.IRON_ORE); //7
                iron_ore.setCount(10);
        shopItems.add(iron_ore);

        ItemStack andesite = new ItemStack(Items.ANDESITE); //8
                andesite.setCount(16);
        shopItems.add(andesite);

        ItemStack birch_log = new ItemStack(Items.BIRCH_LOG); //9
                birch_log.setCount(12);
        shopItems.add(birch_log);

        ItemStack spruce_log = new ItemStack(Items.SPRUCE_LOG); //10
                spruce_log.setCount(12);
        shopItems.add(spruce_log);

        ItemStack netherite = new ItemStack(Items.NETHERITE_SCRAP); //11
                netherite.setCount(1);
        shopItems.add(netherite);

        ItemStack redstone = new ItemStack(Items.REDSTONE); //12
                redstone.setCount(16);
        shopItems.add(redstone);

        ItemStack mrtomato = new ItemStack(ModItems.MR_TOMATO.get()); //13
                mrtomato.setCount(1);
        shopItems.add(mrtomato);

        ItemStack mrtomato_gold = new ItemStack(ModItems.MR_TOMATO_GOLD.get()); //14
                mrtomato_gold.setCount(1);
        shopItems.add(mrtomato_gold);

        return shopItems;
    }

    public static ArrayList<Number> getPrices() {
        
        ArrayList<Number> shopPrices = new ArrayList<Number>();
        shopPrices.add(10); //1
        shopPrices.add(25); //2
        shopPrices.add(12); //3
        shopPrices.add(25); //4
        shopPrices.add(8); //5
        shopPrices.add(50); //6
        shopPrices.add(30); //7
        shopPrices.add(20); //8
        shopPrices.add(25); //9
        shopPrices.add(25); //10
        shopPrices.add(120); //11
        shopPrices.add(30); //12
        shopPrices.add(70); //13
        shopPrices.add(120); //14

        return shopPrices;
    }
}
