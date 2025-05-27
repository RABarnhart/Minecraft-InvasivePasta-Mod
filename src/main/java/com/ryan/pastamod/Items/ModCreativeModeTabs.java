package com.ryan.pastamod.Items;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.network.chat.Component;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS
        = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PastaMod.MODID);

    public static final RegistryObject<CreativeModeTab> ALL_MOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("pasta_mod_items_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RAINBOW_BOOKSHELF_BLOCK.get()))
        .title(Component.translatable("creativetab.pastamod.pastamod_items_tab"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModBlocks.RAINBOW_BOOKSHELF_BLOCK.get());
            output.accept(ModBlocks.AURORA_GLASS_BLOCK.get());
            output.accept(ModBlocks.RAINBOW_GLASS_BLOCK.get());
            output.accept(ModItems.GRAPE_POPPI.get());
            output.accept(ModItems.STRAWBERRY_LEMON_POPPI.get());
            output.accept(ModItems.ORANGE_POPPI.get());
            output.accept(ModItems.RASPBERRY_ROSE_POPPI.get());
        })
        .build());

            public static final RegistryObject<CreativeModeTab> GLASS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("glass_blocks_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RAINBOW_BOOKSHELF_BLOCK.get()))
        .title(Component.translatable("creativetab.pastamod.glass_blocks_tab"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(Blocks.GLASS);
            output.accept(ModBlocks.GLASS_SLAB.get());
            output.accept(ModBlocks.GLASS_STAIRS.get());
            output.accept(ModBlocks.GLASS_WALL.get());
            output.accept(ModBlocks.GLASS_DOOR.get());
            output.accept(ModBlocks.GLASS_TRAPDOOR.get());
        })
        .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
