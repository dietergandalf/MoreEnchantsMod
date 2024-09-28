package com.dietergandalf.moreenchants;

import com.dietergandalf.moreenchants.events.BreakBlockEvent;
import com.dietergandalf.moreenchants.events.TickHandler;
import com.dietergandalf.moreenchants.init.ModBlocks;
import com.dietergandalf.moreenchants.init.ModEnchantments;
import com.dietergandalf.moreenchants.init.ModItems;
import com.dietergandalf.moreenchants.world.ModConfiguredFeature;
import com.dietergandalf.moreenchants.world.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreEnchants implements ModInitializer {

    public static final String MOD_ID = "enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModConfiguredFeature.registerConfiguredFeatures();

        ModItems.RegisterItems();
        ModBlocks.RegisterBlocks();
        ModEnchantments.RegisterEnchantments();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.RUBY_SWORD);
            entries.add(ModItems.RUBY_HELMET);
            entries.add(ModItems.RUBY_CHESTPLATE);
            entries.add(ModItems.RUBY_LEGGINGS);
            entries.add(ModItems.RUBY_BOOTS);
            entries.add(ModItems.ELYTRA_ARMOR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
            entries.add(ModBlocks.RUBY_ORE);
            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.RUBY_PICKAXE);
            entries.add(ModItems.RUBY_AXE);
            entries.add(ModItems.RUBY_SHOVEL);
            entries.add(ModItems.RUBY_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RUBY);
        });

        ModOreGeneration.generateOres();

        ServerTickEvents.START_SERVER_TICK.register(new TickHandler());
        PlayerBlockBreakEvents.AFTER.register(new BreakBlockEvent());
        LOGGER.info("More Enchants has been initialized!");
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
