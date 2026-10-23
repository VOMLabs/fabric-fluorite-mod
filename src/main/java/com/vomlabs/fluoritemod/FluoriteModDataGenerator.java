package com.vomlabs.fluoritemod;

import com.vomlabs.fluoritemod.datagen.ModBlockLootTableProvider;
import com.vomlabs.fluoritemod.datagen.ModBlockTagsProvider;
import com.vomlabs.fluoritemod.datagen.ModModelProvider;
import com.vomlabs.fluoritemod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FluoriteModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
    }
}
