package com.vuzz.haloterra.blocks.crops;

import com.vuzz.haloterra.items.ModItems;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class GrapeBlock extends CropsBlock {


    public GrapeBlock() {
        super(AbstractBlock.Properties.from(Blocks.CARROTS));
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return ModItems.GRAPE_SEEDS.get();
    }

    @Override
    public VoxelShape getShape(BlockState bs, IBlockReader br, BlockPos bp,
            ISelectionContext ctx) {
        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
    }

    @Override
    public int getMaxAge() {
        return 4;
    }
    
}
