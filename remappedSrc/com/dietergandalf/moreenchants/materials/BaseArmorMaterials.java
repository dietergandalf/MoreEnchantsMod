package com.dietergandalf.moreenchants.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.function.Supplier;

public class BaseArmorMaterials implements ArmorMaterial {

    private final int enchantability;
    private final int[] durability, damageReduction;
    private final float toughness, knockbackResistance;
    private final String name;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairMaterial;


    public BaseArmorMaterials(
            int enchantability,
            int[] durability,
            int[] damageReduction,
            float toughness,
            float knockbackResistance,
            String name,
            SoundEvent equipSound,
            Supplier<Ingredient> repairMaterial
    ) {
        this.enchantability = enchantability;
        this.durability = durability;
        this.damageReduction = damageReduction;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.name = name;
        this.equipSound = equipSound;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return this.durability[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.damageReduction[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
