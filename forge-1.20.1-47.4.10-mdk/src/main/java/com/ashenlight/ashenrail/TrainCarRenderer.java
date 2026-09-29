package com.ashenlight.ashenrail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RailState;

public class TrainCarRenderer extends EntityRenderer<TrainCar> {

    //official models
    private final SteamLocomotiveTest steamLocomotiveTest;
    private final SteamLocomotiveModel steamLocomotiveModel;

    public TrainCarRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5f;

        // official models
        this.steamLocomotiveTest = new SteamLocomotiveTest(context.bakeLayer(SteamLocomotiveTest.LAYER_LOCATION));
        this.steamLocomotiveModel = new SteamLocomotiveModel(context.bakeLayer(SteamLocomotiveModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(TrainCar trainCar) {
        return new ResourceLocation(
                AshenRail.MODID,
                "textures/entity/" + trainCar.getTextureId() + "_texture.png"
        );
    }

    private EntityModel<TrainCar> getModel(TrainCar trainCar) {
        return switch (trainCar.getModelId()) {
            case "steam_locomotive" -> this.steamLocomotiveModel;
            default -> this.steamLocomotiveModel;
        };
    }

    @Override
    public void render(TrainCar trainCar, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        // NOTE: nothing in here may move the car or its passengers. render() runs at frame rate,
        // after the render transform has already been derived from the entity's tick position,
        // so mutating position here fights that transform (and the chunk-section bookkeeping,
        // which expects one move per tick). Passengers are seated from TrainCar.positionRider,
        // driven once per tick by Entity.rideTick().

        // rendering the model
        poseStack.pushPose();

        double yOffset = 1.5d;

        poseStack.translate(0.0D, yOffset, 0.0D);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));

        EntityModel<TrainCar> model = this.getModel(trainCar);

        model.setupAnim(trainCar, 0, 0, partialTicks, 0, 0);

        VertexConsumer vertexConsumer = buffer.getBuffer(model.renderType(getTextureLocation(trainCar)));

        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        poseStack.popPose();

        super.render(trainCar, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
