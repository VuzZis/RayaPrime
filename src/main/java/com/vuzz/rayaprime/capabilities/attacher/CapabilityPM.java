package com.vuzz.rayaprime.capabilities.attacher;


import com.vuzz.rayaprime.capabilities.storage.player.PM;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityPM {
    @CapabilityInject(PM.class)
    public static Capability<PM> INSTANCE = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(PM.class, new PM.PMStorage(), PM::new);
    }
}
