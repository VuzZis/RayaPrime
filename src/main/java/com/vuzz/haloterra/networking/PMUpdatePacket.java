package com.vuzz.haloterra.networking;

import java.util.function.Supplier;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.capability.PM;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PMUpdatePacket {
    public int pm;
    public int progress;

    @SuppressWarnings("unused")
    public PMUpdatePacket(int pm,int progress) {
        this.pm = pm;
        this.progress = progress;
    }

    public PMUpdatePacket(PM cap) {
        pm = cap.getPm();
        progress = cap.getProgress();
    }

    public PMUpdatePacket(PacketBuffer buffer) {
        pm = buffer.readInt();
        progress = buffer.readInt();
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeInt(pm);
        buffer.writeInt(progress);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            if(RayaMod.PROXY.getPlayer() == null) return;
            PM.get(RayaMod.PROXY.getPlayer()).ifPresent(cap -> {
                cap.setPm(pm);
                cap.setProgress(progress);
            });
            context.get().setPacketHandled(true);
        });
    }
}
