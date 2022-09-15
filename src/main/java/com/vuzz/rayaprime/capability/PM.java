package com.vuzz.rayaprime.capability;

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

import com.vuzz.rayaprime.networking.Networking;
import com.vuzz.rayaprime.networking.PMUpdatePacket;
import com.vuzz.rayaprime.networking.PMUpdatePacketClient;

public class PM {
    private int pm;

    public static LazyOptional<PM> get(Entity entity) {
        return entity.getCapability(CapabilityPM.INSTANCE);
    }

    public void sync(ServerPlayerEntity player) {
        Networking.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new PMUpdatePacket(this));
    }

    public void sync(ClientPlayerEntity player) {
        Networking.CHANNEL.send(PacketDistributor.SERVER.with(() -> null), new PMUpdatePacketClient(this.pm,player.getUniqueID()));
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public boolean hasPm() {
        return pm > 0;
    }

    public static final class PMStorage implements Capability.IStorage<PM> {
        @Nonnull
        @Override
        public INBT writeNBT(Capability<PM> capability, PM instance, Direction side) {
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
