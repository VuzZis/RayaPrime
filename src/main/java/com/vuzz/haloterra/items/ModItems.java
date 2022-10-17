package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.blocks.ModBlocks;
import com.vuzz.haloterra.items.armor.ModArmors;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> INACTIVE_IMPLANT = ITEMS.register("inactive_implant", InactiveRaya::new);
    public static final RegistryObject<Item> INACTIVE_BEYONDTO = ITEMS.register("inactive_beyondto", InactiveBeyondto::new);
    public static final RegistryObject<Item> INACTIVE_OCULUS = ITEMS.register("inactive_oculus", InactiveOculus::new);
    public static final RegistryObject<Item> INACTIVE_PLAUNT = ITEMS.register("inactive_plaunt", InactivePlaunt::new);
    public static final RegistryObject<Item> MAIN_IMPLANT = ITEMS.register("main_implant", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> ENERGY_PAD = ITEMS.register("energy_pad", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> AI_MODULE = ITEMS.register("ai_module", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> FABRICATOR = ITEMS.register("fabricator", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> ENERGY_SHARD = ITEMS.register("energy_shard", () -> new EnergyItem(50));
    public static final RegistryObject<Item> ACTIVE_ENERGY_SHARD = ITEMS.register("active_energy_shard", () -> new EnergyItem(250));
    public static final RegistryObject<Item> SCREEN = ITEMS.register("screen", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_ORE = ITEMS.register("lead_ore", () -> new BlockItem(ModBlocks.LEAD_ORE.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> LITHIUM_ORE = ITEMS.register("lithium_ore", () -> new BlockItem(ModBlocks.LITHIUM_ORE.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> ENERGY_ORE = ITEMS.register("energy_ore", () -> new BlockItem(ModBlocks.ENERGY_ORE.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    //public static final RegistryObject<Item> COMPUTER = ITEMS.register("computer", () -> new BlockItem(ModBlocks.COMPUTER.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> CLSC = ITEMS.register("clsc", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> GMNC = ITEMS.register("gmnc", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> COAL_PLATE = ITEMS.register("coal_plate", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> MICROSCHEME = ITEMS.register("microscheme", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> PROJECTOR_MODULE = ITEMS.register("projector_module", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> TRANSISTOR = ITEMS.register("transistor", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> RESISTOR = ITEMS.register("resistor", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> TRANSISTOR_PACK = ITEMS.register("transistorpack", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> CPU = ITEMS.register("cpu", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> CONDENSATOR = ITEMS.register("condensator", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> RAYAPRIME_OS = ITEMS.register("rayaprime_os", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> BEYONDTO_OS = ITEMS.register("beyondto_os", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> OCULUS_OS = ITEMS.register("oculus_os", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> MR_TOMATO = ITEMS.register("mrtomato", () -> new BlockItem(ModBlocks.MR_TOMATO.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> MR_TOMATO_GOLD = ITEMS.register("mrtomato_gold", () -> new BlockItem(ModBlocks.MR_TOMATO_GOLD.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new BlockItem(ModBlocks.GRAPES.get(), new Item.Properties().group(RayaMod.MOD_GROUP).food(new Food.Builder().hunger(1).saturation(0).fastToEat().build())));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP).maxStackSize(16).food(new Food.Builder().hunger(5).saturation(10).build())));
    
    public static final RegistryObject<Item> VODKA = ITEMS.register("vodka", () -> new DrinkBase(5,600));
    public static final RegistryObject<Item> WINE = ITEMS.register("wine", () -> new DrinkBase(2,700));
    public static final RegistryObject<Item> BEER = ITEMS.register("beer", () -> new DrinkBase(7,1200));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
        ModArmors.register(eventbus);
    }
}
