package com.ashenlight.ashenrail;// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class OreCarModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "orecar"), "main");
	private final ModelPart wheelandaxle;
	private final ModelPart wheel2;
	private final ModelPart flange2;
	private final ModelPart outerrim2;
	private final ModelPart innerrim2;
	private final ModelPart wheel;
	private final ModelPart flange;
	private final ModelPart outerrim;
	private final ModelPart innerrim;
	private final ModelPart wheelandaxle2;
	private final ModelPart wheel3;
	private final ModelPart flange3;
	private final ModelPart outerrim3;
	private final ModelPart innerrim3;
	private final ModelPart wheel4;
	private final ModelPart flange4;
	private final ModelPart outerrim4;
	private final ModelPart innerrim4;
	private final ModelPart wholebody;
	private final ModelPart underside;
	private final ModelPart couplerfront;
	private final ModelPart couplerback;

	public OreCarModel(ModelPart root) {
		this.wheelandaxle = root.getChild("wheelandaxle");
		this.wheel2 = this.wheelandaxle.getChild("wheel2");
		this.flange2 = this.wheel2.getChild("flange2");
		this.outerrim2 = this.wheel2.getChild("outerrim2");
		this.innerrim2 = this.wheel2.getChild("innerrim2");
		this.wheel = this.wheelandaxle.getChild("wheel");
		this.flange = this.wheel.getChild("flange");
		this.outerrim = this.wheel.getChild("outerrim");
		this.innerrim = this.wheel.getChild("innerrim");
		this.wheelandaxle2 = root.getChild("wheelandaxle2");
		this.wheel3 = this.wheelandaxle2.getChild("wheel3");
		this.flange3 = this.wheel3.getChild("flange3");
		this.outerrim3 = this.wheel3.getChild("outerrim3");
		this.innerrim3 = this.wheel3.getChild("innerrim3");
		this.wheel4 = this.wheelandaxle2.getChild("wheel4");
		this.flange4 = this.wheel4.getChild("flange4");
		this.outerrim4 = this.wheel4.getChild("outerrim4");
		this.innerrim4 = this.wheel4.getChild("innerrim4");
		this.wholebody = root.getChild("wholebody");
		this.underside = root.getChild("underside");
		this.couplerfront = root.getChild("couplerfront");
		this.couplerback = root.getChild("couplerback");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wheelandaxle = partdefinition.addOrReplaceChild("wheelandaxle", CubeListBuilder.create().texOffs(112, 32).addBox(-3.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 16.1716F, 12.0F));

		PartDefinition wheel2 = wheelandaxle.addOrReplaceChild("wheel2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flange2 = wheel2.addOrReplaceChild("flange2", CubeListBuilder.create().texOffs(120, 158).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(156, 158).addBox(-0.5F, 3.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = flange2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 159).addBox(-1.0F, -4.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, -6.0355F, 3.9142F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r2 = flange2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(96, 150).addBox(-1.0F, -4.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, 7.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r3 = flange2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 150).addBox(-1.0F, -4.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 3.9142F, 6.0355F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r4 = flange2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(164, 64).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 1.7929F, -3.9142F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r5 = flange2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(144, 158).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, -4.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r6 = flange2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(132, 158).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, -3.9142F, -1.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition outerrim2 = wheel2.addOrReplaceChild("outerrim2", CubeListBuilder.create().texOffs(118, 166).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(154, 166).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 0.0F));

		PartDefinition cube_r7 = outerrim2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(42, 167).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r8 = outerrim2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 167).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.8284F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r9 = outerrim2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(166, 166).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r10 = outerrim2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(142, 166).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r11 = outerrim2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(130, 166).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.8284F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r12 = outerrim2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(6, 171).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, -3.4142F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim2 = wheel2.addOrReplaceChild("innerrim2", CubeListBuilder.create().texOffs(146, 146).addBox(-1.0F, -3.8285F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = innerrim2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(136, 146).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r14 = innerrim2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(126, 146).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.8284F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r15 = innerrim2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(142, 134).addBox(-1.0F, -9.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 3.4142F, -3.4142F, -0.7854F, 0.0F, 0.0F));

		PartDefinition wheel = wheelandaxle.addOrReplaceChild("wheel", CubeListBuilder.create(), PartPose.offset(10.0F, 0.0F, 0.0F));

		PartDefinition flange = wheel.addOrReplaceChild("flange", CubeListBuilder.create().texOffs(10, 158).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 158).addBox(-0.5F, 3.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flange.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(108, 158).addBox(0.0F, -4.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, -6.0355F, 3.9142F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r17 = flange.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(148, 28).addBox(0.0F, -4.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, 7.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r18 = flange.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(10, 150).addBox(0.0F, -4.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 3.9142F, 6.0355F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r19 = flange.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(164, 56).addBox(0.0F, -2.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 1.7929F, -3.9142F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r20 = flange.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 158).addBox(0.0F, -2.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, -4.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r21 = flange.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(158, 16).addBox(0.0F, -2.0F, -4.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, -3.9142F, -1.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition outerrim = wheel.addOrReplaceChild("outerrim", CubeListBuilder.create().texOffs(164, 127).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(6, 166).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 0.0F));

		PartDefinition cube_r22 = outerrim.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(106, 166).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r23 = outerrim.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(94, 166).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.8284F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r24 = outerrim.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(18, 166).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r25 = outerrim.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(164, 137).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r26 = outerrim.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(164, 132).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.8284F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r27 = outerrim.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(170, 118).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, -3.4142F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim = wheel.addOrReplaceChild("innerrim", CubeListBuilder.create().texOffs(116, 138).addBox(0.0F, -3.8285F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition cube_r28 = innerrim.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(106, 138).addBox(0.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r29 = innerrim.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(96, 138).addBox(0.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.8284F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r30 = innerrim.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(132, 134).addBox(0.0F, -9.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 3.4142F, -3.4142F, -0.7854F, 0.0F, 0.0F));

		PartDefinition wheelandaxle2 = partdefinition.addOrReplaceChild("wheelandaxle2", CubeListBuilder.create().texOffs(96, 134).addBox(-3.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 16.1716F, -12.0F));

		PartDefinition wheel3 = wheelandaxle2.addOrReplaceChild("wheel3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flange3 = wheel3.addOrReplaceChild("flange3", CubeListBuilder.create().texOffs(46, 159).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(82, 159).addBox(-0.5F, 3.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r31 = flange3.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(160, 24).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, -6.0355F, -3.9142F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r32 = flange3.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(152, 134).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, -7.0355F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r33 = flange3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(108, 150).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 3.9142F, -6.0355F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r34 = flange3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(164, 72).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 1.7929F, 3.9142F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r35 = flange3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(70, 159).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, 4.0355F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r36 = flange3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(58, 159).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, -3.9142F, 1.7929F, -0.7854F, 0.0F, 0.0F));

		PartDefinition outerrim3 = wheel3.addOrReplaceChild("outerrim3", CubeListBuilder.create().texOffs(54, 167).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(168, 142).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 0.0F));

		PartDefinition cube_r37 = outerrim3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(168, 157).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, -3.4142F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r38 = outerrim3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(168, 152).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.8284F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r39 = outerrim3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(168, 147).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r40 = outerrim3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(78, 167).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r41 = outerrim3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(66, 167).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.8284F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r42 = outerrim3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(18, 171).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim3 = wheel3.addOrReplaceChild("innerrim3", CubeListBuilder.create().texOffs(66, 147).addBox(-1.0F, -3.8285F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition cube_r43 = innerrim3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(56, 147).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r44 = innerrim3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(46, 147).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.8284F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r45 = innerrim3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(36, 147).addBox(-1.0F, -9.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 3.4142F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wheel4 = wheelandaxle2.addOrReplaceChild("wheel4", CubeListBuilder.create(), PartPose.offset(10.0F, 0.0F, 0.0F));

		PartDefinition flange4 = wheel4.addOrReplaceChild("flange4", CubeListBuilder.create().texOffs(160, 32).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(164, 40).addBox(-0.5F, 3.0355F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r46 = flange4.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(164, 48).addBox(0.0F, -4.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, -6.0355F, -3.9142F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r47 = flange4.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(156, 150).addBox(0.0F, -4.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, -7.0355F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r48 = flange4.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(156, 142).addBox(0.0F, -4.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 3.9142F, -6.0355F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r49 = flange4.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(164, 80).addBox(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 1.7929F, 3.9142F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r50 = flange4.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(164, 8).addBox(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, 4.0355F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r51 = flange4.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(164, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, -3.9142F, 1.7929F, -0.7854F, 0.0F, 0.0F));

		PartDefinition outerrim4 = wheel4.addOrReplaceChild("outerrim4", CubeListBuilder.create().texOffs(170, 16).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(170, 98).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 0.0F));

		PartDefinition cube_r52 = outerrim4.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(170, 113).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, -3.4142F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r53 = outerrim4.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(170, 108).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.8284F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r54 = outerrim4.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(170, 103).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r55 = outerrim4.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(170, 93).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r56 = outerrim4.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(170, 88).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.8284F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r57 = outerrim4.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(90, 171).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.4142F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim4 = wheel4.addOrReplaceChild("innerrim4", CubeListBuilder.create().texOffs(0, 150).addBox(0.0F, -3.8285F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition cube_r58 = innerrim4.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(148, 16).addBox(0.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r59 = innerrim4.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(86, 147).addBox(0.0F, -1.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.8284F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r60 = innerrim4.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(76, 147).addBox(0.0F, -9.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 3.4142F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wholebody = partdefinition.addOrReplaceChild("wholebody", CubeListBuilder.create().texOffs(112, 0).addBox(-6.0F, 6.0F, -7.0F, 12.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(82, 93).addBox(8.2F, -7.0F, -20.0F, 1.0F, 1.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, 5.0F, -20.0F, 16.0F, 1.0F, 40.0F, new CubeDeformation(0.02F))
		.texOffs(36, 134).addBox(-7.0F, -7.0F, -20.0F, 14.0F, 12.0F, 1.0F, new CubeDeformation(-0.02F))
		.texOffs(66, 134).addBox(-7.0F, -7.0F, 19.0F, 14.0F, 12.0F, 1.0F, new CubeDeformation(-0.02F))
		.texOffs(112, 36).addBox(-9.0F, -7.0F, -20.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(112, 38).addBox(-9.0F, -7.0F, 19.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(0, 93).addBox(-9.2F, -7.0F, -20.0F, 1.0F, 1.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r61 = wholebody.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(164, 101).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(164, 88).addBox(-1.0F, -7.0F, -40.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.2F, 20.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r62 = wholebody.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(164, 114).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 162).addBox(-1.0F, -7.0F, -40.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.2F, 20.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r63 = wholebody.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(82, 41).addBox(-1.0F, -12.0F, -20.0F, 1.0F, 12.0F, 40.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-7.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r64 = wholebody.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -12.0F, -20.0F, 1.0F, 12.0F, 40.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(7.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition underside = partdefinition.addOrReplaceChild("underside", CubeListBuilder.create().texOffs(112, 16).addBox(-3.0F, 2.0F, -18.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 134).addBox(-3.0F, 2.0F, 6.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(102, 171).addBox(-1.0F, -2.0F, -16.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(110, 171).addBox(-1.0F, -2.0F, -10.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(126, 171).addBox(-1.0F, -2.0F, 14.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(118, 171).addBox(-1.0F, -2.0F, 8.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition couplerfront = partdefinition.addOrReplaceChild("couplerfront", CubeListBuilder.create().texOffs(120, 156).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(150, 38).addBox(-2.0F, -1.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 150).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(152, 144).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 153).addBox(1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, 21.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition couplerback = partdefinition.addOrReplaceChild("couplerback", CubeListBuilder.create().texOffs(126, 144).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(150, 36).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(126, 138).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(152, 142).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(126, 141).addBox(1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, -21.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public static final double WHEEL_RADIUS = 0.3125d;

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTicks = ageInTicks;

		double rotation = Mth.lerp(
				partialTicks,
				(float) ((TrainCar) entity).getPrevWheelRotation(),
				(float) ((TrainCar) entity).getWheelRotation()
		);

		this.wheelandaxle.xRot = (float) rotation;
		this.wheelandaxle2.xRot = (float) rotation;

		// swaying the train car
		TrainCar trainCar = (TrainCar) entity;

		float movement = (float) trainCar.getAbsSpeed();

		// ageInTicks only holds partialTicks (0..1) here, so build a continuous time from the entity's tick count.
		float time = trainCar.tickCount + partialTicks;
		float swaySpeed = 0.15f;  // radians of sine phase per tick: 2*PI / 0.15 ≈ 42 ticks ≈ 2 seconds per full sway
		float swayAmount = 0.01f; // radians: ≈ 1.7 degrees each way
		float sway = Mth.sin(time * swaySpeed) * swayAmount * Math.min(movement / 0.2f, 1.0f);

		this.wholebody.zRot = sway;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		wheelandaxle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wheelandaxle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wholebody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		underside.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		couplerfront.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		couplerback.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}