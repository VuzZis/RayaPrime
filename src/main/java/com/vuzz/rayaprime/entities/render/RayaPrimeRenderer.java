package com.vuzz.rayaprime.entities.render;

import com.vuzz.rayaprime.RayaMod;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;
import com.vuzz.rayaprime.entities.model.RayaPrimeModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RayaPrimeRenderer extends MobRenderer<RayaPrimeEntity,RayaPrimeModel<RayaPrimeEntity>> 
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(RayaMod.MOD_ID,"textures/entity/raya.png");

    public RayaPrimeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new RayaPrimeModel<>(),0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(RayaPrimeEntity entity) {
        return TEXTURE;
    }



}
