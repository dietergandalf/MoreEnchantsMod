package com.dietergandalf.moreenchants.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static com.dietergandalf.moreenchants.MoreEnchants.MOD_ID;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerWithItem( "ruby_block", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .requiresTool()
            .strength(5.0f, 6.0f)
            .sounds(BlockSoundGroup.METAL)
            .luminance((state) -> 2)),
            new Item.Settings().rarity(Rarity.RARE));

    public static final Block RUBY_ORE = registerWithItem("ruby_ore", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .requiresTool()
            .strength(3.0f, 5.0f)
            .sounds(BlockSoundGroup.STONE)),
            new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Block DEEPSLATE_RUBY_ORE = registerWithItem("deepslate_ruby_ore", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.RED)
            .requiresTool()
            .strength(4.0f, 6.0f)
            .sounds(BlockSoundGroup.DEEPSLATE)),
            new Item.Settings().rarity(Rarity.UNCOMMON));

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings));
        return registered;
    }
    public static void RegisterBlocks(){
    }
}
