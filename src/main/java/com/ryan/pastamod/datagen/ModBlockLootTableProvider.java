package com.ryan.pastamod.datagen;

import java.util.Set;

import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTableProvider extends BlockLootSubProvider{
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropWhenSilkTouch(ModBlocks.RAINBOW_GLASS_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.AURORA_GLASS_BLOCK.get());
        this.add(ModBlocks.RAINBOW_BOOKSHELF_BLOCK.get(), p_250379_ -> this.createSingleItemTableWithSilkTouch(p_250379_, Items.BOOK, ConstantValue.exactly(3.0F)));

            // GLASS NON-BLOCKS
        dropWhenSilkTouch(ModBlocks.GLASS_STAIRS.get());
        dropWhenSilkTouch(ModBlocks.GLASS_TRAPDOOR.get());
        dropWhenSilkTouch(ModBlocks.GLASS_WALL.get());
        this.add(ModBlocks.GLASS_DOOR.get(), block -> createDoorTable(ModBlocks.GLASS_DOOR.get()));
        this.add(ModBlocks.GLASS_SLAB.get(), block -> createSlabItemTable(ModBlocks.GLASS_SLAB.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // making all the blocks defined by the mod available to this class in the way it wants
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
