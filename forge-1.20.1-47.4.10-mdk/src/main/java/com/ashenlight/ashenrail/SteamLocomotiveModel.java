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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SteamLocomotiveModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "steamlocomotivemodel"), "main");
	private final ModelPart wheelandaxle;
	private final ModelPart wheel2;
	private final ModelPart innerrims2;
	private final ModelPart flanges2;
	private final ModelPart spokes2;
	private final ModelPart wheel;
	private final ModelPart innerrims;
	private final ModelPart flanges;
	private final ModelPart spokes;
	private final ModelPart wheelandaxle2;
	private final ModelPart wheel3;
	private final ModelPart innerrims3;
	private final ModelPart flanges3;
	private final ModelPart spokes3;
	private final ModelPart wheel4;
	private final ModelPart innerrims4;
	private final ModelPart flanges4;
	private final ModelPart spokes4;
	private final ModelPart wheelandaxle3;
	private final ModelPart wheel5;
	private final ModelPart innerrims5;
	private final ModelPart flanges5;
	private final ModelPart spokes5;
	private final ModelPart wheel6;
	private final ModelPart innerrims6;
	private final ModelPart flanges6;
	private final ModelPart spokes6;
	private final ModelPart pistonleft;
	private final ModelPart pistonright;
	private final ModelPart underside;
	private final ModelPart couplerfront;
	private final ModelPart couplerback;
	private final ModelPart wholebody;
	private final ModelPart body;
	private final ModelPart buffer;
	private final ModelPart cab;
	private final ModelPart seat;
	private final ModelPart smokestack;
	private final ModelPart headlight;
	private final ModelPart headlightsurrounding;
	private final ModelPart headlightbulb;
	private final ModelPart boiler;
	private final ModelPart boilerfront;

	public SteamLocomotiveModel(ModelPart root) {
		this.wheelandaxle = root.getChild("wheelandaxle");
		this.wheel2 = this.wheelandaxle.getChild("wheel2");
		this.innerrims2 = this.wheel2.getChild("innerrims2");
		this.flanges2 = this.wheel2.getChild("flanges2");
		this.spokes2 = this.wheel2.getChild("spokes2");
		this.wheel = this.wheelandaxle.getChild("wheel");
		this.innerrims = this.wheel.getChild("innerrims");
		this.flanges = this.wheel.getChild("flanges");
		this.spokes = this.wheel.getChild("spokes");
		this.wheelandaxle2 = root.getChild("wheelandaxle2");
		this.wheel3 = this.wheelandaxle2.getChild("wheel3");
		this.innerrims3 = this.wheel3.getChild("innerrims3");
		this.flanges3 = this.wheel3.getChild("flanges3");
		this.spokes3 = this.wheel3.getChild("spokes3");
		this.wheel4 = this.wheelandaxle2.getChild("wheel4");
		this.innerrims4 = this.wheel4.getChild("innerrims4");
		this.flanges4 = this.wheel4.getChild("flanges4");
		this.spokes4 = this.wheel4.getChild("spokes4");
		this.wheelandaxle3 = root.getChild("wheelandaxle3");
		this.wheel5 = this.wheelandaxle3.getChild("wheel5");
		this.innerrims5 = this.wheel5.getChild("innerrims5");
		this.flanges5 = this.wheel5.getChild("flanges5");
		this.spokes5 = this.wheel5.getChild("spokes5");
		this.wheel6 = this.wheelandaxle3.getChild("wheel6");
		this.innerrims6 = this.wheel6.getChild("innerrims6");
		this.flanges6 = this.wheel6.getChild("flanges6");
		this.spokes6 = this.wheel6.getChild("spokes6");
		this.pistonleft = root.getChild("pistonleft");
		this.pistonright = root.getChild("pistonright");
		this.underside = root.getChild("underside");
		this.couplerfront = this.underside.getChild("couplerfront");
		this.couplerback = this.underside.getChild("couplerback");
		this.wholebody = root.getChild("wholebody");
		this.body = this.wholebody.getChild("body");
		this.buffer = this.body.getChild("buffer");
		this.cab = this.wholebody.getChild("cab");
		this.seat = this.cab.getChild("seat");
		this.smokestack = this.wholebody.getChild("smokestack");
		this.headlight = this.wholebody.getChild("headlight");
		this.headlightsurrounding = this.headlight.getChild("headlightsurrounding");
		this.headlightbulb = this.headlight.getChild("headlightbulb");
		this.boiler = this.wholebody.getChild("boiler");
		this.boilerfront = this.boiler.getChild("boilerfront");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wheelandaxle = partdefinition.addOrReplaceChild("wheelandaxle", CubeListBuilder.create().texOffs(216, 144).addBox(-14.5F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 16.1716F, -14.0F));

		PartDefinition wheel2 = wheelandaxle.addOrReplaceChild("wheel2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrims2 = wheel2.addOrReplaceChild("innerrims2", CubeListBuilder.create().texOffs(258, 245).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(236, 260).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrim_r1 = innerrims2.addOrReplaceChild("innerrim_r1", CubeListBuilder.create().texOffs(260, 250).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(224, 260).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r2 = innerrims2.addOrReplaceChild("innerrim_r2", CubeListBuilder.create().texOffs(248, 260).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(212, 260).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r3 = innerrims2.addOrReplaceChild("innerrim_r3", CubeListBuilder.create().texOffs(260, 237).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(200, 260).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flanges2 = wheel2.addOrReplaceChild("flanges2", CubeListBuilder.create().texOffs(74, 247).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(188, 247).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.4F, 0.0F, 0.0F));

		PartDefinition flange_r1 = flanges2.addOrReplaceChild("flange_r1", CubeListBuilder.create().texOffs(12, 248).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(98, 247).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r2 = flanges2.addOrReplaceChild("flange_r2", CubeListBuilder.create().texOffs(0, 248).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(86, 247).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r3 = flanges2.addOrReplaceChild("flange_r3", CubeListBuilder.create().texOffs(110, 247).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(62, 247).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition spokes2 = wheel2.addOrReplaceChild("spokes2", CubeListBuilder.create().texOffs(264, 36).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition spoke_r1 = spokes2.addOrReplaceChild("spoke_r1", CubeListBuilder.create().texOffs(202, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r2 = spokes2.addOrReplaceChild("spoke_r2", CubeListBuilder.create().texOffs(198, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r3 = spokes2.addOrReplaceChild("spoke_r3", CubeListBuilder.create().texOffs(264, 136).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition wheel = wheelandaxle.addOrReplaceChild("wheel", CubeListBuilder.create(), PartPose.offset(-13.0F, 0.0F, 0.0F));

		PartDefinition innerrims = wheel.addOrReplaceChild("innerrims", CubeListBuilder.create().texOffs(200, 255).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(258, 51).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrim_r4 = innerrims.addOrReplaceChild("innerrim_r4", CubeListBuilder.create().texOffs(168, 258).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(144, 256).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r5 = innerrims.addOrReplaceChild("innerrim_r5", CubeListBuilder.create().texOffs(156, 258).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(132, 256).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r6 = innerrims.addOrReplaceChild("innerrim_r6", CubeListBuilder.create().texOffs(258, 56).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(256, 46).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flanges = wheel.addOrReplaceChild("flanges", CubeListBuilder.create().texOffs(210, 241).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(222, 246).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4F, 0.0F, 0.0F));

		PartDefinition flange_r4 = flanges.addOrReplaceChild("flange_r4", CubeListBuilder.create().texOffs(246, 246).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(176, 244).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r5 = flanges.addOrReplaceChild("flange_r5", CubeListBuilder.create().texOffs(234, 246).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(164, 244).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r6 = flanges.addOrReplaceChild("flange_r6", CubeListBuilder.create().texOffs(246, 54).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(50, 247).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition spokes = wheel.addOrReplaceChild("spokes", CubeListBuilder.create().texOffs(72, 83).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition spoke_r4 = spokes.addOrReplaceChild("spoke_r4", CubeListBuilder.create().texOffs(66, 217).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r5 = spokes.addOrReplaceChild("spoke_r5", CubeListBuilder.create().texOffs(72, 101).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r6 = spokes.addOrReplaceChild("spoke_r6", CubeListBuilder.create().texOffs(72, 92).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition wheelandaxle2 = partdefinition.addOrReplaceChild("wheelandaxle2", CubeListBuilder.create().texOffs(218, 93).addBox(-14.5F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 16.1716F, 0.0F));

		PartDefinition wheel3 = wheelandaxle2.addOrReplaceChild("wheel3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrims3 = wheel3.addOrReplaceChild("innerrims3", CubeListBuilder.create().texOffs(260, 255).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrim_r7 = innerrims3.addOrReplaceChild("innerrim_r7", CubeListBuilder.create().texOffs(90, 261).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(42, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r8 = innerrims3.addOrReplaceChild("innerrim_r8", CubeListBuilder.create().texOffs(78, 261).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r9 = innerrims3.addOrReplaceChild("innerrim_r9", CubeListBuilder.create().texOffs(66, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(260, 260).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flanges3 = wheel3.addOrReplaceChild("flanges3", CubeListBuilder.create().texOffs(36, 248).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(250, 68).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.4F, 0.0F, 0.0F));

		PartDefinition flange_r7 = flanges3.addOrReplaceChild("flange_r7", CubeListBuilder.create().texOffs(250, 82).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(248, 238).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r8 = flanges3.addOrReplaceChild("flange_r8", CubeListBuilder.create().texOffs(250, 75).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(200, 248).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r9 = flanges3.addOrReplaceChild("flange_r9", CubeListBuilder.create().texOffs(250, 61).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(24, 248).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition spokes3 = wheel3.addOrReplaceChild("spokes3", CubeListBuilder.create().texOffs(206, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition spoke_r7 = spokes3.addOrReplaceChild("spoke_r7", CubeListBuilder.create().texOffs(218, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r8 = spokes3.addOrReplaceChild("spoke_r8", CubeListBuilder.create().texOffs(214, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r9 = spokes3.addOrReplaceChild("spoke_r9", CubeListBuilder.create().texOffs(210, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition wheel4 = wheelandaxle2.addOrReplaceChild("wheel4", CubeListBuilder.create(), PartPose.offset(-13.0F, 0.0F, 0.0F));

		PartDefinition innerrims4 = wheel4.addOrReplaceChild("innerrims4", CubeListBuilder.create().texOffs(102, 261).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(180, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrim_r10 = innerrims4.addOrReplaceChild("innerrim_r10", CubeListBuilder.create().texOffs(262, 5).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(138, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r11 = innerrims4.addOrReplaceChild("innerrim_r11", CubeListBuilder.create().texOffs(262, 0).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(126, 261).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r12 = innerrims4.addOrReplaceChild("innerrim_r12", CubeListBuilder.create().texOffs(0, 262).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(114, 261).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flanges4 = wheel4.addOrReplaceChild("flanges4", CubeListBuilder.create().texOffs(250, 216).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(176, 251).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4F, 0.0F, 0.0F));

		PartDefinition flange_r10 = flanges4.addOrReplaceChild("flange_r10", CubeListBuilder.create().texOffs(252, 39).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(250, 230).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r11 = flanges4.addOrReplaceChild("flange_r11", CubeListBuilder.create().texOffs(252, 32).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(250, 223).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r12 = flanges4.addOrReplaceChild("flange_r12", CubeListBuilder.create().texOffs(164, 251).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(250, 131).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition spokes4 = wheel4.addOrReplaceChild("spokes4", CubeListBuilder.create().texOffs(222, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition spoke_r10 = spokes4.addOrReplaceChild("spoke_r10", CubeListBuilder.create().texOffs(234, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r11 = spokes4.addOrReplaceChild("spoke_r11", CubeListBuilder.create().texOffs(230, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r12 = spokes4.addOrReplaceChild("spoke_r12", CubeListBuilder.create().texOffs(226, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition wheelandaxle3 = partdefinition.addOrReplaceChild("wheelandaxle3", CubeListBuilder.create().texOffs(220, 50).addBox(-14.5F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 16.1716F, 14.0F));

		PartDefinition wheel5 = wheelandaxle3.addOrReplaceChild("wheel5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrims5 = wheel5.addOrReplaceChild("innerrims5", CubeListBuilder.create().texOffs(262, 10).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(262, 25).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrim_r13 = innerrims5.addOrReplaceChild("innerrim_r13", CubeListBuilder.create().texOffs(262, 71).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(262, 20).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r14 = innerrims5.addOrReplaceChild("innerrim_r14", CubeListBuilder.create().texOffs(262, 66).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(262, 15).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r15 = innerrims5.addOrReplaceChild("innerrim_r15", CubeListBuilder.create().texOffs(262, 61).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(12, 262).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flanges5 = wheel5.addOrReplaceChild("flanges5", CubeListBuilder.create().texOffs(212, 253).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(48, 254).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.4F, 0.0F, 0.0F));

		PartDefinition flange_r13 = flanges5.addOrReplaceChild("flange_r13", CubeListBuilder.create().texOffs(72, 254).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(236, 253).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r14 = flanges5.addOrReplaceChild("flange_r14", CubeListBuilder.create().texOffs(60, 254).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(224, 253).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r15 = flanges5.addOrReplaceChild("flange_r15", CubeListBuilder.create().texOffs(248, 253).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(252, 138).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition spokes5 = wheel5.addOrReplaceChild("spokes5", CubeListBuilder.create().texOffs(238, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition spoke_r13 = spokes5.addOrReplaceChild("spoke_r13", CubeListBuilder.create().texOffs(250, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r14 = spokes5.addOrReplaceChild("spoke_r14", CubeListBuilder.create().texOffs(246, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r15 = spokes5.addOrReplaceChild("spoke_r15", CubeListBuilder.create().texOffs(242, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition wheel6 = wheelandaxle3.addOrReplaceChild("wheel6", CubeListBuilder.create(), PartPose.offset(-13.0F, 0.0F, 0.0F));

		PartDefinition innerrims6 = wheel6.addOrReplaceChild("innerrims6", CubeListBuilder.create().texOffs(262, 76).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(262, 221).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition innerrim_r16 = innerrims6.addOrReplaceChild("innerrim_r16", CubeListBuilder.create().texOffs(150, 263).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(262, 216).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r17 = innerrims6.addOrReplaceChild("innerrim_r17", CubeListBuilder.create().texOffs(262, 231).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(262, 131).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r18 = innerrims6.addOrReplaceChild("innerrim_r18", CubeListBuilder.create().texOffs(262, 226).addBox(-1.0F, -4.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(262, 81).addBox(-1.0F, 3.8284F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flanges6 = wheel6.addOrReplaceChild("flanges6", CubeListBuilder.create().texOffs(254, 89).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(188, 254).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4F, 0.0F, 0.0F));

		PartDefinition flange_r16 = flanges6.addOrReplaceChild("flange_r16", CubeListBuilder.create().texOffs(12, 255).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(108, 254).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r17 = flanges6.addOrReplaceChild("flange_r17", CubeListBuilder.create().texOffs(0, 255).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(96, 254).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r18 = flanges6.addOrReplaceChild("flange_r18", CubeListBuilder.create().texOffs(120, 254).addBox(-0.5F, -6.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(84, 254).addBox(-0.5F, 4.0355F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition spokes6 = wheel6.addOrReplaceChild("spokes6", CubeListBuilder.create().texOffs(254, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition spoke_r16 = spokes6.addOrReplaceChild("spoke_r16", CubeListBuilder.create().texOffs(30, 266).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r17 = spokes6.addOrReplaceChild("spoke_r17", CubeListBuilder.create().texOffs(262, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r18 = spokes6.addOrReplaceChild("spoke_r18", CubeListBuilder.create().texOffs(258, 265).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition pistonleft = partdefinition.addOrReplaceChild("pistonleft", CubeListBuilder.create().texOffs(56, 266).addBox(-1.0F, -1.0F, 13.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
		.texOffs(200, 0).addBox(-0.5F, -1.0F, -15.0F, 1.0F, 2.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(42, 255).addBox(-1.0F, -1.0F, -15.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
		.texOffs(50, 266).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(-8.0F, 13.0F, 0.0F));

		PartDefinition pistonright = partdefinition.addOrReplaceChild("pistonright", CubeListBuilder.create().texOffs(62, 266).addBox(0.0F, -1.0F, 13.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
		.texOffs(212, 148).addBox(-0.5F, -1.0F, -15.0F, 1.0F, 2.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(68, 266).addBox(0.0F, -1.0F, -15.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
		.texOffs(74, 266).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(8.0F, 13.0F, 0.0F));

		PartDefinition underside = partdefinition.addOrReplaceChild("underside", CubeListBuilder.create().texOffs(0, 239).addBox(-3.0F, -4.0F, -52.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(53, 218).addBox(-1.0F, -7.0F, -51.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 216).addBox(-1.0F, -2.0F, -42.0F, 2.0F, 2.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(216, 100).addBox(-1.0F, -6.0F, -42.0F, 2.0F, 2.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(132, 238).addBox(-3.0F, -7.0F, -47.0F, 6.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(220, 32).addBox(-3.0F, -7.0F, -33.0F, 6.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(218, 66).addBox(-3.0F, -7.0F, -19.0F, 6.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 28.0F));

		PartDefinition couplerfront = underside.addOrReplaceChild("couplerfront", CubeListBuilder.create().texOffs(148, 113).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(128, 47).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(188, 244).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(144, 46).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(252, 145).addBox(1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition couplerback = underside.addOrReplaceChild("couplerback", CubeListBuilder.create().texOffs(154, 113).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(136, 47).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(258, 145).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(160, 113).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(180, 258).addBox(1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -55.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition wholebody = partdefinition.addOrReplaceChild("wholebody", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, -6.0F));

		PartDefinition body = wholebody.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -6.0F, -18.0F, 16.0F, 1.0F, 48.0F, new CubeDeformation(0.0F))
		.texOffs(22, 239).addBox(6.0F, -4.0F, 26.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 239).addBox(-9.0F, -4.0F, 26.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(218, 84).addBox(-7.0F, -5.0F, 29.0F, 14.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 4.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition buffer = body.addOrReplaceChild("buffer", CubeListBuilder.create().texOffs(72, 112).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(212, 248).addBox(-10.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 110).addBox(-9.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(164, 238).addBox(-11.5F, -2.5F, -2.5F, 14.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(258, 96).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -2.5F, 33.5F));

		PartDefinition cab = wholebody.addOrReplaceChild("cab", CubeListBuilder.create().texOffs(148, 100).addBox(2.1514F, 6.5541F, 1.0F, 16.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(132, 216).addBox(4.1514F, -4.4459F, -17.0F, 12.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(218, 97).addBox(3.1514F, -3.4459F, 1.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(194, 238).addBox(3.1514F, -3.4459F, -15.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.1514F, -24.5541F, -3.0F));

		PartDefinition cabroofside_r1 = cab.addOrReplaceChild("cabroofside_r1", CubeListBuilder.create().texOffs(0, 217).addBox(1.0F, -1.0F, -17.0F, 5.0F, 1.0F, 21.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition cabroofside_r2 = cab.addOrReplaceChild("cabroofside_r2", CubeListBuilder.create().texOffs(198, 216).addBox(-6.0F, -1.0F, -17.0F, 5.0F, 1.0F, 21.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(20.3027F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition roofpillar_r1 = cab.addOrReplaceChild("roofpillar_r1", CubeListBuilder.create().texOffs(174, 263).addBox(4.0F, -6.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1514F, 3.5541F, -9.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition roofpillar_r2 = cab.addOrReplaceChild("roofpillar_r2", CubeListBuilder.create().texOffs(168, 263).addBox(4.0F, -6.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1514F, 3.5541F, 6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition roofpillar_r3 = cab.addOrReplaceChild("roofpillar_r3", CubeListBuilder.create().texOffs(162, 263).addBox(4.0F, -6.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.1514F, 3.5541F, 6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition roofpillar_r4 = cab.addOrReplaceChild("roofpillar_r4", CubeListBuilder.create().texOffs(192, 261).addBox(4.0F, -6.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.1514F, 3.5541F, -9.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cabrear_r1 = cab.addOrReplaceChild("cabrear_r1", CubeListBuilder.create().texOffs(24, 255).addBox(4.0F, -9.0F, 0.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.1514F, 15.5541F, -14.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cabrear_r2 = cab.addOrReplaceChild("cabrear_r2", CubeListBuilder.create().texOffs(140, 33).addBox(5.0F, -9.0F, 0.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1514F, 15.5541F, -14.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cabside_r1 = cab.addOrReplaceChild("cabside_r1", CubeListBuilder.create().texOffs(216, 131).addBox(-8.0F, -9.0F, 0.0F, 16.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1514F, 15.5541F, -7.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cabside_r2 = cab.addOrReplaceChild("cabside_r2", CubeListBuilder.create().texOffs(182, 100).addBox(-8.0F, -9.0F, 0.0F, 16.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.1514F, 15.5541F, -7.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition seat = cab.addOrReplaceChild("seat", CubeListBuilder.create().texOffs(34, 266).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(224, 238).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(10.1514F, 16.5541F, -7.0F));

		PartDefinition smokestack = wholebody.addOrReplaceChild("smokestack", CubeListBuilder.create().texOffs(128, 33).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(194, 241).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, 25.5F));

		PartDefinition headlight = wholebody.addOrReplaceChild("headlight", CubeListBuilder.create().texOffs(146, 34).addBox(1.0F, -2.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(249, 98).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(146, 32).addBox(-1.0F, -2.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 30.0F));

		PartDefinition headlightsurrounding = headlight.addOrReplaceChild("headlightsurrounding", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 2).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headlightbulb = headlight.addOrReplaceChild("headlightbulb", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(-0.03F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition boiler = wholebody.addOrReplaceChild("boiler", CubeListBuilder.create().texOffs(76, 49).addBox(-2.5F, 4.0355F, -15.5F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.01F))
		.texOffs(0, 116).addBox(-2.5F, -6.0355F, -15.5F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.01F))
		.texOffs(220, 54).addBox(-2.0F, -7.9645F, -10.5F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(52, 238).addBox(-7.0F, 2.0355F, -10.5F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(52, 229).addBox(4.0F, 2.0355F, -10.5F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(122, 247).addBox(4.0F, 2.0F, 6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(264, 30).addBox(-6.0F, 2.0F, 6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0355F, 14.5F));

		PartDefinition boilerside_r1 = boiler.addOrReplaceChild("boilerside_r1", CubeListBuilder.create().texOffs(144, 115).addBox(-3.0F, -1.0F, -30.0F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-5.0355F, -0.5F, 14.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition boilerside_r2 = boiler.addOrReplaceChild("boilerside_r2", CubeListBuilder.create().texOffs(128, 0).addBox(-3.0F, -1.0F, -30.0F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-3.2071F, -3.9142F, 14.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition boilerside_r3 = boiler.addOrReplaceChild("boilerside_r3", CubeListBuilder.create().texOffs(72, 115).addBox(-3.0F, -1.0F, -30.0F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(3.9142F, -3.2071F, 14.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition boilerside_r4 = boiler.addOrReplaceChild("boilerside_r4", CubeListBuilder.create().texOffs(0, 83).addBox(-3.0F, -2.0F, -30.0F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(6.0355F, -0.5F, 14.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition boilerside_r5 = boiler.addOrReplaceChild("boilerside_r5", CubeListBuilder.create().texOffs(76, 82).addBox(-3.0F, -2.0F, -30.0F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(4.6213F, 3.9142F, 14.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition boilerside_r6 = boiler.addOrReplaceChild("boilerside_r6", CubeListBuilder.create().texOffs(148, 33).addBox(-3.0F, -2.0F, -30.0F, 5.0F, 2.0F, 31.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-3.9142F, 4.6213F, 14.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition boilerfront = boiler.addOrReplaceChild("boilerfront", CubeListBuilder.create().texOffs(148, 66).addBox(-2.0F, 1.8284F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.01F))
		.texOffs(70, 182).addBox(-2.0F, -4.8284F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.01F))
		.texOffs(30, 255).addBox(-2.0F, -2.0F, 13.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition boilerfront_r1 = boilerfront.addOrReplaceChild("boilerfront_r1", CubeListBuilder.create().texOffs(0, 183).addBox(4.8284F, -4.8284F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.01F))
		.texOffs(142, 148).addBox(4.8284F, 1.8284F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 6.8284F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition boilerfront_r2 = boilerfront.addOrReplaceChild("boilerfront_r2", CubeListBuilder.create().texOffs(140, 182).addBox(2.8284F, -9.6568F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.0F))
		.texOffs(72, 148).addBox(2.8284F, -3.0F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8284F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition boilerfront_r3 = boilerfront.addOrReplaceChild("boilerfront_r3", CubeListBuilder.create().texOffs(0, 149).addBox(-6.8284F, -9.6568F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.0F))
		.texOffs(210, 182).addBox(-6.8284F, -3.0F, -15.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8284F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	public static final double WHEEL_RADIUS = 0.3125d; // wheel radius in minecraft blocks. in blockbench it is 7.

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
		this.wheelandaxle3.xRot = (float) rotation;

		double pistonRadius = 3.1716d;
		float pistonYOffsetInit = 13.0f + (float)pistonRadius;

		double pistonZOffset = pistonRadius * Math.sin(rotation);
		double pistonYOffset = pistonRadius * Math.cos(rotation);

		this.pistonleft.z = (float) pistonZOffset;
		this.pistonleft.y = pistonYOffsetInit + (float) pistonYOffset;

		this.pistonright.z = (float) pistonZOffset;
		this.pistonright.y = pistonYOffsetInit + (float) pistonYOffset;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		wheelandaxle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wheelandaxle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wheelandaxle3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pistonleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pistonright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		underside.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wholebody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}