package net.polenthor.fun.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.polenthor.fun.fun;
import net.polenthor.fun.item.coustom.FunItem;

import java.rmi.registry.Registry;

public class ModItems {






    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, fun.MOD_ID);
    public static final RegistryObject<Item> VOLTIROT = ITEMS.register("voltirot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MILMOR = ITEMS.register("milmor",
            () -> new FunItem(new Item.Properties().durability(40)));


    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }

}
