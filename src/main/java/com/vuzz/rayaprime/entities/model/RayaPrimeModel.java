package com.vuzz.rayaprime.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public class RayaPrimeModel<T extends RayaPrimeEntity> extends EntityModel<T> {
	public int anim;
	private final ModelRenderer MainBody;
	private final ModelRenderer UpperAC_r1;
	private final ModelRenderer LeftEar;
	private final ModelRenderer RightEar;
	private final ModelRenderer BackJet;
	private final ModelRenderer BackJettyFire_r1;
	private final ModelRenderer BottomJet;
	private final ModelRenderer BottJetFire_r1;
	private final ModelRenderer UwUFace;
	private final ModelRenderer ErrorFace;
	private final ModelRenderer errorface_r1;
	private final ModelRenderer errorface_r2;
	private final ModelRenderer DoneFace;
	private final ModelRenderer doneeye_r1;
	private final ModelRenderer doneeye_r2;
	private final ModelRenderer LoadingFace;
	private final ModelRenderer AttentionFace;
	private final ModelRenderer SadFace;
	private final ModelRenderer eyebrow2_r1;
	private final ModelRenderer eyebrow2_r2;
	private final ModelRenderer SmugFace;
	private final ModelRenderer AngryFace;
	private final ModelRenderer eyebrow2_r3;
	private final ModelRenderer eyebrow2_r4;
	private final ModelRenderer WTFFace;
	private final ModelRenderer HappyFace;
	private final ModelRenderer DefFace;
	private final ModelRenderer LeftEye;
	private final ModelRenderer lefteye1;
	private final ModelRenderer lefteye2;
	private final ModelRenderer lefteye3;
	private final ModelRenderer lefteye4;
	private final ModelRenderer RightEye;
	private final ModelRenderer righteye1;
	private final ModelRenderer righteye2;
	private final ModelRenderer righteye3;
	private final ModelRenderer righteye4;
	private final ModelRenderer RightWing;
	private final ModelRenderer BottomWingR;
	private final ModelRenderer UpperWingR;
	private final ModelRenderer LeftWing;
	private final ModelRenderer BottomWingL;
	private final ModelRenderer UpperWingL;
	private T entit;

	public RayaPrimeModel() {
		textureWidth = 128;
		textureHeight = 128;

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 14.2929F, -1.0779F);
		MainBody.setTextureOffset(81, 39).addBox(-2.0F, -5.2929F, -4.9221F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		MainBody.setTextureOffset(0, 0).addBox(-5.0F, -3.2929F, -4.9221F, 10.0F, 10.0F, 11.0F, 0.0F, false);
		MainBody.setTextureOffset(45, 8).addBox(-6.0F, 6.7071F, -5.9221F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		MainBody.setTextureOffset(102, 0).addBox(-6.0F, -3.2929F, -5.9221F, 1.0F, 10.0F, 12.0F, 0.0F, false);
		MainBody.setTextureOffset(102, 23).addBox(5.0F, -3.2929F, -5.9221F, 1.0F, 10.0F, 12.0F, 0.0F, false);
		MainBody.setTextureOffset(29, 31).addBox(-6.0F, -4.2929F, -5.9221F, 12.0F, 1.0F, 12.0F, 0.0F, false);

		UpperAC_r1 = new ModelRenderer(this);
		UpperAC_r1.setRotationPoint(0.0F, -5.7929F, 1.0779F);
		MainBody.addChild(UpperAC_r1);
		setRotationAngle(UpperAC_r1, 0.2182F, 0.0F, 0.0F);
		UpperAC_r1.setTextureOffset(92, 71).addBox(-5.0F, 0.6F, -4.0F, 10.0F, 3.0F, 8.0F, 0.0F, false);

		LeftEar = new ModelRenderer(this);
		LeftEar.setRotationPoint(3.0F, -3.9929F, -2.9721F);
		MainBody.addChild(LeftEar);
		LeftEar.setTextureOffset(6, 27).addBox(-1.0F, -5.3F, 0.05F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		LeftEar.setTextureOffset(0, 28).addBox(-1.0F, -9.3F, 1.05F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(-3.0F, -4.2929F, -2.9221F);
		MainBody.addChild(RightEar);
		RightEar.setTextureOffset(6, 35).addBox(-3.0F, -5.0F, 0.0F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		RightEar.setTextureOffset(0, 36).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		BackJet = new ModelRenderer(this);
		BackJet.setRotationPoint(0.0F, -1.2929F, 6.0779F);
		MainBody.addChild(BackJet);
		

		BackJettyFire_r1 = new ModelRenderer(this);
		BackJettyFire_r1.setRotationPoint(0.0F, 3.0F, 1.0F);
		BackJet.addChild(BackJettyFire_r1);
		setRotationAngle(BackJettyFire_r1, 0.2618F, 0.0F, 0.0F);
		BackJettyFire_r1.setTextureOffset(111, 56).addBox(-3.25F, 4.0F, -1.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		BackJettyFire_r1.setTextureOffset(108, 60).addBox(-4.0F, -4.0F, -1.9F, 8.0F, 8.0F, 2.0F, 0.0F, false);

		BottomJet = new ModelRenderer(this);
		BottomJet.setRotationPoint(0.0F, 7.6071F, -0.9221F);
		MainBody.addChild(BottomJet);
		setRotationAngle(BottomJet, 0.6545F, 0.0F, 0.0F);
		BottomJet.setTextureOffset(75, 61).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		BottJetFire_r1 = new ModelRenderer(this);
		BottJetFire_r1.setRotationPoint(-1.0F, 1.0F, 2.0F);
		BottomJet.addChild(BottJetFire_r1);
		setRotationAngle(BottJetFire_r1, 0.0873F, 0.0F, 0.0F);
		BottJetFire_r1.setTextureOffset(91, 62).addBox(-0.5F, 1.0F, -2.7F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		UwUFace = new ModelRenderer(this);
		UwUFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		UwUFace.setTextureOffset(60, 108).addBox(-5.0F, -5.05F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);
		UwUFace.setTextureOffset(60, 101).addBox(-2.5F, 1.2F, 3.999F, 5.0F, 2.0F, 0.0F, 0.0F, false);

		ErrorFace = new ModelRenderer(this);
		ErrorFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		

		errorface_r1 = new ModelRenderer(this);
		errorface_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		ErrorFace.addChild(errorface_r1);
		setRotationAngle(errorface_r1, 0.0F, 0.0F, -0.7854F);
		errorface_r1.setTextureOffset(60, 118).addBox(-1.0F, -4.0F, 3.999F, 2.0F, 8.0F, 0.0F, 0.0F, false);

		errorface_r2 = new ModelRenderer(this);
		errorface_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		ErrorFace.addChild(errorface_r2);
		setRotationAngle(errorface_r2, 0.0F, 0.0F, 0.7854F);
		errorface_r2.setTextureOffset(60, 118).addBox(-1.0F, -4.0F, 3.999F, 2.0F, 8.0F, 0.0F, 0.0F, false);

		DoneFace = new ModelRenderer(this);
		DoneFace.setRotationPoint(0.0F, 16.25F, -10.0F);
		

		doneeye_r1 = new ModelRenderer(this);
		doneeye_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		DoneFace.addChild(doneeye_r1);
		setRotationAngle(doneeye_r1, 0.0F, 0.0F, 0.5236F);
		doneeye_r1.setTextureOffset(60, 118).addBox(-0.4F, -4.15F, 3.999F, 2.0F, 5.0F, 0.0F, 0.0F, false);

		doneeye_r2 = new ModelRenderer(this);
		doneeye_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		DoneFace.addChild(doneeye_r2);
		setRotationAngle(doneeye_r2, 0.0F, 0.0F, -1.0472F);
		doneeye_r2.setTextureOffset(60, 118).addBox(-2.8F, -2.4F, 3.999F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		LoadingFace = new ModelRenderer(this);
		LoadingFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		LoadingFace.setTextureOffset(80, 118).addBox(-5.0F, -5.0F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);

		AttentionFace = new ModelRenderer(this);
		AttentionFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		AttentionFace.setTextureOffset(40, 108).addBox(-4.5F, -5.35F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);

		SadFace = new ModelRenderer(this);
		SadFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		SadFace.setTextureOffset(40, 118).addBox(-5.4F, -4.75F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);

		eyebrow2_r1 = new ModelRenderer(this);
		eyebrow2_r1.setRotationPoint(0.0F, -1.6987F, 3.998F);
		SadFace.addChild(eyebrow2_r1);
		setRotationAngle(eyebrow2_r1, 3.1416F, 0.0F, -2.8362F);
		eyebrow2_r1.setTextureOffset(122, 96).addBox(-3.8878F, -0.3F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		eyebrow2_r1.setTextureOffset(122, 96).addBox(-5.2878F, -1.3F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, false);

		eyebrow2_r2 = new ModelRenderer(this);
		eyebrow2_r2.setRotationPoint(-2.4F, -2.1F, 3.998F);
		SadFace.addChild(eyebrow2_r2);
		setRotationAngle(eyebrow2_r2, 0.0F, 0.0F, -0.2182F);
		eyebrow2_r2.setTextureOffset(122, 96).addBox(-1.3F, 0.8F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		eyebrow2_r2.setTextureOffset(122, 96).addBox(-2.7F, 0.8F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);

		SmugFace = new ModelRenderer(this);
		SmugFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		SmugFace.setTextureOffset(30, 98).addBox(-5.0F, -4.95F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);

		AngryFace = new ModelRenderer(this);
		AngryFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		AngryFace.setTextureOffset(20, 118).addBox(-4.9F, -4.75F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);
		AngryFace.setTextureOffset(1, 10).addBox(-0.9F, 1.0F, 3.999F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		eyebrow2_r3 = new ModelRenderer(this);
		eyebrow2_r3.setRotationPoint(0.0F, -1.6987F, 3.998F);
		AngryFace.addChild(eyebrow2_r3);
		setRotationAngle(eyebrow2_r3, 3.1416F, 0.0F, 2.8362F);
		eyebrow2_r3.setTextureOffset(120, 96).addBox(-4.0878F, 0.2F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		eyebrow2_r3.setTextureOffset(121, 95).addBox(-3.7878F, 0.2F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);

		eyebrow2_r4 = new ModelRenderer(this);
		eyebrow2_r4.setRotationPoint(-2.4F, -2.1F, 3.998F);
		AngryFace.addChild(eyebrow2_r4);
		setRotationAngle(eyebrow2_r4, 0.0F, 0.0F, 0.2182F);
		eyebrow2_r4.setTextureOffset(120, 96).addBox(-1.6F, -0.1F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		eyebrow2_r4.setTextureOffset(120, 97).addBox(-1.3F, -0.1F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);

		WTFFace = new ModelRenderer(this);
		WTFFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		WTFFace.setTextureOffset(0, 118).addBox(-5.0F, -5.0F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);
		WTFFace.setTextureOffset(1, 1).addBox(-0.5F, 1.5F, 3.999F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		HappyFace = new ModelRenderer(this);
		HappyFace.setRotationPoint(0.0F, 16.0F, -10.0F);
		HappyFace.setTextureOffset(10, 108).addBox(-5.0F, -5.0F, 3.999F, 10.0F, 10.0F, 0.0F, 0.0F, false);

		DefFace = new ModelRenderer(this);
		DefFace.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		LeftEye = new ModelRenderer(this);
		LeftEye.setRotationPoint(-0.5F, -1.0F, 0.0F);
		DefFace.addChild(LeftEye);
		

		lefteye1 = new ModelRenderer(this);
		lefteye1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftEye.addChild(lefteye1);
		lefteye1.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -6.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		lefteye2 = new ModelRenderer(this);
		lefteye2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftEye.addChild(lefteye2);
		lefteye2.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -5.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		lefteye3 = new ModelRenderer(this);
		lefteye3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftEye.addChild(lefteye3);
		lefteye3.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -5.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		lefteye4 = new ModelRenderer(this);
		lefteye4.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftEye.addChild(lefteye4);
		lefteye4.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -5.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		RightEye = new ModelRenderer(this);
		RightEye.setRotationPoint(4.5F, -1.0F, -1.0F);
		DefFace.addChild(RightEye);
		

		righteye1 = new ModelRenderer(this);
		righteye1.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightEye.addChild(righteye1);
		righteye1.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -5.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		righteye2 = new ModelRenderer(this);
		righteye2.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightEye.addChild(righteye2);
		righteye2.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -4.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		righteye3 = new ModelRenderer(this);
		righteye3.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightEye.addChild(righteye3);
		righteye3.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -4.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		righteye4 = new ModelRenderer(this);
		righteye4.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightEye.addChild(righteye4);
		righteye4.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -4.001F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-6.0F, 16.0F, -4.0F);
		setRotationAngle(RightWing, 0.0F, -0.3491F, 0.0F);
		

		BottomWingR = new ModelRenderer(this);
		BottomWingR.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightWing.addChild(BottomWingR);
		setRotationAngle(BottomWingR, -0.3927F, 0.0F, 0.0F);
		BottomWingR.setTextureOffset(6, 49).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		UpperWingR = new ModelRenderer(this);
		UpperWingR.setRotationPoint(0.0F, -0.5F, 0.0F);
		RightWing.addChild(UpperWingR);
		setRotationAngle(UpperWingR, 0.3491F, 0.0F, 0.0F);
		UpperWingR.setTextureOffset(2, 57).addBox(-3.0F, -2.5F, -1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		UpperWingR.setTextureOffset(24, 63).addBox(-2.5F, -2.0F, 7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(6.0F, 16.0F, -4.0F);
		setRotationAngle(LeftWing, 0.0F, 0.3491F, 0.0F);
		

		BottomWingL = new ModelRenderer(this);
		BottomWingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftWing.addChild(BottomWingL);
		setRotationAngle(BottomWingL, -0.3927F, 0.0F, 0.0F);
		BottomWingL.setTextureOffset(43, 49).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		UpperWingL = new ModelRenderer(this);
		UpperWingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftWing.addChild(UpperWingL);
		setRotationAngle(UpperWingL, 0.3491F, 0.0F, 0.0F);
		UpperWingL.setTextureOffset(40, 57).addBox(0.0F, -3.0F, -1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		UpperWingL.setTextureOffset(62, 63).addBox(0.5F, -2.5F, 7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		entit = entity;
		if(/*entity.getPersistentData().getInt("anim") == 0*/true) 
		{
			setRotationAngle(BottomWingR, -0.393f, 0f, 0f);
			setRotationAngle(UpperWingR, 0.349f, 0f, 0f);
			setRotationAngle(RightWing, 0f, (float) (-0.349f-Math.sin(ageInTicks/4)/4), 0f);

			setRotationAngle(BottomWingL, -0.393f, 0f, 0f);
			setRotationAngle(UpperWingL, 0.349f, 0f, 0f);
			setRotationAngle(LeftWing, 0f, (float) (0.349f+Math.sin(ageInTicks/4)/4), 0f);

			setRotationAngle(BottomJet, (float) (0.654f-Math.sin(ageInTicks/4)/4), 0f, 0f);

			setRotationAngle(LeftEar, (float) (-0.349f+Math.sin(ageInTicks/4)/4), 0.26f, 0.26f);

			setRotationAngle(RightEar, (float) (-0.349f+Math.sin(ageInTicks/4)/4), -0.26f, -0.26f);

		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		MainBody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 0) DefFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 1) UwUFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 2) ErrorFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 3) DoneFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 4) LoadingFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 5) AttentionFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 6) SadFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 7) SmugFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 8) AngryFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 9) WTFFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		if(entit.getPersistentData().getInt("anim") == 10) HappyFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}