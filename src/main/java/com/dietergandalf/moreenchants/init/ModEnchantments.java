package com.dietergandalf.moreenchants.init;

import com.dietergandalf.moreenchants.enchantments.AreaMiner;
import com.dietergandalf.moreenchants.enchantments.FireMaster;
import com.dietergandalf.moreenchants.enchantments.LifeSteal;
import com.dietergandalf.moreenchants.enchantments.Timber;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.dietergandalf.moreenchants.MoreEnchants.MOD_ID;

public class ModEnchantments {

    public static Enchantment AREA_MINER = new AreaMiner();
    public static Enchantment FIREMASTER = new FireMaster();
    public static Enchantment LIFESTEAL = new LifeSteal();
    public static Enchantment TIMBER = new Timber();


    public static void RegisterEnchantments(){
        Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "area_miner"), AREA_MINER);
        Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "firemaster"), FIREMASTER);
        Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "lifesteal"), LIFESTEAL);
        Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "timber"), TIMBER);
    }
}
