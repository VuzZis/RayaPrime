package com.vuzz.rayaprime.capabilities.storage.player;

import javax.annotation.Nonnull;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PM {
    public int pm;

    @Nonnull
    public static PM defaultInstance() {
        PM pm = new PM();
        return pm;
    }

    public static final class PMStorage implements Capability.IStorage<PM> {
        @Nonnull
        @Override
        public INBT writeNBT(Capability<PM> capability, @Nonnull PM instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("pm", instance.pm);
            return nbt;
        }

        @Override
        public void readNBT(Capability<PM> capability, PM instance, Direction side, INBT nbt) {
            if (!(nbt instanceof CompoundNBT)) return;
            CompoundNBT compound = (CompoundNBT) nbt;
            instance.pm = compound.getInt("pm");
        }
    }
}
