package net.luhcarti.blockwar.item;

import net.luhcarti.blockwar.BlockWar;
import net.luhcarti.blockwar.item.custom.ThirtyCarbineItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BlockWar.MODID);

    //AMMO
    public static final RegistryObject<Item> THIRTY_CARBINE = ITEMS.register("thirty_carbine", () -> new ThirtyCarbineItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
