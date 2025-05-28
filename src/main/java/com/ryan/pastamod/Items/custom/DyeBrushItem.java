package com.ryan.pastamod.Items.custom;

import java.util.Map;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class DyeBrushItem extends Item {
    public DyeBrushItem(Properties pProperties) {
        super(pProperties);
    }

    private static final Map<Block, Block> DYE_MAP =
        Map.of();

    public InteractionResult useOn (UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        return super.useOn(pContext);
    }
}
