package com.dietergandalf.moreenchants.init;

import com.dietergandalf.moreenchants.materials.BaseArmorMaterials;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;


public final class ArmorMaterials {
    public static final ArmorMaterial RUBY_INFUSED_NETHERITE = new BaseArmorMaterials(
            500,
            new int[]{1400, 1800, 1600, 1400},
            new int[]{14, 18, 16, 14},
            12.0f,
            0.5f,
            "ruby_netherite",
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.RUBY));
}
