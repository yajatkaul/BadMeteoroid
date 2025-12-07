package com.github.yajatkaul.badmeteoroid.neoforge.datagen;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(arg, completableFuture);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AEItems.ENGINEERING_PROCESSOR_PRESS.get())
                .pattern("#d#")
                .pattern("pmp")
                .pattern("#p#")
                .define('#', Items.QUARTZ)
                .define('d', Items.DIAMOND)
                .define('m', Items.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .define('p', Items.IRON_INGOT)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AEBlocks.MYSTERIOUS_CUBE)
                .pattern("#d#")
                .pattern("pmp")
                .pattern("#p#")
                .define('#', AEBlocks.SKY_STONE_BLOCK)
                .define('d', Items.DIAMOND)
                .define('m', AEBlocks.CONTROLLER)
                .define('p', Items.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AEItems.CERTUS_QUARTZ_CRYSTAL.get(), 2)
                .requires(Items.AMETHYST_SHARD)
                .requires(Items.QUARTZ)
                .unlockedBy("has_amethyst", has(Items.AMETHYST_SHARD)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AEItems.SKY_DUST.get(), 4)
                .requires(Items.GUNPOWDER)
                .requires(Items.QUARTZ)
                .unlockedBy("has_quartz", has(Items.QUARTZ)).save(recipeOutput);
    }
}