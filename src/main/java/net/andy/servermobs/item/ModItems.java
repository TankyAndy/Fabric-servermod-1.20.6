package net.andy.servermobs.item;

import net.andy.servermobs.ServerMobs;
import net.andy.servermobs.item.custom.FlashlightItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FLASHLIGHTBETA = registerItem("flashlightbeta", new Item(new Item.Settings()));
    public static final Item FLASHLIGHT = registerItem("flashlight", new FlashlightItem(new Item.Settings()));
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FLASHLIGHTBETA);
        entries.add(FLASHLIGHT);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ServerMobs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ServerMobs.LOGGER.info("Registering Mod Items for " + ServerMobs.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
