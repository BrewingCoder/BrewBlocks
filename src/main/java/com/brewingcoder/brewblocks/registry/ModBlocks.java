package com.brewingcoder.brewblocks.registry;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.block.StickyOreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BrewBlocks.MODID);

    private static BlockBehaviour.Properties rockProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.0f, 8.0f)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops();
    }

    public static final DeferredBlock<StickyOreBlock> STICKY_ORE = REGISTRY.registerBlock(
            "sticky_ore", StickyOreBlock::new, rockProps());

    // ---- Abyssal set ----
    public static final DeferredBlock<Block> ABYSSAL = plain("abyssal");
    public static final DeferredBlock<Block> ABYSSAL_BRICKS = plain("abyssal_bricks");
    public static final DeferredBlock<Block> ABYSSAL_BRICKS_CRACKED = plain("abyssal_bricks_cracked");
    public static final DeferredBlock<Block> ABYSSAL_COBBLE = plain("abyssal_cobble");
    public static final DeferredBlock<Block> ABYSSAL_SMOOTH = plain("abyssal_smooth");

    public static final DeferredBlock<StairBlock> ABYSSAL_STAIRS = stair("abyssal_stairs", ABYSSAL);
    public static final DeferredBlock<StairBlock> ABYSSAL_BRICK_STAIRS = stair("abyssal_brick_stairs", ABYSSAL_BRICKS);
    public static final DeferredBlock<StairBlock> ABYSSAL_BRICK_CRACKED_STAIRS = stair("abyssal_brick_cracked_stairs", ABYSSAL_BRICKS_CRACKED);
    public static final DeferredBlock<StairBlock> ABYSSAL_COBBLE_STAIRS = stair("abyssal_cobble_stairs", ABYSSAL_COBBLE);
    public static final DeferredBlock<StairBlock> ABYSSAL_SMOOTH_STAIRS = stair("abyssal_smooth_stairs", ABYSSAL_SMOOTH);

    public static final DeferredBlock<SlabBlock> ABYSSAL_SLAB = slab("abyssal_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_BRICK_SLAB = slab("abyssal_brick_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_BRICK_CRACKED_SLAB = slab("abyssal_brick_cracked_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_COBBLE_SLAB = slab("abyssal_cobble_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_SMOOTH_SLAB = slab("abyssal_smooth_slab");

    public static final DeferredBlock<WallBlock> ABYSSAL_WALL = wall("abyssal_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_BRICK_WALL = wall("abyssal_brick_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_BRICK_CRACKED_WALL = wall("abyssal_brick_cracked_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_COBBLE_WALL = wall("abyssal_cobble_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_SMOOTH_WALL = wall("abyssal_smooth_wall");

    // ---- Quarried set ----
    public static final DeferredBlock<Block> QUARRIED = plain("quarried");
    public static final DeferredBlock<Block> QUARRIED_BRICKS = plain("quarried_bricks");
    public static final DeferredBlock<Block> QUARRIED_BRICKS_CRACKED = plain("quarried_bricks_cracked");
    public static final DeferredBlock<Block> QUARRIED_COBBLE = plain("quarried_cobble");
    public static final DeferredBlock<Block> QUARRIED_SMOOTH = plain("quarried_smooth");

    public static final DeferredBlock<StairBlock> QUARRIED_STAIRS = stair("quarried_stairs", QUARRIED);
    public static final DeferredBlock<StairBlock> QUARRIED_BRICKS_STAIRS = stair("quarried_bricks_stairs", QUARRIED_BRICKS);
    public static final DeferredBlock<StairBlock> QUARRIED_BRICKS_CRACKED_STAIRS = stair("quarried_bricks_cracked_stairs", QUARRIED_BRICKS_CRACKED);
    public static final DeferredBlock<StairBlock> QUARRIED_COBBLE_STAIRS = stair("quarried_cobble_stairs", QUARRIED_COBBLE);
    public static final DeferredBlock<StairBlock> QUARRIED_SMOOTH_STAIRS = stair("quarried_smooth_stairs", QUARRIED_SMOOTH);

    public static final DeferredBlock<SlabBlock> QUARRIED_SLAB = slab("quarried_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_BRICKS_SLAB = slab("quarried_bricks_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_BRICKS_CRACKED_SLAB = slab("quarried_bricks_cracked_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_COBBLE_SLAB = slab("quarried_cobble_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_SMOOTH_SLAB = slab("quarried_smooth_slab");

    public static final DeferredBlock<WallBlock> QUARRIED_WALL = wall("quarried_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_BRICKS_WALL = wall("quarried_bricks_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_BRICKS_CRACKED_WALL = wall("quarried_bricks_cracked_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_COBBLE_WALL = wall("quarried_cobble_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_SMOOTH_WALL = wall("quarried_smooth_wall");

    private static DeferredBlock<Block> plain(String name) {
        return REGISTRY.registerBlock(name, Block::new, rockProps());
    }

    private static DeferredBlock<SlabBlock> slab(String name) {
        return REGISTRY.registerBlock(name, SlabBlock::new, rockProps());
    }

    private static DeferredBlock<WallBlock> wall(String name) {
        return REGISTRY.registerBlock(name, WallBlock::new, rockProps());
    }

    private static DeferredBlock<StairBlock> stair(String name, Supplier<Block> base) {
        return REGISTRY.registerBlock(name,
                props -> new StairBlock(base.get().defaultBlockState(), props),
                rockProps());
    }

    private ModBlocks() {}
}
