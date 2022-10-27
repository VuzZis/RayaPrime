package com.vuzz.haloterra.blocks;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.blocks.crops.GrapeBlock;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlocks {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", () -> new Block(Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));
    public static final RegistryObject<Block> LITHIUM_ORE = BLOCKS.register("lithium_ore", () -> new Block(Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));
    public static final RegistryObject<Block> ENERGY_ORE = BLOCKS.register("energy_ore", () -> new Block(Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));
    public static final RegistryObject<Block> MR_TOMATO = BLOCKS.register("mrtomato", () -> new Block(Properties.create(Material.BAMBOO).hardnessAndResistance(2f).notSolid()));
    public static final RegistryObject<Block> MR_TOMATO_GOLD = BLOCKS.register("mrtomato_gold", () -> new Block(Properties.create(Material.BAMBOO).hardnessAndResistance(2f).notSolid()));
    public static final RegistryObject<Block> COMPUTER = BLOCKS.register("computer", HaloComputer::new);

    public static final RegistryObject<Block> LABORATORY_BRICK = BLOCKS.register("laboratory_brick", () -> new Block(Properties.create(Material.ROCK).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(10f)));
    public static final RegistryObject<Block> LABORATORY_FLOOR = BLOCKS.register("laboratory_floor", () -> new Block(Properties.create(Material.ROCK).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(10f)));

    public static final RegistryObject<Block> PLUSH_VUZZ = BLOCKS.register("plush_vuzz", () -> new RotateableBlock(Properties.create(Material.BAMBOO).hardnessAndResistance(2f).notSolid()));
    public static final RegistryObject<Block> PLUSH_BLACK = BLOCKS.register("plush_black", () -> new RotateableBlock(Properties.create(Material.BAMBOO).hardnessAndResistance(2f).notSolid()));
    public static final RegistryObject<Block> PLUSH_TIMA = BLOCKS.register("plush_tima", () -> new RotateableBlock(Properties.create(Material.BAMBOO).hardnessAndResistance(2f).notSolid()));
    public static final RegistryObject<Block> PLUSH_HUNTER = BLOCKS.register("plush_hunter", () -> new RotateableBlock(Properties.create(Material.BAMBOO).hardnessAndResistance(2f).notSolid()));

    public static final RegistryObject<Block> GRAPES = BLOCKS.register("grapes_crop",GrapeBlock::new);

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
