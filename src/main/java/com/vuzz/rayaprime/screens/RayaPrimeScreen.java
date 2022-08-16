package com.vuzz.rayaprime.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.containers.RayaPrimeContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RayaPrimeScreen extends ContainerScreen<RayaPrimeContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/shop_fullt.png");

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
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		// No-op, there's no space for gui titles
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) { 
        RenderSystem.color4f(1f,1f,1f,0.5f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(arg0,i-40,j,0,0,256,168);
        for(int q = 0; q < 9; q++) {
            int xBox = q % 5;
            int yBox = (int) Math.floor(q/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            this.blit(arg0,i+6+xBox-40,j+6+yBox,0,170,46,44);
        }
    }
    
}
