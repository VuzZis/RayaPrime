package com.vuzz.rayaprime.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.vuzz.rayaprime.RayaMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class PageButton extends Button {

    public PlayerEntity playerEntity;
    private final IPressable onPress;
    private int widthIn;
    private int heightIn;
    public int ind;
    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/shop_fullt.png");
    private int xIn;
    private int yIn;
    private boolean isLeft;
    
    public PageButton(int widthIn, int heightIn, int xIn, int yIn, PlayerEntity player, IPressable onPress, int index,boolean isLeft) {
        
        super(xIn, yIn, widthIn, heightIn, new StringTextComponent(""), onPress);
        this.onPress = onPress;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
        this.ind = index;
        this.xIn = xIn;
        this.yIn = yIn;
        this.isLeft = isLeft;
    }

    @Override
    public void onPress() {
        this.onPress.onPress(this);
    }

    @Override
    public void renderWidget(MatrixStack ms, int a, int b, float c) {
        Minecraft mc = Minecraft.getInstance();
        mc.textureManager.bindTexture(GUI);
        if(isLeft) {
            if(isHovered) {
                mc.ingameGUI.blit(ms, xIn, yIn, 48, 192, width, height);
            } else 
                mc.ingameGUI.blit(ms, xIn, yIn, 48, 170, width, height);
        } else
            if(isHovered) {
                mc.ingameGUI.blit(ms, xIn, yIn, 75, 192, width, height);
            } else 
                mc.ingameGUI.blit(ms, xIn, yIn, 75, 170, width, height);
        //super.renderWidget(ms,a,b,c);
    }
    
}
