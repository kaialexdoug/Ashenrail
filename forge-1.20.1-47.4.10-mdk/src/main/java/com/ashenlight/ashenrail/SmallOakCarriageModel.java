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

public class SmallOakCarriageModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "small_oak_carriage"), "main");
	private final ModelPart smalloakcarriage;
	private final ModelPart bogey;
	private final ModelPart wheel;
	private final ModelPart wheel2;
	private final ModelPart bogey2;
	private final ModelPart wheel3;
	private final ModelPart wheel4;
	private final ModelPart sidedoor;
	private final ModelPart side_door2;
	private final ModelPart side_door3;
	private final ModelPart side_door4;

	public SmallOakCarriageModel(ModelPart root) {
		this.smalloakcarriage = root.getChild("smalloakcarriage");
		this.bogey = this.smalloakcarriage.getChild("bogey");
		this.wheel = this.bogey.getChild("wheel");
		this.wheel2 = this.bogey.getChild("wheel2");
		this.bogey2 = this.smalloakcarriage.getChild("bogey2");
		this.wheel3 = this.bogey2.getChild("wheel3");
		this.wheel4 = this.bogey2.getChild("wheel4");
		this.sidedoor = this.smalloakcarriage.getChild("sidedoor");
		this.side_door2 = this.smalloakcarriage.getChild("side_door2");
		this.side_door3 = this.smalloakcarriage.getChild("side_door3");
		this.side_door4 = this.smalloakcarriage.getChild("side_door4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition smalloakcarriage = partdefinition.addOrReplaceChild("smalloakcarriage", CubeListBuilder.create().texOffs(0, 0).addBox(-40.0F, -8.0F, -11.5F, 66.0F, 1.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(-40.0F, -34.0F, -12.5F, 66.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 78).addBox(-40.0F, -21.0F, -12.5F, 26.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 152).addBox(22.0F, -30.0F, -12.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(156, 49).addBox(22.0F, -30.0F, 11.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 78).addBox(-40.0F, -21.0F, 11.5F, 26.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(108, 78).addBox(0.0F, -21.0F, 11.5F, 26.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 93).addBox(0.0F, -21.0F, -12.5F, 26.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 68).addBox(-40.0F, -34.0F, 11.5F, 66.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(158, 139).addBox(-40.0F, -30.0F, 11.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(158, 149).addBox(-40.0F, -30.0F, -12.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 159).addBox(4.0F, -30.0F, 11.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 159).addBox(4.0F, -30.0F, -12.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 159).addBox(-22.0F, -30.0F, 11.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(86, 159).addBox(-22.0F, -30.0F, -12.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-41.0F, -39.0F, -6.5F, 68.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(92, 108).addBox(-29.0F, -7.0F, -6.4F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 116).addBox(-37.0F, -7.0F, -6.4F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(38, 116).addBox(18.0F, -7.0F, -6.4F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(76, 127).addBox(10.0F, -7.0F, -6.4F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 73).addBox(-24.0F, -7.0F, 2.6F, 35.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(74, 73).addBox(-24.0F, -7.0F, -4.4F, 35.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(114, 127).addBox(25.0F, -34.0F, -12.5F, 1.0F, 27.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(130, 108).addBox(25.0F, -34.0F, 5.5F, 1.0F, 27.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(32, 135).addBox(25.0F, -37.8F, -6.7F, 1.0F, 4.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 135).addBox(-40.0F, -34.0F, 5.5F, 1.0F, 27.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(130, 142).addBox(-40.0F, -37.8F, -6.7F, 1.0F, 4.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(16, 135).addBox(-40.0F, -34.0F, -12.5F, 1.0F, 27.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(134, 67).addBox(-46.0F, -5.0F, 0.6F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(156, 39).addBox(-42.0F, -5.0F, -1.4F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 159).addBox(-43.0F, -5.0F, -2.4F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(162, 67).addBox(-46.0F, -5.0F, -0.4F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(146, 139).addBox(-44.0F, -5.0F, -2.4F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(148, 67).addBox(-39.0F, -6.0F, -2.4F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(134, 63).addBox(-14.0F, -8.0F, 11.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 65).addBox(-14.0F, -8.0F, -12.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.7F, 6.6F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r1 = smalloakcarriage.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(156, 59).addBox(-3.0F, -2.0F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(130, 159).addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(162, 72).addBox(-3.0F, -2.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(152, 139).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.0F, -3.0F, 0.6F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r2 = smalloakcarriage.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(156, 44).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 152).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -3.0F, 0.6F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r3 = smalloakcarriage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(146, 129).addBox(0.0F, -27.574F, -2.3858F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(76, 116).addBox(65.0F, -27.574F, -2.3858F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-40.0F, -9.5F, 0.3F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = smalloakcarriage.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(146, 119).addBox(0.0F, -26.426F, -7.3858F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(60, 135).addBox(65.0F, -26.426F, -7.3858F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-40.0F, -9.8F, 2.8F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r5 = smalloakcarriage.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 51).addBox(-66.0F, -41.3661F, -8.3595F, 68.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, 2.0F, -4.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r6 = smalloakcarriage.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 39).addBox(-66.0F, -42.6339F, -4.3595F, 68.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, 2.0F, 7.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition bogey = smalloakcarriage.addOrReplaceChild("bogey", CubeListBuilder.create().texOffs(2, 95).addBox(-31.0F, -1.5F, -9.5F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wheel = bogey.addOrReplaceChild("wheel", CubeListBuilder.create().texOffs(142, 159).addBox(-0.5F, 3.0F, -0.7F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.5F, -6.4F, -7.0F));

		PartDefinition cube_r7 = wheel.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(162, 87).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 2.1F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r8 = wheel.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(162, 119).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.6F, 1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r9 = wheel.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(162, 124).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.9F, 1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10 = wheel.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(162, 129).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 4.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r11 = wheel.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(162, 134).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, 4.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r12 = wheel.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(162, 159).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 8.0F, 1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r13 = wheel.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(162, 164).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 9.8F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r14 = wheel.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(166, 49).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.3F, 1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r15 = wheel.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(152, 159).addBox(-3.0F, -5.0F, -0.7F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r16 = wheel.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(158, 166).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 7.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r17 = wheel.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(52, 166).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.6F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = wheel.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(52, 162).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 7.5F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r19 = wheel.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(110, 154).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r20 = wheel.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(56, 152).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r21 = wheel.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(110, 150).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.1F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r22 = wheel.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(110, 146).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.1F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r23 = wheel.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(164, 63).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition wheel2 = bogey.addOrReplaceChild("wheel2", CubeListBuilder.create().texOffs(32, 161).addBox(-0.5F, 3.0F, -0.3F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.5F, -6.4F, 7.0F));

		PartDefinition cube_r24 = wheel2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(152, 166).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 2.1F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r25 = wheel2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(146, 166).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.6F, -1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r26 = wheel2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(140, 166).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.9F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r27 = wheel2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(134, 166).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 4.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r28 = wheel2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(128, 166).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, 4.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r29 = wheel2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(102, 166).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 8.0F, -1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r30 = wheel2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(96, 166).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 9.8F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r31 = wheel2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(166, 54).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.3F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r32 = wheel2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(108, 161).addBox(-3.0F, -5.0F, -0.3F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r33 = wheel2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(168, 160).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 7.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r34 = wheel2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(168, 156).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.6F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = wheel2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(168, 152).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 7.5F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r36 = wheel2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(168, 148).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r37 = wheel2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(168, 144).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r38 = wheel2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(168, 140).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.1F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r39 = wheel2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(168, 136).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.1F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r40 = wheel2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(38, 168).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bogey2 = smalloakcarriage.addOrReplaceChild("bogey2", CubeListBuilder.create().texOffs(48, 95).addBox(-31.0F, -1.5F, -9.5F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(47.0F, 0.0F, 0.0F));

		PartDefinition wheel3 = bogey2.addOrReplaceChild("wheel3", CubeListBuilder.create().texOffs(118, 161).addBox(-0.5F, 3.0F, -0.7F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.5F, -6.4F, -7.0F));

		PartDefinition cube_r41 = wheel3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(108, 168).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 2.1F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r42 = wheel3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(168, 106).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.6F, 1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r43 = wheel3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(162, 77).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.9F, 1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r44 = wheel3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(168, 87).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 4.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r45 = wheel3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(168, 82).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, 4.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r46 = wheel3.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(168, 77).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 8.0F, 1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r47 = wheel3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(168, 59).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 9.8F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = wheel3.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(32, 168).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.3F, 1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r49 = wheel3.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(162, 24).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 0.3F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r50 = wheel3.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(20, 169).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 7.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r51 = wheel3.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(16, 169).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.6F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r52 = wheel3.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(12, 169).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 7.5F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r53 = wheel3.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(8, 169).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r54 = wheel3.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(4, 169).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r55 = wheel3.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(0, 169).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.1F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r56 = wheel3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(168, 168).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.1F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r57 = wheel3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(168, 164).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition wheel4 = bogey2.addOrReplaceChild("wheel4", CubeListBuilder.create().texOffs(162, 31).addBox(-0.5F, 3.0F, -0.3F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.5F, -6.4F, 7.0F));

		PartDefinition cube_r58 = wheel4.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(168, 131).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 2.1F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r59 = wheel4.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(168, 126).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.6F, -1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r60 = wheel4.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(162, 82).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.9F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r61 = wheel4.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(168, 121).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 4.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r62 = wheel4.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(120, 168).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, 4.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r63 = wheel4.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(168, 116).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 8.0F, -1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r64 = wheel4.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(114, 168).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 9.8F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r65 = wheel4.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(168, 111).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.3F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r66 = wheel4.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(42, 162).addBox(-3.0F, -5.0F, -0.3F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r67 = wheel4.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(68, 169).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 7.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r68 = wheel4.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(64, 169).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.6F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r69 = wheel4.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(60, 169).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 7.5F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r70 = wheel4.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(56, 169).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r71 = wheel4.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(46, 169).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r72 = wheel4.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(42, 169).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.1F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r73 = wheel4.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(28, 169).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.1F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r74 = wheel4.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(24, 169).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sidedoor = smalloakcarriage.addOrReplaceChild("sidedoor", CubeListBuilder.create().texOffs(56, 156).addBox(-1.0F, -19.0F, -12.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(110, 158).addBox(-1.0F, -13.0F, -12.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 146).addBox(-14.0F, -21.0F, -12.5F, 13.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition side_door2 = smalloakcarriage.addOrReplaceChild("side_door2", CubeListBuilder.create().texOffs(168, 64).addBox(-1.0F, -19.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 169).addBox(-1.0F, -13.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(146, 93).addBox(-14.0F, -21.0F, -12.5F, 13.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 24.0F));

		PartDefinition side_door3 = smalloakcarriage.addOrReplaceChild("side_door3", CubeListBuilder.create().texOffs(76, 169).addBox(0.5F, -19.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 169).addBox(0.5F, -13.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 146).addBox(-9.5F, -21.0F, -11.0F, 10.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(36.0F, 0.0F, -4.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition side_door4 = smalloakcarriage.addOrReplaceChild("side_door4", CubeListBuilder.create().texOffs(84, 169).addBox(-1.0F, -19.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 169).addBox(-1.0F, -13.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(146, 106).addBox(-9.5F, -21.0F, -11.0F, 10.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, 0.0F, -4.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		smalloakcarriage.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}