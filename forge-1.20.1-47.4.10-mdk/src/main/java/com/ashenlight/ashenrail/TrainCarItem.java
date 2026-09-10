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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;

import static com.ashenlight.ashenrail.Debug.logInGame;
import static com.ashenlight.ashenrail.TrackBlock.AXIS;

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

        if (level.getBlockState(pos).getBlock() instanceof TrackBlock && !level.isClientSide) {
            TrackEdge edge = TrackGraph.edgesByPos.get(pos.immutable());
            if (edge != null) {
                TrainCar trainCar = new TrainCar(ModEntities.TRAIN_CAR.get(), level);
                trainCar.setVariant(variantId); // this makes sure the right train car is being placed!

                Direction.Axis axis = state.getValue(AXIS);

                Vec3 spawnPos = new Vec3(pos.getX() + 0.5, pos.getY() + 0.0625, pos.getZ() + 0.5);
                trainCar.spawnOnEdge(edge, spawnPos, pos, getFinalYaw(context, player, axis));

                level.addFreshEntity(trainCar);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    private static float getFinalYaw(UseOnContext context, Player player, Direction.Axis trackAxis) {
        float rawYaw = (player != null) ? player.getYRot() : context.getHorizontalDirection().toYRot();

        float normalizedYaw = (rawYaw % 360.0f + 360.0f) % 360.0f;

        if (trackAxis == Direction.Axis.X) {
            //track runs east / west
            return (normalizedYaw > 180.0f && normalizedYaw < 360.0f) ? 270.0f : 90.0f;
        } else {
            //track runs north / south
            return (normalizedYaw > 90.0f && normalizedYaw < 270.0f) ? 180.0f : 0.0f;
        }
    }
}
