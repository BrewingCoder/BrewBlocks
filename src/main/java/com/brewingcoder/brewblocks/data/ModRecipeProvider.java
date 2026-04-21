package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
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
        // ----- Abyssal family -----
        chain(out,
                ModBlocks.ABYSSAL_COBBLESTONE.get(),
                ModBlocks.ABYSSAL_STONE.get(),
                ModBlocks.ABYSSAL_SMOOTH_STONE.get(),
                ModBlocks.ABYSSAL_BRICKS.get(),
                ModBlocks.ABYSSAL_BRICKS_CRACKED.get());

        variants(out, ModBlocks.ABYSSAL_STONE.get(),
                ModBlocks.ABYSSAL_STONE_STAIRS.get(), ModBlocks.ABYSSAL_STONE_SLAB.get(), ModBlocks.ABYSSAL_STONE_WALL.get(),
                ModBlocks.ABYSSAL_STONE_FENCE.get(), ModBlocks.ABYSSAL_STONE_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_STONE_BUTTON.get(), ModBlocks.ABYSSAL_STONE_PRESSURE_PLATE.get(), ModBlocks.ABYSSAL_STONE_PILLAR.get());
        variants(out, ModBlocks.ABYSSAL_BRICKS.get(),
                ModBlocks.ABYSSAL_BRICK_STAIRS.get(), ModBlocks.ABYSSAL_BRICK_SLAB.get(), ModBlocks.ABYSSAL_BRICK_WALL.get(),
                ModBlocks.ABYSSAL_BRICK_FENCE.get(), ModBlocks.ABYSSAL_BRICK_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_BRICK_BUTTON.get(), ModBlocks.ABYSSAL_BRICK_PRESSURE_PLATE.get(), ModBlocks.ABYSSAL_BRICK_PILLAR.get());
        variants(out, ModBlocks.ABYSSAL_BRICKS_CRACKED.get(),
                ModBlocks.ABYSSAL_BRICK_CRACKED_STAIRS.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_SLAB.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_WALL.get(),
                ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_BRICK_CRACKED_BUTTON.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_PRESSURE_PLATE.get(), ModBlocks.ABYSSAL_BRICK_CRACKED_PILLAR.get());
        variants(out, ModBlocks.ABYSSAL_COBBLESTONE.get(),
                ModBlocks.ABYSSAL_COBBLESTONE_STAIRS.get(), ModBlocks.ABYSSAL_COBBLESTONE_SLAB.get(), ModBlocks.ABYSSAL_COBBLESTONE_WALL.get(),
                ModBlocks.ABYSSAL_COBBLESTONE_FENCE.get(), ModBlocks.ABYSSAL_COBBLESTONE_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_COBBLESTONE_BUTTON.get(), ModBlocks.ABYSSAL_COBBLESTONE_PRESSURE_PLATE.get(), ModBlocks.ABYSSAL_COBBLESTONE_PILLAR.get());
        variants(out, ModBlocks.ABYSSAL_SMOOTH_STONE.get(),
                ModBlocks.ABYSSAL_SMOOTH_STONE_STAIRS.get(), ModBlocks.ABYSSAL_SMOOTH_STONE_SLAB.get(), ModBlocks.ABYSSAL_SMOOTH_STONE_WALL.get(),
                ModBlocks.ABYSSAL_SMOOTH_STONE_FENCE.get(), ModBlocks.ABYSSAL_SMOOTH_STONE_FENCE_GATE.get(),
                ModBlocks.ABYSSAL_SMOOTH_STONE_BUTTON.get(), ModBlocks.ABYSSAL_SMOOTH_STONE_PRESSURE_PLATE.get(), ModBlocks.ABYSSAL_SMOOTH_STONE_PILLAR.get());

        // ----- Quarried family -----
        chain(out,
                ModBlocks.QUARRIED_COBBLESTONE.get(),
                ModBlocks.QUARRIED_STONE.get(),
                ModBlocks.QUARRIED_SMOOTH_STONE.get(),
                ModBlocks.QUARRIED_BRICKS.get(),
                ModBlocks.QUARRIED_BRICKS_CRACKED.get());

        variants(out, ModBlocks.QUARRIED_STONE.get(),
                ModBlocks.QUARRIED_STONE_STAIRS.get(), ModBlocks.QUARRIED_STONE_SLAB.get(), ModBlocks.QUARRIED_STONE_WALL.get(),
                ModBlocks.QUARRIED_STONE_FENCE.get(), ModBlocks.QUARRIED_STONE_FENCE_GATE.get(),
                ModBlocks.QUARRIED_STONE_BUTTON.get(), ModBlocks.QUARRIED_STONE_PRESSURE_PLATE.get(), ModBlocks.QUARRIED_STONE_PILLAR.get());
        variants(out, ModBlocks.QUARRIED_BRICKS.get(),
                ModBlocks.QUARRIED_BRICK_STAIRS.get(), ModBlocks.QUARRIED_BRICK_SLAB.get(), ModBlocks.QUARRIED_BRICK_WALL.get(),
                ModBlocks.QUARRIED_BRICK_FENCE.get(), ModBlocks.QUARRIED_BRICK_FENCE_GATE.get(),
                ModBlocks.QUARRIED_BRICK_BUTTON.get(), ModBlocks.QUARRIED_BRICK_PRESSURE_PLATE.get(), ModBlocks.QUARRIED_BRICK_PILLAR.get());
        variants(out, ModBlocks.QUARRIED_BRICKS_CRACKED.get(),
                ModBlocks.QUARRIED_BRICK_CRACKED_STAIRS.get(), ModBlocks.QUARRIED_BRICK_CRACKED_SLAB.get(), ModBlocks.QUARRIED_BRICK_CRACKED_WALL.get(),
                ModBlocks.QUARRIED_BRICK_CRACKED_FENCE.get(), ModBlocks.QUARRIED_BRICK_CRACKED_FENCE_GATE.get(),
                ModBlocks.QUARRIED_BRICK_CRACKED_BUTTON.get(), ModBlocks.QUARRIED_BRICK_CRACKED_PRESSURE_PLATE.get(), ModBlocks.QUARRIED_BRICK_CRACKED_PILLAR.get());
        variants(out, ModBlocks.QUARRIED_COBBLESTONE.get(),
                ModBlocks.QUARRIED_COBBLESTONE_STAIRS.get(), ModBlocks.QUARRIED_COBBLESTONE_SLAB.get(), ModBlocks.QUARRIED_COBBLESTONE_WALL.get(),
                ModBlocks.QUARRIED_COBBLESTONE_FENCE.get(), ModBlocks.QUARRIED_COBBLESTONE_FENCE_GATE.get(),
                ModBlocks.QUARRIED_COBBLESTONE_BUTTON.get(), ModBlocks.QUARRIED_COBBLESTONE_PRESSURE_PLATE.get(), ModBlocks.QUARRIED_COBBLESTONE_PILLAR.get());
        variants(out, ModBlocks.QUARRIED_SMOOTH_STONE.get(),
                ModBlocks.QUARRIED_SMOOTH_STONE_STAIRS.get(), ModBlocks.QUARRIED_SMOOTH_STONE_SLAB.get(), ModBlocks.QUARRIED_SMOOTH_STONE_WALL.get(),
                ModBlocks.QUARRIED_SMOOTH_STONE_FENCE.get(), ModBlocks.QUARRIED_SMOOTH_STONE_FENCE_GATE.get(),
                ModBlocks.QUARRIED_SMOOTH_STONE_BUTTON.get(), ModBlocks.QUARRIED_SMOOTH_STONE_PRESSURE_PLATE.get(), ModBlocks.QUARRIED_SMOOTH_STONE_PILLAR.get());

        // ----- Burnt family -----
        chain(out,
                ModBlocks.BURNT_COBBLESTONE.get(),
                ModBlocks.BURNT_STONE.get(),
                ModBlocks.BURNT_SMOOTH_STONE.get(),
                ModBlocks.BURNT_BRICKS.get(),
                ModBlocks.BURNT_BRICKS_CRACKED.get());

        variants(out, ModBlocks.BURNT_STONE.get(),
                ModBlocks.BURNT_STONE_STAIRS.get(), ModBlocks.BURNT_STONE_SLAB.get(), ModBlocks.BURNT_STONE_WALL.get(),
                ModBlocks.BURNT_STONE_FENCE.get(), ModBlocks.BURNT_STONE_FENCE_GATE.get(),
                ModBlocks.BURNT_STONE_BUTTON.get(), ModBlocks.BURNT_STONE_PRESSURE_PLATE.get(), ModBlocks.BURNT_STONE_PILLAR.get());
        variants(out, ModBlocks.BURNT_BRICKS.get(),
                ModBlocks.BURNT_BRICK_STAIRS.get(), ModBlocks.BURNT_BRICK_SLAB.get(), ModBlocks.BURNT_BRICK_WALL.get(),
                ModBlocks.BURNT_BRICK_FENCE.get(), ModBlocks.BURNT_BRICK_FENCE_GATE.get(),
                ModBlocks.BURNT_BRICK_BUTTON.get(), ModBlocks.BURNT_BRICK_PRESSURE_PLATE.get(), ModBlocks.BURNT_BRICK_PILLAR.get());
        variants(out, ModBlocks.BURNT_BRICKS_CRACKED.get(),
                ModBlocks.BURNT_BRICK_CRACKED_STAIRS.get(), ModBlocks.BURNT_BRICK_CRACKED_SLAB.get(), ModBlocks.BURNT_BRICK_CRACKED_WALL.get(),
                ModBlocks.BURNT_BRICK_CRACKED_FENCE.get(), ModBlocks.BURNT_BRICK_CRACKED_FENCE_GATE.get(),
                ModBlocks.BURNT_BRICK_CRACKED_BUTTON.get(), ModBlocks.BURNT_BRICK_CRACKED_PRESSURE_PLATE.get(), ModBlocks.BURNT_BRICK_CRACKED_PILLAR.get());
        variants(out, ModBlocks.BURNT_COBBLESTONE.get(),
                ModBlocks.BURNT_COBBLESTONE_STAIRS.get(), ModBlocks.BURNT_COBBLESTONE_SLAB.get(), ModBlocks.BURNT_COBBLESTONE_WALL.get(),
                ModBlocks.BURNT_COBBLESTONE_FENCE.get(), ModBlocks.BURNT_COBBLESTONE_FENCE_GATE.get(),
                ModBlocks.BURNT_COBBLESTONE_BUTTON.get(), ModBlocks.BURNT_COBBLESTONE_PRESSURE_PLATE.get(), ModBlocks.BURNT_COBBLESTONE_PILLAR.get());
        variants(out, ModBlocks.BURNT_SMOOTH_STONE.get(),
                ModBlocks.BURNT_SMOOTH_STONE_STAIRS.get(), ModBlocks.BURNT_SMOOTH_STONE_SLAB.get(), ModBlocks.BURNT_SMOOTH_STONE_WALL.get(),
                ModBlocks.BURNT_SMOOTH_STONE_FENCE.get(), ModBlocks.BURNT_SMOOTH_STONE_FENCE_GATE.get(),
                ModBlocks.BURNT_SMOOTH_STONE_BUTTON.get(), ModBlocks.BURNT_SMOOTH_STONE_PRESSURE_PLATE.get(), ModBlocks.BURNT_SMOOTH_STONE_PILLAR.get());
    }

    /** All stonecutter + crafting recipes derived from a single base block. */
    private void variants(RecipeOutput out, Block base,
                          Block stair, Block slab, Block wall,
                          Block fence, Block gate,
                          Block button, Block plate, Block pillar) {
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, stair, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, slab, base, 2);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, wall, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, fence, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, gate, base, 1);
        stonecut(out, RecipeCategory.REDSTONE, button, base, 1);
        stonecut(out, RecipeCategory.REDSTONE, plate, base, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, pillar, base, 1);

        stairBuilder(stair, Ingredient.of(base)).unlockedBy(hasTag(base), has(base)).save(out);
        slab(out, RecipeCategory.BUILDING_BLOCKS, slab, base);
        wall(out, RecipeCategory.BUILDING_BLOCKS, wall, base);
        fenceBuilder(fence, Ingredient.of(base)).unlockedBy(hasTag(base), has(base)).save(out);
        fenceGateBuilder(gate, Ingredient.of(base)).unlockedBy(hasTag(base), has(base)).save(out);
        buttonBuilder(button, Ingredient.of(base)).unlockedBy(hasTag(base), has(base)).save(out);
        pressurePlate(out, plate, base);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2)
                .define('#', base)
                .pattern("#")
                .pattern("#")
                .unlockedBy(hasTag(base), has(base))
                .save(out);
    }

    /** Chain conversions: cobble→stone→smooth, stone→bricks→cracked. */
    private void chain(RecipeOutput out, Block cobble, Block stone, Block smooth, Block bricks, Block cracked) {
        smelt(out, stone, cobble);
        smelt(out, smooth, stone);
        smelt(out, cracked, bricks);
        twoByTwoPacker(out, RecipeCategory.BUILDING_BLOCKS, bricks, stone);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, bricks, stone, 1);
        stonecut(out, RecipeCategory.BUILDING_BLOCKS, smooth, stone, 1);
    }

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
        if (item instanceof Block b) return BuiltInRegistries.BLOCK.getKey(b);
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

    @SuppressWarnings("unused")
    private static void silenceRecipeImport(Recipe<?> ignored) {}
}
