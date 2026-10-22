package de.devflare.tutorialmod.creativeModeTab;

import de.devflare.tutorialmod.TutorialMod;
import de.devflare.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTabs {
    public static final CreativeModeTab FLUORITE_ITEM_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "fluorite_items"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_FLUORITE))
                    .title(Component.translatable("creativemodetab.tutorialmod.fluorite_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.FLUORITE);
                        output.accept(ModItems.RAW_FLUORITE);
                    }).build());

    public static final CreativeModeTab FLUORITE_BLOCK_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "fluorite_blocks"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_FLUORITE))
                    .title(Component.translatable("creativemodetab.tutorialmod.fluorite_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(Items.BIRCH_LOG);
                    }).build());


    public static void registerModCreativeModeTabs() {
        TutorialMod.LOGGER.info("Registering Creative Mode Tabs for " + TutorialMod.MOD_ID);

    }
}
