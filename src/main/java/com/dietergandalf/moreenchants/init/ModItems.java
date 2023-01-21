package com.dietergandalf.moreenchants.init;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

import static com.dietergandalf.moreenchants.MoreEnchants.MOD_ID;


public class ModItems {

    //Items
    public static final Item RUBY = new Item(new FabricItemSettings().rarity(Rarity.RARE));

    //Tools
    public static final PickaxeItem RUBY_PICKAXE = new ModPickaxeItem(ToolMaterials.RUBY_INFUSED_NETHERITE, 7, 1.5f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final AxeItem RUBY_AXE = new ModAxeItem(ToolMaterials.RUBY_INFUSED_NETHERITE, 11, 3f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final ShovelItem RUBY_SHOVEL = new ModShovelItem(ToolMaterials.RUBY_INFUSED_NETHERITE, 6, 1.3f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final HoeItem RUBY_HOE = new ModHoeItem(ToolMaterials.RUBY_INFUSED_NETHERITE, 5, 1, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final SwordItem RUBY_SWORD = new SwordItem(ToolMaterials.RUBY_INFUSED_NETHERITE,9, 1.25f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

    //Armor
    public static final ArmorItem RUBY_HELMET = new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE, EquipmentSlot.HEAD, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final ArmorItem RUBY_CHESTPLATE = new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final ArmorItem RUBY_LEGGINGS = new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE, EquipmentSlot.LEGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final ArmorItem RUBY_BOOTS = new ArmorItem(ArmorMaterials.RUBY_INFUSED_NETHERITE, EquipmentSlot.FEET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
    public static final ElytraItem ELYTRA_ARMOR = new ElytraItem(ArmorMaterials.RUBY_INFUSED_NETHERITE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

    //Blocks
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new FabricItemSettings().rarity(Rarity.RARE));
    public static final BlockItem RUBY_ORE = new BlockItem(ModBlocks.RUBY_ORE, new FabricItemSettings().rarity(Rarity.UNCOMMON));
    public static final BlockItem DEEPSLATE_RUBY_ORE = new BlockItem(ModBlocks.DEEPSLATE_RUBY_ORE, new FabricItemSettings().rarity(Rarity.UNCOMMON));




    public static void RegisterItems(){
        //Items
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby"), RUBY);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(RUBY);
        });

        //Tools
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_axe"), RUBY_AXE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_hoe"), RUBY_HOE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_sword"), RUBY_SWORD);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            List<Item> tools = List.of(RUBY_SHOVEL, RUBY_PICKAXE, RUBY_AXE, RUBY_HOE);
            for (Item item: tools
            ) {
                content.add(item);
            }
        });

        //Armor
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_boots"), RUBY_BOOTS);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "elytra_armor"), ELYTRA_ARMOR);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            List<Item> combat = List.of(RUBY_SWORD, RUBY_HELMET, RUBY_CHESTPLATE, ELYTRA_ARMOR, RUBY_LEGGINGS, RUBY_BOOTS);
            for (Item item: combat
                 ) {
                content.add(item);
            }
        });

        //Blocks
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(RUBY_ORE);
            content.add(DEEPSLATE_RUBY_ORE);
            content.add(RUBY_BLOCK);
        });


    }
}

