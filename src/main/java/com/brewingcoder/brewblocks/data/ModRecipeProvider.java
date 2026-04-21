package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public final class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {
        // Abyssal family
        chain(out,
                ModBlocks.ABYSSAL_COBBLE.get(),
                ModBlocks.ABYSSAL.get(),
                ModBlocks.ABYSSAL_SMOOTH.get(),
                ModBlocks.ABYSSAL_BRICKS.get(),
                ModBlocks.ABYSSAL_BRICKS_CRACKED.get());

        variants(out, ModBlocks.ABYSSAL.get(),
                ModBlocks.ABYSSAL_STAIRS.get(), ModBlocks.ABYSSAL_SLAB.get(), ModBlocks.ABYSSAL_WALL.get(),
                ModBlocks.ABYSSAL_FENCE.get(), ModBlocks.ABYSSAL_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_BUTTON.get(), ModBlocks.ABYSSAL_PRESSURE_PLATE.get());
        variants(out, ModBlocks.ABYSSAL_BRICKS.get(),
                ModBlocks.ABYSSAL_BRICK_STAIRS.get(), ModBlocks.ABYSSAL_BRICK_SLAB.get(), ModBlocks.ABYSSAL_BRICK_WALL.get(),
                ModBlocks.ABYSSAL_BRICK_FENCE.get(), ModBlocks.ABYSSAL_BRICK_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_BRICK_BUTTON.get(), ModBlocks.ABYSSAL_BRICK_PRESSURE_PLATE.get());
        variants(out, ModBlocks.ABYSSAL_BRICKS_CRACKED.get(),
                ModBlocks.ABYSSAL_BRICK_CRACKED_STAIRS.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_SLAB.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_WALL.get(),
                ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_BRICK_CRACKED_BUTTON.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_PRESSURE_PLATE.get());
        variants(out, ModBlocks.ABYSSAL_COBBLE.get(),
                ModBlocks.ABYSSAL_COBBLE_STAIRS.get(), ModBlocks.ABYSSAL_COBBLE_SLAB.get(), ModBlocks.ABYSSAL_COBBLE_WALL.get(),
                ModBlocks.ABYSSAL_COBBLE_FENCE.get(), ModBlocks.ABYSSAL_COBBLE_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_COBBLE_BUTTON.get(), ModBlocks.ABYSSAL_COBBLE_PRESSURE_PLATE.get());
        variants(out, ModBlocks.ABYSSAL_SMOOTH.get(),
                ModBlocks.ABYSSAL_SMOOTH_STAIRS.get(), ModBlocks.ABYSSAL_SMOOTH_SLAB.get(), ModBlocks.ABYSSAL_SMOOTH_WALL.get(),
                ModBlocks.ABYSSAL_SMOOTH_FENCE.get(), ModBlocks.ABYSSAL_SMOOTH_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_SMOOTH_BUTTON.get(), ModBlocks.ABYSSAL_SMOOTH_PRESSURE_PLATE.get());

        // Quarried family
        chain(out,
                ModBlocks.QUARRIED_COBBLE.get(),
                ModBlocks.QUARRIED.get(),
                ModBlocks.QUARRIED_SMOOTH.get(),
                ModBlocks.QUARRIED_BRICKS.get(),
                ModBlocks.QUARRIED_BRICKS_CRACKED.get());

        variants(out, ModBlocks.QUARRIED.get(),
                ModBlocks.QUARRIED_STAIRS.get(), ModBlocks.QUARRIED_SLAB.get(), ModBlocks.QUARRIED_WALL.get(),
                ModBlocks.QUARRIED_FENCE.get(), ModBlocks.QUARRIED_FENCE_GATE.get(),
                ModBlocks.QUARRIED_BUTTON.get(), ModBlocks.QUARRIED_PRESSURE_PLATE.get());
        variants(out, ModBlocks.QUARRIED_BRICKS.get(),
                ModBlocks.QUARRIED_BRICKS_STAIRS.get(), ModBlocks.QUARRIED_BRICKS_SLAB.get(), ModBlocks.QUARRIED_BRICKS_WALL.get(),
                ModBlocks.QUARRIED_BRICKS_FENCE.get(), ModBlocks.QUARRIED_BRICKS_FENCE_GATE.get(),
                ModBlocks.QUARRIED_BRICKS_BUTTON.get(), ModBlocks.QUARRIED_BRICKS_PRESSURE_PLATE.get());
        variants(out, ModBlocks.QUARRIED_BRICKS_CRACKED.get(),
                ModBlocks.QUARRIED_BRICKS_CRACKED_STAIRS.get(), ModBlocks.QUARRIED_BRICKS_CRACKED_SLAB.get(), ModBlocks.QUARRIED_BRICKS_CRACKED_WALL.get(),
                ModBlocks.QUARRIED_BRICKS_CRACKED_FENCE.get(), ModBlocks.QUARRIED_BRICKS_CRACKED_FENCE_GATE.get(),
                ModBlocks.QUARRIED_BRICKS_CRACKED_BUTTON.get(), ModBlocks.QUARRIED_BRICKS_CRACKED_PRESSURE_PLATE.get());
        variants(out, ModBlocks.QUARRIED_COBBLE.get(),
                ModBlocks.QUARRIED_COBBLE_STAIRS.get(), ModBlocks.QUARRIED_COBBLE_SLAB.get(), ModBlocks.QUARRIED_COBBLE_WALL.get(),
                ModBlocks.QUARRIED_COBBLE_FENCE.get(), ModBlocks.QUARRIED_COBBLE_FENCE_GATE.get(),
                ModBlocks.QUARRIED_COBBLE_BUTTON.get(), ModBlocks.QUARRIED_COBBLE_PRESSURE_PLATE.get());
        variants(out, ModBlocks.QUARRIED_SMOOTH.get(),
                ModBlocks.QUARRIED_SMOOTH_STAIRS.get(), ModBlocks.QUARRIED_SMOOTH_SLAB.get(), ModBlocks.QUARRIED_SMOOTH_WALL.get(),
                ModBlocks.QUARRIED_SMOOTH_FENCE.get(), ModBlocks.QUARRIED_SMOOTH_FENCE_GATE.get(),
                ModBlocks.QUARRIED_SMOOTH_BUTTON.get(), ModBlocks.QUARRIED_SMOOTH_PRESSURE_PLATE.get());
    }

    /** All stonecutter + crafting recipes derived from a single base block. */
    private void variants(RecipeOutput out, Block base,
                          Block stair, Block slab, Block wall,
                          Block fence, Block gate,
                          Block button, Block plate) {
        // Stonecutter 1:1 (slab 1:2 following vanilla convention)
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, stair, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, slab, base, 2);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, wall, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, fence, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, gate, base, 1);
        stonecut(out, RecipeCategory.REDSTONE, button, base, 1);
        stonecut(out, RecipeCategory.REDSTONE, plate, base, 1);

        // Shaped crafting
        stairBuilder(stair, Ingredient.of(base))
                .unlockedBy(hasTag(base), has(base))
                .save(out);
        slab(out, RecipeCategory.BUILDING_BLOCKS, slab, base);
        wall(out, RecipeCategory.BUILDING_BLOCKS, wall, base);
        fenceBuilder(fence, Ingredient.of(base))
                .unlockedBy(hasTag(base), has(base))
                .save(out);
        fenceGateBuilder(gate, Ingredient.of(base))
                .unlockedBy(hasTag(base), has(base))
                .save(out);
        buttonBuilder(button, Ingredient.of(base))
                .unlockedBy(hasTag(base), has(base))
                .save(out);
        pressurePlate(out, plate, base);
    }

    /** Chain conversions: cobble→stone→smooth, stone→bricks→cracked. */
    private void chain(RecipeOutput out, Block cobble, Block stone, Block smooth, Block bricks, Block cracked) {
        // Smelting chain
        smelt(out, stone, cobble);
        smelt(out, smooth, stone);
        smelt(out, cracked, bricks);

        // Bricks from stone: 2x2 packer gives 4 bricks from 4 stone
        twoByTwoPacker(out, RecipeCategory.BUILDING_BLOCKS, bricks, stone);

        // Stonecutter between family variants
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, bricks, stone, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, smooth, stone, 1);
    }

    /**
     * Stonecutter recipe saved into the mod's own namespace. The vanilla
     * {@code stonecutterResultFromBase} helper uses {@code save(out, String)}
     * which defaults to the {@code minecraft} namespace.
     */
    private void stonecut(RecipeOutput out, RecipeCategory category, Block result, Block base, int count) {
        String id = keyOf(result).getPath() + "_from_" + keyOf(base).getPath() + "_stonecutting";
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), category, result, count)
                .unlockedBy(hasTag(base), has(base))
                .save(out, ResourceLocation.fromNamespaceAndPath(
                        com.brewingcoder.brewblocks.BrewBlocks.MODID, id));
    }

    private void smelt(RecipeOutput out, Block result, Block input) {
        String id = keyOf(result).getPath() + "_from_smelting_" + keyOf(input).getPath();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, 0.1f, 200)
                .unlockedBy(hasTag(input), has(input))
                .save(out, ResourceLocation.fromNamespaceAndPath(
                        com.brewingcoder.brewblocks.BrewBlocks.MODID, id));
    }

    private static String hasTag(ItemLike item) {
        return "has_" + keyOf(item).getPath();
    }

    private static ResourceLocation keyOf(ItemLike item) {
        if (item instanceof Block b) {
            return BuiltInRegistries.BLOCK.getKey(b);
        }
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

    @SuppressWarnings("unused")
    private static void silenceRecipeImport(Recipe<?> ignored) {}
}
