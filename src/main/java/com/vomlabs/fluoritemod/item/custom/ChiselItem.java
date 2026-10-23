
package com.vomlabs.fluoritemod.item.custom;

import com.vomlabs.fluoritemod.block.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {

    public static final Map<Block, Block> CHISEL_MAP = Map.ofEntries(
            // Stone
            Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
            Map.entry(Blocks.STONE_BRICKS, Blocks.STONE),

            // Deepslate
            Map.entry(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE),
            Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
            Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE),

            Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
            Map.entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE),

            Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
            Map.entry(Blocks.END_STONE_BRICKS, Blocks.END_STONE),

            // Nether Bricks
            Map.entry(Blocks.NETHER_BRICKS, Blocks.RED_NETHER_BRICKS),
            Map.entry(Blocks.RED_NETHER_BRICKS, Blocks.NETHER_BRICKS),

            // Sandstone
            Map.entry(Blocks.SANDSTONE, Blocks.CUT_SANDSTONE),
            Map.entry(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE),

            Map.entry(Blocks.RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE),
            Map.entry(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE),

            // Prismarine
            Map.entry(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
            Map.entry(Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE),
            Map.entry(Blocks.DARK_PRISMARINE, Blocks.PRISMARINE),

            // Fluorite
            Map.entry(ModBlocks.FLUORITE_BLOCK, ModBlocks.RAW_FLUORITE_BLOCK),
            Map.entry(ModBlocks.RAW_FLUORITE_BLOCK, ModBlocks.FLUORITE_BLOCK)
    );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        var pos = context.getClickedPos();

        Block clickedBlock = level.getBlockState(pos).getBlock();

        if (!CHISEL_MAP.containsKey(clickedBlock)) {
            return InteractionResult.PASS;
        }

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        if (context.getPlayer() == null) {
            return InteractionResult.FAIL;
        }

        Block result = CHISEL_MAP.get(clickedBlock);
        level.setBlockAndUpdate(pos, result.defaultBlockState());

        context.getItemInHand().hurtAndBreak(
                1,
                context.getPlayer(),
                context.getHand()
        );

        return InteractionResult.SUCCESS;
    }
}
