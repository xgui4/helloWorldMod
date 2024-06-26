package net.xgui4.helloWorld.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.xgui4.helloWorld.TutorialMod;
import net.xgui4.helloWorld.block.ModBlocks;
import net.xgui4.helloWorld.item.ModItems;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> SAPHIRRE_TAB = CREATIVE_MODE_TABS.register("ore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.helloworld_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.PINE_CONE.get());
                        pOutput.accept(ModItems.RAW_RADIUM.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.RADIUM_ORE_BLOCK.get());
                        pOutput.accept(ModBlocks.RADIUM_BLOCK.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PROGRAMMING = CREATIVE_MODE_TABS.register("programming_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CSHARP.get()))
                    .title(Component.translatable("computer.helloworld_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.JAVA_CUP.get());
                        pOutput.accept(ModItems.JAVA_SEED.get());
                        pOutput.accept(ModItems.TERMINAL.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.JAVA_BLOCK.get());
                        pOutput.accept(ModItems.CSHARP.get());

                        pOutput.accept(Items.COMMAND_BLOCK);
                        pOutput.accept(Items.CHAIN_COMMAND_BLOCK);
                        pOutput.accept(Items.REPEATING_COMMAND_BLOCK);
                        pOutput.accept(Items.STRUCTURE_BLOCK);
                        pOutput.accept(Items.STRUCTURE_VOID);
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
