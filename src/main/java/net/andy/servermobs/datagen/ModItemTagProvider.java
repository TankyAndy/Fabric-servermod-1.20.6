package net.andy.servermobs.datagen;

import net.andy.servermobs.block.ModBlocks;
import net.andy.servermobs.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        /*
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.GALVANIZED_SQUARE_STEEL.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModItems.GALVANIZED_STEEL_SHEET.asItem());

         */
    }

    }


