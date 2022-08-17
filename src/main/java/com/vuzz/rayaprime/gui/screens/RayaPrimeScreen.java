package com.vuzz.rayaprime.gui.screens;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.gui.ShopButton;
import com.vuzz.rayaprime.gui.containers.RayaPrimeContainer;
import com.vuzz.rayaprime.shop.ShopItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RayaPrimeScreen extends ContainerScreen<RayaPrimeContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/shop_fullt.png");
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();
    private final PlayerEntity playerEntity;
    private final ArrayList<ShopButton> shopButtons = new ArrayList<ShopButton>();
    private int page = 1;
    
    public RayaPrimeScreen(RayaPrimeContainer p_i51105_1_, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, playerInventory, p_i51105_3_);
        playerEntity = playerInventory.player;
    }

    @Override
    protected void init() {
        int b = this.guiLeft;
        int j = this.guiTop;
        for(int i = 0; i < shopItems.size()-(15*(page-1)); i++) {
            int xBox = i % 5;
            int yBox = (int) Math.floor(i/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            int e = i;
            ShopButton btn = new ShopButton(46, 44, b+6+xBox-40, j+6+yBox, playerEntity, $ -> {
                int pageMultiplier = (15*(page-1));
                ItemStack stack = shopItems.get(pageMultiplier+e);
                int price = (int) shopPrices.get(pageMultiplier+e);
                int pm = playerEntity.getPersistentData().getInt("pm");
                if(pm >= price) {
                    playerEntity.getPersistentData().putInt("pm", pm-price);
                    playerEntity.addItemStackToInventory(stack);
                }
            }, e);
            addButton(btn);
        }
        super.init();
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

    }

    @Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		RayaPrimeContainer cont = (RayaPrimeContainer) this.container;
        drawString(matrixStack, Minecraft.getInstance().fontRenderer, "ПМ: "+playerEntity.getPersistentData().getInt("pm"), 15, 15, Integer.parseInt("FFFFFF",16));
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) { 
        RenderSystem.color4f(1f,1f,1f,0.5f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(arg0,i-40,j,0,0,256,168);
        for(int q = 0; q < shopItems.size()-(15*(page-1)); q++) {
            int xBox = q % 5;
            int yBox = (int) Math.floor(q/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            this.blit(arg0,i+6+xBox-40,j+6+yBox,0,170,46,44);
        }
    }
    
}
