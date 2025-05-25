package com.ryan.pastamod.datagen;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PastaMod.MODID, exFileHelper);
    }

    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAINBOW_GLASS_BLOCK);
        blockWithItem(ModBlocks.AURORA_GLASS_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    // public BlockStateProviderType type() {
    //     // Return a default BlockState or implement your logic here
    //     throw new UnsupportedOperationException("Not implemented yet");
    // }

    // public BlockState getState(RandomSource source, BlockPos pos) {
    //     // Return a default BlockState or implement your logic here
    //     throw new UnsupportedOperationException("Not implemented yet");
    // }
}
