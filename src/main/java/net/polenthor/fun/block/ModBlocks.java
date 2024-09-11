package net.polenthor.fun.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.polenthor.fun.fun;
import net.polenthor.fun.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, fun.MOD_ID);

    public static final
    RegistryObject<Block> VOLTIROT_BLOCK = registerBlock("voltirot_block",
            () -> new Block(BlockBehaviour.Properties.of().friction(0.98F).explosionResistance(3f).strength(4f).requiresCorrectToolForDrops().sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> VOLTIROT_ORE = registerBlock("voltirot_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .explosionResistance(3f).strength(4f).requiresCorrectToolForDrops().sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> VOLTIROT_DEEPSLATE_ORE = registerBlock("voltirot_deepslate_ore",
            () ->
                new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                        .explosionResistance(3f).strength(5f).requiresCorrectToolForDrops().sound(SoundType.ANVIL)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);

    }
}
