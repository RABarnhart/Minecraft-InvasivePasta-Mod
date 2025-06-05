package com.ryan.pastamod.datagen;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.blocks.ModBlocks;
import com.ryan.pastamod.blocks.custom.SaltLampBlock;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PastaMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItemColumn(ModBlocks.RAINBOW_BOOKSHELF_BLOCK, "block/rainbow_bookshelf_block", "block/oak_planks");
        blockWithItem(ModBlocks.RAINBOW_GLASS_BLOCK);
        blockWithItem(ModBlocks.AURORA_GLASS_BLOCK);
        saltLamp();

        // GLASS NON-BLOCKS: Generate block models for stairs, slab, wall, door, trapdoor
        stairsBlock(ModBlocks.GLASS_STAIRS.get(), blockTexture(Blocks.GLASS));
        slabBlock(ModBlocks.GLASS_SLAB.get(), blockTexture(Blocks.GLASS), blockTexture(Blocks.GLASS));
        wallBlock(ModBlocks.GLASS_WALL.get(), blockTexture(Blocks.GLASS));
        models().wallInventory("glass_wall_inventory", blockTexture(Blocks.GLASS));
        doorBlockWithRenderType(ModBlocks.GLASS_DOOR.get(), modLoc("block/glass_door_bottom"), modLoc("block/glass_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.GLASS_TRAPDOOR.get(), modLoc("block/glass_trapdoor"), true, "cutout");

        // Ensure block item models use the block model as parent for 3D inventory rendering
        simpleBlockItem(ModBlocks.GLASS_STAIRS.get(), models().getExistingFile(modLoc("block/glass_stairs")));
        simpleBlockItem(ModBlocks.GLASS_SLAB.get(), models().getExistingFile(modLoc("block/glass_slab")));
        simpleBlockItem(ModBlocks.GLASS_WALL.get(), models().getExistingFile(modLoc("block/glass_wall_inventory")));
        simpleBlockItem(ModBlocks.GLASS_TRAPDOOR.get(), models().getExistingFile(modLoc("block/glass_trapdoor_bottom")));
    }

    private void saltLamp() {
        String modelOn = "salt_lamp_block_on";
        String modelOff = "salt_lamp_block_off";
        // ON model
        models().withExistingParent(modelOn, "minecraft:block/block")
            .texture("side", modLoc("block/salt_lamp_block_on"))
            .texture("top", modLoc("block/salt_lamp_block_on_top"))
            .texture("bottom", mcLoc("block/oak_planks"))
            .texture("particle", modLoc("block/salt_block"))
            .element()
                .from(2F, 0F, 2F).to(14F, 13F, 14F)
                .face(Direction.NORTH).texture("#side").end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.EAST).texture("#side").end()
                .face(Direction.WEST).texture("#side").end()
                .face(Direction.UP).texture("#top").end()
                .face(Direction.DOWN).texture("#bottom").end()
            .end();
        // OFF model
        models().withExistingParent(modelOff, "minecraft:block/block")
            .texture("side", modLoc("block/salt_lamp_block_off"))
            .texture("top", modLoc("block/salt_block"))
            .texture("bottom", mcLoc("block/oak_planks"))
            .texture("particle", modLoc("block/salt_block"))
            .element()
                .from(2F, 0F, 2F).to(14F, 13F, 14F)
                .face(Direction.NORTH).texture("#side").end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.EAST).texture("#side").end()
                .face(Direction.WEST).texture("#side").end()
                .face(Direction.UP).texture("#top").end()
                .face(Direction.DOWN).texture("#bottom").end()
            .end();
        getVariantBuilder(ModBlocks.SALT_LAMP_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(SaltLampBlock.CLICKED)) {
                return new ConfiguredModel[]{
                    new ConfiguredModel(models().getExistingFile(modLoc("block/" + modelOn)))
                };
            } else {
                return new ConfiguredModel[]{
                    new ConfiguredModel(models().getExistingFile(modLoc("block/" + modelOff)))
                };
            }
        });
        simpleBlockItem(ModBlocks.SALT_LAMP_BLOCK.get(), models().getExistingFile(modLoc("block/" + modelOff)));
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

