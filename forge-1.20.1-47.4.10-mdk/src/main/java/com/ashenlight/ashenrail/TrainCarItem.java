package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static com.ashenlight.ashenrail.TrackBlock.AXIS;

public class TrainCarItem extends Item {
    private final EntityType<? extends TrainCar> entityType;

    public TrainCarItem(EntityType<? extends TrainCar> entityType, Properties properties) {
        super(properties);
        this.entityType = entityType;
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
                TrainCar trainCar = entityType.create(level);

                if (trainCar == null) return InteractionResult.PASS;

                Direction.Axis axis = state.getValue(AXIS);

                Vec3 spawnPos = new Vec3(pos.getX() + 0.5, pos.getY() + 0.0625, pos.getZ() + 0.5);
                trainCar.spawnOnEdge(edge, spawnPos, getFinalYaw(context, player, axis));

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
