package com.vuzz.storymoding.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.vuzz.storymoding.StoryModing;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class ShopButton extends Button {

    public PlayerEntity playerEntity;
    private final IPressable onPress;
    private int widthIn;
    private int heightIn;
    public int ind;
    private final ResourceLocation GUI = new ResourceLocation(StoryModing.MOD_ID,"textures/gui/storymoding/shop_fullt.png");
    private int xIn;
    private int yIn;
    
    public ShopButton(int widthIn, int heightIn, int xIn, int yIn, PlayerEntity player, IPressable onPress, int index) {
        
        super(xIn, yIn, widthIn, heightIn, new StringTextComponent(""), onPress);
        this.onPress = onPress;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
        this.ind = index;
        this.xIn = xIn;
        this.yIn = yIn;
    }

    @Override
    public void onPress() {
        this.onPress.onPress(this);
    }

    @Override
    public void renderWidget(MatrixStack ms, int a, int b, float c) {
        Minecraft mc = Minecraft.getInstance();
        mc.textureManager.bindTexture(GUI);
        mc.ingameGUI.blit(ms, xIn, yIn, 0, 170, width, height);
        //super.renderWidget(ms,a,b,c);
    }
    
}
