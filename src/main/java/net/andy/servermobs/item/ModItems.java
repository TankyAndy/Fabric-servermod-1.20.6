package net.andy.servermobs.item;

import net.andy.servermobs.ServerMobs;
import net.andy.servermobs.block.ModBlocks;
import net.andy.servermobs.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class ModItems {
    public static final Item FLASHLIGHTBETA = registerItem("flashlightbeta", new Item(new Item.Settings()));
    public static final Item FLASHLIGHT = registerItem("flashlight", new FlashlightItem(new Item.Settings()));
    public static final Item GUNTEST = registerItem("guntest", new Guntest(new RangedWeaponItem.Settings()));
    public static final Item GALVANIZED_STEEL_SHEET = registerItem("galvanized_steel_sheet", new Item(new Item.Settings()));
    public static final Item GALVANIZED_STEEL_BAR = registerItem("galvanized_steel_bar", new GalvanizedSteelBar(ToolMaterials.DIAMOND, 50, -5, 0.5f, 0, new Item.Settings()));
    public static final Item FAULTYROCKETLAUNCHER = registerItem("faulty_rocket_launcher", new FaultyRocketLauncher(new RangedWeaponItem.Settings()));
    public static final Item FAULTYROCKETLAUNCHER_WORLD_ENDER = registerItem("faulty_rocket_launcher_wd", new FaultyRocketLauncherWorldEnder(new RangedWeaponItem.Settings()));
    public static final Item FAULTYGRENADELAUNCHER = registerItem("faulty_grenade_launcher", new FaultyGrenadeLauncher(new RangedWeaponItem.Settings()));
    public static final Item FAULTYROCKETLAUNCHER_NUCLEAR = registerItem("faulty_rocket_launcher_nuclear", new FaultyRocketLauncherNuclear(new RangedWeaponItem.Settings()));




    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FLASHLIGHTBETA);
        entries.add(FLASHLIGHT);
        entries.add(ModBlocks.GALVANIZED_SQUARE_STEEL);
        entries.add(GALVANIZED_STEEL_SHEET);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(GALVANIZED_STEEL_BAR);
        entries.add(FAULTYROCKETLAUNCHER);
        entries.add(FAULTYROCKETLAUNCHER_WORLD_ENDER);
        entries.add(GUNTEST);
        entries.add(FAULTYGRENADELAUNCHER);
        entries.add(FAULTYROCKETLAUNCHER_NUCLEAR);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ServerMobs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ServerMobs.LOGGER.info("Registering Mod Items for " + ServerMobs.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
