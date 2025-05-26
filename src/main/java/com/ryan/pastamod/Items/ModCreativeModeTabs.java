package com.ryan.pastamod.Items;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.core.registries.Registries;
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
        .title(Component.translatable("creativetab.pastamod.pastamod_itmes"))
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



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
