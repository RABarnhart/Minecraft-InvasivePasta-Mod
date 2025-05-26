package com.ryan.pastamod;

import com.mojang.logging.LogUtils;
import com.ryan.pastamod.Items.ModCreativeModeTabs;
import com.ryan.pastamod.Items.ModItems;
import com.ryan.pastamod.blocks.ModBlocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.item.CreativeModeTabs;
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
import net.minecraft.client.renderer.RenderType;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PastaMod.MODID)
public class PastaMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "pastamod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Event listeners and setup methods
    public PastaMod(FMLJavaModLoadingContext context)
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
    @Mod.EventBusSubscriber(modid = PastaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class PastaModClient {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAINBOW_GLASS_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.AURORA_GLASS_BLOCK.get(), RenderType.translucent());
            });
        }
}
}
