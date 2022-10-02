package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BeyondtoModel<T extends BeyondtoEntity> extends EntityModel<T> {
	private final ModelRenderer RightWing;
	private final ModelRenderer cube_r1;
	private final ModelRenderer LeftWing;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer Jet;
	private final ModelRenderer cube_r5;
	private final ModelRenderer DefaultFace;
	private final ModelRenderer SadFace;
	private T entit;

	public BeyondtoModel() {
		textureWidth = 64;
		textureHeight = 64;

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-3.5F, 18.5F, -1.0F);
		setRotationAngle(RightWing, 0.2618F, -0.3491F, 0.0F);
		RightWing.setTextureOffset(0, 21).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(3.5F, 6.5F, 1.0F);
		RightWing.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.0873F, 0.2618F, 0.0F);
		cube_r1.setTextureOffset(0, 31).addBox(-4.5F, -7.5F, 1.3F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(3.5F, 18.5F, -1.0F);
		setRotationAngle(LeftWing, 0.2618F, 0.3491F, 0.0F);
		LeftWing.setTextureOffset(0, 21).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 6.0F);
		LeftWing.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.0873F, -0.2618F, 0.0F);
		cube_r2.setTextureOffset(9, 31).addBox(-0.2F, -1.0F, -2.1F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 18.3604F, 0.0601F);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -3.3604F, -3.0601F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(28, 25).addBox(-2.0F, -3.3604F, 2.9399F, 4.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.2618F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 13).addBox(-3.0F, -4.5F, -4.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 6.6396F, -0.0601F);
		Body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.2618F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(19, 7).addBox(-2.99F, -4.0F, -2.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		Jet = new ModelRenderer(this);
		Jet.setRotationPoint(0.0F, 6.6396F, -0.0601F);
		Body.addChild(Jet);
		

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		Jet.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.2618F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(19, 0).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		DefaultFace = new ModelRenderer(this);
		DefaultFace.setRotationPoint(0.0F, 18.0F, -3.3F);
		DefaultFace.setTextureOffset(15, 25).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);

		SadFace = new ModelRenderer(this);
		SadFace.setRotationPoint(0.0F, 18.0F, -3.3F);
		SadFace.setTextureOffset(20, 34).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		entit = entity;
		int anim = entit.getPersistentData().getInt("anim");
		setRotationAngle(RightWing, 0f, (float) (-0.349f-Math.sin(ageInTicks/4)/5), 0f);
		setRotationAngle(LeftWing, 0f, (float) (0.349f+Math.sin(ageInTicks/4)/5), 0f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		int anim = entit.getPersistentData().getInt("anim");
		int phase = entit.getPersistentData().getInt("phase");
		System.out.println(phase);
		switch(phase) {
			case 0:
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				switch(anim) {
					case 0:
						DefaultFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
					break;
					case 1:
						SadFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
					break;
				}
			break;
		}
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}