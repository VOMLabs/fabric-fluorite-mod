package com.vomlabs.fluoritemod;

import com.vomlabs.fluoritemod.block.ModBlocks;
import com.vomlabs.fluoritemod.creativemodetab.ModCreativeModeTabs;
import com.vomlabs.fluoritemod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluoriteMod implements ModInitializer {
    public static final String MOD_ID = "fluoritemod";

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
