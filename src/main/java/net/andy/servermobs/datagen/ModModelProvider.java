package net.andy.servermobs.datagen;

import net.andy.servermobs.block.ModBlocks;
import net.andy.servermobs.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.GALVANIZED_SQUARE_STEEL).log(ModBlocks.GALVANIZED_SQUARE_STEEL).wood(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GUNTEST, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLASHLIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLASHLIGHTBETA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GALVANIZED_STEEL_SHEET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GALVANIZED_STEEL_BAR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FAULTYROCKETLAUNCHER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FAULTYROCKETLAUNCHER_WORLD_ENDER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FAULTYROCKETLAUNCHER_NUCLEAR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FAULTYGRENADELAUNCHER, Models.HANDHELD);



    }
}
