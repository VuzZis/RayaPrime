package com.vuzz.haloterra.entities.render;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.custom.OculusEntity;
import com.vuzz.haloterra.entities.model.OculusModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class OculusRender extends MobRenderer<OculusEntity,OculusModel<OculusEntity>> 
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(RayaMod.MOD_ID,"textures/entity/oculus.png");

    public OculusRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new OculusModel<>(),0.35F);
    }

    @Override
    public ResourceLocation getEntityTexture(OculusEntity entity) {
        return TEXTURE;
    }



}
