package com.ryan.pastamod.blocks;

import java.util.function.Supplier;

import com.ryan.pastamod.Items.ModItems;
import com.ryan.pastamod.blocks.custom.SaltLampBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
        = DeferredRegister.create(ForgeRegistries.BLOCKS, "pastamod");

        // CUSTOM BOOKSHELF
    public static final RegistryObject<Block> RAINBOW_BOOKSHELF_BLOCK = registerBlock("rainbow_bookshelf_block", 
    () -> new Block(Block.Properties.of()
        .strength(1f)
        .mapColor(DyeColor.BROWN)
        .sound(SoundType.WOOD)
    ));

        // NEW GLASS BLOCKS
    public static final RegistryObject<Block> RAINBOW_GLASS_BLOCK = registerBlock("rainbow_glass_block", 
        () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final RegistryObject<Block> AURORA_GLASS_BLOCK = registerBlock("aurora_glass_block", 
        () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

        // GLASS NON-BLOCK BLOCKS
    public static final RegistryObject<StairBlock> GLASS_STAIRS = registerBlock("glass_stairs", 
        () -> new StairBlock(Blocks.GLASS.defaultBlockState(),
        BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()
            .sound(Blocks.GLASS.getSoundType(null, null, null, null))
            .isViewBlocking((state, level, pos) -> false)));
    public static final RegistryObject<SlabBlock> GLASS_SLAB = registerBlock("glass_slab", 
        () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()
            .sound(Blocks.GLASS.getSoundType(null, null, null, null))
            .isViewBlocking((state, level, pos) -> false)));
    public static final RegistryObject<WallBlock> GLASS_WALL = registerBlock("glass_wall", 
        () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()
            .sound(Blocks.GLASS.getSoundType(null, null, null, null))
            .isViewBlocking((state, level, pos) -> false)));

    public static final RegistryObject<DoorBlock> GLASS_DOOR = registerBlock("glass_door", 
        () -> new DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()
            .sound(Blocks.GLASS.getSoundType(null, null, null, null))));
    public static final RegistryObject<TrapDoorBlock> GLASS_TRAPDOOR = registerBlock("glass_trapdoor", 
        () -> new TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()
            .sound(Blocks.GLASS.getSoundType(null, null, null, null))));

    public static final RegistryObject<SaltLampBlock> SALT_LAMP_BLOCK = registerBlock("salt_lamp_block", 
        () -> new SaltLampBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()
            .lightLevel(state -> state.getValue(SaltLampBlock.CLICKED) ? 15 : 0)));
            

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
