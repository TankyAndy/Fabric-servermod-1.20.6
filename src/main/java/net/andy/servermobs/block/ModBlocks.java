package net.andy.servermobs.block;

import net.andy.servermobs.ServerMobs;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GALVANIZED_SQUARE_STEEL = registerBlock("galvanized_square_steel", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).resistance(500.0f).sounds(BlockSoundGroup.ANVIL)));
    public static final Block GALVANIZED_SQUARE_STEEL_BLOCK = registerBlock("galvanized_square_steel_block", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).resistance(500.0f).sounds(BlockSoundGroup.ANVIL)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ServerMobs.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ServerMobs.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks () {
        ServerMobs.LOGGER.info("Registering ModBlocks for " + ServerMobs.MOD_ID);
    }
}

