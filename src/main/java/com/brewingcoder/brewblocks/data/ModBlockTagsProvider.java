package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
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

        ModBlocks.REGISTRY.getEntries().forEach(holder -> {
            Block block = holder.get();
            pickaxe.add(block);
            needsStone.add(block);
        });

        // Sticky ore counts as an ore for common tag aggregators.
        tag(Tags.Blocks.ORES).add(ModBlocks.STICKY_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(ModBlocks.STICKY_ORE.get());
    }
}
