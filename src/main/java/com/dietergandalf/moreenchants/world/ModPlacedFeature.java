package com.dietergandalf.moreenchants.world;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeature {
    public static final RegistryEntry<PlacedFeature> RUBY_ORE_PLACED = PlacedFeatures.register(
            "ruby_ore_placed", ModConfiguredFeature.RUBY_ORE, modifiersWithCount(
                    1,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-60), YOffset.fixed(10))));



    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier){
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier){
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier){
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
