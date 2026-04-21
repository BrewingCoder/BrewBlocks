package com.brewingcoder.brewblocks.registry;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.block.StickyOreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    private static BlockBehaviour.Properties buttonProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .noCollission()
                .strength(0.5f)
                .pushReaction(net.minecraft.world.level.material.PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties plateProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .forceSolidOn()
                .noCollission()
                .strength(0.5f)
                .pushReaction(net.minecraft.world.level.material.PushReaction.DESTROY);
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

    public static final DeferredBlock<FenceBlock> ABYSSAL_FENCE = fence("abyssal_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_BRICK_FENCE = fence("abyssal_brick_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_BRICK_CRACKED_FENCE = fence("abyssal_brick_cracked_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_COBBLE_FENCE = fence("abyssal_cobble_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_SMOOTH_FENCE = fence("abyssal_smooth_fence");

    public static final DeferredBlock<FenceGateBlock> ABYSSAL_FENCE_GATE = fenceGate("abyssal_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_BRICK_FENCE_GATE = fenceGate("abyssal_brick_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_BRICK_CRACKED_FENCE_GATE = fenceGate("abyssal_brick_cracked_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_COBBLE_FENCE_GATE = fenceGate("abyssal_cobble_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_SMOOTH_FENCE_GATE = fenceGate("abyssal_smooth_fence_gate");

    public static final DeferredBlock<ButtonBlock> ABYSSAL_BUTTON = button("abyssal_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_BRICK_BUTTON = button("abyssal_brick_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_BRICK_CRACKED_BUTTON = button("abyssal_brick_cracked_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_COBBLE_BUTTON = button("abyssal_cobble_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_SMOOTH_BUTTON = button("abyssal_smooth_button");

    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_PRESSURE_PLATE = plate("abyssal_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_BRICK_PRESSURE_PLATE = plate("abyssal_brick_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_BRICK_CRACKED_PRESSURE_PLATE = plate("abyssal_brick_cracked_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_COBBLE_PRESSURE_PLATE = plate("abyssal_cobble_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_SMOOTH_PRESSURE_PLATE = plate("abyssal_smooth_pressure_plate");

    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_PILLAR = pillar("abyssal_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_BRICK_PILLAR = pillar("abyssal_brick_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_BRICK_CRACKED_PILLAR = pillar("abyssal_brick_cracked_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_COBBLE_PILLAR = pillar("abyssal_cobble_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_SMOOTH_PILLAR = pillar("abyssal_smooth_pillar");

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

    public static final DeferredBlock<FenceBlock> QUARRIED_FENCE = fence("quarried_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_BRICKS_FENCE = fence("quarried_bricks_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_BRICKS_CRACKED_FENCE = fence("quarried_bricks_cracked_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_COBBLE_FENCE = fence("quarried_cobble_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_SMOOTH_FENCE = fence("quarried_smooth_fence");

    public static final DeferredBlock<FenceGateBlock> QUARRIED_FENCE_GATE = fenceGate("quarried_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_BRICKS_FENCE_GATE = fenceGate("quarried_bricks_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_BRICKS_CRACKED_FENCE_GATE = fenceGate("quarried_bricks_cracked_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_COBBLE_FENCE_GATE = fenceGate("quarried_cobble_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_SMOOTH_FENCE_GATE = fenceGate("quarried_smooth_fence_gate");

    public static final DeferredBlock<ButtonBlock> QUARRIED_BUTTON = button("quarried_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_BRICKS_BUTTON = button("quarried_bricks_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_BRICKS_CRACKED_BUTTON = button("quarried_bricks_cracked_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_COBBLE_BUTTON = button("quarried_cobble_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_SMOOTH_BUTTON = button("quarried_smooth_button");

    public static final DeferredBlock<PressurePlateBlock> QUARRIED_PRESSURE_PLATE = plate("quarried_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_BRICKS_PRESSURE_PLATE = plate("quarried_bricks_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_BRICKS_CRACKED_PRESSURE_PLATE = plate("quarried_bricks_cracked_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_COBBLE_PRESSURE_PLATE = plate("quarried_cobble_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_SMOOTH_PRESSURE_PLATE = plate("quarried_smooth_pressure_plate");

    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_PILLAR = pillar("quarried_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_BRICKS_PILLAR = pillar("quarried_bricks_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_BRICKS_CRACKED_PILLAR = pillar("quarried_bricks_cracked_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_COBBLE_PILLAR = pillar("quarried_cobble_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_SMOOTH_PILLAR = pillar("quarried_smooth_pillar");

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

    private static DeferredBlock<FenceBlock> fence(String name) {
        return REGISTRY.registerBlock(name, FenceBlock::new, rockProps());
    }

    private static DeferredBlock<FenceGateBlock> fenceGate(String name) {
        return REGISTRY.registerBlock(name,
                props -> new FenceGateBlock(WoodType.OAK, props),
                rockProps());
    }

    private static DeferredBlock<ButtonBlock> button(String name) {
        return REGISTRY.registerBlock(name,
                props -> new ButtonBlock(BlockSetType.STONE, 20, props),
                buttonProps());
    }

    private static DeferredBlock<PressurePlateBlock> plate(String name) {
        return REGISTRY.registerBlock(name,
                props -> new PressurePlateBlock(BlockSetType.STONE, props),
                plateProps());
    }

    private static DeferredBlock<RotatedPillarBlock> pillar(String name) {
        return REGISTRY.registerBlock(name, RotatedPillarBlock::new, rockProps());
    }

    private ModBlocks() {}
}
