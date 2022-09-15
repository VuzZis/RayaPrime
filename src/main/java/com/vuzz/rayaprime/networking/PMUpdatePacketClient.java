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
    public UUID uuid;

    @SuppressWarnings("unused")
    public PMUpdatePacketClient(int pm, UUID uuid) {
        this.pm = pm;
        this.uuid = uuid;
    }

    public PMUpdatePacketClient(PM cap, UUID uuid) {
        this.pm = cap.getPm();
        this.uuid = uuid;
    }

    public PMUpdatePacketClient(PacketBuffer buffer) {
        this.pm = buffer.readInt();
        this.uuid = buffer.readUniqueId();
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeInt(pm);
        buffer.writeUniqueId(uuid);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            System.out.println("checking player");
            if(context.get().getSender() == null) return;
            PM.get(context.get().getSender()).ifPresent(cap -> {
                cap.setPm(pm);
            });;
            context.get().setPacketHandled(true);
        });
    }
}