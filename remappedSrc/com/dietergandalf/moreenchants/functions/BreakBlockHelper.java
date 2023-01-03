package com.dietergandalf.moreenchants.functions;

import com.dietergandalf.moreenchants.util.util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;

import static com.dietergandalf.moreenchants.util.util.*;



public class BreakBlockHelper {

    /*
     * Destroy the block and drop the block's drops at the player
     */
    public static void destroyBlockDropAtPlayer(World world, BlockPos pos, BlockState state, PlayerEntity player, boolean standard) {
        int fortuneLvl = EnchantmentHelper.getEquipmentLevel(Enchantments.FORTUNE, player);
        int silktouch = EnchantmentHelper.getEquipmentLevel(Enchantments.SILK_TOUCH, player);

        if(world.getBlockState(pos).getBlock().toString().contains("shulker"))return;
        world.breakBlock(pos, false, player, 11);
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);

        if(silktouch == 1){
            ItemStack itemStack = new ItemStack(state.getBlock(), 1);
            ItemEntity blockDrop = new ItemEntity(world, player.getBlockX()+ 0.5, player.getBlockY() + 0.5, player.getBlockZ() + 0.5, itemStack);
            world.spawnEntity(blockDrop);
        }else{
            Block.getDroppedStacks(state, (ServerWorld) world, pos, null).forEach(itemStack -> {

                if(!standard && !itemStack.getItem().equals(state.getBlock().asItem())) {
                    itemStack.setCount(fortuneLvl + 1);
                }else if(checkLeave(state.getBlock())){
                    int i = Random.create().nextBetween(0, 3);
                    if(i != 0){itemStack = null;}
                }else if(itemStack.getItem().equals(state.getBlock().asItem())){
                    itemStack.setCount(fortuneLvl+1);
                }
                if(!(itemStack == null)) {
                    ItemEntity blockDrop = new ItemEntity(world, player.getBlockX() + 0.5, player.getBlockY() + 0.5, player.getBlockZ() + 0.5, itemStack);
                    world.spawnEntity(blockDrop);
                }
            });
        }
    }

    public static void getAdjacentTreeBlocks(ArrayList<BlockPos> list, ArrayList<util.Tuple> sapling_list, World world, BlockPos pos, int curDepth, int maxDepth){
        if(curDepth>maxDepth)return;
        list.add(pos);
        String name = world.getBlockState(pos).getBlock().getName().toString();
        if(name.contains("log") && checkDirt(world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ())).getBlock()) ||
                name.contains("stem") && checkNetherrack(world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ())).getBlock())) {
            BlockState sapling = getSapling(name);
            util.Tuple t = new util.Tuple(pos, sapling);
            sapling_list.add(t);

        }
        for (int i = -1; i <= 1; i++) {
            for (int k = -1; k <= 1; k++) {
                for (int j = -1; j <= 1; j++) {
                    BlockPos tmpPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
                    BlockState blockState = world.getBlockState(tmpPos);
                    if (checkTree(blockState.getBlock()) && !list.contains(tmpPos)) {
                        getAdjacentTreeBlocks(list, sapling_list, world, tmpPos, curDepth+1, maxDepth);
                    }
                }
            }
        }
    }
}
