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

    public static final RegistryObject<Item> RED_DYEBRUSH = ITEMS.register("red_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.RED));
    public static final RegistryObject<Item> ORANGE_DYEBRUSH = ITEMS.register("orange_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.ORANGE));
    public static final RegistryObject<Item> YELLOW_DYEBRUSH = ITEMS.register("yellow_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.YELLOW));
    public static final RegistryObject<Item> LIME_DYEBRUSH = ITEMS.register("lime_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.LIME));
    public static final RegistryObject<Item> GREEN_DYEBRUSH = ITEMS.register("green_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.GREEN));
    public static final RegistryObject<Item> CYAN_DYEBRUSH = ITEMS.register("cyan_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.CYAN));
    public static final RegistryObject<Item> LIGHT_BLUE_DYEBRUSH = ITEMS.register("light_blue_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> BLUE_DYEBRUSH = ITEMS.register("blue_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.BLUE));
    public static final RegistryObject<Item> PURPLE_DYEBRUSH = ITEMS.register("purple_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.PURPLE));
    public static final RegistryObject<Item> MAGENTA_DYEBRUSH = ITEMS.register("magenta_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.MAGENTA));
    public static final RegistryObject<Item> PINK_DYEBRUSH = ITEMS.register("pink_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.PINK));
    public static final RegistryObject<Item> BROWN_DYEBRUSH = ITEMS.register("brown_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.BROWN));
    public static final RegistryObject<Item> BLACK_DYEBRUSH = ITEMS.register("black_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.BLACK));
    public static final RegistryObject<Item> GRAY_DYEBRUSH = ITEMS.register("gray_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.GRAY));
    public static final RegistryObject<Item> LIGHT_GRAY_DYEBRUSH = ITEMS.register("light_gray_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> WHITE_DYEBRUSH = ITEMS.register("white_dyebrush",
        () -> new DyeBrushItem(new Item.Properties().durability(32), DyeColor.WHITE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
