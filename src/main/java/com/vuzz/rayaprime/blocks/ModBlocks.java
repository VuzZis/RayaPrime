package com.vuzz.rayaprime.blocks;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.vuzz.rayaprime.RayaMod;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlocks {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", () -> new Block(Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
