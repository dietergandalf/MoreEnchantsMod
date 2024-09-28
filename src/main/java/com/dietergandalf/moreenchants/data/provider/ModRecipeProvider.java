package com.dietergandalf.moreenchants.data.provider;

import com.dietergandalf.moreenchants.init.ModBlocks;
import com.dietergandalf.moreenchants.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK)
                .input('#', ModItems.RUBY)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        List<ItemConvertible> RubyOres = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
        RecipeProvider.offerBlasting(exporter, RubyOres, RecipeCategory.MISC, ModItems.RUBY, 2, 200, "ruby_ore_smelting");
        RecipeProvider.offerSmelting(exporter, RubyOres, RecipeCategory.MISC, ModItems.RUBY, 2, 200, "ruby_ore_smelting");

        RecipeProvider.offerSmithingTemplateCopyingRecipe();
    }
}
