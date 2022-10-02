package com.vuzz.haloterra.items.armor;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.blocks.ModBlocks;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModArmors {
    private final static String MODID = RayaMod.MOD_ID;
    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    /*public static final RegistryObject<Item> DOCUMENTARY_TOP = ARMOR.register("documentary_top", 
        () -> new ArmorItem(ModArmorMaterials.CLOTH_DOCUMENTARY, EquipmentSlotType.CHEST, 
            new Item.Properties().group(RayaMod.CLOTHS_GROUP)));
    public static final RegistryObject<Item> DOCUMENTARY_BOTTOM = ARMOR.register("documentary_bottom", 
        () -> new ArmorItem(ModArmorMaterials.CLOTH_DOCUMENTARY, EquipmentSlotType.LEGS, 
            new Item.Properties().group(RayaMod.CLOTHS_GROUP)));*/

    public static void register(IEventBus eventbus) {
        ARMOR.register(eventbus);
    }

}
