package com.ryan.pastamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.Items.ModItems;
import com.ryan.pastamod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, PastaMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.DYEBRUSHES)
                .add(ModItems.DYEBRUSH.get())
                .add(ModItems.DYEBRUSH_WHITE.get())
                .add(ModItems.DYEBRUSH_RED.get())
                .add(ModItems.DYEBRUSH_ORANGE.get())
                .add(ModItems.DYEBRUSH_YELLOW.get())
                .add(ModItems.DYEBRUSH_LIME.get())
                .add(ModItems.DYEBRUSH_GREEN.get())
                .add(ModItems.DYEBRUSH_CYAN.get())
                .add(ModItems.DYEBRUSH_LIGHT_BLUE.get())
                .add(ModItems.DYEBRUSH_BLUE.get())
                .add(ModItems.DYEBRUSH_PURPLE.get())
                .add(ModItems.DYEBRUSH_MAGENTA.get())
                .add(ModItems.DYEBRUSH_PINK.get())
                .add(ModItems.DYEBRUSH_BROWN.get())
                .add(ModItems.DYEBRUSH_BLACK.get())
                .add(ModItems.DYEBRUSH_GRAY.get())
                .add(ModItems.DYEBRUSH_LIGHT_GRAY.get());
    }
}
