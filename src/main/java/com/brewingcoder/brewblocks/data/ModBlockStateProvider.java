package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public final class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, BrewBlocks.MODID, efh);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.STICKY_ORE.get(), cubeAll(ModBlocks.STICKY_ORE.get()));

        // Abyssal family
        decoSet(ModBlocks.ABYSSAL_STONE, ModBlocks.ABYSSAL_STONE_STAIRS, ModBlocks.ABYSSAL_STONE_SLAB, ModBlocks.ABYSSAL_STONE_WALL,
                ModBlocks.ABYSSAL_STONE_FENCE, ModBlocks.ABYSSAL_STONE_FENCE_GATE,
                ModBlocks.ABYSSAL_STONE_BUTTON, ModBlocks.ABYSSAL_STONE_PRESSURE_PLATE, ModBlocks.ABYSSAL_STONE_PILLAR);
        decoSet(ModBlocks.ABYSSAL_BRICKS, ModBlocks.ABYSSAL_BRICK_STAIRS, ModBlocks.ABYSSAL_BRICK_SLAB, ModBlocks.ABYSSAL_BRICK_WALL,
                ModBlocks.ABYSSAL_BRICK_FENCE, ModBlocks.ABYSSAL_BRICK_FENCE_GATE,
                ModBlocks.ABYSSAL_BRICK_BUTTON, ModBlocks.ABYSSAL_BRICK_PRESSURE_PLATE, ModBlocks.ABYSSAL_BRICK_PILLAR);
        decoSet(ModBlocks.ABYSSAL_BRICKS_CRACKED, ModBlocks.ABYSSAL_BRICK_CRACKED_STAIRS, ModBlocks.ABYSSAL_BRICK_CRACKED_SLAB, ModBlocks.ABYSSAL_BRICK_CRACKED_WALL,
                ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE, ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE_GATE,
                ModBlocks.ABYSSAL_BRICK_CRACKED_BUTTON, ModBlocks.ABYSSAL_BRICK_CRACKED_PRESSURE_PLATE, ModBlocks.ABYSSAL_BRICK_CRACKED_PILLAR);
        decoSet(ModBlocks.ABYSSAL_COBBLESTONE, ModBlocks.ABYSSAL_COBBLESTONE_STAIRS, ModBlocks.ABYSSAL_COBBLESTONE_SLAB, ModBlocks.ABYSSAL_COBBLESTONE_WALL,
                ModBlocks.ABYSSAL_COBBLESTONE_FENCE, ModBlocks.ABYSSAL_COBBLESTONE_FENCE_GATE,
                ModBlocks.ABYSSAL_COBBLESTONE_BUTTON, ModBlocks.ABYSSAL_COBBLESTONE_PRESSURE_PLATE, ModBlocks.ABYSSAL_COBBLESTONE_PILLAR);
        decoSet(ModBlocks.ABYSSAL_SMOOTH_STONE, ModBlocks.ABYSSAL_SMOOTH_STONE_STAIRS, ModBlocks.ABYSSAL_SMOOTH_STONE_SLAB, ModBlocks.ABYSSAL_SMOOTH_STONE_WALL,
                ModBlocks.ABYSSAL_SMOOTH_STONE_FENCE, ModBlocks.ABYSSAL_SMOOTH_STONE_FENCE_GATE,
                ModBlocks.ABYSSAL_SMOOTH_STONE_BUTTON, ModBlocks.ABYSSAL_SMOOTH_STONE_PRESSURE_PLATE, ModBlocks.ABYSSAL_SMOOTH_STONE_PILLAR);

        // Quarried family
        decoSet(ModBlocks.QUARRIED_STONE, ModBlocks.QUARRIED_STONE_STAIRS, ModBlocks.QUARRIED_STONE_SLAB, ModBlocks.QUARRIED_STONE_WALL,
                ModBlocks.QUARRIED_STONE_FENCE, ModBlocks.QUARRIED_STONE_FENCE_GATE,
                ModBlocks.QUARRIED_STONE_BUTTON, ModBlocks.QUARRIED_STONE_PRESSURE_PLATE, ModBlocks.QUARRIED_STONE_PILLAR);
        decoSet(ModBlocks.QUARRIED_BRICKS, ModBlocks.QUARRIED_BRICK_STAIRS, ModBlocks.QUARRIED_BRICK_SLAB, ModBlocks.QUARRIED_BRICK_WALL,
                ModBlocks.QUARRIED_BRICK_FENCE, ModBlocks.QUARRIED_BRICK_FENCE_GATE,
                ModBlocks.QUARRIED_BRICK_BUTTON, ModBlocks.QUARRIED_BRICK_PRESSURE_PLATE, ModBlocks.QUARRIED_BRICK_PILLAR);
        decoSet(ModBlocks.QUARRIED_BRICKS_CRACKED, ModBlocks.QUARRIED_BRICK_CRACKED_STAIRS, ModBlocks.QUARRIED_BRICK_CRACKED_SLAB, ModBlocks.QUARRIED_BRICK_CRACKED_WALL,
                ModBlocks.QUARRIED_BRICK_CRACKED_FENCE, ModBlocks.QUARRIED_BRICK_CRACKED_FENCE_GATE,
                ModBlocks.QUARRIED_BRICK_CRACKED_BUTTON, ModBlocks.QUARRIED_BRICK_CRACKED_PRESSURE_PLATE, ModBlocks.QUARRIED_BRICK_CRACKED_PILLAR);
        decoSet(ModBlocks.QUARRIED_COBBLESTONE, ModBlocks.QUARRIED_COBBLESTONE_STAIRS, ModBlocks.QUARRIED_COBBLESTONE_SLAB, ModBlocks.QUARRIED_COBBLESTONE_WALL,
                ModBlocks.QUARRIED_COBBLESTONE_FENCE, ModBlocks.QUARRIED_COBBLESTONE_FENCE_GATE,
                ModBlocks.QUARRIED_COBBLESTONE_BUTTON, ModBlocks.QUARRIED_COBBLESTONE_PRESSURE_PLATE, ModBlocks.QUARRIED_COBBLESTONE_PILLAR);
        decoSet(ModBlocks.QUARRIED_SMOOTH_STONE, ModBlocks.QUARRIED_SMOOTH_STONE_STAIRS, ModBlocks.QUARRIED_SMOOTH_STONE_SLAB, ModBlocks.QUARRIED_SMOOTH_STONE_WALL,
                ModBlocks.QUARRIED_SMOOTH_STONE_FENCE, ModBlocks.QUARRIED_SMOOTH_STONE_FENCE_GATE,
                ModBlocks.QUARRIED_SMOOTH_STONE_BUTTON, ModBlocks.QUARRIED_SMOOTH_STONE_PRESSURE_PLATE, ModBlocks.QUARRIED_SMOOTH_STONE_PILLAR);

        // Burnt family
        decoSet(ModBlocks.BURNT_STONE, ModBlocks.BURNT_STONE_STAIRS, ModBlocks.BURNT_STONE_SLAB, ModBlocks.BURNT_STONE_WALL,
                ModBlocks.BURNT_STONE_FENCE, ModBlocks.BURNT_STONE_FENCE_GATE,
                ModBlocks.BURNT_STONE_BUTTON, ModBlocks.BURNT_STONE_PRESSURE_PLATE, ModBlocks.BURNT_STONE_PILLAR);
        decoSet(ModBlocks.BURNT_BRICKS, ModBlocks.BURNT_BRICK_STAIRS, ModBlocks.BURNT_BRICK_SLAB, ModBlocks.BURNT_BRICK_WALL,
                ModBlocks.BURNT_BRICK_FENCE, ModBlocks.BURNT_BRICK_FENCE_GATE,
                ModBlocks.BURNT_BRICK_BUTTON, ModBlocks.BURNT_BRICK_PRESSURE_PLATE, ModBlocks.BURNT_BRICK_PILLAR);
        decoSet(ModBlocks.BURNT_BRICKS_CRACKED, ModBlocks.BURNT_BRICK_CRACKED_STAIRS, ModBlocks.BURNT_BRICK_CRACKED_SLAB, ModBlocks.BURNT_BRICK_CRACKED_WALL,
                ModBlocks.BURNT_BRICK_CRACKED_FENCE, ModBlocks.BURNT_BRICK_CRACKED_FENCE_GATE,
                ModBlocks.BURNT_BRICK_CRACKED_BUTTON, ModBlocks.BURNT_BRICK_CRACKED_PRESSURE_PLATE, ModBlocks.BURNT_BRICK_CRACKED_PILLAR);
        decoSet(ModBlocks.BURNT_COBBLESTONE, ModBlocks.BURNT_COBBLESTONE_STAIRS, ModBlocks.BURNT_COBBLESTONE_SLAB, ModBlocks.BURNT_COBBLESTONE_WALL,
                ModBlocks.BURNT_COBBLESTONE_FENCE, ModBlocks.BURNT_COBBLESTONE_FENCE_GATE,
                ModBlocks.BURNT_COBBLESTONE_BUTTON, ModBlocks.BURNT_COBBLESTONE_PRESSURE_PLATE, ModBlocks.BURNT_COBBLESTONE_PILLAR);
        decoSet(ModBlocks.BURNT_SMOOTH_STONE, ModBlocks.BURNT_SMOOTH_STONE_STAIRS, ModBlocks.BURNT_SMOOTH_STONE_SLAB, ModBlocks.BURNT_SMOOTH_STONE_WALL,
                ModBlocks.BURNT_SMOOTH_STONE_FENCE, ModBlocks.BURNT_SMOOTH_STONE_FENCE_GATE,
                ModBlocks.BURNT_SMOOTH_STONE_BUTTON, ModBlocks.BURNT_SMOOTH_STONE_PRESSURE_PLATE, ModBlocks.BURNT_SMOOTH_STONE_PILLAR);
    }

    private void decoSet(DeferredBlock<Block> base,
                         DeferredBlock<StairBlock> stair,
                         DeferredBlock<SlabBlock> slab,
                         DeferredBlock<WallBlock> wall,
                         DeferredBlock<FenceBlock> fence,
                         DeferredBlock<FenceGateBlock> gate,
                         DeferredBlock<ButtonBlock> button,
                         DeferredBlock<PressurePlateBlock> plate,
                         DeferredBlock<RotatedPillarBlock> pillar) {
        Block baseBlock = base.get();
        ResourceLocation tex = blockTexture(baseBlock);
        ResourceLocation baseModel = modLoc("block/" + pathOf(baseBlock));

        simpleBlockWithItem(baseBlock, cubeAll(baseBlock));

        StairBlock stairBlock = stair.get();
        stairsBlock(stairBlock, tex);
        itemModels().withExistingParent(pathOf(stairBlock), modLoc("block/" + pathOf(stairBlock)));

        SlabBlock slabBlock = slab.get();
        slabBlock(slabBlock, baseModel, tex);
        itemModels().withExistingParent(pathOf(slabBlock), modLoc("block/" + pathOf(slabBlock)));

        WallBlock wallBlock = wall.get();
        wallBlock(wallBlock, tex);
        itemModels().wallInventory(pathOf(wallBlock), tex);

        FenceBlock fenceBlock = fence.get();
        fenceBlock(fenceBlock, tex);
        itemModels().fenceInventory(pathOf(fenceBlock), tex);

        FenceGateBlock gateBlock = gate.get();
        fenceGateBlock(gateBlock, tex);
        itemModels().withExistingParent(pathOf(gateBlock), modLoc("block/" + pathOf(gateBlock)));

        ButtonBlock buttonBlock = button.get();
        buttonBlock(buttonBlock, tex);
        itemModels().buttonInventory(pathOf(buttonBlock), tex);

        PressurePlateBlock plateBlock = plate.get();
        pressurePlateBlock(plateBlock, tex);
        itemModels().withExistingParent(pathOf(plateBlock), modLoc("block/" + pathOf(plateBlock)));

        RotatedPillarBlock pillarBlock = pillar.get();
        axisBlock(pillarBlock, tex, tex);
        itemModels().withExistingParent(pathOf(pillarBlock), modLoc("block/" + pathOf(pillarBlock)));
    }

    private static String pathOf(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }
}
