package com.vuzz.haloterra.entities.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import com.vuzz.haloterra.entities.model.OcubladeModel;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderType.State;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class OcubladeRenderer extends MobRenderer<OcubladeEntity,OcubladeModel<OcubladeEntity>>
{
    
    protected static final ResourceLocation TEXTURE = new ResourceLocation(RayaMod.MOD_ID,"textures/entity/ocublade.png");

    public OcubladeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new OcubladeModel<>(),0.1F);
    }

    @Override
    public ResourceLocation getEntityTexture(OcubladeEntity entity) {
        return TEXTURE;
    }

}
