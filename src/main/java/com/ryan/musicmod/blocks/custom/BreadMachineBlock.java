package com.ryan.musicmod.blocks.custom;

import net.minecraft.world.level.block.FurnaceBlock;

public class BreadMachineBlock extends FurnaceBlock {
    public BreadMachineBlock(Properties properties) {
        super(properties);
    }


    // private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 14, 15);
    
    // @Override
    // public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    //     return SHAPE;
    // }

    // @Override
    // public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    //     return new BreadMachineBlockEntity(pos, state);
    // }

    // @Nullable
    // @Override
    // public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    //     // Use your custom block entity type for ticking
    //     return createFurnaceTicker(level, type, com.ryan.musicmod.registry.ModBlockEntities.BREAD_MACHINE.get());
    // }

    // @Override
    // protected void openContainer(Level level, BlockPos pos, Player player) {
    //     BlockEntity blockentity = level.getBlockEntity(pos);
    //     if (blockentity instanceof com.ryan.musicmod.blocks.entity.BreadMachineBlockEntity) {
    //         player.openMenu((MenuProvider) blockentity);
    //         player.awardStat(net.minecraft.stats.Stats.INTERACT_WITH_FURNACE);
    //     }
    // }
}
