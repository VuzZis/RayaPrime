package com.vuzz.haloterra.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;

public class HaloTerraCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<ArrayList<ArrayList<String>>> RAYAPRIME_SHOP;

    static {
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        addItem(items,"minecraft:carrot","5","5");
        addItem(items,"minecraft:iron_ore","10","20");
        addItem(items,"haloterra:lead_ore","15","20");
        addItem(items,"haloterra:lithium_ore","8","20");
        addItem(items,"minecraft:wheat_seeds","16","5");
        addItem(items,"minecraft:bone","4","8");
        addItem(items,"minecraft:oak_log","16","10");
        addItem(items,"minecraft:dark_oak_log","16","10");
        addItem(items,"minecraft:birch_log","16","10");
        addItem(items,"minecraft:acacia_log","16","12");
        addItem(items,"minecraft:sand","16","12");
        addItem(items,"minecraft:diamond","1","50");
        addItem(items,"minecraft:cactus","4","8");
        addItem(items,"minecraft:lava_bucket","1","12");
        addItem(items,"minecraft:dirt","32","12");
        addItem(items,"minecraft:coal","8","8");
        addItem(items,"minecraft:spawner","1","1200");
        addItem(items,"minecraft:clay","8","14");
        addItem(items,"haloterra:transistor","9","20");
        addItem(items,"haloterra:condensator","8","18");
        addItem(items,"minecraft:white_wool","10","15");
        addItem(items,"minecraft:redstone","5","8");
        addItem(items,"minecraft:cobblestone","20","12");
        addItem(items,"minecraft:obsidian","2","20");
        addItem(items,"minecraft:netherite_scrap","1","200");
        addItem(items,"minecraft:andesite","15","10");
            BUILDER.push("Configs for RayaPrime Shop");
                RAYAPRIME_SHOP = BUILDER.comment("Put your items here")
                    .define("Items", 
                        items
                    );

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    static void addItem(ArrayList<ArrayList<String>> array, String id, String count, String price) {
        array.add(createItem(id,count,price));
    }
 
    
    static ArrayList<String> createItem(String id, String count, String price) {
        ArrayList<String> a = new ArrayList<String>();
            a.add(id);
            a.add(count);
            a.add(price);
        return a;
    }
}
