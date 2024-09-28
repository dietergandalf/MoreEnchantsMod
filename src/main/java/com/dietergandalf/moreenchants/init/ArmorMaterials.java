package com.dietergandalf.moreenchants.init;

import com.dietergandalf.moreenchants.MoreEnchants;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public final class ArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> RUBY_INFUSED_NETHERITE = register("ruby_netherite", Map.of(
            ArmorItem.Type.HELMET, 14,
            ArmorItem.Type.CHESTPLATE, 18,
            ArmorItem.Type.LEGGINGS, 16,
            ArmorItem.Type.BOOTS, 14
    ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.RUBY),
            0.5f,
            0.5f,
            false
            );

    public static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defensePoints,
                                                        int enchantability, RegistryEntry<SoundEvent> equipSound,
                                                        Supplier<Ingredient> repairIngredient, float toughness,
                                                        float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(MoreEnchants.id(id), "", dyeable)
        );
        var material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, MoreEnchants.id(id), material);

        return RegistryEntry.of(material);
    }

}
