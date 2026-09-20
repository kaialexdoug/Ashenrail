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
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;

public class TrainCarRenderer extends EntityRenderer<TrainCar> {

    private record VariantData(EntityModel<TrainCar> model, ResourceLocation texture) {}

    //models
    private final SmallSteamLocomotiveModel smallSteamLocomotiveModel;
    private final SmallSteamLocomotiveNoRoofModel smallSteamLocomotiveNoRoofModel;
    private final SmallSteamLocomotiveNoWindowModel smallSteamLocomotiveNoWindowModel;
    private final SmallOakCarriageModel smallOakCarriageModel;
    private final SmallOakCarriageNoRoofModel smallOakCarriageNoRoofModel;

    //textures
    private static final ResourceLocation SMALL_STEAM_LOCOMOTIVE_TEXTURE = new ResourceLocation(AshenRail.MODID, "textures/entity/small_steam_locomotive.png");
    private static final ResourceLocation SMALL_STEAM_LOCOMOTIVE_NO_ROOF_TEXTURE = new ResourceLocation(AshenRail.MODID, "textures/entity/small_steam_locomotive_noroof.png");
    private static final ResourceLocation SMALL_STEAM_LOCOMOTIVE_NO_WINDOW_TEXTURE = new ResourceLocation(AshenRail.MODID, "textures/entity/small_steam_locomotive_nowindow.png");
    private static final ResourceLocation SMALL_OAK_CARRIAGE_TEXTURE = new ResourceLocation(AshenRail.MODID,  "textures/entity/small_oak_carriage.png");
    private static final ResourceLocation SMALL_OAK_CARRIAGE_NO_ROOF_TEXTURE = new ResourceLocation(AshenRail.MODID, "textures/entity/small_oak_carriage.png");

    public TrainCarRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5f;
        this.smallSteamLocomotiveModel = new SmallSteamLocomotiveModel(context.bakeLayer(SmallSteamLocomotiveModel.LAYER_LOCATION));
        this.smallSteamLocomotiveNoRoofModel = new SmallSteamLocomotiveNoRoofModel(context.bakeLayer(SmallSteamLocomotiveNoRoofModel.LAYER_LOCATION));
        this.smallSteamLocomotiveNoWindowModel = new SmallSteamLocomotiveNoWindowModel(context.bakeLayer(SmallSteamLocomotiveNoWindowModel.LAYER_LOCATION));
        this.smallOakCarriageModel = new SmallOakCarriageModel(context.bakeLayer(SmallOakCarriageModel.LAYER_LOCATION));
        this.smallOakCarriageNoRoofModel = new SmallOakCarriageNoRoofModel(context.bakeLayer(SmallOakCarriageNoRoofModel.LAYER_LOCATION));
    }

    //variants
    public static final int VARIANT_SMALL_STEAM_LOCOMOTIVE = 0;
    public static final int VARIANT_SMALL_STEAM_LOCOMOTIVE_NO_ROOF = 1;
    public static  final int VARIANT_SMALL_STEAM_LOCOMOTIVE_NO_WINDOW = 2;
    public static final int VARIANT_SMALL_OAK_CARRIAGE = 3;
    public static final int VARIANT_SMALL_OAK_CARRIAGE_NO_ROOF = 4;

    private VariantData getVariantData(TrainCar trainCar) {
        return switch (trainCar.getVariant()) {
            case VARIANT_SMALL_STEAM_LOCOMOTIVE -> new VariantData(this.smallSteamLocomotiveModel, SMALL_STEAM_LOCOMOTIVE_TEXTURE);
            case VARIANT_SMALL_STEAM_LOCOMOTIVE_NO_ROOF -> new VariantData(this.smallSteamLocomotiveNoRoofModel, SMALL_STEAM_LOCOMOTIVE_NO_ROOF_TEXTURE);
            case VARIANT_SMALL_STEAM_LOCOMOTIVE_NO_WINDOW -> new VariantData(this.smallSteamLocomotiveNoWindowModel, SMALL_STEAM_LOCOMOTIVE_NO_WINDOW_TEXTURE);
            case VARIANT_SMALL_OAK_CARRIAGE -> new VariantData(this.smallOakCarriageModel, SMALL_OAK_CARRIAGE_TEXTURE);
            case VARIANT_SMALL_OAK_CARRIAGE_NO_ROOF -> new VariantData(this.smallOakCarriageNoRoofModel, SMALL_OAK_CARRIAGE_NO_ROOF_TEXTURE);
            default -> new VariantData(this.smallOakCarriageModel, SMALL_OAK_CARRIAGE_TEXTURE);
        };
    }

    @Override
    public ResourceLocation getTextureLocation(TrainCar trainCar) {
        return getVariantData(trainCar).texture();
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

        double yOffset = 1.7d;

        poseStack.translate(0.0D, yOffset, 0.0D);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));

        EntityModel<TrainCar> model = getVariantData(trainCar).model();

        VertexConsumer vertexConsumer = buffer.getBuffer(model.renderType(getTextureLocation(trainCar)));

        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        poseStack.popPose();

        super.render(trainCar, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
