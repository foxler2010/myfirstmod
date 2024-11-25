package top.drewssite.myfirstmod.block;

import java.util.function.Supplier;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.drewssite.myfirstmod.MyFirstMod;
import top.drewssite.myfirstmod.item.ModItems;

/**
 * Blocks added by the mod.
 */
public class ModBlocks {

  public static final DeferredRegister<Block> BLOCKS =
          DeferredRegister.create(ForgeRegistries.BLOCKS, MyFirstMod.MOD_ID);
  
  public static final RegistryObject<Block> SMILEY_BLOCK =
          registerBlock("smiley_block",
                  () -> new Block(BlockBehaviour.Properties
                          .ofFullCopy(Blocks.IRON_BLOCK)
                          .sound(SoundType.AMETHYST)));
  
  public static final RegistryObject<Block> DEEP_FRIED_SMILEY_BLOCK =
          registerBlock("deep_fried_smiley_block",
                  () -> new Block(BlockBehaviour.Properties
                          .ofFullCopy(Blocks.IRON_BLOCK)
                          .sound(SoundType.AMETHYST)));
  
  public static final RegistryObject<Block> SMILE_ORE =
          registerBlock("smile_ore",
                  () -> new DropExperienceBlock(UniformInt.of(3, 6),
                          BlockBehaviour.Properties
                                  .ofFullCopy(Blocks.STONE)
                                  .strength(2f)
                                  .requiresCorrectToolForDrops()));
  
  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
    
  }
  
  @SuppressWarnings({"CheckStyle", "UnusedReturnValue"})
  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    
    return ModItems.ITEMS.register(name,
            () -> new BlockItem(block.get(), new Item.Properties()));
    
  }
  
  /**
   * Register the DeferredRegister to the event bus.
   *
   * @param eventBus The event bus to register to.
   */
  public static void register(IEventBus eventBus) {
    
    BLOCKS.register(eventBus);
    
  }

}
