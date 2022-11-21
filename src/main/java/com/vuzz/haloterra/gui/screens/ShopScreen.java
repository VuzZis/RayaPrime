package com.vuzz.haloterra.gui.screens;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.capability.PM;
import com.vuzz.haloterra.gui.PageButton;
import com.vuzz.haloterra.gui.ShopButton;
import com.vuzz.haloterra.gui.containers.RayaPrimeContainer;
import com.vuzz.haloterra.networking.Networking;
import com.vuzz.haloterra.networking.PacketItemStack;
import com.vuzz.haloterra.networking.PMUpdatePacket;
import com.vuzz.haloterra.shop.ShopItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.RenderState;
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

public class ShopScreen extends ContainerScreen<RayaPrimeContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/lololoshkashop.png");
    private final ResourceLocation GUI_2 = new ResourceLocation(RayaMod.MOD_ID,"textures/gui/rayaprime/lololoshkashop_2.png");
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();
    private final ArrayList<ShopButton> shopButtons = new ArrayList<ShopButton>();
    private int page = 1;

    public int guiXOffset = -53;
    public int guiYOffset = -22;
    
    private static final RenderState.TransparencyState TRANSLUCENT_TRANSPARENCY = new RenderState.TransparencyState("translucent_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public ShopScreen(RayaPrimeContainer container, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
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
        int pagesMax = (int) Math.ceil(shopItems.size()/31);
        PageButton pageBtnLeft = new PageButton(9,10,b+guiXOffset+91,j+guiYOffset+208,player,$ -> {
            if(page-1 > 0)
                page--;
        },0,true);
        PageButton pageBtnRight = new PageButton(9,10,b+guiXOffset+191,j+guiYOffset+208,player,$ -> {
            if(page-1 < pagesMax)
                page++;
        },1,false);
        addButton(pageBtnLeft);
        addButton(pageBtnRight);
        for(int i = 0; i < 30; i++) {
            int xBox = i % 6;
            int yBox = (int) Math.floor(i/6);
            xBox = (int) xBox * 40;
            yBox = (int) yBox * 38;
            int e = i;
            
            ShopButton btn = new ShopButton(39, 37, b+xBox+guiXOffset+3,j+yBox+guiYOffset+19, player, $ -> {
                Minecraft mca = Minecraft.getInstance();
                int a = e;
                ClientPlayerEntity playera = mca.player;
                int pageMultiplier = (30*(page-1));
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
        for(int i = 0; i < 30; i++) {
            int a = i;
            int pageMultiplier = (30*(page-1));
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
        for(int i = 0; i < Math.min(shopItems.size()-(30*(page-1)),30); i++) {
            int b = (this.width) / 2;
            int j = (this.height) / 2;
            //int b = x - 88;
            //int j = y - 83;
            int xBox = i % 6;
            int yBox = (int) Math.floor(i/6);
            xBox = (int) xBox * 40;
            yBox = (int) yBox * 38;
            int pageMultiplier = (30*(page-1));
            int a = i;
            int price = (int) shopPrices.get(pageMultiplier+a);
            drawString(matrixStack, Minecraft.getInstance().fontRenderer, 
            new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()+": "+price, 
            xBox+5-53+2-5+2,yBox+5-22+18+20+2, Integer.parseInt("FFFFFF",16));
        }
        LazyOptional<PM> capability =  PM.get(player);
        if(capability.resolve().isPresent()) {
            PM cap = capability.resolve().get();
            drawString(matrixStack, Minecraft.getInstance().fontRenderer, new TranslationTextComponent("title."+RayaMod.MOD_ID+".pm").getString()+": "+cap.getPm(), -53+223,-22+2, Integer.parseInt("FFFFFF",16));
        }
        int pagesMax = (int) Math.ceil(shopItems.size()/31);
        drawString(matrixStack, Minecraft.getInstance().fontRenderer, new StringTextComponent((page)+"/"+(pagesMax+1)), -53+108+1,-22+209+1, Integer.parseInt("FFFFFF",16));
        drawString(matrixStack, Minecraft.getInstance().fontRenderer, new StringTextComponent("https://haloterra.shop/@"+player.getDisplayName().getString().toLowerCase()+"/"), -53+4,-22+2, Integer.parseInt("FFFFFF",16));
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack arg0, float arg1, int arg2, int arg3) { 
        TRANSLUCENT_TRANSPARENCY.setupRenderState();
        RenderSystem.color4f(1f,1f,1f,1f);
        int i = this.guiLeft;
        int j = this.guiTop;
        //makes this: this.blit(arg0,i+guiXOffset,j+guiYOffset,0,0,280,219);
        this.minecraft.getTextureManager().bindTexture(GUI);
            this.blit(arg0,i+guiXOffset,j+guiYOffset,0,0,256,219);
        this.minecraft.getTextureManager().bindTexture(GUI_2);
            this.blit(arg0,i+guiXOffset+256,j+guiYOffset,0,0,256,219);
        for(int q = 0; q < 30; q++) {
            int xBox = q % 6;
            int yBox = (int) Math.floor(q/6);
            xBox = (int) xBox * 40;
            yBox = (int) yBox * 38;
            //this.blit(arg0,i+xBox+guiXOffset,j+yBox+guiYOffset,3,19,39,37);
        }
        TRANSLUCENT_TRANSPARENCY.clearRenderState();
    }
    
}
