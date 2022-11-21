package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BeyondtoModel<T extends BeyondtoEntity> extends EntityModel<T> {
	private final ModelRenderer LEar;
	private final ModelRenderer REar;
	private final ModelRenderer LWing;
	private final ModelRenderer RWing;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	private T entit;

	public BeyondtoModel() {
		textureWidth = 64;
		textureHeight = 64;

		LEar = new ModelRenderer(this);
		LEar.setRotationPoint(2.0F, 14.25F, -1.75F);
		setRotationAngle(LEar, 0.0F, 0.0F, 0.4363F);
		LEar.setTextureOffset(7, 13).addBox(-1.25F, -2.75F, -1.25F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		LEar.setTextureOffset(0, 0).addBox(-1.25F, -5.75F, -1.25F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		REar = new ModelRenderer(this);
		REar.setRotationPoint(-2.5F, 13.25F, -1.75F);
		setRotationAngle(REar, 0.0F, 0.0F, -0.4363F);
		REar.setTextureOffset(17, 37).addBox(-1.75F, -1.75F, -1.25F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		REar.setTextureOffset(42, 9).addBox(-0.75F, -4.75F, -1.25F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LWing = new ModelRenderer(this);
		LWing.setRotationPoint(5.0F, 17.0F, -2.0F);
		setRotationAngle(LWing, 0.3927F, 0.3054F, 0.0F);
		LWing.setTextureOffset(28, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		RWing = new ModelRenderer(this);
		RWing.setRotationPoint(-5.0F, 17.0F, -2.0F);
		setRotationAngle(RWing, 0.3054F, -0.3927F, 0.0F);
		RWing.setTextureOffset(28, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 19).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Body.setTextureOffset(24, 44).addBox(-5.0F, -12.0F, -4.9F, 10.0F, 10.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(33, 22).addBox(-1.5F, -13.0F, -3.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(39, 0).addBox(-3.0F, -9.0F, 4.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 36).addBox(-3.5F, -10.5F, -5.0F, 7.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3054F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(27, 30).addBox(-3.0F, -3.8F, -2.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -12.0F, -2.0F);
		Body.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3491F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(23, 12).addBox(-1.49F, -2.0F, 2.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(bone);
		bone.setTextureOffset(10, 30).addBox(-1.6F, -8.0F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(10, 30).addBox(-1.6F, -7.7F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(10, 30).addBox(-1.9F, -7.7F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(10, 30).addBox(-1.9F, -8.0F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.5F, 0.0F, 0.0F);
		Body.addChild(bone2);
		bone2.setTextureOffset(10, 30).addBox(-1.6F, -8.0F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		bone2.setTextureOffset(10, 30).addBox(-1.6F, -7.7F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		bone2.setTextureOffset(10, 30).addBox(-1.9F, -7.7F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		bone2.setTextureOffset(10, 30).addBox(-1.9F, -8.0F, -5.01F, 1.0F, 2.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		entit = entity;
		int anim = entit.getPersistentData().getInt("anim");
		setRotationAngle(RWing, 0f, (float) (-0.349f-Math.sin(ageInTicks/4)/5), 0f);
		setRotationAngle(LWing, 0f, (float) (0.349f+Math.sin(ageInTicks/4)/5), 0f);
		setRotationAngle(REar, 0f, 0f, (float) (-0.349f-Math.sin(ageInTicks/4)/5));
		setRotationAngle(LEar, 0f, 0f, (float) (0.349f-Math.sin(ageInTicks/4)/5));
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		LEar.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		REar.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LWing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RWing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}