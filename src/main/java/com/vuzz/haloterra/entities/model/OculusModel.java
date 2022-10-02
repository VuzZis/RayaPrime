package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.OculusEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class OculusModel<T extends OculusEntity> extends EntityModel<T> {
	private T entit;
	private final ModelRenderer DefaultFace;
	private final ModelRenderer SadFace;
	private final ModelRenderer MainBody;
	private final ModelRenderer LeftHand;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Sword2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer RightWing;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer LeftWing;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer RightHand;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer Sword;
	private final ModelRenderer cube_r12;
	private final ModelRenderer Head;
	private final ModelRenderer HappyFace;

	public OculusModel() {
		textureWidth = 128;
		textureHeight = 128;

		DefaultFace = new ModelRenderer(this);
		DefaultFace.setRotationPoint(0.0F, 32.0F, 0.5F);
		DefaultFace.setTextureOffset(0, 70).addBox(-4.0F, -30.5F, -5.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		SadFace = new ModelRenderer(this);
		SadFace.setRotationPoint(0.0F, 24.0F, 0.5F);
		SadFace.setTextureOffset(74, 33).addBox(-4.0F, -22.5F, -5.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		LeftHand = new ModelRenderer(this);
		LeftHand.setRotationPoint(5.0F, -8.5F, 2.5F);
		MainBody.addChild(LeftHand);
		setRotationAngle(LeftHand, -0.2434F, -0.0222F, -0.1141F);
		LeftHand.setTextureOffset(0, 0).addBox(1.0F, -0.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		LeftHand.setTextureOffset(29, 15).addBox(0.5F, -2.0F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		LeftHand.setTextureOffset(0, 22).addBox(2.0F, -2.0001F, -1.501F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftHand.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0873F);
		cube_r1.setTextureOffset(29, 0).addBox(4.3F, -2.4F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftHand.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.0873F);
		cube_r2.setTextureOffset(29, 20).addBox(-0.3F, -1.95F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		Sword2 = new ModelRenderer(this);
		Sword2.setRotationPoint(3.5F, 10.197F, -0.4014F);
		LeftHand.addChild(Sword2);
		setRotationAngle(Sword2, 1.3526F, 0.0F, 0.0F);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -0.6946F, 3.9392F);
		Sword2.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.3963F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(-4.5F, -2.0F, -8.0F, 7.0F, 0.0F, 14.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.014F, -14.6329F, 2.1623F);
		MainBody.addChild(Body);
		setRotationAngle(Body, 0.1396F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 15).addBox(-2.014F, 1.6329F, -3.1623F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-0.014F, 14.6329F, -2.1623F);
		Body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3927F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(60, 0).addBox(-3.0F, -2.9F, 3.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-0.014F, 14.6329F, -2.1623F);
		Body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3054F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(21, 47).addBox(3.05F, -14.99F, 2.001F, 1.0F, 12.0F, 6.0F, 0.0F, false);
		cube_r5.setTextureOffset(36, 47).addBox(-4.0F, -15.0F, 2.001F, 1.0F, 12.0F, 6.0F, 0.0F, false);
		cube_r5.setTextureOffset(33, 30).addBox(-3.98F, -14.999F, 3.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-3.514F, 2.6329F, 1.8377F);
		Body.addChild(RightWing);
		setRotationAngle(RightWing, 0.4363F, 0.6109F, 0.5236F);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-2.2446F, 0.7102F, -0.1229F);
		RightWing.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 3.1416F, -0.1745F);
		cube_r6.setTextureOffset(55, 12).addBox(-3.5F, 0.0F, -1.0F, 11.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-2.2446F, 0.7102F, -0.1229F);
		RightWing.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 3.1416F, 0.1745F);
		cube_r7.setTextureOffset(58, 30).addBox(-3.5F, -4.0F, -1.0F, 11.0F, 3.0F, 2.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(7.486F, 4.6329F, 2.8377F);
		Body.addChild(LeftWing);
		setRotationAngle(LeftWing, 0.6109F, -0.6109F, -0.5236F);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-1.3319F, -2.2574F, 2.3533F);
		LeftWing.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.1745F);
		cube_r8.setTextureOffset(51, 58).addBox(-3.5F, 0.0F, -1.0F, 11.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-1.3319F, -2.2574F, 2.3533F);
		LeftWing.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -0.1745F);
		cube_r9.setTextureOffset(58, 36).addBox(-3.5F, -4.0F, -1.0F, 11.0F, 3.0F, 2.0F, 0.0F, false);

		RightHand = new ModelRenderer(this);
		RightHand.setRotationPoint(-7.496F, -8.7871F, 2.5376F);
		MainBody.addChild(RightHand);
		setRotationAngle(RightHand, -0.3768F, 0.0209F, 0.1374F);
		RightHand.setTextureOffset(0, 7).addBox(-1.504F, -0.2104F, -1.4998F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		RightHand.setTextureOffset(12, 47).addBox(-2.004F, -1.7104F, -1.4998F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		RightHand.setTextureOffset(41, 12).addBox(-0.504F, -1.7105F, -1.5008F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-2.504F, 0.2896F, 0.0002F);
		RightHand.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 0.0873F);
		cube_r10.setTextureOffset(0, 47).addBox(4.3F, -2.4F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-2.504F, 0.2896F, 0.0002F);
		RightHand.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.0873F);
		cube_r11.setTextureOffset(64, 18).addBox(-0.3F, -1.95F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		Sword = new ModelRenderer(this);
		Sword.setRotationPoint(-2.504F, 0.2896F, 0.0002F);
		RightHand.addChild(Sword);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(2.5F, 3.5F, -1.5F);
		Sword.addChild(cube_r12);
		setRotationAngle(cube_r12, 3.1416F, -0.0436F, 1.5708F);
		cube_r12.setTextureOffset(0, 15).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 14.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -18.5F, -1.0F);
		MainBody.addChild(Head);
		Head.setTextureOffset(43, 12).addBox(4.0F, -4.5F, -4.0F, 1.0F, 8.0F, 9.0F, 0.0F, false);
		Head.setTextureOffset(0, 47).addBox(-5.0F, -4.5F, -4.0F, 1.0F, 8.0F, 9.0F, 0.0F, false);
		Head.setTextureOffset(29, 0).addBox(-5.0F, -6.5F, -4.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Head.setTextureOffset(51, 47).addBox(-5.0F, -5.5F, 5.0F, 10.0F, 9.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 30).addBox(-4.0F, -4.5F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		HappyFace = new ModelRenderer(this);
		HappyFace.setRotationPoint(0.0F, 13.0F, 0.5F);
		HappyFace.setTextureOffset(74, 25).addBox(-4.0F, -12.5F, -5.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		entit = entity;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		DefaultFace.render(matrixStack, buffer, 15, packedOverlay, red, green, blue, alpha);
		//SadFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		MainBody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		//HappyFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}