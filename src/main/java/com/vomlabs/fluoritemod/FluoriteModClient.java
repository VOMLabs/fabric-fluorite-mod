
package com.vomlabs.fluoritemod;

import com.vomlabs.fluoritemod.item.ModItems;
import com.vomlabs.fluoritemod.item.custom.ChiselItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import java.util.Comparator;

public class FluoriteModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
            if (!stack.is(ModItems.CHISEL)) {
                return;
            }

            if (!Minecraft.getInstance().hasShiftDown()) {
                tooltip.add(
                        Component.translatable(
                                "item.fluoritemod.chisel.tooltip"
                        ).withStyle(ChatFormatting.DARK_GRAY)
                );
                return;
            }

            tooltip.add(
                    Component.translatable(
                            "item.fluoritemod.chisel.tooltip.header"
                    )
            );

            ChiselItem.CHISEL_MAP.keySet().stream()
                    // Exclude blocks that are transformation results.
                    .filter(block -> !ChiselItem.CHISEL_MAP.containsValue(block))
                    .sorted(Comparator.comparing(
                            block -> block.getName().getString(),
                            String.CASE_INSENSITIVE_ORDER
                    ))
                    .forEach(block -> tooltip.add(
                            Component.literal("• ")
                                    .append(block.getName())
                    ));
        });
    }
}
