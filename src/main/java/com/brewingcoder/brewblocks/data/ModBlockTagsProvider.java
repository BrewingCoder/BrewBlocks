package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public final class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> registries,
                                ExistingFileHelper efh) {
        super(output, registries, BrewBlocks.MODID, efh);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var pickaxe = tag(BlockTags.MINEABLE_WITH_PICKAXE);
        var needsStone = tag(BlockTags.NEEDS_STONE_TOOL);
        var walls = tag(BlockTags.WALLS);
        var fences = tag(BlockTags.FENCES);
        var fenceGates = tag(BlockTags.FENCE_GATES);
        var buttons = tag(BlockTags.BUTTONS);
        var plates = tag(BlockTags.PRESSURE_PLATES);

        ModBlocks.REGISTRY.getEntries().forEach(holder -> {
            Block block = holder.get();
            pickaxe.add(block);
            needsStone.add(block);
            if (block instanceof WallBlock) walls.add(block);
            else if (block instanceof FenceGateBlock) fenceGates.add(block);
            else if (block instanceof FenceBlock) fences.add(block);
            else if (block instanceof ButtonBlock) buttons.add(block);
            else if (block instanceof PressurePlateBlock) plates.add(block);
        });

        // Sticky ore counts as an ore for common tag aggregators.
        tag(Tags.Blocks.ORES).add(ModBlocks.STICKY_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(ModBlocks.STICKY_ORE.get());
    }
}
