package com.ashenlight.ashenrail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TrainCarRenderer extends EntityRenderer<TrainCar> {

    private record VariantData(EntityModel<TrainCar> model, ResourceLocation texture) {}

    //models
    private final SmallSteamLocomotiveModel smallSteamLocomotiveModel;
    private final SmallOakCarriageModel smallOakCarriageModel;

    //textures
    private static final ResourceLocation SMALL_STEAM_LOCOMOTIVE_TEXTURE = new ResourceLocation(AshenRail.MODID, "textures/entity/small_steam_locomotive.png");
    private static final ResourceLocation SMALL_OAK_CARRIAGE_TEXTURE = new ResourceLocation(AshenRail.MODID,  "textures/entity/small_oak_carriage.png");

    public TrainCarRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5f;
        this.smallSteamLocomotiveModel = new SmallSteamLocomotiveModel(context.bakeLayer(SmallSteamLocomotiveModel.LAYER_LOCATION));
        this.smallOakCarriageModel = new SmallOakCarriageModel(context.bakeLayer(SmallOakCarriageModel.LAYER_LOCATION));
    }

    private VariantData getVariantData(TrainCar trainCar) {
        return switch (trainCar.getVariant()) {
            case 0 -> new VariantData(this.smallSteamLocomotiveModel, SMALL_STEAM_LOCOMOTIVE_TEXTURE);
            case 1 -> new VariantData(this.smallOakCarriageModel, SMALL_OAK_CARRIAGE_TEXTURE);
            default -> new VariantData(this.smallOakCarriageModel, SMALL_OAK_CARRIAGE_TEXTURE);
        };
    }

    @Override
    public ResourceLocation getTextureLocation(TrainCar trainCar) {
        return getVariantData(trainCar).texture();
    }

    @Override
    public void render(TrainCar trainCar, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(0.0D, 1.5, 0.0D);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));

        EntityModel<TrainCar> model = getVariantData(trainCar).model();

        VertexConsumer vertexConsumer = buffer.getBuffer(model.renderType(getTextureLocation(trainCar)));

        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        poseStack.popPose();

        super.render(trainCar, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

}
