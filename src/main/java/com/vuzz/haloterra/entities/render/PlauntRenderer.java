package com.vuzz.haloterra.entities.render;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.custom.PlauntEntity;
import com.vuzz.haloterra.entities.model.PlauntModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PlauntRenderer extends MobRenderer<PlauntEntity,PlauntModel<PlauntEntity>> 
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(RayaMod.MOD_ID,"textures/entity/plaunt.png");

    public PlauntRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new PlauntModel<>(),0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(PlauntEntity entity) {
        return TEXTURE;
    }



}
