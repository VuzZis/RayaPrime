package com.vuzz.rayaprime.items;

import com.vuzz.rayaprime.RayaMod;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> INACTIVE_IMPLANT = ITEMS.register("inactive_implant", () -> new InactiveRaya());
    public static final RegistryObject<Item> MAIN_IMPLANT = ITEMS.register("main_implant", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> AI_MODULE = ITEMS.register("ai_module", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> FABRICATOR = ITEMS.register("fabricator", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> SCREEN = ITEMS.register("screen", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
