package com.vuzz.storymoding.entities.render;

import com.vuzz.storymoding.StoryModing;
import com.vuzz.storymoding.entities.custom.RayaPrimeEntity;
import com.vuzz.storymoding.entities.model.RayaPrimeModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RayaPrimeRenderer extends MobRenderer<RayaPrimeEntity,RayaPrimeModel<RayaPrimeEntity>> 
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(StoryModing.MOD_ID,"textures/entity/raya.png");

    public RayaPrimeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new RayaPrimeModel<>(),0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(RayaPrimeEntity entity) {
        return TEXTURE;
    }



}
