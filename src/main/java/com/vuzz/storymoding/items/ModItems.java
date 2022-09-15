package com.vuzz.storymoding.items;

import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.blocks.ModBlocks;
import com.vuzz.storymoding.items.armor.ModArmors;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {
    private final static String MODID = StoryModing.MOD_ID;
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> INACTIVE_IMPLANT = ITEMS.register("inactive_implant", () -> new InactiveRaya());
    public static final RegistryObject<Item> MAIN_IMPLANT = ITEMS.register("main_implant", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> AI_MODULE = ITEMS.register("ai_module", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> FABRICATOR = ITEMS.register("fabricator", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> SCREEN = ITEMS.register("screen", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_ORE = ITEMS.register("lead_ore", () -> new BlockItem(ModBlocks.LEAD_ORE.get(), new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> CLSC = ITEMS.register("clsc", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> COAL_PLATE = ITEMS.register("coal_plate", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    public static final RegistryObject<Item> MICROSCHEME = ITEMS.register("microscheme", () -> new Item(new Item.Properties().group(StoryModing.MOD_GROUP)));
    //public static final RegistryObject<Item> MR_TOMATO = ITEMS.register("mrtomato", () -> new BlockItem(ModBlocks.MR_TOMATO.get(), new Item.Properties().group(StoryModing.MOD_GROUP)));
    //public static final RegistryObject<Item> MR_TOMATO_GOLD = ITEMS.register("mrtomato_gold", () -> new BlockItem(ModBlocks.MR_TOMATO_GOLD.get(), new Item.Properties().group(StoryModing.MOD_GROUP)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
        ModArmors.register(eventbus);
    }
}
