package com.ryan.musicmod;

import com.mojang.logging.LogUtils;
import com.ryan.musicmod.Items.ModCreativeModeTabs;
import com.ryan.musicmod.Items.ModItems;
import com.ryan.musicmod.blocks.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MusicMod.MODID)
public class MusicMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "musicmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Event listeners and setup methods
    public MusicMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register for server and other game events
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register mod's ForgeConfigSpec
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // Common setup method
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add items to creative tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.ORANGE_POPPI);
            event.accept(ModItems.GRAPE_POPPI);
            event.accept(ModItems.STRAWBERRY_LEMON_POPPI);
            event.accept(ModItems.RASPBERRY_ROSE_POPPI);
        }
        else if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.RAINBOW_GLASS_BLOCK);
            event.accept(ModBlocks.AURORA_GLASS_BLOCK);
            event.accept(ModBlocks.RAINBOW_BOOKSHELF_BLOCK);
        }
    }

    // Server starting event
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MusicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class MusicModClient {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAINBOW_GLASS_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.AURORA_GLASS_BLOCK.get(), RenderType.translucent());
            });
        }
}
}
