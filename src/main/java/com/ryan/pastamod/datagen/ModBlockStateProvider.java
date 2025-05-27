package com.ryan.pastamod.datagen;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PastaMod.MODID, exFileHelper);
    }

    protected void registerStatesAndModels() {
        blockWithItemColumn(ModBlocks.RAINBOW_BOOKSHELF_BLOCK, "block/rainbow_bookshelf_block", "block/oak_planks");
        blockWithItem(ModBlocks.RAINBOW_GLASS_BLOCK);
        blockWithItem(ModBlocks.AURORA_GLASS_BLOCK);

        stairsBlock(ModBlocks.GLASS_STAIRS.get(), blockTexture(Blocks.GLASS));
        slabBlock(ModBlocks.GLASS_SLAB.get(), blockTexture(Blocks.GLASS), blockTexture(Blocks.GLASS));
        wallBlock(ModBlocks.GLASS_WALL.get(), blockTexture(Blocks.GLASS));

        doorBlockWithRenderType(ModBlocks.GLASS_DOOR.get(), modLoc("block/glass_door_bottom"), modLoc("block/glass_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.GLASS_TRAPDOOR.get(), modLoc("block/glass_trapdoor"), true, "cutout");

        blockItem(ModBlocks.GLASS_STAIRS);
        blockItem(ModBlocks.GLASS_SLAB);
        blockItem(ModBlocks.GLASS_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemColumn(RegistryObject<Block> blockRegistryObject, String sideTexture, String endTexture) {
        simpleBlockWithItem(
            blockRegistryObject.get(),
            models().cubeColumn(
                blockRegistryObject.getId().getPath(),
                modLoc(sideTexture),
                mcLoc(endTexture)
            )
        );
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}

