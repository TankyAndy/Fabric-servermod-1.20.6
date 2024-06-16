package net.andy.servermobs.datagen;

import net.andy.servermobs.block.ModBlocks;
import net.andy.servermobs.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GALVANIZED_STEEL_SHEET, 1)
                .pattern("III")
                .pattern("ICI")
                .pattern("III")
                .input('I', Items.IRON_INGOT)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GALVANIZED_STEEL_SHEET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GALVANIZED_SQUARE_STEEL, 1)
                .pattern("GGG")
                .pattern("G G")
                .pattern("GGG")
                .input('G', ModItems.GALVANIZED_STEEL_SHEET)
                .criterion(hasItem(ModItems.GALVANIZED_STEEL_SHEET), conditionsFromItem(ModItems.GALVANIZED_STEEL_SHEET))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GALVANIZED_SQUARE_STEEL)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GALVANIZED_STEEL_BAR, 1)
                .pattern(" O ")
                .pattern(" O ")
                .pattern(" O ")
                .input('O', ModBlocks.GALVANIZED_SQUARE_STEEL)
                .criterion(hasItem(ModBlocks.GALVANIZED_SQUARE_STEEL), conditionsFromItem(ModBlocks.GALVANIZED_SQUARE_STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GALVANIZED_STEEL_BAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FAULTYGRENADELAUNCHER, 4)
                .pattern("IGI")
                .pattern("SGS")
                .pattern("SGS")
                .input('G', Items.GUNPOWDER)
                .input('S', ModItems.GALVANIZED_STEEL_SHEET)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.GALVANIZED_STEEL_SHEET), conditionsFromItem(ModItems.GALVANIZED_STEEL_SHEET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FAULTYGRENADELAUNCHER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FAULTYROCKETLAUNCHER, 2)
                .pattern("SGS")
                .pattern("SGS")
                .pattern("SKS")
                .input('G', Items.GUNPOWDER)
                .input('S', ModItems.GALVANIZED_STEEL_SHEET)
                .input('K', ModBlocks.GALVANIZED_SQUARE_STEEL)
                .criterion(hasItem(ModItems.GALVANIZED_STEEL_SHEET), conditionsFromItem(ModItems.GALVANIZED_STEEL_SHEET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FAULTYROCKETLAUNCHER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FAULTYROCKETLAUNCHER_NUCLEAR, 1)
                .pattern("LKL")
                .pattern("LKL")
                .pattern("NNN")
                .input('N', Blocks.NETHERITE_BLOCK)
                .input('L', Items.NETHERITE_INGOT)
                .input('K', Items.NETHER_STAR)
                .criterion(hasItem(Blocks.NETHERITE_BLOCK), conditionsFromItem(Blocks.NETHERITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FAULTYROCKETLAUNCHER_NUCLEAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FAULTYROCKETLAUNCHER_WORLD_ENDER, 1)
                .pattern("SDS")
                .pattern("SDS")
                .pattern("NDN")
                .input('N', Blocks.NETHERITE_BLOCK)
                .input('D', Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .input('S', Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .criterion(hasItem(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FAULTYROCKETLAUNCHER_WORLD_ENDER)));


    }

}
