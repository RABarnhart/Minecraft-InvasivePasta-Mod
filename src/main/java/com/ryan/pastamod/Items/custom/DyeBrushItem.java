package com.ryan.pastamod.Items.custom;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DyeBrushItem extends Item {
    private final DyeColor dyeColor;

    public DyeBrushItem(Properties pProperties, DyeColor dyeColor) {
        super(pProperties);
        this.dyeColor = dyeColor;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        Block recolored = getRecoloredBlock(clickedBlock, dyeColor);
        if (recolored != null && recolored != clickedBlock) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), recolored.defaultBlockState());
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null, pContext.getClickedPos(), SoundEvents.SLIME_JUMP_SMALL, SoundSource.BLOCKS);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private Block getRecoloredBlock(Block block, DyeColor color) {
        for (DyeColor dye : DyeColor.values()) {
            if (block == getWoolBlock(dye)) return getWoolBlock(color);
            if (block == getCarpetBlock(dye)) return getCarpetBlock(color);
            if (block == getConcreteBlock(dye)) return getConcreteBlock(color);
            if (block == getTerracottaBlock(dye)) return getTerracottaBlock(color);
            if (block == getStainedGlassBlock(dye)) return getStainedGlassBlock(color);
            if (block == getStainedGlassPaneBlock(dye)) return getStainedGlassPaneBlock(color);
        }
        return null;
    }

    private Block getWoolBlock(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_WOOL;
            case ORANGE: return Blocks.ORANGE_WOOL;
            case MAGENTA: return Blocks.MAGENTA_WOOL;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_WOOL;
            case YELLOW: return Blocks.YELLOW_WOOL;
            case LIME: return Blocks.LIME_WOOL;
            case PINK: return Blocks.PINK_WOOL;
            case GRAY: return Blocks.GRAY_WOOL;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_WOOL;
            case CYAN: return Blocks.CYAN_WOOL;
            case PURPLE: return Blocks.PURPLE_WOOL;
            case BLUE: return Blocks.BLUE_WOOL;
            case BROWN: return Blocks.BROWN_WOOL;
            case GREEN: return Blocks.GREEN_WOOL;
            case RED: return Blocks.RED_WOOL;
            case BLACK: return Blocks.BLACK_WOOL;
        }
        return null;
    }
    private Block getCarpetBlock(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_CARPET;
            case ORANGE: return Blocks.ORANGE_CARPET;
            case MAGENTA: return Blocks.MAGENTA_CARPET;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_CARPET;
            case YELLOW: return Blocks.YELLOW_CARPET;
            case LIME: return Blocks.LIME_CARPET;
            case PINK: return Blocks.PINK_CARPET;
            case GRAY: return Blocks.GRAY_CARPET;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_CARPET;
            case CYAN: return Blocks.CYAN_CARPET;
            case PURPLE: return Blocks.PURPLE_CARPET;
            case BLUE: return Blocks.BLUE_CARPET;
            case BROWN: return Blocks.BROWN_CARPET;
            case GREEN: return Blocks.GREEN_CARPET;
            case RED: return Blocks.RED_CARPET;
            case BLACK: return Blocks.BLACK_CARPET;
        }
        return null;
    }
    private Block getConcreteBlock(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_CONCRETE;
            case ORANGE: return Blocks.ORANGE_CONCRETE;
            case MAGENTA: return Blocks.MAGENTA_CONCRETE;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_CONCRETE;
            case YELLOW: return Blocks.YELLOW_CONCRETE;
            case LIME: return Blocks.LIME_CONCRETE;
            case PINK: return Blocks.PINK_CONCRETE;
            case GRAY: return Blocks.GRAY_CONCRETE;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_CONCRETE;
            case CYAN: return Blocks.CYAN_CONCRETE;
            case PURPLE: return Blocks.PURPLE_CONCRETE;
            case BLUE: return Blocks.BLUE_CONCRETE;
            case BROWN: return Blocks.BROWN_CONCRETE;
            case GREEN: return Blocks.GREEN_CONCRETE;
            case RED: return Blocks.RED_CONCRETE;
            case BLACK: return Blocks.BLACK_CONCRETE;
        }
        return null;
    }
    private Block getTerracottaBlock(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_TERRACOTTA;
            case ORANGE: return Blocks.ORANGE_TERRACOTTA;
            case MAGENTA: return Blocks.MAGENTA_TERRACOTTA;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_TERRACOTTA;
            case YELLOW: return Blocks.YELLOW_TERRACOTTA;
            case LIME: return Blocks.LIME_TERRACOTTA;
            case PINK: return Blocks.PINK_TERRACOTTA;
            case GRAY: return Blocks.GRAY_TERRACOTTA;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_TERRACOTTA;
            case CYAN: return Blocks.CYAN_TERRACOTTA;
            case PURPLE: return Blocks.PURPLE_TERRACOTTA;
            case BLUE: return Blocks.BLUE_TERRACOTTA;
            case BROWN: return Blocks.BROWN_TERRACOTTA;
            case GREEN: return Blocks.GREEN_TERRACOTTA;
            case RED: return Blocks.RED_TERRACOTTA;
            case BLACK: return Blocks.BLACK_TERRACOTTA;
        }
        return null;
    }
    private Block getStainedGlassBlock(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_STAINED_GLASS;
            case ORANGE: return Blocks.ORANGE_STAINED_GLASS;
            case MAGENTA: return Blocks.MAGENTA_STAINED_GLASS;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_STAINED_GLASS;
            case YELLOW: return Blocks.YELLOW_STAINED_GLASS;
            case LIME: return Blocks.LIME_STAINED_GLASS;
            case PINK: return Blocks.PINK_STAINED_GLASS;
            case GRAY: return Blocks.GRAY_STAINED_GLASS;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_STAINED_GLASS;
            case CYAN: return Blocks.CYAN_STAINED_GLASS;
            case PURPLE: return Blocks.PURPLE_STAINED_GLASS;
            case BLUE: return Blocks.BLUE_STAINED_GLASS;
            case BROWN: return Blocks.BROWN_STAINED_GLASS;
            case GREEN: return Blocks.GREEN_STAINED_GLASS;
            case RED: return Blocks.RED_STAINED_GLASS;
            case BLACK: return Blocks.BLACK_STAINED_GLASS;
        }
        return null;
    }
    private Block getStainedGlassPaneBlock(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_STAINED_GLASS_PANE;
            case ORANGE: return Blocks.ORANGE_STAINED_GLASS_PANE;
            case MAGENTA: return Blocks.MAGENTA_STAINED_GLASS_PANE;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_STAINED_GLASS_PANE;
            case YELLOW: return Blocks.YELLOW_STAINED_GLASS_PANE;
            case LIME: return Blocks.LIME_STAINED_GLASS_PANE;
            case PINK: return Blocks.PINK_STAINED_GLASS_PANE;
            case GRAY: return Blocks.GRAY_STAINED_GLASS_PANE;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_STAINED_GLASS_PANE;
            case CYAN: return Blocks.CYAN_STAINED_GLASS_PANE;
            case PURPLE: return Blocks.PURPLE_STAINED_GLASS_PANE;
            case BLUE: return Blocks.BLUE_STAINED_GLASS_PANE;
            case BROWN: return Blocks.BROWN_STAINED_GLASS_PANE;
            case GREEN: return Blocks.GREEN_STAINED_GLASS_PANE;
            case RED: return Blocks.RED_STAINED_GLASS_PANE;
            case BLACK: return Blocks.BLACK_STAINED_GLASS_PANE;
        }
        return null;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.pastamod.dyebrush.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.pastamod.dyebrush"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
