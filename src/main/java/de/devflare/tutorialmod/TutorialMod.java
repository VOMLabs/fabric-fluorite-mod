package de.devflare.tutorialmod;

import de.devflare.tutorialmod.block.ModBlocks;
import de.devflare.tutorialmod.creativemodetab.ModCreativeModeTabs;
import de.devflare.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
    public static final String MOD_ID = "tutorialmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

		ModCreativeModeTabs.registerModCreativeModeTabs();
    }
}
