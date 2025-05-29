package com.ryan.pastamod.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.DyeColor;

import com.ryan.pastamod.PastaMod;
import com.ryan.pastamod.Items.custom.DyeBrushItem;

import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, PastaMod.MODID);

    public static final RegistryObject<Item> ORANGE_POPPI = ITEMS.register("orange_poppi", 
        () -> new PotionItem(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));

    public static final RegistryObject<Item> GRAPE_POPPI = ITEMS.register("grape_poppi",
        () -> new PotionItem(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));
    
    public static final RegistryObject<Item> STRAWBERRY_LEMON_POPPI = ITEMS.register("strawberry_lemon_poppi",
        () -> new PotionItem(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));

    public static final RegistryObject<Item> RASPBERRY_ROSE_POPPI = ITEMS.register("raspberry_rose_poppi",
        () -> new PotionItem(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));

    public static final RegistryObject<Item> DYEBRUSH = ITEMS.register("dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.WHITE));

    public static final RegistryObject<Item> DYEBRUSH_RED = ITEMS.register("dyebrush_red",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.RED));
    public static final RegistryObject<Item> DYEBRUSH_ORANGE = ITEMS.register("dyebrush_orange",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.ORANGE));
    public static final RegistryObject<Item> DYEBRUSH_YELLOW = ITEMS.register("dyebrush_yellow",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.YELLOW));
    public static final RegistryObject<Item> DYEBRUSH_LIME = ITEMS.register("dyebrush_lime",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.LIME));
    public static final RegistryObject<Item> DYEBRUSH_GREEN = ITEMS.register("dyebrush_green",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.GREEN));
    public static final RegistryObject<Item> DYEBRUSH_CYAN = ITEMS.register("dyebrush_cyan",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.CYAN));
    public static final RegistryObject<Item> DYEBRUSH_LIGHT_BLUE = ITEMS.register("dyebrush_light_blue",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> DYEBRUSH_BLUE = ITEMS.register("dyebrush_blue",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.BLUE));
    public static final RegistryObject<Item> DYEBRUSH_PURPLE = ITEMS.register("dyebrush_purple",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.PURPLE));
    public static final RegistryObject<Item> DYEBRUSH_MAGENTA = ITEMS.register("dyebrush_magenta",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.MAGENTA));
    public static final RegistryObject<Item> DYEBRUSH_PINK = ITEMS.register("dyebrush_pink",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.PINK));
    public static final RegistryObject<Item> DYEBRUSH_BROWN = ITEMS.register("dyebrush_brown",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.BROWN));
    public static final RegistryObject<Item> DYEBRUSH_BLACK = ITEMS.register("dyebrush_black",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.BLACK));
    public static final RegistryObject<Item> DYEBRUSH_GRAY = ITEMS.register("dyebrush_gray",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.GRAY));
    public static final RegistryObject<Item> DYEBRUSH_LIGHT_GRAY = ITEMS.register("dyebrush_light_gray",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> DYEBRUSH_WHITE = ITEMS.register("dyebrush_white",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.WHITE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
