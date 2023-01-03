package com.dietergandalf.moreenchants.events;

import com.dietergandalf.moreenchants.init.ModEnchantments;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.List;

public class TickHandler implements ServerTickEvents.StartTick {
    @Override
    public void onStartTick(MinecraftServer server) {
        List<ServerPlayerEntity> server_players = server.getPlayerManager().getPlayerList();
        for(ServerPlayerEntity server_player : server_players) {
                PlayerEntity player = server_player.getInventory().player;
                if(EnchantmentHelper.getEquipmentLevel(ModEnchantments.FIREMASTER, player) > 0){
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 1));
            }
        }
    }
}
