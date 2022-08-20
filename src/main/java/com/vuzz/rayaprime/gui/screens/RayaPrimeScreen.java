package com.vuzz.rayaprime.gui.screens;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.gui.ShopButton;
import com.vuzz.rayaprime.gui.containers.RayaPrimeContainer;
import com.vuzz.rayaprime.shop.ShopItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class RayaPrimeScreen extends ContainerScreen<RayaPrimeContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/shop_fullt.png");
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();
    private final ArrayList<ShopButton> shopButtons = new ArrayList<ShopButton>();
    private int page = 1;
    
    public RayaPrimeScreen(RayaPrimeContainer container, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
        super(container, playerInventory, p_i51105_3_);
    
    }

    @Override
    protected void init() {
        this.guiLeft = (this.width) / 2;
        this.guiTop = (this.height) / 2;
        int b = this.guiLeft - 88;
        int j = this.guiTop - 83;
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        for(int i = 0; i < 15; i++) {
            int xBox = i % 5;
            int yBox = (int) Math.floor(i/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            int e = i;
            ShopButton btn = new ShopButton(46, 44, b+6+xBox-40, j+6+yBox, player, $ -> {
                Minecraft mca = Minecraft.getInstance();
                int a = e;
                ClientPlayerEntity playera = mca.player;
                int pageMultiplier = (15*(page-1));
                if(shopItems.size() > pageMultiplier+a) {
                    ItemStack stack = shopItems.get(pageMultiplier+a);
                    int price = (int) shopPrices.get(pageMultiplier+a);
                    int pm = playera.getPersistentData().getInt("pm");
                    if(pm >= price) {
                        playera.getPersistentData().putInt("pm", pm-price);
                        playera.addItemStackToInventory(stack.copy());
                    }
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
        Minecraft mc = Minecraft.getInstance();
        for(int i = 0; i < Math.min(shopItems.size()-(15*(page-1)),15); i++) {
            int a = i;
            int pageMultiplier = (15*(page-1));
            if(shopItems.size() > pageMultiplier+a) {
                ItemStack stack = shopItems.get(pageMultiplier+a);    
                container.putStackInSlot(a, stack);          
            } else {
                container.putStackInSlot(a, new ItemStack(Items.AIR));
            }
        }
    }

    @Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        for(int i = 0; i < Math.min(shopItems.size()-(15*(page-1)),15); i++) {
            int b = (this.width) / 2;
            int j = (this.height) / 2;
            //int b = x - 88;
            //int j = y - 83;
            int xBox = i % 5;
            int yBox = (int) Math.floor(i/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            int pageMultiplier = (15*(page-1));
            int a = i;
            int price = (int) shopPrices.get(pageMultiplier+a);
            drawString(matrixStack, Minecraft.getInstance().fontRenderer, 
            new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()+": "+price, 
            xBox-31, yBox+38, Integer.parseInt("FFFFFF",16));
        }
        drawString(matrixStack, Minecraft.getInstance().fontRenderer, new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()+": "+player.getPersistentData().getInt("pm"), -24, 154, Integer.parseInt("FFFFFF",16));
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) { 
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(arg0,i-40,j,0,0,256,168);
        for(int q = 0; q < 15; q++) {
            int xBox = q % 5;
            int yBox = (int) Math.floor(q/5);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            this.blit(arg0,i+6+xBox-40,j+6+yBox,0,170,46,44);
        }
    }
    
}
