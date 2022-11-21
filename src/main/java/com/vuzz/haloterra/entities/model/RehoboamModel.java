package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RehoboamModel<T extends RehoboamEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Screen;

	public RehoboamModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 33).addBox(-9.0F, -15.0F, -9.0F, 18.0F, 5.0F, 18.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-8.0F, -20.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		Body.setTextureOffset(55, 16).addBox(-2.0F, -20.5F, -8.5F, 4.0F, 17.0F, 17.0F, 0.0F, false);

		Screen = new ModelRenderer(this);
		Screen.setRotationPoint(0.0F, 12.175F, -0.5F);
		Screen.setTextureOffset(0, 77).addBox(-8.0F, -22.175F, -0.5F, 16.0F, 9.0F, 1.0F, 0.0F, false);
		Screen.setTextureOffset(0, 95).addBox(-8.0F, -12.825F, -0.5F, 16.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		setRotationAngle(Body, 0,ageInTicks/20/10,0);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Screen.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}