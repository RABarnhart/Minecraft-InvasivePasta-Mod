package com.ryan.pastamod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ryan.pastamod.Items.ModItems;
import com.ryan.pastamod.PastaMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        // List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
        //         ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DYEBRUSH.get(), 1)
                .pattern("F ")
                .pattern("S ")
                .define('F', Items.FEATHER)
                .define('S', Items.STICK)
                .unlockedBy("has_feather", has(Items.FEATHER))
                .save(pRecipeOutput);


        // Dyebrush dyeing recipes: any dyebrush + dye -> colored dyebrush
        // List of dye colors and their corresponding vanilla dye items
        var dyeBrushes = new Object[][] {
            {ModItems.DYEBRUSH_WHITE.get(), Items.WHITE_DYE, "white"},
            {ModItems.DYEBRUSH_RED.get(), Items.RED_DYE, "red"},
            {ModItems.DYEBRUSH_ORANGE.get(), Items.ORANGE_DYE, "orange"},
            {ModItems.DYEBRUSH_YELLOW.get(), Items.YELLOW_DYE, "yellow"},
            {ModItems.DYEBRUSH_LIME.get(), Items.LIME_DYE, "lime"},
            {ModItems.DYEBRUSH_GREEN.get(), Items.GREEN_DYE, "green"},
            {ModItems.DYEBRUSH_CYAN.get(), Items.CYAN_DYE, "cyan"},
            {ModItems.DYEBRUSH_LIGHT_BLUE.get(), Items.LIGHT_BLUE_DYE, "light_blue"},
            {ModItems.DYEBRUSH_BLUE.get(), Items.BLUE_DYE, "blue"},
            {ModItems.DYEBRUSH_PURPLE.get(), Items.PURPLE_DYE, "purple"},
            {ModItems.DYEBRUSH_MAGENTA.get(), Items.MAGENTA_DYE, "magenta"},
            {ModItems.DYEBRUSH_PINK.get(), Items.PINK_DYE, "pink"},
            {ModItems.DYEBRUSH_BROWN.get(), Items.BROWN_DYE, "brown"},
            {ModItems.DYEBRUSH_BLACK.get(), Items.BLACK_DYE, "black"},
            {ModItems.DYEBRUSH_GRAY.get(), Items.GRAY_DYE, "gray"},
            {ModItems.DYEBRUSH_LIGHT_GRAY.get(), Items.LIGHT_GRAY_DYE, "light_gray"}
        };
        for (Object[] entry : dyeBrushes) {
            String recipeName = "dyebrush_" + entry[2];
            if (recipeName.equals("dyebrush_white")) continue; // skip duplicate for base
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, (ItemLike)entry[0])
                .requires(com.ryan.pastamod.util.ModTags.Items.DYEBRUSHES)
                .requires((ItemLike)entry[1])
                .unlockedBy("has_dye", has((ItemLike)entry[1]))
                .save(pRecipeOutput); // Remove explicit save name
        }
    }

        // HELPER METHODS
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, PastaMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
