package top.drewssite.myfirstmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.drewssite.myfirstmod.MyFirstMod;

/**
 * Items added by the mod.
 */
public class ModItems {
  
  public static final DeferredRegister<Item> ITEMS =
          DeferredRegister.create(ForgeRegistries.ITEMS, MyFirstMod.MOD_ID);
  
  public static final RegistryObject<Item> SMILEY = ITEMS.register("smiley",
          () -> new Item(new Item.Properties()));
  
  public static final RegistryObject<Item> DEEP_FRIED_SMILEY = ITEMS.register("deep_fried_smiley",
          () -> new Item(new Item.Properties()));
    
  /**
   * Register the DeferredRegister to the event bus.
   *
   * @param eventBus The event bus to register to.
   */
  public static void register(IEventBus eventBus) {
    
    ITEMS.register(eventBus);
    
  }

}
