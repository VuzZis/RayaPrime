package com.vuzz.haloterra.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityPM {
    @CapabilityInject(PM.class)
    public static Capability<PM> INSTANCE;
    public static void register() {
        CapabilityManager.INSTANCE.register(PM.class, new PM.PMStorage(), PM::new);
    }
}
