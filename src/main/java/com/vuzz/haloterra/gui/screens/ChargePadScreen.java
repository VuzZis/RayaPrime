package com.vuzz.haloterra.gui.screens;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.capability.PM;
import com.vuzz.haloterra.gui.PageButton;
import com.vuzz.haloterra.gui.ShopButton;
import com.vuzz.haloterra.gui.containers.ChargePadContainer;
import com.vuzz.haloterra.gui.containers.RayaPrimeContainer;
import com.vuzz.haloterra.networking.Networking;
import com.vuzz.haloterra.networking.PacketItemStack;
import com.vuzz.haloterra.networking.PMUpdatePacket;
import com.vuzz.haloterra.shop.ShopItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;

public class ChargePadScreen extends ContainerScreen<ChargePadContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/plaunt.png");
    
    public ChargePadScreen(ChargePadContainer container, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
        super(container, playerInventory, p_i51105_3_);
    
    }

    @Override
    protected void init() {
        this.guiLeft = (this.width) / 2;
        this.guiTop = (this.height) / 2;
        int b = this.guiLeft - 88;
        int j = this.guiTop - 83;
        super.init();
    }

    @Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) { 
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(arg0,i,j,0,0,176,168);
    }
    
}
