package com.vuzz.rayaprime.networking;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketPM {
    private int pm;
    public PacketPM(int pm) {
        this.pm = pm;
    }
    public PacketPM(PacketBuffer buf) {
        this.pm = buf.readInt();
    }
    public void toBytes(PacketBuffer buf) {
        buf.writeInt(pm);
    }
    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            if(context.get().getSender() == null) return;
            context.get().getSender().getPersistentData().putInt("pm",pm);
        });
        context.get().setPacketHandled(true);
    }


}
