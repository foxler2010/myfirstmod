/*
 * Project: My First Mod
 * Author: Foxler2010
 * Created: 11/18/24
 * Provides: Some example blocks, items, etc.
 *           My sandbox for playing around with the Forge modding API
 */

package top.drewssite.myfirstmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.drewssite.myfirstmod.block.ModBlocks;
import top.drewssite.myfirstmod.item.ModCreativeModeTabs;
import top.drewssite.myfirstmod.item.ModItems;

/**
 * My First Mod!
 *
 * <p>The value inside the parentheses of {@code @Mod()}
 * should match an entry in the {@code META-INF/mods.toml} file.
 */
@Mod(MyFirstMod.MOD_ID)
public class MyFirstMod {

  /*
   * Common stuff
   */

  /**
   * Define the mod ID in a common place for everything to reference.
   */
  public static final String MOD_ID = "myfirstmod";

  /**
   * Directly reference a slf4j logger.
   */
  private static final Logger LOGGER = LogUtils.getLogger();
  
  /**
   * Mod constructor.
   * Does things that need to happen when
   * the mod is initialized.
   */
  public MyFirstMod() {

    // Retrieves the mod event bus and stores it to this local variable.
    // The mod event bus is used for events that are specific to this mod only.
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    
    // Register DeferredRegisters to the mod event bus
    ModCreativeModeTabs.register(modEventBus);
    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);

    // Register the commonSetup method for modloading.
    // commonSetup() will be called by the event bus when necessary.
    modEventBus.addListener(this::commonSetup);

    // Register ourselves (The mod class) for server
    // and other game events we are interested in.
    // This event bus is for events pertaining to the whole game.
    MinecraftForge.EVENT_BUS.register(this);
    
    modEventBus.addListener(this::addCreative);
    
    // Register our mod's ForgeConfigSpec
    // so that Forge can create and load the config file for us
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

  }
  
  /**
   * Currently unused.
   *
   * @param event Event to run this method on.
   */
  private void commonSetup(final FMLCommonSetupEvent event) {

  }
  
  /**
   * Add items to vanilla creative mode tabs.
   * Currently not used.
   *
   * @param event The event on which to add the items
   */
  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    
  }

  /**
   * You can use {@code @SubscribeEvent}
   *
   * <p>and let the Event Bus discover methods to call.
   *
   * @param event The event that triggers this method
   */
  @SubscribeEvent
  public void onServerStarting(final ServerStartingEvent event) {
  
  }

  /**
   * You can use EventBusSubscriber to
   *
   * <p>automatically register all static methods
   *
   * <p>in the class annotated with {@code @SubscribeEvent}.
   */
  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {

    /**
     * Runs on client setup event.
     *
     * @param event The event that triggers this method
     */
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
    
    }

  }

}
