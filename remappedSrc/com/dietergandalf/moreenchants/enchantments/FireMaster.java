package com.dietergandalf.moreenchants.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;


public class FireMaster extends Enchantment {

    public FireMaster() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    @Override
    public int getMaxLevel(){
        return 1;
    }
}
