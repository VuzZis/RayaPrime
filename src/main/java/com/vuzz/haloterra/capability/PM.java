package com.vuzz.haloterra.capability;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;

import javax.annotation.Nonnull;

import com.vuzz.haloterra.networking.Networking;
import com.vuzz.haloterra.networking.PMUpdatePacket;
import com.vuzz.haloterra.networking.PMUpdatePacketClient;

public class PM {
    private int pm;
    private int progress;

    public static LazyOptional<PM> get(Entity entity) {
        return entity.getCapability(CapabilityPM.INSTANCE);
    }

    public void sync(ServerPlayerEntity player) {
        Networking.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new PMUpdatePacket(this));
    }

    public void sync(ClientPlayerEntity player) {
        Networking.CHANNEL.send(PacketDistributor.SERVER.with(() -> null), new PMUpdatePacketClient(this));
    }

    public int getPm() {
        return pm;
    }

    public int getProgress() {
        return progress;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean hasPm() {
        return pm > 0;
    }

    public boolean hasProgress() {
        return progress > 0;
    }

    public static final class PMStorage implements Capability.IStorage<PM> {
        @Nonnull
        @Override
        public INBT writeNBT(Capability<PM> capability, PM instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("pm", instance.pm);
            nbt.putInt("progress",instance.progress);
            System.out.println(nbt.getInt("pm"));
            return nbt;
        }

        @Override
        public void readNBT(Capability<PM> capability, PM instance, Direction side, INBT nbt) {
            if (!(nbt instanceof CompoundNBT)) return;
            CompoundNBT compound = (CompoundNBT) nbt;
            instance.pm = compound.getInt("pm");
            instance.progress = compound.getInt("progress");
            System.out.println(instance.pm);
        }
    }
}
