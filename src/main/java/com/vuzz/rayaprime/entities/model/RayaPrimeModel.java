package com.vuzz.rayaprime.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.rayaprime.entities.custom.RayaPrimeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.vector.Vector3d;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class RayaPrimeModel<T extends RayaPrimeEntity> extends EntityModel<T> {
	public final ModelRenderer MainBody;
	public final ModelRenderer UpperAC_r1;
	public final ModelRenderer LeftEar;
	public final ModelRenderer RightEar;
	public final ModelRenderer BackJet;
	public final ModelRenderer BackJettyFire_r1;
	public final ModelRenderer BottomJet;
	public final ModelRenderer BottJetFire_r1;
	public final ModelRenderer LeftWing;
	public final ModelRenderer BottomWingL;
	public final ModelRenderer UpperWingL;
	public final ModelRenderer RightWing;
	public final ModelRenderer BottomWingR;
	public final ModelRenderer UpperWingR;
	public final ModelRenderer Face;
	public final ModelRenderer LeftEye;
	public final ModelRenderer lefteye1;
	public final ModelRenderer lefteye2;
	public final ModelRenderer lefteye3;
	public final ModelRenderer lefteye4;
	public final ModelRenderer RightEye;
	public final ModelRenderer righteye1;
	public final ModelRenderer righteye2;
	public final ModelRenderer righteye3;
	public final ModelRenderer righteye4;
	//public final ModelRenderer Mouth;

	public int anim = 0;

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
		LeftEar.setRotationPoint(3.0F, -3.2929F, -4.9221F);
		MainBody.addChild(LeftEar);
		LeftEar.setTextureOffset(6, 27).addBox(-1.0F, -5.0F, 0.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		LeftEar.setTextureOffset(0, 28).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(-3.0F, -3.2929F, -4.9221F);
		MainBody.addChild(RightEar);
		RightEar.setTextureOffset(6, 35).addBox(-3.0F, -5.0F, 0.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		RightEar.setTextureOffset(0, 36).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

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
		BottomJet.setTextureOffset(75, 61).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		BottJetFire_r1 = new ModelRenderer(this);
		BottJetFire_r1.setRotationPoint(-1.0F, 1.0F, 2.0F);
		BottomJet.addChild(BottJetFire_r1);
		setRotationAngle(BottJetFire_r1, 0.0873F, 0.0F, 0.0F);
		BottJetFire_r1.setTextureOffset(91, 62).addBox(-0.5F, 1.0F, -2.7F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(6.0F, 1.7071F, -2.9221F);
		MainBody.addChild(LeftWing);
		

		BottomWingL = new ModelRenderer(this);
		BottomWingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftWing.addChild(BottomWingL);
		BottomWingL.setTextureOffset(43, 49).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		UpperWingL = new ModelRenderer(this);
		UpperWingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftWing.addChild(UpperWingL);
		UpperWingL.setTextureOffset(40, 57).addBox(0.0F, -3.0F, -1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		UpperWingL.setTextureOffset(62, 63).addBox(0.5F, -2.5F, 7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-6.0F, 1.7071F, -2.9221F);
		MainBody.addChild(RightWing);
		

		BottomWingR = new ModelRenderer(this);
		BottomWingR.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightWing.addChild(BottomWingR);
		BottomWingR.setTextureOffset(6, 49).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		UpperWingR = new ModelRenderer(this);
		UpperWingR.setRotationPoint(0.0F, -0.5F, 0.0F);
		RightWing.addChild(UpperWingR);
		UpperWingR.setTextureOffset(2, 57).addBox(-3.0F, -2.5F, -1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		UpperWingR.setTextureOffset(24, 63).addBox(-2.5F, -2.0F, 7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Face = new ModelRenderer(this);
		Face.setRotationPoint(0.0F, 9.7071F, 1.0779F);
		MainBody.addChild(Face);
		

		LeftEye = new ModelRenderer(this);
		LeftEye.setRotationPoint(-0.5F, -1.0F, 0.0F);
		Face.addChild(LeftEye);
		

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
		Face.addChild(RightEye);
		

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

		/*Mouth = new ModelRenderer(this);
		Mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		Face.addChild(Mouth);
		Mouth.setTextureOffset(0, 6).addBox(-2.0F, -6.0F, -6.001F, 4.0F, 1.0F, 1.0F, 0.0F, false);*/
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		if(anim == 0) 
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
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}