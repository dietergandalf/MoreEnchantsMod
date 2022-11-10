package com.dietergandalf.moreenchants.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public class BaseToolMaterial implements ToolMaterial {

    private final float attackDamageBonus, speed;
    private final int enchantability, harvestLevel, durability;
    private final Supplier<Ingredient> repairMaterial;

    public BaseToolMaterial(
            float attackDamageBonus,
            float speed,
            int enchantability,
            int harvestLevel,
            int durability,
            Supplier<Ingredient> repairMaterial
    ) {
        this.attackDamageBonus = attackDamageBonus;
        this.speed = speed;
        this.enchantability = enchantability;
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.speed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamageBonus;
    }

    @Override
    public int getMiningLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
