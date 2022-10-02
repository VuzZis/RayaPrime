package com.vuzz.haloterra.entities.render;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.model.BeyondtoModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BeyondtoRenderer extends MobRenderer<BeyondtoEntity,BeyondtoModel<BeyondtoEntity>> 
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(RayaMod.MOD_ID,"textures/entity/beyondto.png");

    public BeyondtoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new BeyondtoModel<>(),0.35F);
    }

    @Override
    public ResourceLocation getEntityTexture(BeyondtoEntity entity) {
        return TEXTURE;
    }



}
