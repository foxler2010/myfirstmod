package top.drewssite.myfirstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.drewssite.myfirstmod.MyFirstMod;
import top.drewssite.myfirstmod.block.ModBlocks;

/**
 * Creative Mode Tabs added by the mod.
 */
public class ModCreativeModeTabs {
  
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
          DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyFirstMod.MOD_ID);
  
  @SuppressWarnings("unused")
  public static final RegistryObject<CreativeModeTab> MYFIRSTMOD_TAB =
          CREATIVE_MODE_TABS.register("myfirstmod_tab", () -> CreativeModeTab.builder()
                  .icon(() -> new ItemStack(ModItems.SMILEY.get()))
                  .title(Component.translatable("creativetab.myfirstmod_tab"))
                  .displayItems((parameters, output) -> {
                    output.accept(ModItems.RAW_SMILES.get());
                    output.accept(ModItems.SMILEY.get());
                    output.accept(ModItems.DEEP_FRIED_SMILEY.get());
                    output.accept(ModBlocks.SMILEY_BLOCK.get());
                    output.accept(ModBlocks.DEEP_FRIED_SMILEY_BLOCK.get());
                    output.accept(ModBlocks.SMILE_ORE.get());
                  })
                  .build());
  
  /**
   * Register the DeferredRegister to the event bus.
   *
   * @param eventBus The event bus to register to.
   */
  public static void register(IEventBus eventBus) {
    
    CREATIVE_MODE_TABS.register(eventBus);
    
  }
  
}
