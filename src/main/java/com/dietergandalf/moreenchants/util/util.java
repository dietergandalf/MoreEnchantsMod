package com.dietergandalf.moreenchants.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.List;

public class util {
    public static final List<Block> TREE_BLOCKS = List.of(
            Blocks.OAK_LOG, Blocks.OAK_LEAVES,
            Blocks.SPRUCE_LOG, Blocks.SPRUCE_LEAVES,
            Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES,
            Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES,
            Blocks.ACACIA_LOG, Blocks.ACACIA_LEAVES,
            Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES,
            Blocks.CRIMSON_STEM, Blocks.NETHER_WART_BLOCK,
            Blocks.WARPED_STEM, Blocks.WARPED_WART_BLOCK
            );

    public static boolean checkTree(Block block){
        return TREE_BLOCKS.contains(block);
    }
}
