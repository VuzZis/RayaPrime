package com.vuzz.rayaprime.networking;

import java.util.function.Supplier;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.capability.PM;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PMUpdatePacket {
    public int pm;

    @SuppressWarnings("unused")
    public PMUpdatePacket(int pm) {
        this.pm = pm;
    }

    public PMUpdatePacket(PM cap) {
        pm = cap.getPm();
    }

    public PMUpdatePacket(PacketBuffer buffer) {
        pm = buffer.readInt();
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeInt(pm);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            if(RayaMod.PROXY.getPlayer() == null) return;
            PM.get(RayaMod.PROXY.getPlayer()).ifPresent(cap -> {
                cap.setPm(pm);
            });
            context.get().setPacketHandled(true);
        });
    }
}
