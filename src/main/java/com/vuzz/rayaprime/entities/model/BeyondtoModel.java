package com.vuzz.rayaprime.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.rayaprime.entities.custom.BeyondtoEntity;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BeyondtoModel<T extends BeyondtoEntity> extends EntityModel<T> {
	private final ModelRenderer NeutralFace;
	private final ModelRenderer MainBody;
	private final ModelRenderer backjet_r1;
	private final ModelRenderer backjet_fire_r1;
	private final ModelRenderer upperbattery2_r1;
	private final ModelRenderer LeftWing;
	private final ModelRenderer left_wing_r1;
	private final ModelRenderer RightWing;
	private final ModelRenderer LeftEar;
	private final ModelRenderer RightEar;
	private final ModelRenderer BottomJet;
	private final ModelRenderer holo_second_r1;
	private final ModelRenderer HappyFace;
	private final ModelRenderer SadFace;
	private final ModelRenderer Shield;
	private final ModelRenderer cube_r1;
	private T entit;

	public BeyondtoModel() {
		textureWidth = 48;
		textureHeight = 48;

		NeutralFace = new ModelRenderer(this);
		NeutralFace.setRotationPoint(0.0F, 24.0F, 0.0F);
		NeutralFace.setTextureOffset(2, 36).addBox(-2.5F, -9.9F, -3.501F, 5.0F, 5.0F, 0.0F, 0.0F, false);
		NeutralFace.setTextureOffset(46, 29).addBox(-1.6F, -8.2F, -3.502F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		NeutralFace.setTextureOffset(46, 29).addBox(0.6F, -8.2F, -3.502F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		MainBody.setTextureOffset(25, 6).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		MainBody.setTextureOffset(0, 23).addBox(-2.5F, -9.5F, -3.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		MainBody.setTextureOffset(0, 0).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		backjet_r1 = new ModelRenderer(this);
		backjet_r1.setRotationPoint(0.0F, -7.0F, 5.0F);
		MainBody.addChild(backjet_r1);
		setRotationAngle(backjet_r1, -0.7854F, 0.0F, 0.0F);
		backjet_r1.setTextureOffset(26, 23).addBox(-2.0F, 0.3F, -2.5F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		backjet_fire_r1 = new ModelRenderer(this);
		backjet_fire_r1.setRotationPoint(0.0F, -7.0F, 5.0F);
		MainBody.addChild(backjet_fire_r1);
		setRotationAngle(backjet_fire_r1, -1.2157F, 0.0F, 0.0F);
		backjet_fire_r1.setTextureOffset(24, 10).addBox(-1.5F, 0.8F, -0.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		upperbattery2_r1 = new ModelRenderer(this);
		upperbattery2_r1.setRotationPoint(0.0F, -10.5F, -1.0F);
		MainBody.addChild(upperbattery2_r1);
		setRotationAngle(upperbattery2_r1, -0.3491F, 0.0F, 0.0F);
		upperbattery2_r1.setTextureOffset(24, 15).addBox(-1.0F, -0.8F, 0.7F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(3.5F, -6.5F, -3.0F);
		MainBody.addChild(LeftWing);
		setRotationAngle(LeftWing, 0.2501F, 0.2615F, -0.0452F);
		

		left_wing_r1 = new ModelRenderer(this);
		left_wing_r1.setRotationPoint(-7.0F, 0.0F, 0.0F);
		LeftWing.addChild(left_wing_r1);
		setRotationAngle(left_wing_r1, 0.0F, 3.1416F, 0.0F);
		left_wing_r1.setTextureOffset(15, 13).addBox(-7.5F, -1.5F, -6.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-3.5F, -6.5F, -3.0F);
		MainBody.addChild(RightWing);
		setRotationAngle(RightWing, 0.2903F, -0.28F, -0.0995F);
		RightWing.setTextureOffset(15, 13).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		LeftEar = new ModelRenderer(this);
		LeftEar.setRotationPoint(-2.5F, -9.0F, -2.0F);
		MainBody.addChild(LeftEar);
		setRotationAngle(LeftEar, -0.1501F, -0.2355F, -0.3115F);
		LeftEar.setTextureOffset(11, 28).addBox(-0.499F, -3.5F, -0.999F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(2.5F, -9.0F, -2.0F);
		MainBody.addChild(RightEar);
		setRotationAngle(RightEar, -0.0818F, 0.2665F, 0.3626F);
		RightEar.setTextureOffset(9, 13).addBox(-0.499F, -3.5F, -1.001F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		BottomJet = new ModelRenderer(this);
		BottomJet.setRotationPoint(0.0F, -4.3F, -1.0F);
		MainBody.addChild(BottomJet);
		setRotationAngle(BottomJet, 0.1582F, 0.0F, 0.0F);
		

		holo_second_r1 = new ModelRenderer(this);
		holo_second_r1.setRotationPoint(0.0F, 4.0F, 1.0F);
		BottomJet.addChild(holo_second_r1);
		setRotationAngle(holo_second_r1, 0.1582F, 0.0F, 0.0F);
		holo_second_r1.setTextureOffset(18, 28).addBox(-1.0F, -1.0F, -0.25F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		holo_second_r1.setTextureOffset(13, 23).addBox(-1.5F, -3.0F, -0.75F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		holo_second_r1.setTextureOffset(19, 0).addBox(-2.0F, -4.5F, -1.3F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		HappyFace = new ModelRenderer(this);
		HappyFace.setRotationPoint(0.0F, 24.0F, 0.0F);
		HappyFace.setTextureOffset(8, 43).addBox(-2.5F, -9.5F, -3.501F, 5.0F, 5.0F, 0.0F, 0.0F, false);
		HappyFace.setTextureOffset(46, 29).addBox(-2.0F, -6.5F, -3.502F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		HappyFace.setTextureOffset(46, 29).addBox(1.0F, -6.5F, -3.502F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		SadFace = new ModelRenderer(this);
		SadFace.setRotationPoint(0.0F, 24.0F, 0.0F);
		SadFace.setTextureOffset(46, 28).addBox(0.7F, -6.7F, -3.502F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		SadFace.setTextureOffset(46, 28).addBox(-1.7F, -6.7F, -3.502F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		SadFace.setTextureOffset(13, 36).addBox(-2.5F, -9.5F, -3.501F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		Shield = new ModelRenderer(this);
		Shield.setRotationPoint(0.0F, 24.0F, -1.0F);
		Shield.setTextureOffset(42, 10).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		Shield.setTextureOffset(37, 0).addBox(-3.0F, -11.0F, 0.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shield.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 3.1416F, 0.0F);
		cube_r1.setTextureOffset(37, 0).addBox(-3.0F, -11.0F, -1.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		entit = entity;
		int anim = entit.getPersistentData().getInt("anim");
		setRotationAngle(RightWing, 0f, (float) (-0.349f-Math.sin(ageInTicks/4)/5), 0f);

		setRotationAngle(LeftWing, 0f, (float) (0.349f+Math.sin(ageInTicks/4)/5), 0f);

		setRotationAngle(BottomJet, (float) (0.654f-Math.sin(ageInTicks/4)/5), 0f, 0f);
		switch(anim) {
			case 0:
			break;
			case 1:
			break;
			case 2:
			break;
		}
		setRotationAngle(LeftEar, (float) (-0.349f+Math.sin(ageInTicks/4)/7), 0.26f, 0.26f);

		setRotationAngle(RightEar, (float) (-0.349f+Math.sin(ageInTicks/4)/7), -0.26f, -0.26f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		int anim = entit.getPersistentData().getInt("anim");
		int phase = entit.getPersistentData().getInt("phase");
		System.out.println(phase);
		switch(phase) {
			case 0:
				MainBody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				switch(anim) {
					case 0:
						NeutralFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
					break;
					case 1:
						HappyFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
					break;
					case 2:
						SadFace.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
					break;
				}
			break;
			case 1:
				Shield.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			break;
		}
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}