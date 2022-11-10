package com.dietergandalf.moreenchants.init;

import com.dietergandalf.moreenchants.materials.BaseToolMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public final class ToolMaterials {

    private ToolMaterials(){}

    public static final ToolMaterial RUBY_INFUSED_NETHERITE = new BaseToolMaterial(
            5.5f, 75f, 100, 7, 2500,
            () -> Ingredient.ofItems(ModItems.RUBY));

}
