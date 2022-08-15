package com.vuzz.rayaprime.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.containers.RayaPrimeContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RayaPrimeScreen extends ContainerScreen<RayaPrimeContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/shop.png");

    public RayaPrimeScreen(RayaPrimeContainer p_i51105_1_, PlayerInventory p_i51105_2_, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, p_i51105_2_, p_i51105_3_);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) {   
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(arg0,i,j,0,0,this.xSize,this.ySize);
    }
    
}
