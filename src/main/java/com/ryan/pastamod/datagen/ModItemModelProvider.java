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

        // TODO: make a method that passes in a block to make modded non-blocks
        glassLikeBlockItem(ModBlocks.GLASS_STAIRS);
        glassLikeBlockItem(ModBlocks.GLASS_SLAB);
        // Use the inventory model for the wall item so it renders as a wall in inventory
        withExistingParent(ModBlocks.GLASS_WALL.getId().getPath(), modLoc("block/glass_wall_inventory"));
        simpleBlockItem(ModBlocks.GLASS_DOOR); // Use vanilla flat item model for door
    }

        // HELPER METHODS
    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PastaMod.MODID,"item/" + item.getId().getPath()));
    }

    // Helper for glass-like block items using vanilla glass texture
    private void glassLikeBlockItem(RegistryObject<? extends Block> block) {
        // Use the block model as the parent so the item renders as a 3D block in the inventory, like vanilla glass
        this.withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }
}
