package com.dietergandalf.moreenchants.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

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
            Blocks.WARPED_STEM, Blocks.WARPED_WART_BLOCK,
            Blocks.SHROOMLIGHT
            );

    public static final List<BlockState> SAPLINGS = List.of(Blocks.OAK_SAPLING.getDefaultState(),
            Blocks.DARK_OAK_SAPLING.getDefaultState(), Blocks.SPRUCE_SAPLING.getDefaultState(),
            Blocks.ACACIA_SAPLING.getDefaultState(), Blocks.JUNGLE_SAPLING.getDefaultState(),
            Blocks.BIRCH_SAPLING.getDefaultState(),
            Blocks.CRIMSON_FUNGUS.getDefaultState(), Blocks.WARPED_FUNGUS.getDefaultState());

    public static final List<Block> LEAVES = List.of(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK,
        Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES, Blocks.JUNGLE_LEAVES);

    public static final List<Block> DIRT_VARIANT = List.of(Blocks.DIRT, Blocks.GRASS, Blocks.PODZOL);
    public static final List<Block> NETHERRACK_VARIANTS = List.of(Blocks.NETHERRACK, Blocks.WARPED_NYLIUM, Blocks.CRIMSON_NYLIUM);

    public static boolean checkLeave(Block block) { return LEAVES.contains(block); }
    public static boolean checkTree(Block block){
        return TREE_BLOCKS.contains(block);
    }
    public static boolean checkDirt(Block block) { return DIRT_VARIANT.contains(block); }
    public static boolean checkNetherrack(Block block) { return NETHERRACK_VARIANTS.contains(block); }

    public static BlockState getSapling(String name){
        String s = name.substring(33, name.length()-15);
        for(BlockState state : SAPLINGS){
            if(state.getBlock().toString().contains(s)){
                return state;
            }
        }
        return null;
    }

    public static void print(String msg){
        assert MinecraftClient.getInstance().player != null;
        MinecraftClient.getInstance().player.sendChatMessage(msg,null);
    }

    public static class Tuple{
        public BlockPos pos;
        public BlockState state;

        public Tuple(BlockPos pos, BlockState state) {
            this.pos = pos;
            this.state = state;
        }
    }


}
