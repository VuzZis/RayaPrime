package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.PlauntEntity;

import net.minecraft.advancements.criterion.PlayerPredicate.Default;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PlauntModel<T extends PlauntEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer RightWheel;
	private final ModelRenderer LeftWheel;
	private final ModelRenderer Flower;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer DefaultFace;

	public PlauntModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 22).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 9.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-5.5F, -12.5F, -5.5F, 11.0F, 10.0F, 11.0F, 0.0F, false);
		Body.setTextureOffset(31, 22).addBox(-3.0F, -9.0F, 5.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(49, 8).addBox(-2.99F, -7.1F, 3.9F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(32, 33).addBox(-4.5F, -19.0F, -4.5F, 9.0F, 7.0F, 9.0F, 0.0F, false);

		RightWheel = new ModelRenderer(this);
		RightWheel.setRotationPoint(-3.0F, -1.5F, 0.0F);
		Body.addChild(RightWheel);
		RightWheel.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		LeftWheel = new ModelRenderer(this);
		LeftWheel.setRotationPoint(3.0F, -1.5F, 0.0F);
		Body.addChild(LeftWheel);
		LeftWheel.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		Flower = new ModelRenderer(this);
		Flower.setRotationPoint(-0.3536F, -12.0F, 0.0F);
		Body.addChild(Flower);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.3536F, 12.0F, 0.0F);
		Flower.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.setTextureOffset(34, 64).addBox(-3.5F, -18.0F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.3536F, 12.0F, 0.0F);
		Flower.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.7854F, 0.0F);
		cube_r2.setTextureOffset(34, 64).addBox(-3.5F, -18.0F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);

		DefaultFace = new ModelRenderer(this);
		DefaultFace.setRotationPoint(0.0F, 16.5F, -5.01F);
		DefaultFace.setTextureOffset(0, 54).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		setRotationAngle(DefaultFace,0,0,(float) (Math.sin(ageInTicks/16)/18));
		setRotationAngle(Flower,(float) (Math.sin(ageInTicks/16)/34),0,(float) (Math.sin(ageInTicks/16)/44));
		setRotationAngle(RightWheel,(float) ageInTicks/14,0,0);
		setRotationAngle(LeftWheel,(float) ageInTicks/14,0,0);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		DefaultFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}