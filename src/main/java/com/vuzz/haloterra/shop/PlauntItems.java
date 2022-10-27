package com.vuzz.haloterra.shop;

import java.util.ArrayList;

import com.vuzz.haloterra.config.HaloTerraCommonConfig;
import com.vuzz.haloterra.items.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class PlauntItems {
    public static ArrayList<Item> getInputItems() {
        ArrayList<ArrayList<String>> config = HaloTerraCommonConfig.PLAUNT_PLANTS.get();
        ArrayList<Item> shopItems = parseItems(config);
        /*addItem(shopItems, Items.APPLE, 8); //1
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
        addItem(shopItems, Items.BASALT, 1); //15*/
        return shopItems;

    }

    public static ArrayList<Item> parseItems(ArrayList<ArrayList<String>> configArray) {
        ArrayList<Item> shopItems = new ArrayList<Item>();
        configArray.forEach((e) -> {
            String id = e.get(0);
            String modId = "minecraft";
            String name = "";
            if(id.indexOf(":") != -1) {
                modId = id.substring(0,id.indexOf(":"));
            }
            name = id.substring(id.indexOf(":")+1);
            Item itemReg = ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, name));
            shopItems.add(itemReg);
        });
        return shopItems;
    }

    public static ArrayList<Item> parseOutputItems(ArrayList<ArrayList<String>> configArray) {
        ArrayList<Item> shopItems = new ArrayList<Item>();
        configArray.forEach((e) -> {
            String id = e.get(1);
            String modId = "minecraft";
            String name = "";
            if(id.indexOf(":") != -1) {
                modId = id.substring(0,id.indexOf(":"));
            }
            name = id.substring(id.indexOf(":")+1);
            Item itemReg = ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, name));
            shopItems.add(itemReg);
        });
        return shopItems;
    }
    public static ArrayList<Item> getOutputItems() {
        ArrayList<ArrayList<String>> config = HaloTerraCommonConfig.PLAUNT_PLANTS.get();
        ArrayList<Item> shopPrices = parseOutputItems(config);
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
