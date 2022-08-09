package com.vuzz.rayaprime.capabilities.provider;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.vuzz.rayaprime.capabilities.attacher.CapabilityPM;
import com.vuzz.rayaprime.capabilities.storage.player.PM;

@SuppressWarnings("all")
public class CapabilityProviderPlayers implements ICapabilitySerializable<INBT> {
    
    private final PM pm = new PM();

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityPM.INSTANCE) return (LazyOptional<T>) LazyOptional.of(() -> pm);
        return LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        if(CapabilityPM.INSTANCE == null) return nbt;
        INBT pmNBT = CapabilityPM.INSTANCE.writeNBT(pm, null);
        nbt.put("pm", pmNBT);
        return nbt;
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        if(CapabilityPM.INSTANCE == null) return;
        if(!(nbt instanceof CompoundNBT)) return;
        CompoundNBT compound = (CompoundNBT) nbt;
        CapabilityPM.INSTANCE.readNBT(pm, null, compound.get("pm"));
    }

}
