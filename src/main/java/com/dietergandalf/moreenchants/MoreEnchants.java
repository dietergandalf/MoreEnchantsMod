package com.dietergandalf.moreenchants;

import com.dietergandalf.moreenchants.events.BreakBlockEvent;
import com.dietergandalf.moreenchants.events.TickHandler;
import com.dietergandalf.moreenchants.init.ModBlocks;
import com.dietergandalf.moreenchants.init.ModEnchantments;
import com.dietergandalf.moreenchants.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreEnchants implements ModInitializer {

    public static final String MOD_ID = "enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "ruby_gen"));

    @Override
    public void onInitialize() {

        ModItems.RegisterItems();
        ModBlocks.RegisterBlocks();
        ModEnchantments.RegisterEnchantments();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);

        ServerTickEvents.START_SERVER_TICK.register(new TickHandler());
        PlayerBlockBreakEvents.AFTER.register(new BreakBlockEvent());

        LOGGER.debug(MOD_ID + " loaded.");
    }
}
