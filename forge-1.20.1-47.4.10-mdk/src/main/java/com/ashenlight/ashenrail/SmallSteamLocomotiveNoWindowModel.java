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

public class SmallSteamLocomotiveNoWindowModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "small_steam_locomotive_no_window"), "main");
	private final ModelPart smallsteamlocomotive;
	private final ModelPart bone41;
	private final ModelPart piston2;
	private final ModelPart piston;
	private final ModelPart coupler;
	private final ModelPart door2;
	private final ModelPart door;
	private final ModelPart locowheelandaxel2;
	private final ModelPart locowheel3;
	private final ModelPart bone21;
	private final ModelPart bone22;
	private final ModelPart bone23;
	private final ModelPart bone24;
	private final ModelPart inner_rim3;
	private final ModelPart bone25;
	private final ModelPart bone26;
	private final ModelPart bone27;
	private final ModelPart bone28;
	private final ModelPart bone29;
	private final ModelPart bone30;
	private final ModelPart locowheel4;
	private final ModelPart bone31;
	private final ModelPart bone32;
	private final ModelPart bone33;
	private final ModelPart bone34;
	private final ModelPart inner_rim4;
	private final ModelPart bone35;
	private final ModelPart bone36;
	private final ModelPart bone37;
	private final ModelPart bone38;
	private final ModelPart bone39;
	private final ModelPart bone40;
	private final ModelPart locowheelandaxel;
	private final ModelPart locowheel;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart innerrim;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart locowheel2;
	private final ModelPart bone11;
	private final ModelPart bone12;
	private final ModelPart bone13;
	private final ModelPart bone14;
	private final ModelPart inner_rim2;
	private final ModelPart bone15;
	private final ModelPart bone16;
	private final ModelPart bone17;
	private final ModelPart bone18;
	private final ModelPart bone19;
	private final ModelPart bone20;
	private final ModelPart reference;
	private final ModelPart bogey2;
	private final ModelPart wheel3;
	private final ModelPart wheel4;

	public SmallSteamLocomotiveNoWindowModel(ModelPart root) {
		this.smallsteamlocomotive = root.getChild("smallsteamlocomotive");
		this.bone41 = this.smallsteamlocomotive.getChild("bone41");
		this.piston2 = this.smallsteamlocomotive.getChild("piston2");
		this.piston = this.smallsteamlocomotive.getChild("piston");
		this.coupler = this.smallsteamlocomotive.getChild("coupler");
		this.door2 = this.smallsteamlocomotive.getChild("door2");
		this.door = this.smallsteamlocomotive.getChild("door");
		this.locowheelandaxel2 = this.smallsteamlocomotive.getChild("locowheelandaxel2");
		this.locowheel3 = this.locowheelandaxel2.getChild("locowheel3");
		this.bone21 = this.locowheel3.getChild("bone21");
		this.bone22 = this.locowheel3.getChild("bone22");
		this.bone23 = this.locowheel3.getChild("bone23");
		this.bone24 = this.locowheel3.getChild("bone24");
		this.inner_rim3 = this.locowheel3.getChild("inner_rim3");
		this.bone25 = this.inner_rim3.getChild("bone25");
		this.bone26 = this.inner_rim3.getChild("bone26");
		this.bone27 = this.inner_rim3.getChild("bone27");
		this.bone28 = this.inner_rim3.getChild("bone28");
		this.bone29 = this.locowheel3.getChild("bone29");
		this.bone30 = this.locowheel3.getChild("bone30");
		this.locowheel4 = this.locowheelandaxel2.getChild("locowheel4");
		this.bone31 = this.locowheel4.getChild("bone31");
		this.bone32 = this.locowheel4.getChild("bone32");
		this.bone33 = this.locowheel4.getChild("bone33");
		this.bone34 = this.locowheel4.getChild("bone34");
		this.inner_rim4 = this.locowheel4.getChild("inner_rim4");
		this.bone35 = this.inner_rim4.getChild("bone35");
		this.bone36 = this.inner_rim4.getChild("bone36");
		this.bone37 = this.inner_rim4.getChild("bone37");
		this.bone38 = this.inner_rim4.getChild("bone38");
		this.bone39 = this.locowheel4.getChild("bone39");
		this.bone40 = this.locowheel4.getChild("bone40");
		this.locowheelandaxel = this.smallsteamlocomotive.getChild("locowheelandaxel");
		this.locowheel = this.locowheelandaxel.getChild("locowheel");
		this.bone = this.locowheel.getChild("bone");
		this.bone2 = this.locowheel.getChild("bone2");
		this.bone3 = this.locowheel.getChild("bone3");
		this.bone4 = this.locowheel.getChild("bone4");
		this.innerrim = this.locowheel.getChild("innerrim");
		this.bone5 = this.innerrim.getChild("bone5");
		this.bone6 = this.innerrim.getChild("bone6");
		this.bone7 = this.innerrim.getChild("bone7");
		this.bone8 = this.innerrim.getChild("bone8");
		this.bone9 = this.locowheel.getChild("bone9");
		this.bone10 = this.locowheel.getChild("bone10");
		this.locowheel2 = this.locowheelandaxel.getChild("locowheel2");
		this.bone11 = this.locowheel2.getChild("bone11");
		this.bone12 = this.locowheel2.getChild("bone12");
		this.bone13 = this.locowheel2.getChild("bone13");
		this.bone14 = this.locowheel2.getChild("bone14");
		this.inner_rim2 = this.locowheel2.getChild("inner_rim2");
		this.bone15 = this.inner_rim2.getChild("bone15");
		this.bone16 = this.inner_rim2.getChild("bone16");
		this.bone17 = this.inner_rim2.getChild("bone17");
		this.bone18 = this.inner_rim2.getChild("bone18");
		this.bone19 = this.locowheel2.getChild("bone19");
		this.bone20 = this.locowheel2.getChild("bone20");
		this.reference = this.smallsteamlocomotive.getChild("reference");
		this.bogey2 = this.reference.getChild("bogey2");
		this.wheel3 = this.bogey2.getChild("wheel3");
		this.wheel4 = this.bogey2.getChild("wheel4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition smallsteamlocomotive = partdefinition.addOrReplaceChild("smallsteamlocomotive", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 8.7F, 16.9F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone41 = smallsteamlocomotive.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(160, 108).addBox(49.0F, -27.0F, -15.4F, 1.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 67).addBox(-12.0F, -13.1426F, -10.5574F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(130, 179).addBox(-13.0F, -11.9F, -10.1F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.002F))
		.texOffs(0, 91).addBox(26.0F, -28.0233F, -13.7942F, 25.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(76, 91).addBox(-13.0F, -11.2F, -10.1F, 2.0F, 11.0F, 5.0F, new CubeDeformation(0.001F))
		.texOffs(0, 0).addBox(-1.7085F, -3.0697F, -19.098F, 29.0F, 2.0F, 23.0F, new CubeDeformation(0.001F))
		.texOffs(104, 0).addBox(-17.6F, 3.6F, -20.1F, 6.0F, 2.0F, 23.0F, new CubeDeformation(0.001F))
		.texOffs(0, 25).addBox(-11.0F, -2.0F, -12.9F, 38.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(110, 166).addBox(-7.0F, -25.0F, -10.1F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(130, 166).addBox(-8.0F, -24.0F, -11.1F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(40, 154).addBox(-9.0F, 5.0F, -12.9F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(138, 37).addBox(-17.0F, 5.0F, -9.7F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 135).addBox(-18.0F, 5.0F, -16.4F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(80, 154).addBox(-22.0F, 4.0F, -18.1F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 175).addBox(-22.0F, 4.0F, -2.9F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(188, 104).addBox(-20.0F, 6.0F, -16.9F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(190, 35).addBox(-20.0F, 6.0F, -1.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 193).addBox(-14.0F, -8.0F, -8.6F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(161, 0).addBox(27.0F, -25.0F, -19.1F, 11.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(161, 83).addBox(27.0F, -25.0F, 2.9F, 11.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(166, 166).addBox(47.0F, -25.0F, 2.8F, 3.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(158, 166).addBox(47.0F, -25.0F, -19.2F, 3.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(160, 126).addBox(7.0F, -15.0F, -10.4F, 13.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 157).addBox(27.0F, -27.0F, -15.4F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(96, 150).addBox(11.0F, 3.0F, -12.3F, 14.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(28.0F, -1.0F, -19.2F, 22.0F, 1.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(142, 150).addBox(31.0F, 3.0F, -12.4F, 14.0F, 7.0F, 9.0F, new CubeDeformation(0.001F))
		.texOffs(0, 118).addBox(28.0F, 0.0F, -11.5F, 20.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(192, 184).addBox(-1.0F, -2.0F, -17.9F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(188, 192).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone41.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(71, 108).addBox(-1.0F, -12.0F, -2.0F, 21.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -1.0F, 1.8F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = bone41.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 171).addBox(6.0F, -24.0F, -2.0F, 3.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.0F, -1.0F, -6.2F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bone41.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 171).addBox(6.0F, -24.0F, -2.0F, 3.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.0F, -1.0F, -24.2F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bone41.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(114, 133).addBox(0.0F, -12.0F, 0.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, 12.0F, -1.0F, 0.48F, 0.0F, 0.7854F));

		PartDefinition cube_r5 = bone41.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(100, 181).addBox(0.0F, -11.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 12.0F, -4.9F, 0.1745F, 0.0F, 0.7854F));

		PartDefinition cube_r6 = bone41.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(36, 157).addBox(0.0F, -10.0F, 0.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, 11.0F, -8.3F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r7 = bone41.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 175).addBox(0.0F, -11.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 12.0F, -11.9F, -0.1745F, 0.0F, 0.7854F));

		PartDefinition cube_r8 = bone41.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(110, 133).addBox(0.0F, -13.0F, 0.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.6F, 12.0F, -15.9F, -0.48F, 0.0F, 0.7854F));

		PartDefinition cube_r9 = bone41.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(80, 166).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 14.0F, -7.8F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r10 = bone41.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(160, 134).addBox(-1.0F, -2.0F, -12.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 14.0F, -8.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition cube_r11 = bone41.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(90, 83).addBox(-12.0F, -2.0F, -8.0F, 13.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4783F, -0.8466F, -11.099F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r12 = bone41.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(40, 135).addBox(-1.0F, -12.0F, -2.0F, 2.0F, 11.0F, 5.0F, new CubeDeformation(0.003F)), PartPose.offsetAndRotation(-12.0F, -10.0F, -2.4F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r13 = bone41.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(96, 133).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 11.0F, 5.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(-12.0F, -1.4F, -4.4F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r14 = bone41.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(54, 118).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -5.4F, -1.6F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r15 = bone41.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(98, 25).addBox(-51.0F, -42.0F, -3.0F, 25.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(77.0F, 13.0F, -2.3884F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r16 = bone41.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 106).addBox(-51.0F, -42.0F, -7.0F, 25.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(77.0F, 13.0F, -12.2F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r17 = bone41.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(180, 41).addBox(-40.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(27.0F, -11.2F, -9.4F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r18 = bone41.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(180, 47).addBox(-40.0F, -1.1F, -0.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.009F)), PartPose.offsetAndRotation(27.0F, -4.1F, -12.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bone41.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(180, 53).addBox(-40.0F, -1.0F, -4.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.006F)), PartPose.offsetAndRotation(27.0F, -1.3F, -5.2F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r20 = bone41.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(180, 59).addBox(-40.0F, -1.1F, -0.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.007F)), PartPose.offsetAndRotation(27.0F, -1.0F, -5.8F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r21 = bone41.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(180, 65).addBox(-40.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.008F)), PartPose.offsetAndRotation(27.0F, -4.1F, -12.9F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r22 = bone41.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(180, 71).addBox(-40.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.004F)), PartPose.offsetAndRotation(27.0F, -7.7F, -2.3F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r23 = bone41.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(180, 77).addBox(-40.0F, -1.1F, -0.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(27.0F, -7.7F, -2.7F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r24 = bone41.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(90, 67).addBox(-39.0F, -2.1F, -0.7F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -8.2F, -2.4147F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r25 = bone41.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(90, 75).addBox(-39.0F, -2.0F, -5.0F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -8.1929F, -2.436F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r26 = bone41.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 83).addBox(-39.0F, -2.0F, -5.0F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -3.6071F, -12.6787F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r27 = bone41.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(90, 51).addBox(-39.0F, -2.1F, -0.7F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -0.8F, -6.3F, 3.1416F, 0.0436F, 0.0F));

		PartDefinition cube_r28 = bone41.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(90, 59).addBox(-39.0F, -2.0F, -5.0F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -0.7787F, -5.2645F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r29 = bone41.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(90, 43).addBox(-39.0F, -2.1F, -0.7F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -3.6F, -12.7F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r30 = bone41.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 75).addBox(-39.0F, -2.0F, -5.0F, 39.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, -11.0213F, -9.8502F, 0.7854F, 0.0F, 0.0F));

		PartDefinition piston2 = smallsteamlocomotive.addOrReplaceChild("piston2", CubeListBuilder.create().texOffs(168, 33).addBox(-1.0F, -2.0F, -1.0F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(192, 171).addBox(11.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(172, 192).addBox(17.0F, 7.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(180, 192).addBox(37.0F, 7.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(124, 185).addBox(7.0F, 0.0F, 0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 40).addBox(18.0F, 7.0F, 0.5F, 19.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, 0.0F));

		PartDefinition cube_r31 = piston2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(174, 177).addBox(-1.0F, -2.0F, 0.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 2.0F, 0.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition piston = smallsteamlocomotive.addOrReplaceChild("piston", CubeListBuilder.create().texOffs(168, 25).addBox(-1.0F, -2.0F, -2.0F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(190, 180).addBox(11.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(192, 163).addBox(17.0F, 7.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(192, 167).addBox(37.0F, 7.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 151).addBox(7.0F, 0.0F, -1.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 37).addBox(18.0F, 7.0F, -1.5F, 19.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, -16.9F));

		PartDefinition cube_r32 = piston.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(130, 176).addBox(-1.0F, -2.0F, -1.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 2.0F, -0.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition coupler = smallsteamlocomotive.addOrReplaceChild("coupler", CubeListBuilder.create().texOffs(68, 185).addBox(-8.0F, -2.0F, 0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(174, 180).addBox(-4.0F, -2.0F, -1.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(146, 179).addBox(-5.0F, -2.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(158, 37).addBox(-8.0F, -2.0F, -0.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(110, 147).addBox(-6.0F, -2.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 175).addBox(-1.0F, -3.0F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.0F, 8.0F, -8.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition door2 = smallsteamlocomotive.addOrReplaceChild("door2", CubeListBuilder.create().texOffs(174, 166).addBox(-9.0F, -9.0F, 1.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(188, 163).addBox(-1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(194, 160).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(47.0F, -2.0F, 1.9F));

		PartDefinition door = smallsteamlocomotive.addOrReplaceChild("door", CubeListBuilder.create().texOffs(52, 171).addBox(-9.0F, -9.0F, 0.8F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(154, 176).addBox(-1.0F, -8.0F, 0.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(150, 176).addBox(-1.0F, -2.0F, 0.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(47.0F, -2.0F, -19.9F));

		PartDefinition locowheelandaxel2 = smallsteamlocomotive.addOrReplaceChild("locowheelandaxel2", CubeListBuilder.create().texOffs(118, 129).addBox(3.4F, -5.4F, -1.5F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(33.5F, 12.6F, -15.9F));

		PartDefinition locowheel3 = locowheelandaxel2.addOrReplaceChild("locowheel3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition bone21 = locowheel3.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r33 = bone21.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(86, 188).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r34 = bone21.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(188, 83).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone22 = locowheel3.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.8F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r35 = bone22.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(92, 188).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r36 = bone22.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(188, 90).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone23 = locowheel3.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, -8.8F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r37 = bone23.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(124, 188).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r38 = bone23.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(188, 97).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone24 = locowheel3.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r39 = bone24.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(188, 149).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r40 = bone24.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(130, 188).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition inner_rim3 = locowheel3.addOrReplaceChild("inner_rim3", CubeListBuilder.create(), PartPose.offset(4.9F, 0.5F, -1.0F));

		PartDefinition bone25 = inner_rim3.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r41 = bone25.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(196, 20).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r42 = bone25.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(20, 196).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone26 = inner_rim3.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.4F, -4.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r43 = bone26.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(196, 26).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r44 = bone26.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(24, 196).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone27 = inner_rim3.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9F, -9.9F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r45 = bone27.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(38, 196).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r46 = bone27.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(34, 196).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone28 = inner_rim3.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -5.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r47 = bone28.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(42, 196).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = bone28.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(196, 39).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone29 = locowheel3.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(24, 184).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.9F, -1.6F, -1.6F));

		PartDefinition cube_r49 = bone29.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(20, 184).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bone30 = locowheel3.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(184, 95).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, -2.7F, -1.6F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r50 = bone30.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(184, 83).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition locowheel4 = locowheelandaxel2.addOrReplaceChild("locowheel4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 14.0F));

		PartDefinition bone31 = locowheel4.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r51 = bone31.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(68, 189).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r52 = bone31.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(188, 156).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone32 = locowheel4.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.8F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r53 = bone32.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(190, 21).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r54 = bone32.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(74, 189).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone33 = locowheel4.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, -8.8F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r55 = bone33.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(190, 134).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r56 = bone33.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(190, 28).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone34 = locowheel4.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r57 = bone34.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(154, 191).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r58 = bone34.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(190, 141).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition inner_rim4 = locowheel4.addOrReplaceChild("inner_rim4", CubeListBuilder.create(), PartPose.offset(4.9F, 0.5F, 1.0F));

		PartDefinition bone35 = inner_rim4.addOrReplaceChild("bone35", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r59 = bone35.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(46, 196).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r60 = bone35.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(196, 45).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone36 = inner_rim4.addOrReplaceChild("bone36", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.4F, -4.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r61 = bone36.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(196, 57).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r62 = bone36.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(196, 51).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone37 = inner_rim4.addOrReplaceChild("bone37", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9F, -9.9F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r63 = bone37.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(68, 196).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0142F, 0.0284F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r64 = bone37.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(196, 63).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone38 = inner_rim4.addOrReplaceChild("bone38", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -5.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r65 = bone38.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(72, 196).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r66 = bone38.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(196, 69).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone39 = locowheel4.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(112, 184).addBox(-1.0F, -8.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.9F, -1.6F, 1.6F));

		PartDefinition cube_r67 = bone39.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(108, 184).addBox(-1.0F, -9.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bone40 = locowheel4.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(120, 184).addBox(-1.0F, -8.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, -2.7F, 1.6F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r68 = bone40.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(116, 184).addBox(-1.0F, -9.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition locowheelandaxel = smallsteamlocomotive.addOrReplaceChild("locowheelandaxel", CubeListBuilder.create().texOffs(118, 108).addBox(3.4F, -5.4F, -0.4F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, 12.6F, -16.9F));

		PartDefinition locowheel = locowheelandaxel.addOrReplaceChild("locowheel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition bone = locowheel.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r69 = bone.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(180, 185).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r70 = bone.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(174, 185).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone2 = locowheel.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.8F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r71 = bone2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(148, 186).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r72 = bone2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(142, 186).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone3 = locowheel.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, -8.8F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r73 = bone3.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(186, 185).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r74 = bone3.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(136, 185).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3858F, 1.8284F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone4 = locowheel.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r75 = bone4.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(0, 187).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r76 = bone4.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(160, 191).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition innerrim = locowheel.addOrReplaceChild("innerrim", CubeListBuilder.create(), PartPose.offset(4.9F, 0.5F, -1.0F));

		PartDefinition bone5 = innerrim.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r77 = bone5.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(12, 187).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r78 = bone5.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(12, 193).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone6 = innerrim.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.4F, -4.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r79 = bone6.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(64, 194).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r80 = bone6.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(104, 193).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone7 = innerrim.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9F, -9.9F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r81 = bone7.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(194, 119).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r82 = bone7.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(194, 113).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone8 = innerrim.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -5.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r83 = bone8.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(194, 154).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r84 = bone8.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(194, 148).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone9 = locowheel.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(104, 181).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.9F, -1.6F, -1.6F));

		PartDefinition cube_r85 = bone9.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(52, 182).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bone10 = locowheel.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(60, 182).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, -2.7F, -1.6F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r86 = bone10.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(56, 182).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition locowheel2 = locowheelandaxel.addOrReplaceChild("locowheel2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 15.0F));

		PartDefinition bone11 = locowheel2.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r87 = bone11.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(28, 187).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r88 = bone11.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(6, 187).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone12 = locowheel2.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.8F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r89 = bone12.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(188, 7).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r90 = bone12.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(188, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone13 = locowheel2.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, -8.8F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r91 = bone13.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(188, 14).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0142F, -0.0284F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r92 = bone13.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(166, 191).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone14 = locowheel2.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r93 = bone14.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(80, 188).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r94 = bone14.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(136, 192).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 1.8F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition inner_rim2 = locowheel2.addOrReplaceChild("inner_rim2", CubeListBuilder.create(), PartPose.offset(4.9F, 0.5F, 1.0F));

		PartDefinition bone15 = inner_rim2.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r95 = bone15.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(84, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r96 = bone15.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(80, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone16 = inner_rim2.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.4F, -4.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r97 = bone16.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(92, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r98 = bone16.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(88, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5929F, -0.9787F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone17 = inner_rim2.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9F, -9.9F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r99 = bone17.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(128, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1071F, 0.0213F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100 = bone17.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(124, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone18 = inner_rim2.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -5.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r101 = bone18.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(16, 196).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r102 = bone18.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(132, 195).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.1F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone19 = locowheel2.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(184, 0).addBox(-1.0F, -8.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.9F, -1.6F, 1.6F));

		PartDefinition cube_r103 = bone19.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(64, 182).addBox(-1.0F, -9.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bone20 = locowheel2.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(16, 184).addBox(-1.0F, -8.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, -2.7F, 1.6F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r104 = bone20.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(184, 12).addBox(-1.0F, -9.0F, -1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -2.4F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition reference = smallsteamlocomotive.addOrReplaceChild("reference", CubeListBuilder.create(), PartPose.offset(103.0F, 4.0F, -18.9F));

		PartDefinition bogey2 = reference.addOrReplaceChild("bogey2", CubeListBuilder.create().texOffs(54, 133).addBox(-31.0F, -1.5F, -8.0F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(-77.0F, 7.0F, 9.0F));

		PartDefinition wheel3 = bogey2.addOrReplaceChild("wheel3", CubeListBuilder.create().texOffs(80, 181).addBox(-0.5F, 3.0F, -0.7F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.5F, -6.4F, -5.0F));

		PartDefinition cube_r105 = wheel3.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(194, 15).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 2.1F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r106 = wheel3.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(194, 10).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.6F, 1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r107 = wheel3.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(6, 194).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.9F, 1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r108 = wheel3.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(194, 5).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 4.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r109 = wheel3.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(194, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, 4.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r110 = wheel3.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(0, 194).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 8.0F, 1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r111 = wheel3.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(148, 193).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 9.8F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r112 = wheel3.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(142, 193).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.3F, 1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r113 = wheel3.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(90, 181).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 0.3F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r114 = wheel3.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(108, 196).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 7.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r115 = wheel3.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(196, 103).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.6F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r116 = wheel3.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(196, 79).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 7.5F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r117 = wheel3.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(76, 196).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r118 = wheel3.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(196, 75).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r119 = wheel3.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(194, 175).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.1F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r120 = wheel3.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(192, 188).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.1F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r121 = wheel3.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(154, 186).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition wheel4 = bogey2.addOrReplaceChild("wheel4", CubeListBuilder.create().texOffs(70, 171).addBox(-0.5F, 3.0F, -0.3F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.5F, -6.4F, 9.0F));

		PartDefinition cube_r122 = wheel4.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(194, 108).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 2.1F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r123 = wheel4.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(194, 98).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.6F, -1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r124 = wheel4.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(194, 93).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.9F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r125 = wheel4.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(194, 88).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 4.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r126 = wheel4.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(194, 83).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, 4.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r127 = wheel4.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(58, 194).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 8.0F, -1.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r128 = wheel4.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(52, 194).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 9.8F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r129 = wheel4.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(28, 194).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.3F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r130 = wheel4.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(70, 178).addBox(-3.0F, -5.0F, -0.3F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r131 = wheel4.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(176, 196).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 7.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r132 = wheel4.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(172, 196).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.6F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r133 = wheel4.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(196, 142).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 7.5F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r134 = wheel4.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(196, 138).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r135 = wheel4.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(196, 134).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 4.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r136 = wheel4.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(120, 196).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.1F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r137 = wheel4.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(116, 196).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.1F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r138 = wheel4.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(112, 196).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.4F, 0.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		smallsteamlocomotive.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}