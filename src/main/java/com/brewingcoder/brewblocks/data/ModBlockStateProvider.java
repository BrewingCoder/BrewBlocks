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
        // Sticky ore — simple cube
        simpleBlockWithItem(ModBlocks.STICKY_ORE.get(), cubeAll(ModBlocks.STICKY_ORE.get()));

        // Abyssal family
        decoSet(ModBlocks.ABYSSAL, ModBlocks.ABYSSAL_STAIRS, ModBlocks.ABYSSAL_SLAB, ModBlocks.ABYSSAL_WALL,
                ModBlocks.ABYSSAL_FENCE, ModBlocks.ABYSSAL_FENCE_GATE,
                ModBlocks.ABYSSAL_BUTTON, ModBlocks.ABYSSAL_PRESSURE_PLATE);
        decoSet(ModBlocks.ABYSSAL_BRICKS, ModBlocks.ABYSSAL_BRICK_STAIRS, ModBlocks.ABYSSAL_BRICK_SLAB, ModBlocks.ABYSSAL_BRICK_WALL,
                ModBlocks.ABYSSAL_BRICK_FENCE, ModBlocks.ABYSSAL_BRICK_FENCE_GATE,
                ModBlocks.ABYSSAL_BRICK_BUTTON, ModBlocks.ABYSSAL_BRICK_PRESSURE_PLATE);
        decoSet(ModBlocks.ABYSSAL_BRICKS_CRACKED, ModBlocks.ABYSSAL_BRICK_CRACKED_STAIRS, ModBlocks.ABYSSAL_BRICK_CRACKED_SLAB, ModBlocks.ABYSSAL_BRICK_CRACKED_WALL,
                ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE, ModBlocks.ABYSSAL_BRICK_CRACKED_FENCE_GATE,
                ModBlocks.ABYSSAL_BRICK_CRACKED_BUTTON, ModBlocks.ABYSSAL_BRICK_CRACKED_PRESSURE_PLATE);
        decoSet(ModBlocks.ABYSSAL_COBBLE, ModBlocks.ABYSSAL_COBBLE_STAIRS, ModBlocks.ABYSSAL_COBBLE_SLAB, ModBlocks.ABYSSAL_COBBLE_WALL,
                ModBlocks.ABYSSAL_COBBLE_FENCE, ModBlocks.ABYSSAL_COBBLE_FENCE_GATE,
                ModBlocks.ABYSSAL_COBBLE_BUTTON, ModBlocks.ABYSSAL_COBBLE_PRESSURE_PLATE);
        decoSet(ModBlocks.ABYSSAL_SMOOTH, ModBlocks.ABYSSAL_SMOOTH_STAIRS, ModBlocks.ABYSSAL_SMOOTH_SLAB, ModBlocks.ABYSSAL_SMOOTH_WALL,
                ModBlocks.ABYSSAL_SMOOTH_FENCE, ModBlocks.ABYSSAL_SMOOTH_FENCE_GATE,
                ModBlocks.ABYSSAL_SMOOTH_BUTTON, ModBlocks.ABYSSAL_SMOOTH_PRESSURE_PLATE);

        // Quarried family
        decoSet(ModBlocks.QUARRIED, ModBlocks.QUARRIED_STAIRS, ModBlocks.QUARRIED_SLAB, ModBlocks.QUARRIED_WALL,
                ModBlocks.QUARRIED_FENCE, ModBlocks.QUARRIED_FENCE_GATE,
                ModBlocks.QUARRIED_BUTTON, ModBlocks.QUARRIED_PRESSURE_PLATE);
        decoSet(ModBlocks.QUARRIED_BRICKS, ModBlocks.QUARRIED_BRICKS_STAIRS, ModBlocks.QUARRIED_BRICKS_SLAB, ModBlocks.QUARRIED_BRICKS_WALL,
                ModBlocks.QUARRIED_BRICKS_FENCE, ModBlocks.QUARRIED_BRICKS_FENCE_GATE,
                ModBlocks.QUARRIED_BRICKS_BUTTON, ModBlocks.QUARRIED_BRICKS_PRESSURE_PLATE);
        decoSet(ModBlocks.QUARRIED_BRICKS_CRACKED, ModBlocks.QUARRIED_BRICKS_CRACKED_STAIRS, ModBlocks.QUARRIED_BRICKS_CRACKED_SLAB, ModBlocks.QUARRIED_BRICKS_CRACKED_WALL,
                ModBlocks.QUARRIED_BRICKS_CRACKED_FENCE, ModBlocks.QUARRIED_BRICKS_CRACKED_FENCE_GATE,
                ModBlocks.QUARRIED_BRICKS_CRACKED_BUTTON, ModBlocks.QUARRIED_BRICKS_CRACKED_PRESSURE_PLATE);
        decoSet(ModBlocks.QUARRIED_COBBLE, ModBlocks.QUARRIED_COBBLE_STAIRS, ModBlocks.QUARRIED_COBBLE_SLAB, ModBlocks.QUARRIED_COBBLE_WALL,
                ModBlocks.QUARRIED_COBBLE_FENCE, ModBlocks.QUARRIED_COBBLE_FENCE_GATE,
                ModBlocks.QUARRIED_COBBLE_BUTTON, ModBlocks.QUARRIED_COBBLE_PRESSURE_PLATE);
        decoSet(ModBlocks.QUARRIED_SMOOTH, ModBlocks.QUARRIED_SMOOTH_STAIRS, ModBlocks.QUARRIED_SMOOTH_SLAB, ModBlocks.QUARRIED_SMOOTH_WALL,
                ModBlocks.QUARRIED_SMOOTH_FENCE, ModBlocks.QUARRIED_SMOOTH_FENCE_GATE,
                ModBlocks.QUARRIED_SMOOTH_BUTTON, ModBlocks.QUARRIED_SMOOTH_PRESSURE_PLATE);
    }

    private void decoSet(DeferredBlock<Block> base,
                         DeferredBlock<StairBlock> stair,
                         DeferredBlock<SlabBlock> slab,
                         DeferredBlock<WallBlock> wall,
                         DeferredBlock<FenceBlock> fence,
                         DeferredBlock<FenceGateBlock> gate,
                         DeferredBlock<ButtonBlock> button,
                         DeferredBlock<PressurePlateBlock> plate) {
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
    }

    private static String pathOf(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }
}
