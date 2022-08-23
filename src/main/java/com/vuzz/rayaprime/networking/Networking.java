package com.vuzz.rayaprime.networking;

import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import com.vuzz.rayaprime.RayaMod;
import net.minecraft.util.ResourceLocation;

public class Networking {
    public static SimpleChannel CHANNEL;
    public static int ID;

    public static int nextID(){return ID++;}

    public static void register() {
        CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(RayaMod.MOD_ID, "network"), () -> "1.0", s -> true, s -> true);
        CHANNEL.registerMessage(nextID(), PacketItemStack.class, PacketItemStack::toBytes, PacketItemStack::new, PacketItemStack::handle);
        CHANNEL.registerMessage(nextID(), PacketPM.class, PacketPM::toBytes, PacketPM::new, PacketPM::handle);
    }

}
