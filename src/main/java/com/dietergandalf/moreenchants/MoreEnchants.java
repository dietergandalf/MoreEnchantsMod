package com.dietergandalf.moreenchants;

import com.dietergandalf.moreenchants.events.BreakBlockEvent;
import com.dietergandalf.moreenchants.events.TickHandler;
import com.dietergandalf.moreenchants.init.ModBlocks;
import com.dietergandalf.moreenchants.init.ModEnchantments;
import com.dietergandalf.moreenchants.init.ModItems;
import com.dietergandalf.moreenchants.world.ModConfiguredFeature;
import com.dietergandalf.moreenchants.world.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreEnchants implements ModInitializer {

    public static final String MOD_ID = "enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModConfiguredFeature.registerConfiguredFeatures();

        ModItems.RegisterItems();
        ModBlocks.RegisterBlocks();
        ModEnchantments.RegisterEnchantments();

        ModOreGeneration.generateOres();

        ServerTickEvents.START_SERVER_TICK.register(new TickHandler());
        PlayerBlockBreakEvents.AFTER.register(new BreakBlockEvent());
    }
}
