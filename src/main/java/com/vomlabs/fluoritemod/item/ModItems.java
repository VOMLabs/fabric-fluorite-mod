package com.vomlabs.fluoritemod.item;

import com.vomlabs.fluoritemod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import com.vomlabs.fluoritemod.FluoriteMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", Item::new);
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);

    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(32)));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(FluoriteMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FluoriteMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        FluoriteMod.LOGGER.info("Registering Mod Items for " + FluoriteMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(FLUORITE);
            output.accept(RAW_FLUORITE);
        });
    }
}