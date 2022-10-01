package com.vuzz.rayaprime.world.gen;

import com.vuzz.rayaprime.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {
    
    
    LEAD(Lazy.of(ModBlocks.LEAD_ORE),7,10,30),
    LITHIUM(Lazy.of(ModBlocks.LITHIUM_ORE),4,5,20);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight,int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }
    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
