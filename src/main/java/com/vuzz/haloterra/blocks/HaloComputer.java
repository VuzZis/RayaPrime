package com.vuzz.haloterra.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;

public class HaloComputer extends DirectionalBlock {

    public HaloComputer() {
        super(
            Properties.create(Material.IRON)
                .hardnessAndResistance(2f)
        );
    }


    
}
