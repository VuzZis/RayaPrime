package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.blocks.ModBlocks;
import com.vuzz.haloterra.items.armor.ModArmors;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
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
    //public static final RegistryObject<Item> ENERGY_PAD = ITEMS.register("energy_pad", ChargePad::new);
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
    
    public static final RegistryObject<Item> CAN = ITEMS.register("can", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> BERRY_SODA = ITEMS.register("berry_soda", () -> new DrinkBase(3,600));
    public static final RegistryObject<Item> GEPARD_SODA = ITEMS.register("gepard_soda", () -> new DrinkBase(2,700));
    public static final RegistryObject<Item> FRESH_SODA = ITEMS.register("fresh_soda", () -> new DrinkBase(4,1200));
    public static final RegistryObject<Item> SEA_SODA = ITEMS.register("sea_soda", () -> new DrinkBase(3,1200));
    

    public static final RegistryObject<Item> CUP = ITEMS.register("cup", () -> new Item(new Item.Properties().group(RayaMod.MOD_GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> VUZZ_GRANDE = ITEMS.register("vuzz_grande", () -> new SimpleEffectDrink(Effects.INVISIBILITY, 1200, 0));
    public static final RegistryObject<Item> AVIAN_ABUNDANCE = ITEMS.register("avian_abundance", () -> new SimpleEffectDrink(Effects.SLOW_FALLING, 600, 1));
    public static final RegistryObject<Item> COCOA = ITEMS.register("cocoa", () -> new SimpleEffectDrink(Effects.HASTE, 2400, 1));
    public static final RegistryObject<Item> LEMON_TEA = ITEMS.register("lemon_tea", () -> new SimpleEffectDrink(Effects.REGENERATION, 1200, 2));
    public static final RegistryObject<Item> MOCHITO = ITEMS.register("mochito", () -> new SimpleEffectDrink(Effects.SPEED, 1200, 2));
    public static final RegistryObject<Item> TEA_LA_GRAF = ITEMS.register("tea_la_graf", () -> new SimpleEffectDrink(Effects.JUMP_BOOST, 1200, 3));
    public static final RegistryObject<Item> REVIVUS_TEA = ITEMS.register("revivus_tea", () -> new SimpleEffectDrink(Effects.STRENGTH, 2400, 10,true));

    public static final RegistryObject<Item> PLUSH_BLACK = ITEMS.register("plush_black", () -> new BlockItem(ModBlocks.PLUSH_BLACK.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> PLUSH_TIMA = ITEMS.register("plush_tima", () -> new BlockItem(ModBlocks.PLUSH_TIMA.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> PLUSH_VUZZ = ITEMS.register("plush_vuzz", () -> new BlockItem(ModBlocks.PLUSH_VUZZ.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));
    public static final RegistryObject<Item> PLUSH_HUNTER = ITEMS.register("plush_hunter", () -> new BlockItem(ModBlocks.PLUSH_HUNTER.get(), new Item.Properties().group(RayaMod.MOD_GROUP)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
        ModArmors.register(eventbus);
    }
}
