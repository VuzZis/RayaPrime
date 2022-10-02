package com.vuzz.haloterra.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("all")
public class CapabilityPMProvider implements ICapabilitySerializable<INBT> {
    //Capability can be null, but what prevents me from using a ZenStorage instance? X_X
    private static final PM.PMStorage STORAGE = new PM.PMStorage();
    private final PM pm = new PM();
    private final LazyOptional<PM> lazyOptional = LazyOptional.of(() -> pm);


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityPM.INSTANCE) return (LazyOptional<T>) LazyOptional.of(() -> pm);
        return LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        INBT pmNBT = STORAGE.writeNBT(null, pm, null);
        nbt.put("pm", pmNBT);
        return nbt;
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        if(!(nbt instanceof CompoundNBT)) return;
        CompoundNBT compound = (CompoundNBT) nbt;
        STORAGE.readNBT(null, pm, null, compound.get("pm"));
    }
}
