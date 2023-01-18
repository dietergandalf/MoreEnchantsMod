package com.dietergandalf.moreenchants.world;

import com.dietergandalf.moreenchants.MoreEnchants;
import com.dietergandalf.moreenchants.init.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

import static com.dietergandalf.moreenchants.MoreEnchants.MOD_ID;

public class ModConfiguredFeature {
    public static final List<OreFeatureConfig.Target> OVERWORLD_RUBY_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> RUBY_ORE = ConfiguredFeatures
            .register("ruby_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 2));

    public static void registerConfiguredFeatures(){
        MoreEnchants.LOGGER.debug("Registering the ModConfiguredFeatures for " + MOD_ID);
    }
}
