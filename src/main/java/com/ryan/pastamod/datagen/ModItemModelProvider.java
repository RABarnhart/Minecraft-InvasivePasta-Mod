package com.ryan.pastamod.datagen;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.Items.ModItems;
import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{
        public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, PastaMod.MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.GRAPE_POPPI.get());
        basicItem(ModItems.ORANGE_POPPI.get());
        basicItem(ModItems.STRAWBERRY_LEMON_POPPI.get());
        basicItem(ModItems.RASPBERRY_ROSE_POPPI.get());

        // wallItem(ModBlocks.GLASS_WALL, Blocks.GLASS);
        // simpleBlockItem(ModBlocks.GLASS_DOOR);
        // simpleBlockItem(ModBlocks.GLASS_TRAPDOOR);
        // simpleBlockItem(ModBlocks.GLASS_STAIRS);
        // simpleBlockItem(ModBlocks.GLASS_SLAB);
    }

        // HELPER METHODS
    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
    this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
            .texture("texture",  ResourceLocation.fromNamespaceAndPath(PastaMod.MODID,
                    "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(PastaMod.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(PastaMod.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PastaMod.MODID,"item/" + item.getId().getPath()));
    }
}
