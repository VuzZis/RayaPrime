package com.vuzz.rayaprime.gui;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ShopButton extends Button {

    public PlayerEntity playerEntity;
    private final IPressable onPress;
    private int widthIn;
    private int heightIn;
    public int ind;

    public ShopButton(int widthIn, int heightIn, int xIn, int yIn, PlayerEntity player, IPressable onPress, int index) {
        
        super(widthIn, heightIn, xIn, yIn, new StringTextComponent(""), onPress);
        this.onPress = onPress;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
        this.ind = index;
    }

    @Override
    public void onPress() {
        this.onPress.onPress(this);
    }

    @Override
    public void renderWidget(MatrixStack ms, int a, int b, float c) {
        super.renderWidget(ms,a,b,c);
    }
    
}
