package com.ryan.musicmod.Items;

import com.ryan.musicmod.MusicMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, MusicMod.MODID);

    public static final RegistryObject<Item> ORANGE_POPPI = ITEMS.register("orange_poppi", 
        () -> new Item(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));

    public static final RegistryObject<Item> GRAPE_POPPI = ITEMS.register("grape_poppi",
        () -> new Item(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));
    
    public static final RegistryObject<Item> STRAWBERRY_LEMON_POPPI = ITEMS.register("strawberry_lemon_poppi",
        () -> new Item(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));

    public static final RegistryObject<Item> RASPBERRY_ROSE_POPPI = ITEMS.register("raspberry_rose_poppi",
        () -> new Item(new Item.Properties()
            .stacksTo(16)
            .rarity(Rarity.EPIC)
            .food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationModifier(0.3f)
                .build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
