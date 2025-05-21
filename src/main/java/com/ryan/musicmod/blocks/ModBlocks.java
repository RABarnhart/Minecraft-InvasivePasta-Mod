package com.ryan.musicmod.blocks;

import java.util.function.Supplier;
import com.ryan.musicmod.MusicMod;
import com.ryan.musicmod.Items.ModItems;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
        = DeferredRegister.create(ForgeRegistries.BLOCKS, "musicmod");

    public static final RegistryObject<Block> RAINBOW_GLASS_BLOCK = registerBlock("rainbow_glass_block", 
        () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
        ));

    public static final RegistryObject<Block> AURORA_GLASS_BLOCK = registerBlock("aurora_glass_block", 
        () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
        ));

    public static final RegistryObject<Block> RAINBOW_BOOKSHELF_BLOCK = registerBlock("rainbow_bookshelf_block", 
        () -> new Block(Block.Properties.of()
            .strength(1f)
            .mapColor(DyeColor.BROWN)
            .sound(SoundType.WOOD)
        ));
            

    // Register Blocks with a name and a block object
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Register a block item with a name and a block object
    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
