package com.dietergandalf.moreenchants.events;

import com.dietergandalf.moreenchants.init.ModEnchantments;
import com.dietergandalf.moreenchants.util.util;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.ArrayList;

import static com.dietergandalf.moreenchants.util.util.*;


public class BreakBlockEvent implements PlayerBlockBreakEvents.After {

    @Override
    public void afterBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        int area_miner_lvl = EnchantmentHelper.getEquipmentLevel(ModEnchantments.AREA_MINER, player);
        int timber = EnchantmentHelper.getEquipmentLevel(ModEnchantments.TIMBER, player);
        if(area_miner_lvl > 0 && !player.isCreative() && player.getMainHandStack().isSuitableFor(state)){
            ArrayList<BlockPos> AdjacentBlocksList = new ArrayList<>();
            int area = 2;
            int height = 2;
            int floor = 1;
            if(area_miner_lvl == 1){
                area = 0;
                height = 1;
            } else if (area_miner_lvl == 2) {
                area = 1;
                height = 1;
            } else if (area_miner_lvl == 4) {
                area = 3;
                height = 3;
            } else if(area_miner_lvl == 5){
                area = 8;
                height = 5;
            }

            //Add all Blocks affected by area_miner
            for(int x = -area; x<=area; x++) {
                for (int y = -floor; y <= height; y++) {
                    for (int z = -area; z <= area; z++) {
                        if (!(x == 0 && y == 0 && z == 0)) {
                            AdjacentBlocksList.add(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                        }
                    }
                }
            }

            for (BlockPos blockPos : AdjacentBlocksList) {
                BlockState tmp_state = world.getBlockState(blockPos);
                if (player.getMainHandStack().getItem().isSuitableFor(tmp_state)) {
                    destroyBlockDropAtPlayer(world, blockPos, tmp_state, player, true);
                }
            }

        } else if (timber>0 && player.getMainHandStack().getItem().isSuitableFor(state)) {
            ArrayList<BlockPos> AdjacentBlocks = new ArrayList<>();
            ArrayList<util.Tuple> sapling_list = new ArrayList<>();
            getAdjacentTreeBlocks(AdjacentBlocks, sapling_list, world, pos, 0, 6000);
            print(Integer.toString(AdjacentBlocks.size()));
            for(BlockPos blockpos : AdjacentBlocks){
                destroyBlockDropAtPlayer(world, blockpos, world.getBlockState(blockpos), player, false);
            }
            for (Tuple tuple : sapling_list) {
                assert MinecraftClient.getInstance().player != null;
                world.setBlockState(tuple.pos, tuple.state, 11);
            }
        }

    }

    /*
     * Destroy the block and drop the block's drops

    private static void destroyBlock(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        int fortuneLvl = EnchantmentHelper.getEquipmentLevel(Enchantments.FORTUNE, player);
        int silktouch = EnchantmentHelper.getEquipmentLevel(Enchantments.SILK_TOUCH, player);
        world.breakBlock(pos, false, player, 11);
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);

        if(silktouch == 1){
            ItemStack itemStack = new ItemStack(state.getBlock(), 1);
            ItemEntity blockDrop = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);
            world.spawnEntity(blockDrop);
        }else{
            Block.getDroppedStacks(state, (ServerWorld) world, pos, null).forEach(itemStack -> {

                if(!itemStack.getItem().equals(state.getBlock().asItem())) {
                    itemStack.setCount(fortuneLvl + 1);
                }
                ItemEntity blockDrop = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);
                world.spawnEntity(blockDrop);

            });
        }
    }
    */

    /*
     * Destroy the block and drop the block's drops at the player
     */
    private static void destroyBlockDropAtPlayer(World world, BlockPos pos, BlockState state, PlayerEntity player, boolean standard) {
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
                }else if(itemStack.getItem().equals(state.getBlock().asItem())){
                    itemStack.setCount(fortuneLvl+1);
                }
                ItemEntity blockDrop = new ItemEntity(world, player.getBlockX()+ 0.5, player.getBlockY() + 0.5, player.getBlockZ() + 0.5, itemStack);
                world.spawnEntity(blockDrop);

            });
        }
    }

    public static void getAdjacentTreeBlocks(ArrayList<BlockPos> list, ArrayList<util.Tuple> sapling_list, World world, BlockPos pos, int curDepth, int maxDepth){
        if(curDepth>maxDepth)return;
        list.add(pos);
        BlockState state = world.getBlockState(pos);
        if(checkDirt(world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ())).getBlock()) && checkLog(state.getBlock())){
            String name = world.getBlockState(pos).getBlock().getName().toString();
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
