package com.dietergandalf.moreenchants.init;


import com.dietergandalf.moreenchants.init.ArmorMaterials;
import com.dietergandalf.moreenchants.init.enums.ToolMaterials;
import com.dietergandalf.moreenchants.MoreEnchants;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {

    //Items
    public static final Item RUBY = register("ruby", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item RUBY_UPGRADE_KIT = register("ruby_upgrade_kit", SmithingTemplateItem.of(Identifier.of(MoreEnchants.MOD_ID, "ruby_upgrade_kit")));

    //Tools
    public static final PickaxeItem RUBY_PICKAXE = register("ruby_pickaxe", new ModPickaxeItem(ToolMaterials.RUBY_INFUSED_NETHERITE,
            new Item.Settings().fireproof().rarity(Rarity.EPIC)));
    public static final AxeItem RUBY_AXE = register("ruby_axe", new ModAxeItem(ToolMaterials.RUBY_INFUSED_NETHERITE,
            new Item.Settings().fireproof().rarity(Rarity.EPIC)));
    public static final ShovelItem RUBY_SHOVEL = register("ruby_shovel", new ModShovelItem(ToolMaterials.RUBY_INFUSED_NETHERITE,
            new Item.Settings().fireproof().rarity(Rarity.EPIC)));
    public static final HoeItem RUBY_HOE = register("ruby_hoe", new ModHoeItem(ToolMaterials.RUBY_INFUSED_NETHERITE,
            new Item.Settings().fireproof().rarity(Rarity.EPIC)));
    public static final SwordItem RUBY_SWORD = register("ruby_sword", new SwordItem(ToolMaterials.RUBY_INFUSED_NETHERITE,
            new Item.Settings().fireproof().rarity(Rarity.EPIC)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.RUBY_INFUSED_NETHERITE, 9, 1.2f))));

    //Armor
    public static final ArmorItem RUBY_HELMET = register("ruby_helmet", new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE,
            ArmorItem.Type.HELMET, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(60))));
    public static final ArmorItem RUBY_CHESTPLATE = register("ruby_chestplate", new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(60))));
    public static final ArmorItem RUBY_LEGGINGS = register("ruby_leggings", new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE,
            ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(60))));
    public static final ArmorItem RUBY_BOOTS = register("ruby_boots", new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE,
            ArmorItem.Type.BOOTS, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(60))));
    public static final ElytraItem ELYTRA_ARMOR = register("elytra_armor", new ElytraItem(ArmorMaterials.RUBY_INFUSED_NETHERITE,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(60))));


    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, MoreEnchants.id(name), item);
    }
    public static void RegisterItems(){}
}

