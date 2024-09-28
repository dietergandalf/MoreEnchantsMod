package com.dietergandalf.moreenchants.init.enums;

import com.dietergandalf.moreenchants.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public enum ToolMaterials implements ToolMaterial {
    RUBY_INFUSED_NETHERITE(
            5.5f,
            75f,
            2500,
            15,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            Ingredient.ofItems(ModItems.RUBY)
    );

    private final float attackDamage;
    private final float miningSpeed;
    private final int durability;
    private final int enchantability;
    private final TagKey<Block> inverseTag;
    private final Ingredient repairIngredient;

    ToolMaterials(float attackDamage, float miningSpeed, int durability, int enchantability, TagKey<Block> inverseTag, Ingredient repairIngredient) {
        this.attackDamage = attackDamage;
        this.miningSpeed = miningSpeed;
        this.durability = durability;
        this.enchantability = enchantability;
        this.inverseTag = inverseTag;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public ToolComponent createComponent(TagKey<Block> tag) {
        return ToolMaterial.super.createComponent(tag);
    }
}
