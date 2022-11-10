package com.dietergandalf.moreenchants;

import com.dietergandalf.moreenchants.events.BreakBlockEvent;
import com.dietergandalf.moreenchants.events.TickHandler;
import com.dietergandalf.moreenchants.init.ModBlocks;
import com.dietergandalf.moreenchants.init.ModEnchantments;
import com.dietergandalf.moreenchants.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class MoreEnchants implements ModInitializer {

    public static final String MOD_ID = "enchants";

    @Override
    public void onInitialize() {
        ModItems.RegisterItems();
        ModBlocks.RegisterBlocks();
        ModEnchantments.RegisterEnchantments();
        ServerTickEvents.START_SERVER_TICK.register(new TickHandler());
        PlayerBlockBreakEvents.AFTER.register(new BreakBlockEvent());
    }
}
