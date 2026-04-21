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
    public static final DeferredBlock<Block> ABYSSAL_STONE             = plain("abyssal_stone");
    public static final DeferredBlock<Block> ABYSSAL_BRICKS            = plain("abyssal_bricks");
    public static final DeferredBlock<Block> ABYSSAL_BRICKS_CRACKED    = plain("abyssal_bricks_cracked");
    public static final DeferredBlock<Block> ABYSSAL_COBBLESTONE       = plain("abyssal_cobblestone");
    public static final DeferredBlock<Block> ABYSSAL_SMOOTH_STONE      = plain("abyssal_smooth_stone");

    public static final DeferredBlock<StairBlock> ABYSSAL_STONE_STAIRS             = stair("abyssal_stone_stairs", ABYSSAL_STONE);
    public static final DeferredBlock<StairBlock> ABYSSAL_BRICK_STAIRS             = stair("abyssal_brick_stairs", ABYSSAL_BRICKS);
    public static final DeferredBlock<StairBlock> ABYSSAL_BRICK_CRACKED_STAIRS     = stair("abyssal_brick_cracked_stairs", ABYSSAL_BRICKS_CRACKED);
    public static final DeferredBlock<StairBlock> ABYSSAL_COBBLESTONE_STAIRS       = stair("abyssal_cobblestone_stairs", ABYSSAL_COBBLESTONE);
    public static final DeferredBlock<StairBlock> ABYSSAL_SMOOTH_STONE_STAIRS      = stair("abyssal_smooth_stone_stairs", ABYSSAL_SMOOTH_STONE);

    public static final DeferredBlock<SlabBlock> ABYSSAL_STONE_SLAB                = slab("abyssal_stone_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_BRICK_SLAB                = slab("abyssal_brick_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_BRICK_CRACKED_SLAB        = slab("abyssal_brick_cracked_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_COBBLESTONE_SLAB          = slab("abyssal_cobblestone_slab");
    public static final DeferredBlock<SlabBlock> ABYSSAL_SMOOTH_STONE_SLAB         = slab("abyssal_smooth_stone_slab");

    public static final DeferredBlock<WallBlock> ABYSSAL_STONE_WALL                = wall("abyssal_stone_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_BRICK_WALL                = wall("abyssal_brick_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_BRICK_CRACKED_WALL        = wall("abyssal_brick_cracked_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_COBBLESTONE_WALL          = wall("abyssal_cobblestone_wall");
    public static final DeferredBlock<WallBlock> ABYSSAL_SMOOTH_STONE_WALL         = wall("abyssal_smooth_stone_wall");

    public static final DeferredBlock<FenceBlock> ABYSSAL_STONE_FENCE              = fence("abyssal_stone_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_BRICK_FENCE              = fence("abyssal_brick_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_BRICK_CRACKED_FENCE      = fence("abyssal_brick_cracked_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_COBBLESTONE_FENCE        = fence("abyssal_cobblestone_fence");
    public static final DeferredBlock<FenceBlock> ABYSSAL_SMOOTH_STONE_FENCE       = fence("abyssal_smooth_stone_fence");

    public static final DeferredBlock<FenceGateBlock> ABYSSAL_STONE_FENCE_GATE             = fenceGate("abyssal_stone_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_BRICK_FENCE_GATE             = fenceGate("abyssal_brick_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_BRICK_CRACKED_FENCE_GATE     = fenceGate("abyssal_brick_cracked_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_COBBLESTONE_FENCE_GATE       = fenceGate("abyssal_cobblestone_fence_gate");
    public static final DeferredBlock<FenceGateBlock> ABYSSAL_SMOOTH_STONE_FENCE_GATE      = fenceGate("abyssal_smooth_stone_fence_gate");

    public static final DeferredBlock<ButtonBlock> ABYSSAL_STONE_BUTTON            = button("abyssal_stone_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_BRICK_BUTTON            = button("abyssal_brick_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_BRICK_CRACKED_BUTTON    = button("abyssal_brick_cracked_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_COBBLESTONE_BUTTON      = button("abyssal_cobblestone_button");
    public static final DeferredBlock<ButtonBlock> ABYSSAL_SMOOTH_STONE_BUTTON     = button("abyssal_smooth_stone_button");

    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_STONE_PRESSURE_PLATE          = plate("abyssal_stone_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_BRICK_PRESSURE_PLATE          = plate("abyssal_brick_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_BRICK_CRACKED_PRESSURE_PLATE  = plate("abyssal_brick_cracked_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_COBBLESTONE_PRESSURE_PLATE    = plate("abyssal_cobblestone_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> ABYSSAL_SMOOTH_STONE_PRESSURE_PLATE   = plate("abyssal_smooth_stone_pressure_plate");

    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_STONE_PILLAR             = pillar("abyssal_stone_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_BRICK_PILLAR             = pillar("abyssal_brick_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_BRICK_CRACKED_PILLAR     = pillar("abyssal_brick_cracked_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_COBBLESTONE_PILLAR       = pillar("abyssal_cobblestone_pillar");
    public static final DeferredBlock<RotatedPillarBlock> ABYSSAL_SMOOTH_STONE_PILLAR      = pillar("abyssal_smooth_stone_pillar");

    // ---- Quarried set ----
    public static final DeferredBlock<Block> QUARRIED_STONE            = plain("quarried_stone");
    public static final DeferredBlock<Block> QUARRIED_BRICKS           = plain("quarried_bricks");
    public static final DeferredBlock<Block> QUARRIED_BRICKS_CRACKED   = plain("quarried_bricks_cracked");
    public static final DeferredBlock<Block> QUARRIED_COBBLESTONE      = plain("quarried_cobblestone");
    public static final DeferredBlock<Block> QUARRIED_SMOOTH_STONE     = plain("quarried_smooth_stone");

    public static final DeferredBlock<StairBlock> QUARRIED_STONE_STAIRS            = stair("quarried_stone_stairs", QUARRIED_STONE);
    public static final DeferredBlock<StairBlock> QUARRIED_BRICK_STAIRS            = stair("quarried_brick_stairs", QUARRIED_BRICKS);
    public static final DeferredBlock<StairBlock> QUARRIED_BRICK_CRACKED_STAIRS    = stair("quarried_brick_cracked_stairs", QUARRIED_BRICKS_CRACKED);
    public static final DeferredBlock<StairBlock> QUARRIED_COBBLESTONE_STAIRS      = stair("quarried_cobblestone_stairs", QUARRIED_COBBLESTONE);
    public static final DeferredBlock<StairBlock> QUARRIED_SMOOTH_STONE_STAIRS     = stair("quarried_smooth_stone_stairs", QUARRIED_SMOOTH_STONE);

    public static final DeferredBlock<SlabBlock> QUARRIED_STONE_SLAB               = slab("quarried_stone_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_BRICK_SLAB               = slab("quarried_brick_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_BRICK_CRACKED_SLAB       = slab("quarried_brick_cracked_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_COBBLESTONE_SLAB         = slab("quarried_cobblestone_slab");
    public static final DeferredBlock<SlabBlock> QUARRIED_SMOOTH_STONE_SLAB        = slab("quarried_smooth_stone_slab");

    public static final DeferredBlock<WallBlock> QUARRIED_STONE_WALL               = wall("quarried_stone_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_BRICK_WALL               = wall("quarried_brick_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_BRICK_CRACKED_WALL       = wall("quarried_brick_cracked_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_COBBLESTONE_WALL         = wall("quarried_cobblestone_wall");
    public static final DeferredBlock<WallBlock> QUARRIED_SMOOTH_STONE_WALL        = wall("quarried_smooth_stone_wall");

    public static final DeferredBlock<FenceBlock> QUARRIED_STONE_FENCE             = fence("quarried_stone_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_BRICK_FENCE             = fence("quarried_brick_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_BRICK_CRACKED_FENCE     = fence("quarried_brick_cracked_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_COBBLESTONE_FENCE       = fence("quarried_cobblestone_fence");
    public static final DeferredBlock<FenceBlock> QUARRIED_SMOOTH_STONE_FENCE      = fence("quarried_smooth_stone_fence");

    public static final DeferredBlock<FenceGateBlock> QUARRIED_STONE_FENCE_GATE            = fenceGate("quarried_stone_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_BRICK_FENCE_GATE            = fenceGate("quarried_brick_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_BRICK_CRACKED_FENCE_GATE    = fenceGate("quarried_brick_cracked_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_COBBLESTONE_FENCE_GATE      = fenceGate("quarried_cobblestone_fence_gate");
    public static final DeferredBlock<FenceGateBlock> QUARRIED_SMOOTH_STONE_FENCE_GATE     = fenceGate("quarried_smooth_stone_fence_gate");

    public static final DeferredBlock<ButtonBlock> QUARRIED_STONE_BUTTON           = button("quarried_stone_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_BRICK_BUTTON           = button("quarried_brick_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_BRICK_CRACKED_BUTTON   = button("quarried_brick_cracked_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_COBBLESTONE_BUTTON     = button("quarried_cobblestone_button");
    public static final DeferredBlock<ButtonBlock> QUARRIED_SMOOTH_STONE_BUTTON    = button("quarried_smooth_stone_button");

    public static final DeferredBlock<PressurePlateBlock> QUARRIED_STONE_PRESSURE_PLATE         = plate("quarried_stone_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_BRICK_PRESSURE_PLATE         = plate("quarried_brick_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_BRICK_CRACKED_PRESSURE_PLATE = plate("quarried_brick_cracked_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_COBBLESTONE_PRESSURE_PLATE   = plate("quarried_cobblestone_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> QUARRIED_SMOOTH_STONE_PRESSURE_PLATE  = plate("quarried_smooth_stone_pressure_plate");

    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_STONE_PILLAR            = pillar("quarried_stone_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_BRICK_PILLAR            = pillar("quarried_brick_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_BRICK_CRACKED_PILLAR    = pillar("quarried_brick_cracked_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_COBBLESTONE_PILLAR      = pillar("quarried_cobblestone_pillar");
    public static final DeferredBlock<RotatedPillarBlock> QUARRIED_SMOOTH_STONE_PILLAR     = pillar("quarried_smooth_stone_pillar");

    // ---- Burnt set ----
    public static final DeferredBlock<Block> BURNT_STONE               = plain("burnt_stone");
    public static final DeferredBlock<Block> BURNT_BRICKS              = plain("burnt_bricks");
    public static final DeferredBlock<Block> BURNT_BRICKS_CRACKED      = plain("burnt_bricks_cracked");
    public static final DeferredBlock<Block> BURNT_COBBLESTONE         = plain("burnt_cobblestone");
    public static final DeferredBlock<Block> BURNT_SMOOTH_STONE        = plain("burnt_smooth_stone");

    public static final DeferredBlock<StairBlock> BURNT_STONE_STAIRS               = stair("burnt_stone_stairs", BURNT_STONE);
    public static final DeferredBlock<StairBlock> BURNT_BRICK_STAIRS               = stair("burnt_brick_stairs", BURNT_BRICKS);
    public static final DeferredBlock<StairBlock> BURNT_BRICK_CRACKED_STAIRS       = stair("burnt_brick_cracked_stairs", BURNT_BRICKS_CRACKED);
    public static final DeferredBlock<StairBlock> BURNT_COBBLESTONE_STAIRS         = stair("burnt_cobblestone_stairs", BURNT_COBBLESTONE);
    public static final DeferredBlock<StairBlock> BURNT_SMOOTH_STONE_STAIRS        = stair("burnt_smooth_stone_stairs", BURNT_SMOOTH_STONE);

    public static final DeferredBlock<SlabBlock> BURNT_STONE_SLAB                  = slab("burnt_stone_slab");
    public static final DeferredBlock<SlabBlock> BURNT_BRICK_SLAB                  = slab("burnt_brick_slab");
    public static final DeferredBlock<SlabBlock> BURNT_BRICK_CRACKED_SLAB          = slab("burnt_brick_cracked_slab");
    public static final DeferredBlock<SlabBlock> BURNT_COBBLESTONE_SLAB            = slab("burnt_cobblestone_slab");
    public static final DeferredBlock<SlabBlock> BURNT_SMOOTH_STONE_SLAB           = slab("burnt_smooth_stone_slab");

    public static final DeferredBlock<WallBlock> BURNT_STONE_WALL                  = wall("burnt_stone_wall");
    public static final DeferredBlock<WallBlock> BURNT_BRICK_WALL                  = wall("burnt_brick_wall");
    public static final DeferredBlock<WallBlock> BURNT_BRICK_CRACKED_WALL          = wall("burnt_brick_cracked_wall");
    public static final DeferredBlock<WallBlock> BURNT_COBBLESTONE_WALL            = wall("burnt_cobblestone_wall");
    public static final DeferredBlock<WallBlock> BURNT_SMOOTH_STONE_WALL           = wall("burnt_smooth_stone_wall");

    public static final DeferredBlock<FenceBlock> BURNT_STONE_FENCE                = fence("burnt_stone_fence");
    public static final DeferredBlock<FenceBlock> BURNT_BRICK_FENCE                = fence("burnt_brick_fence");
    public static final DeferredBlock<FenceBlock> BURNT_BRICK_CRACKED_FENCE        = fence("burnt_brick_cracked_fence");
    public static final DeferredBlock<FenceBlock> BURNT_COBBLESTONE_FENCE          = fence("burnt_cobblestone_fence");
    public static final DeferredBlock<FenceBlock> BURNT_SMOOTH_STONE_FENCE         = fence("burnt_smooth_stone_fence");

    public static final DeferredBlock<FenceGateBlock> BURNT_STONE_FENCE_GATE               = fenceGate("burnt_stone_fence_gate");
    public static final DeferredBlock<FenceGateBlock> BURNT_BRICK_FENCE_GATE               = fenceGate("burnt_brick_fence_gate");
    public static final DeferredBlock<FenceGateBlock> BURNT_BRICK_CRACKED_FENCE_GATE       = fenceGate("burnt_brick_cracked_fence_gate");
    public static final DeferredBlock<FenceGateBlock> BURNT_COBBLESTONE_FENCE_GATE         = fenceGate("burnt_cobblestone_fence_gate");
    public static final DeferredBlock<FenceGateBlock> BURNT_SMOOTH_STONE_FENCE_GATE        = fenceGate("burnt_smooth_stone_fence_gate");

    public static final DeferredBlock<ButtonBlock> BURNT_STONE_BUTTON              = button("burnt_stone_button");
    public static final DeferredBlock<ButtonBlock> BURNT_BRICK_BUTTON              = button("burnt_brick_button");
    public static final DeferredBlock<ButtonBlock> BURNT_BRICK_CRACKED_BUTTON      = button("burnt_brick_cracked_button");
    public static final DeferredBlock<ButtonBlock> BURNT_COBBLESTONE_BUTTON        = button("burnt_cobblestone_button");
    public static final DeferredBlock<ButtonBlock> BURNT_SMOOTH_STONE_BUTTON       = button("burnt_smooth_stone_button");

    public static final DeferredBlock<PressurePlateBlock> BURNT_STONE_PRESSURE_PLATE            = plate("burnt_stone_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> BURNT_BRICK_PRESSURE_PLATE            = plate("burnt_brick_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> BURNT_BRICK_CRACKED_PRESSURE_PLATE    = plate("burnt_brick_cracked_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> BURNT_COBBLESTONE_PRESSURE_PLATE      = plate("burnt_cobblestone_pressure_plate");
    public static final DeferredBlock<PressurePlateBlock> BURNT_SMOOTH_STONE_PRESSURE_PLATE     = plate("burnt_smooth_stone_pressure_plate");

    public static final DeferredBlock<RotatedPillarBlock> BURNT_STONE_PILLAR               = pillar("burnt_stone_pillar");
    public static final DeferredBlock<RotatedPillarBlock> BURNT_BRICK_PILLAR               = pillar("burnt_brick_pillar");
    public static final DeferredBlock<RotatedPillarBlock> BURNT_BRICK_CRACKED_PILLAR       = pillar("burnt_brick_cracked_pillar");
    public static final DeferredBlock<RotatedPillarBlock> BURNT_COBBLESTONE_PILLAR         = pillar("burnt_cobblestone_pillar");
    public static final DeferredBlock<RotatedPillarBlock> BURNT_SMOOTH_STONE_PILLAR        = pillar("burnt_smooth_stone_pillar");

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
