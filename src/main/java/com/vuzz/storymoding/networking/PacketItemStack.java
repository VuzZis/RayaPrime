package com.vuzz.storymoding.networking;

import java.util.function.Supplier;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketItemStack {
    private ItemStack stack;
    public PacketItemStack(ItemStack stack) {
        this.stack = stack;
    }
    public PacketItemStack(PacketBuffer buf) {
        this.stack = buf.readItemStack();
    }
    public void toBytes(PacketBuffer buf) {
        buf.writeItemStack(stack);
    }
    public void handle(Supplier<NetworkEvent.Context> context) {
        System.out.println("handling itemstack");
        context.get().enqueueWork(() -> {
            System.out.println("checking player");
            if(context.get().getSender() == null) return;
            System.out.println("giving stack to "+context.get().getSender().getDisplayName().getString());
            System.out.println(this.stack.getTranslationKey());
            context.get().getSender().addItemStackToInventory(this.stack);
        });
        context.get().setPacketHandled(true);
    }
}