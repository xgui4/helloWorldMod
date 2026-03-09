package net.xgui4.helloWorld.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xgui4.helloWorld.TutorialMod;
import net.xgui4.helloWorld.item.ModFoods;
import net.xgui4.helloWorld.item.custom.FuelItem;
import net.xgui4.helloWorld.item.custom.MetalDetectorItem;
import net.xgui4.helloWorld.item.custom.Terminal;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RADIUM = ITEMS.register("raw_radium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 600));

    public static final RegistryObject<Item> JAVA_SEED = ITEMS.register("java_seed",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JAVA_CUP = ITEMS.register("java_cup",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> TERMINAL = ITEMS.register("terminal",
            () -> new Terminal(new Item.Properties()));

    public static final RegistryObject<Item> CSHARP = ITEMS.register("csharp",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
