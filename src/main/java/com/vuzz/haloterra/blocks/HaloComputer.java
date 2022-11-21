package com.vuzz.haloterra.blocks;

import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.Material;

public class HaloComputer extends DirectionalBlock {

    public HaloComputer() {
        super(
            Properties.create(Material.IRON)
                .hardnessAndResistance(2f)
                .notSolid()
        );
    }


    
}
