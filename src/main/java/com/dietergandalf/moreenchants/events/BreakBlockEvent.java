package com.dietergandalf.moreenchants.events;

import com.dietergandalf.moreenchants.init.ModEnchantments;
import com.dietergandalf.moreenchants.util.util;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.ArrayList;

import static com.dietergandalf.moreenchants.functions.BreakBlockHelper.destroyBlockDropAtPlayer;
import static com.dietergandalf.moreenchants.functions.BreakBlockHelper.getAdjacentTreeBlocks;
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
        }

        if (timber>0 && player.getMainHandStack().getItem().isSuitableFor(state)) {
            ArrayList<BlockPos> AdjacentBlocks = new ArrayList<>();
            ArrayList<util.Tuple> sapling_list = new ArrayList<>();
            getAdjacentTreeBlocks(AdjacentBlocks, sapling_list, world, pos, 0, 6000);
            for(BlockPos blockpos : AdjacentBlocks){
                destroyBlockDropAtPlayer(world, blockpos, world.getBlockState(blockpos), player, false);
            }
            for (Tuple tuple : sapling_list) {
                assert MinecraftClient.getInstance().player != null;
                world.setBlockState(tuple.pos, tuple.state, 11);
            }
        }

    }

}

