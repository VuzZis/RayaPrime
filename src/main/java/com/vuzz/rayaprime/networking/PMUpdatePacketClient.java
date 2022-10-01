package com.vuzz.rayaprime.networking;

import java.util.UUID;
import java.util.function.Supplier;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.capability.PM;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfig.Server;
import net.minecraftforge.fml.network.NetworkEvent;

public class PMUpdatePacketClient {
    public int pm;
    public int progress;

    @SuppressWarnings("unused")
    public PMUpdatePacketClient(int pm,int progress) {
        this.pm = pm;
        this.progress = progress;
    }

    public PMUpdatePacketClient(PM cap) {
        pm = cap.getPm();
        progress = cap.getProgress();
    }

    public PMUpdatePacketClient(PacketBuffer buffer) {
        pm = buffer.readInt();
        progress = buffer.readInt();
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeInt(pm);
        buffer.writeInt(progress);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            System.out.println("checking player");
            if(context.get().getSender() == null) return;
            PM.get(context.get().getSender()).ifPresent(cap -> {
                cap.setPm(pm);
                cap.setProgress(progress);
            });;
            context.get().setPacketHandled(true);
        });
    }
}