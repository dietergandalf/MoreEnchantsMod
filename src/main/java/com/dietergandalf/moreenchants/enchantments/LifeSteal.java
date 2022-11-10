package com.dietergandalf.moreenchants.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LifeSteal extends Enchantment {
    public LifeSteal() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.getWorld().isClient()){
            user.heal((float)level);
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel(){
        return 5;
    }
}
