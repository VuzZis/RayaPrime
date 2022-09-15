package com.vuzz.storymoding.gui.screens;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.capability.PM;
import com.vuzz.storymoding.gui.ShopButton;
import com.vuzz.storymoding.gui.containers.RayaPrimeContainer;
import com.vuzz.storymoding.networking.Networking;
import com.vuzz.storymoding.networking.PacketItemStack;
import com.vuzz.storymoding.networking.PMUpdatePacket;
import com.vuzz.storymoding.shop.ShopItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;

public class RayaPrimeScreen extends ContainerScreen<RayaPrimeContainer> {

    private final ResourceLocation GUI = new ResourceLocation(StoryModing.MOD_ID,"textures/gui/storymoding/shop_fullt.png");
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
            int xBox = i % 8;
            int yBox = (int) Math.floor(i/8);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            int e = i;
            ShopButton btn = new ShopButton(46, 44, b+6+xBox-90, j+6+yBox, player, $ -> {
                Minecraft mca = Minecraft.getInstance();
                int a = e;
                ClientPlayerEntity playera = mca.player;
                int pageMultiplier = (15*(page-1));
                if(shopItems.size() > pageMultiplier+a) {
                    ItemStack stack = shopItems.get(pageMultiplier+a);
                    int price = (int) shopPrices.get(pageMultiplier+a);
                    LazyOptional<PM> capability =  PM.get(playera);
                    if(capability.resolve().isPresent()) {
                        PM cap = capability.resolve().get();
                        int pm = cap.getPm();
                        if(pm >= price) {
                            cap.setPm(pm-price);
                            cap.sync((ClientPlayerEntity) player);
                            ItemStack stcopy = stack.copy();
                            Networking.CHANNEL.send(PacketDistributor.SERVER.noArg(), new PacketItemStack(stcopy));
                        }
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
            int xBox = i % 8;
            int yBox = (int) Math.floor(i/8);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            int pageMultiplier = (15*(page-1));
            int a = i;
            int price = (int) shopPrices.get(pageMultiplier+a);
            drawString(matrixStack, Minecraft.getInstance().fontRenderer, 
            new TranslationTextComponent("title."+StoryModing.MOD_ID+".pm").getString()+": "+price, 
            xBox-31-40, yBox+38, Integer.parseInt("FFFFFF",16));
        }
        LazyOptional<PM> capability =  PM.get(player);
        if(capability.resolve().isPresent()) {
            PM cap = capability.resolve().get();
            drawString(matrixStack, Minecraft.getInstance().fontRenderer, new TranslationTextComponent("title."+StoryModing.MOD_ID+".pm").getString()+": "+cap.getPm(), -64, 124, Integer.parseInt("FFFFFF",16));
        }
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) { 
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(arg0,i-90,j,0,0,356,168);
        for(int q = 0; q < 15; q++) {
            int xBox = q % 8;
            int yBox = (int) Math.floor(q/8);
            xBox = (int) xBox * 47;
            yBox = (int) yBox * 46;
            this.blit(arg0,i+6+xBox-90,j+6+yBox,0,170,46,44);
        }
    }
    
}
