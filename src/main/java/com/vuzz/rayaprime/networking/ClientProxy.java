package com.vuzz.rayaprime.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

    @Override
    public Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }

    @Override
    public PlayerEntity getPlayer() {
        return getMinecraft().player;
    }

    @Override
    public World getWorld() {
        return getMinecraft().world;
    }
    
}
