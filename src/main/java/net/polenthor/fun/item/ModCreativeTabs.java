package net.polenthor.fun.item;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.polenthor.fun.block.ModBlocks;
import net.polenthor.fun.fun;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, fun.MOD_ID);
    public static final RegistryObject<CreativeModeTab> FUN_TAB = CREATIVE_MOD_TABS.register("fun_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VOLTIROT.get()))
                    .title(Component.translatable("creativetab.fun.fun_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MILMOR.get());
                        pOutput.accept(ModItems.VOLTIROT.get());
                    })


                    .build());

    public static final RegistryObject<CreativeModeTab> FUN_BLOCK_TAB = CREATIVE_MOD_TABS.register("fun_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.VOLTIROT_BLOCK.get()))
                    .withTabsBefore(FUN_TAB.getId())
                    .title(Component.translatable("creativetab.fun.fun_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.VOLTIROT_BLOCK.get());
                        pOutput.accept(ModBlocks.VOLTIROT_DEEPSLATE_ORE.get());
                        pOutput.accept(ModBlocks.VOLTIROT_ORE.get());



                    })


                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MOD_TABS.register(eventbus);
    }
}
