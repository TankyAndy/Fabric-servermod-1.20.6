package net.andy.servermobs;

import net.andy.servermobs.block.ModBlocks;
import net.andy.servermobs.item.ModItems;
import net.andy.servermobs.entity.custom.ExplosiveArrowEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerMobs implements ModInitializer {
    public static final String MOD_ID = "servermobs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

//testing changes
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}