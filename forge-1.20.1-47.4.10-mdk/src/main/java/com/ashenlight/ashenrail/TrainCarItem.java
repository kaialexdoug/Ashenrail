package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TrainCarItem extends Item {
    private final int variantId;

    public TrainCarItem(int variantId, Properties properties) {
        super(properties);
        this.variantId = variantId;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof TrackBlock) {
            if (!level.isClientSide()) {

                TrainCar trainCar = new TrainCar(ModEntities.TRAIN_CAR.get(), level);

                Direction.Axis trackAxis = state.hasProperty(TrackBlock.AXIS)
                        ? state.getValue(TrackBlock.AXIS)
                        : Direction.Axis.Z;

                float finalYaw = getFinalYaw(context, player, trackAxis);
                System.out.println("the final yaw is " + finalYaw);

                trainCar.moveTo(
                        pos.getX() + 0.5d,
                        pos.getY() + 0.0625d,
                        pos.getZ() + 0.5d,
                        finalYaw,
                        0.0f
                );
                trainCar.setVariant(this.variantId);
                level.addFreshEntity(trainCar);

                /*
                if (context.getPlayer() != null && !context.getPlayer().getAbilities().instabuild) {
                    context.getItemInHand().shrink(1);
                }
                */
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return InteractionResult.PASS;
    }

    private static float getFinalYaw(UseOnContext context, Player player, Direction.Axis trackAxis) {
        float rawYaw = (player != null) ? player.getYRot() : context.getHorizontalDirection().toYRot();

        float normalizedYaw = (rawYaw % 360.0f + 360.0f) % 360.0f;

        System.out.println("the player yaw is " + normalizedYaw);

        if (trackAxis == Direction.Axis.X) {
            //track runs east / west
            return (normalizedYaw > 180.0f && normalizedYaw < 360.0f) ? 270.0f : 90.0f;
        } else {
            //track runs north / south
            return (normalizedYaw > 90.0f && normalizedYaw < 270.0f) ? 180.0f : 0.0f;
        }
    }
}
