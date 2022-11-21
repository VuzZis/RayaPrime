package com.vuzz.haloterra.entities.render;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;
import com.vuzz.haloterra.entities.model.RehoboamModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RehoboamRenderer extends MobRenderer<RehoboamEntity,RehoboamModel<RehoboamEntity>> 
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(RayaMod.MOD_ID,"textures/entity/rehoboam.png");

    public RehoboamRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new RehoboamModel<>(),0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(RehoboamEntity entity) {
        return TEXTURE;
    }



}
