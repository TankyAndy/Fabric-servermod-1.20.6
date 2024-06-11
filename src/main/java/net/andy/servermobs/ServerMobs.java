package net.andy.servermobs;

import net.andy.servermobs.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerMobs implements ModInitializer {
    public static final String MOD_ID = "servermobs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//testing changes
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}