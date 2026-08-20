package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
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
        BlockState state = level.getBlockState(pos);

        if (BaseRailBlock.isRail(state)) {
            if (!level.isClientSide()) {
                System.out.println("SERVER SIDE: spawning train car...");
                TrainCar trainCar = new TrainCar(ModEntities.TRAIN_CAR.get(), level);

                trainCar.setPos(pos.getX() + 0.5D, pos.getY() + 0.0625D, pos.getZ() + 0.5D);
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
}
