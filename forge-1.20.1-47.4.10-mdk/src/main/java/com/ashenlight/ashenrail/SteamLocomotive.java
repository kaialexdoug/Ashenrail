package com.ashenlight.ashenrail;// Made with Blockbench 5.2.0
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
import net.minecraft.world.entity.Entity;

public class SteamLocomotive<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "steamlocomotive"), "main");
	private final ModelPart steamlocomotive;
	private final ModelPart boiler;
	private final ModelPart cab;
	private final ModelPart seat;
	private final ModelPart underside;
	private final ModelPart smokestack;
	private final ModelPart frontlight;
	private final ModelPart sixwheels;
	private final ModelPart wheelsandaxle;
	private final ModelPart wheel2;
	private final ModelPart wheel;
	private final ModelPart wheelsandaxle2;
	private final ModelPart wheel3;
	private final ModelPart wheel4;
	private final ModelPart wheelsandaxle3;
	private final ModelPart wheel5;
	private final ModelPart wheel6;

	public SteamLocomotive(ModelPart root) {
		this.steamlocomotive = root.getChild("steamlocomotive");
		this.boiler = this.steamlocomotive.getChild("boiler");
		this.cab = this.steamlocomotive.getChild("cab");
		this.seat = this.cab.getChild("seat");
		this.underside = this.steamlocomotive.getChild("underside");
		this.smokestack = this.steamlocomotive.getChild("smokestack");
		this.frontlight = this.steamlocomotive.getChild("frontlight");
		this.sixwheels = this.steamlocomotive.getChild("sixwheels");
		this.wheelsandaxle = this.sixwheels.getChild("wheelsandaxle");
		this.wheel2 = this.wheelsandaxle.getChild("wheel2");
		this.wheel = this.wheelsandaxle.getChild("wheel");
		this.wheelsandaxle2 = this.sixwheels.getChild("wheelsandaxle2");
		this.wheel3 = this.wheelsandaxle2.getChild("wheel3");
		this.wheel4 = this.wheelsandaxle2.getChild("wheel4");
		this.wheelsandaxle3 = this.sixwheels.getChild("wheelsandaxle3");
		this.wheel5 = this.wheelsandaxle3.getChild("wheel5");
		this.wheel6 = this.wheelsandaxle3.getChild("wheel6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition steamlocomotive = partdefinition.addOrReplaceChild("steamlocomotive", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition boiler = steamlocomotive.addOrReplaceChild("boiler", CubeListBuilder.create().texOffs(-54, -45).addBox(-8.3F, -16.4F, -12.0F, 16.0F, 2.0F, 37.0F, new CubeDeformation(0.0F))
		.texOffs(-11, -9).addBox(-2.7F, -37.2F, -0.8F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(-39, -36).addBox(-4.0F, -18.0F, -12.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F))
		.texOffs(-39, -36).addBox(-4.0F, -35.3137F, -12.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 0).addBox(-4.0F, -34.0F, 24.0F, 8.0F, 16.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -3.2F, 2.4F));

		PartDefinition boilerfront_r1 = boiler.addOrReplaceChild("boilerfront_r1", CubeListBuilder.create().texOffs(-3, 0).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 16.0F, 2.0F, new CubeDeformation(-0.04F)), PartPose.offsetAndRotation(6.0F, -31.0F, 25.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition boilerfront_r2 = boiler.addOrReplaceChild("boilerfront_r2", CubeListBuilder.create().texOffs(-3, 0).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 16.0F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(8.0F, -25.0F, 25.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition boilerfront_r3 = boiler.addOrReplaceChild("boilerfront_r3", CubeListBuilder.create().texOffs(-3, 0).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 16.0F, 2.0F, new CubeDeformation(-0.03F)), PartPose.offsetAndRotation(6.0F, -20.0F, 25.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition boilerside_r1 = boiler.addOrReplaceChild("boilerside_r1", CubeListBuilder.create().texOffs(-39, -36).addBox(-4.0F, -2.0F, -17.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4142F, -31.0711F, 5.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition boilerside_r2 = boiler.addOrReplaceChild("boilerside_r2", CubeListBuilder.create().texOffs(-39, -36).addBox(-4.0F, -2.0F, -17.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8284F, -18.8284F, 5.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition boilerside_r3 = boiler.addOrReplaceChild("boilerside_r3", CubeListBuilder.create().texOffs(-39, -36).addBox(-4.0F, -2.0F, -17.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8284F, -18.8284F, 5.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition boilerside_r4 = boiler.addOrReplaceChild("boilerside_r4", CubeListBuilder.create().texOffs(-39, -36).addBox(-4.0F, -2.0F, -17.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4142F, -31.0711F, 5.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition boilerside_r5 = boiler.addOrReplaceChild("boilerside_r5", CubeListBuilder.create().texOffs(-39, -36).addBox(-4.0F, -2.0F, -17.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.6569F, -25.6569F, 5.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition boilerside_r6 = boiler.addOrReplaceChild("boilerside_r6", CubeListBuilder.create().texOffs(-39, -36).addBox(-4.0F, -2.0F, -17.0F, 8.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6569F, -25.6569F, 5.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cab = steamlocomotive.addOrReplaceChild("cab", CubeListBuilder.create().texOffs(-11, 0).addBox(-9.5F, -32.2F, -13.6F, 19.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-33, -22).addBox(-9.5F, -13.2F, -32.8F, 19.0F, 2.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(-12, 0).addBox(-10.5F, -43.8F, -32.8F, 4.0F, 31.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-11, 0).addBox(6.5F, -43.8F, -32.8F, 4.0F, 31.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-11, 0).addBox(6.5F, -44.0F, -13.6F, 3.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-11, 0).addBox(-9.5F, -44.0F, -13.6F, 3.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-11, 0).addBox(-9.4F, -45.4F, -32.8F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(-11, 0).addBox(-9.4F, -45.4F, -13.6F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(-37, -27).addBox(-9.1F, -46.8F, -33.6F, 18.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.4F, 2.4F));

		PartDefinition roofside_r1 = cab.addOrReplaceChild("roofside_r1", CubeListBuilder.create().texOffs(-28, -27).mirror().addBox(-2.4F, -2.0F, -7.2F, 4.0F, 2.0F, 23.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(9.1828F, -43.6887F, -26.4F, 0.0F, 0.0F, 0.7854F));

		PartDefinition roofside_r2 = cab.addOrReplaceChild("roofside_r2", CubeListBuilder.create().texOffs(-28, -27).addBox(-1.6F, -2.0F, -7.2F, 4.0F, 2.0F, 23.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-9.3828F, -43.6887F, -26.4F, 0.0F, 0.0F, -0.7854F));

		PartDefinition sidepanel_r1 = cab.addOrReplaceChild("sidepanel_r1", CubeListBuilder.create().texOffs(-11, 0).addBox(-10.0F, -15.8F, -0.8F, 18.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.9F, -16.0F, -23.2F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sidepanel_r2 = cab.addOrReplaceChild("sidepanel_r2", CubeListBuilder.create().texOffs(-11, 0).addBox(-10.0F, -15.8F, -0.8F, 18.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7F, -16.0F, -23.2F, 0.0F, 1.5708F, 0.0F));

		PartDefinition seat = cab.addOrReplaceChild("seat", CubeListBuilder.create().texOffs(-3, -2).addBox(-10.0657F, 27.7716F, 1.6F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-12, -8).addBox(-12.6657F, 25.3716F, -0.8F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5657F, -47.5716F, -26.4F));

		PartDefinition underside = steamlocomotive.addOrReplaceChild("underside", CubeListBuilder.create().texOffs(-14, -11).addBox(-3.1F, -17.8F, 15.2F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(-14, -11).addBox(-3.1F, -17.8F, -2.8F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(-20, -17).addBox(-3.1F, -17.8F, -24.4F, 6.0F, 10.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(-27, -26).addBox(-1.7F, -14.4F, -8.8F, 3.0F, 4.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(-13, -6).addBox(-6.8F, -17.4F, -29.6F, 13.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2F, 0.0F, 0.0F));

		PartDefinition smokestack = steamlocomotive.addOrReplaceChild("smokestack", CubeListBuilder.create().texOffs(-7, -4).addBox(-2.7F, -57.4F, 19.8F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(-9, -6).addBox(-3.3F, -55.8F, 19.3F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition frontlight = steamlocomotive.addOrReplaceChild("frontlight", CubeListBuilder.create().texOffs(-3, -2).addBox(-2.0F, -31.0F, 28.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(-1.0F, -31.0F, 31.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, -30.0F, 29.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -30.0F, 29.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(-2.0F, -29.0F, 29.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(1.0F, -29.0F, 29.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 0).addBox(-1.4F, -30.0F, 27.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition sixwheels = steamlocomotive.addOrReplaceChild("sixwheels", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition wheelsandaxle = sixwheels.addOrReplaceChild("wheelsandaxle", CubeListBuilder.create().texOffs(-7, 0).addBox(-8.0F, -0.9F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.3F, 20.0F));

		PartDefinition wheel2 = wheelsandaxle.addOrReplaceChild("wheel2", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(-3.0F, 5.5F, 18.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-4, -4).mirror().addBox(-3.0F, -6.9853F, 18.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-4, -3).mirror().addBox(-2.0F, 5.2F, 18.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
		.texOffs(-4, -3).mirror().addBox(-2.0F, -5.8711F, 18.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
		.texOffs(-7, -8).mirror().addBox(-1.0F, -0.2F, 16.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offset(7.5F, -0.2F, -21.0F));

		PartDefinition spoke_r1 = wheel2.addOrReplaceChild("spoke_r1", CubeListBuilder.create().texOffs(-7, -8).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 19.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition spoke_r2 = wheel2.addOrReplaceChild("spoke_r2", CubeListBuilder.create().texOffs(-8, -9).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.1F, 24.5F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r3 = wheel2.addOrReplaceChild("spoke_r3", CubeListBuilder.create().texOffs(-8, -9).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.8F, 21.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r1 = wheel2.addOrReplaceChild("innerrim_r1", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0787F, 16.3787F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r2 = wheel2.addOrReplaceChild("innerrim_r2", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3355F, 15.9645F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r3 = wheel2.addOrReplaceChild("innerrim_r3", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.7498F, 17.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r4 = wheel2.addOrReplaceChild("innerrim_r4", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.7498F, 24.2071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r5 = wheel2.addOrReplaceChild("innerrim_r5", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3355F, 27.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r6 = wheel2.addOrReplaceChild("innerrim_r6", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0787F, 25.6213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r1 = wheel2.addOrReplaceChild("flange_r1", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -2.7426F, 16.5858F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r2 = wheel2.addOrReplaceChild("flange_r2", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.2574F, 15.7574F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r3 = wheel2.addOrReplaceChild("flange_r3", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 4.6716F, 15.1716F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r4 = wheel2.addOrReplaceChild("flange_r4", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -4.1569F, 24.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r5 = wheel2.addOrReplaceChild("flange_r5", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.2574F, 28.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r6 = wheel2.addOrReplaceChild("flange_r6", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 6.0858F, 25.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wheel = wheelsandaxle.addOrReplaceChild("wheel", CubeListBuilder.create().texOffs(-4, -4).addBox(-12.0F, 2.5F, 53.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-4, -4).addBox(-12.0F, -9.9853F, 53.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-4, -3).addBox(-14.0F, 2.2F, 53.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(-4, -3).addBox(-14.0F, -8.8711F, 53.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(-7, -8).addBox(-14.0F, -3.2F, 51.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)), PartPose.offset(6.6F, 2.8F, -56.0F));

		PartDefinition spoke_r4 = wheel.addOrReplaceChild("spoke_r4", CubeListBuilder.create().texOffs(-7, -8).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 54.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition spoke_r5 = wheel.addOrReplaceChild("spoke_r5", CubeListBuilder.create().texOffs(-8, -9).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 0.1F, 59.5F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r6 = wheel.addOrReplaceChild("spoke_r6", CubeListBuilder.create().texOffs(-8, -9).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 1.8F, 56.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r7 = wheel.addOrReplaceChild("innerrim_r7", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0787F, 51.3787F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r8 = wheel.addOrReplaceChild("innerrim_r8", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-12.0F, -3.3355F, 50.9645F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r9 = wheel.addOrReplaceChild("innerrim_r9", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.7498F, 52.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r10 = wheel.addOrReplaceChild("innerrim_r10", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.7498F, 59.2071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r11 = wheel.addOrReplaceChild("innerrim_r11", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-12.0F, -3.3355F, 62.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r12 = wheel.addOrReplaceChild("innerrim_r12", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0787F, 60.6213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r7 = wheel.addOrReplaceChild("flange_r7", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, -5.7426F, 51.5858F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r8 = wheel.addOrReplaceChild("flange_r8", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -1.7426F, 50.7574F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r9 = wheel.addOrReplaceChild("flange_r9", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, 1.6716F, 50.1716F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r10 = wheel.addOrReplaceChild("flange_r10", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, -7.1569F, 59.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r11 = wheel.addOrReplaceChild("flange_r11", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -1.7426F, 63.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r12 = wheel.addOrReplaceChild("flange_r12", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, 3.0858F, 60.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wheelsandaxle2 = sixwheels.addOrReplaceChild("wheelsandaxle2", CubeListBuilder.create().texOffs(-7, 0).addBox(-8.0F, -0.9F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.3F, 2.0F));

		PartDefinition wheel3 = wheelsandaxle2.addOrReplaceChild("wheel3", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(-3.0F, 5.5F, 18.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-4, -4).mirror().addBox(-3.0F, -6.9853F, 18.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-4, -3).mirror().addBox(-2.0F, 5.2F, 18.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
		.texOffs(-4, -3).mirror().addBox(-2.0F, -5.8711F, 18.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
		.texOffs(-7, -8).mirror().addBox(-1.0F, -0.2F, 16.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offset(7.5F, -0.2F, -21.0F));

		PartDefinition spoke_r7 = wheel3.addOrReplaceChild("spoke_r7", CubeListBuilder.create().texOffs(-7, -8).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 19.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition spoke_r8 = wheel3.addOrReplaceChild("spoke_r8", CubeListBuilder.create().texOffs(-8, -9).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.1F, 24.5F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r9 = wheel3.addOrReplaceChild("spoke_r9", CubeListBuilder.create().texOffs(-8, -9).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.8F, 21.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r13 = wheel3.addOrReplaceChild("innerrim_r13", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0787F, 16.3787F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r14 = wheel3.addOrReplaceChild("innerrim_r14", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3355F, 15.9645F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r15 = wheel3.addOrReplaceChild("innerrim_r15", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.7498F, 17.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r16 = wheel3.addOrReplaceChild("innerrim_r16", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.7498F, 24.2071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r17 = wheel3.addOrReplaceChild("innerrim_r17", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3355F, 27.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r18 = wheel3.addOrReplaceChild("innerrim_r18", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0787F, 25.6213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r13 = wheel3.addOrReplaceChild("flange_r13", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -2.7426F, 16.5858F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r14 = wheel3.addOrReplaceChild("flange_r14", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.2574F, 15.7574F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r15 = wheel3.addOrReplaceChild("flange_r15", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 4.6716F, 15.1716F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r16 = wheel3.addOrReplaceChild("flange_r16", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -4.1569F, 24.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r17 = wheel3.addOrReplaceChild("flange_r17", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.2574F, 28.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r18 = wheel3.addOrReplaceChild("flange_r18", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 6.0858F, 25.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wheel4 = wheelsandaxle2.addOrReplaceChild("wheel4", CubeListBuilder.create().texOffs(-4, -4).addBox(-12.0F, 2.5F, 53.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-4, -4).addBox(-12.0F, -9.9853F, 53.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-4, -3).addBox(-14.0F, 2.2F, 53.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(-4, -3).addBox(-14.0F, -8.8711F, 53.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(-7, -8).addBox(-14.0F, -3.2F, 51.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)), PartPose.offset(6.6F, 2.8F, -56.0F));

		PartDefinition spoke_r10 = wheel4.addOrReplaceChild("spoke_r10", CubeListBuilder.create().texOffs(-7, -8).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 54.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition spoke_r11 = wheel4.addOrReplaceChild("spoke_r11", CubeListBuilder.create().texOffs(-8, -9).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 0.1F, 59.5F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r12 = wheel4.addOrReplaceChild("spoke_r12", CubeListBuilder.create().texOffs(-8, -9).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 1.8F, 56.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r19 = wheel4.addOrReplaceChild("innerrim_r19", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0787F, 51.3787F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r20 = wheel4.addOrReplaceChild("innerrim_r20", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-12.0F, -3.3355F, 50.9645F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r21 = wheel4.addOrReplaceChild("innerrim_r21", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.7498F, 52.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r22 = wheel4.addOrReplaceChild("innerrim_r22", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.7498F, 59.2071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r23 = wheel4.addOrReplaceChild("innerrim_r23", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-12.0F, -3.3355F, 62.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r24 = wheel4.addOrReplaceChild("innerrim_r24", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0787F, 60.6213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r19 = wheel4.addOrReplaceChild("flange_r19", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, -5.7426F, 51.5858F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r20 = wheel4.addOrReplaceChild("flange_r20", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -1.7426F, 50.7574F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r21 = wheel4.addOrReplaceChild("flange_r21", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, 1.6716F, 50.1716F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r22 = wheel4.addOrReplaceChild("flange_r22", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, -7.1569F, 59.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r23 = wheel4.addOrReplaceChild("flange_r23", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -1.7426F, 63.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r24 = wheel4.addOrReplaceChild("flange_r24", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, 3.0858F, 60.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wheelsandaxle3 = sixwheels.addOrReplaceChild("wheelsandaxle3", CubeListBuilder.create().texOffs(-7, 0).addBox(-8.0F, -0.9F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.3F, -16.0F));

		PartDefinition wheel5 = wheelsandaxle3.addOrReplaceChild("wheel5", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(-3.0F, 5.5F, -4.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-4, -4).mirror().addBox(-3.0F, -6.9853F, -4.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-4, -3).mirror().addBox(-2.0F, 5.2F, -3.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
		.texOffs(-4, -3).mirror().addBox(-2.0F, -5.8711F, -3.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
		.texOffs(-7, -8).mirror().addBox(-1.0F, -0.2F, -6.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offset(7.5F, -0.2F, 1.0F));

		PartDefinition spoke_r13 = wheel5.addOrReplaceChild("spoke_r13", CubeListBuilder.create().texOffs(-7, -8).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition spoke_r14 = wheel5.addOrReplaceChild("spoke_r14", CubeListBuilder.create().texOffs(-8, -9).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.1F, 2.5F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r15 = wheel5.addOrReplaceChild("spoke_r15", CubeListBuilder.create().texOffs(-8, -9).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.8F, -0.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r25 = wheel5.addOrReplaceChild("innerrim_r25", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0787F, -5.6213F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r26 = wheel5.addOrReplaceChild("innerrim_r26", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3355F, -6.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r27 = wheel5.addOrReplaceChild("innerrim_r27", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.7498F, -4.2071F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r28 = wheel5.addOrReplaceChild("innerrim_r28", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.7498F, 2.2071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r29 = wheel5.addOrReplaceChild("innerrim_r29", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3355F, 5.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r30 = wheel5.addOrReplaceChild("innerrim_r30", CubeListBuilder.create().texOffs(-4, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0787F, 3.6213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r25 = wheel5.addOrReplaceChild("flange_r25", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -2.7426F, -5.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r26 = wheel5.addOrReplaceChild("flange_r26", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.2574F, -6.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r27 = wheel5.addOrReplaceChild("flange_r27", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 4.6716F, -6.8284F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r28 = wheel5.addOrReplaceChild("flange_r28", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -4.1569F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r29 = wheel5.addOrReplaceChild("flange_r29", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.2574F, 6.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r30 = wheel5.addOrReplaceChild("flange_r30", CubeListBuilder.create().texOffs(-4, -4).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 6.0858F, 3.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition wheel6 = wheelsandaxle3.addOrReplaceChild("wheel6", CubeListBuilder.create().texOffs(-4, -4).addBox(-12.0F, 2.5F, 31.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-4, -4).addBox(-12.0F, -9.9853F, 31.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-4, -3).addBox(-14.0F, 2.2F, 31.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(-4, -3).addBox(-14.0F, -8.8711F, 31.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(-7, -8).addBox(-14.0F, -3.2F, 29.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)), PartPose.offset(6.6F, 2.8F, -34.0F));

		PartDefinition spoke_r16 = wheel6.addOrReplaceChild("spoke_r16", CubeListBuilder.create().texOffs(-7, -8).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 32.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition spoke_r17 = wheel6.addOrReplaceChild("spoke_r17", CubeListBuilder.create().texOffs(-8, -9).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 0.1F, 37.5F, 2.3562F, 0.0F, 0.0F));

		PartDefinition spoke_r18 = wheel6.addOrReplaceChild("spoke_r18", CubeListBuilder.create().texOffs(-8, -9).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-14.0F, 1.8F, 34.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r31 = wheel6.addOrReplaceChild("innerrim_r31", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0787F, 29.3787F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r32 = wheel6.addOrReplaceChild("innerrim_r32", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-12.0F, -3.3355F, 28.9645F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r33 = wheel6.addOrReplaceChild("innerrim_r33", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.7498F, 30.7929F, 0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r34 = wheel6.addOrReplaceChild("innerrim_r34", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.7498F, 37.2071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition innerrim_r35 = wheel6.addOrReplaceChild("innerrim_r35", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-12.0F, -3.3355F, 40.0355F, 1.5708F, 0.0F, 0.0F));

		PartDefinition innerrim_r36 = wheel6.addOrReplaceChild("innerrim_r36", CubeListBuilder.create().texOffs(-4, -3).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0787F, 38.6213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r31 = wheel6.addOrReplaceChild("flange_r31", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, -5.7426F, 29.5858F, 0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r32 = wheel6.addOrReplaceChild("flange_r32", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -1.7426F, 28.7574F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r33 = wheel6.addOrReplaceChild("flange_r33", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, 1.6716F, 28.1716F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r34 = wheel6.addOrReplaceChild("flange_r34", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, -7.1569F, 37.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition flange_r35 = wheel6.addOrReplaceChild("flange_r35", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -1.7426F, 41.2426F, 1.5708F, 0.0F, 0.0F));

		PartDefinition flange_r36 = wheel6.addOrReplaceChild("flange_r36", CubeListBuilder.create().texOffs(-4, -4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-11.0F, 3.0858F, 38.4142F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	public static final double WHEEL_RADIUS = 0.4375d; // wheel radius in minecraft blocks. in blockbench it is 7.

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		double rotation = ((TrainCar) entity).getWheelRotation();

		this.wheelsandaxle.xRot = (float) rotation;
		this.wheelsandaxle2.xRot = (float) rotation;
		this.wheelsandaxle3.xRot = (float) rotation;

		System.out.println(rotation);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		steamlocomotive.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}