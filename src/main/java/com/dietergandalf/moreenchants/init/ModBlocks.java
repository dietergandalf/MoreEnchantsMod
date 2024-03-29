package com.dietergandalf.moreenchants.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.dietergandalf.moreenchants.MoreEnchants.MOD_ID;

public class ModBlocks {

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL, MapColor.RED)
            .requiresTool()
            .strength(5.0f, 6.0f)
            .sounds(BlockSoundGroup.METAL)
            .luminance(2));

    public static final Block RUBY_ORE = new Block(FabricBlockSettings
            .of(Material.STONE, MapColor.RED)
            .requiresTool()
            .strength(3.0f, 5.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_RUBY_ORE = new Block(FabricBlockSettings
            .of(Material.STONE, MapColor.RED)
            .requiresTool()
            .strength(4.0f, 6.0f)
            .sounds(BlockSoundGroup.DEEPSLATE));

    public static void RegisterBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
    }
}
