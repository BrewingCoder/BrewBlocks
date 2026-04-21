package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public final class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> registries,
                               CompletableFuture<TagsProvider.TagLookup<Block>> blockTagLookup,
                               ExistingFileHelper efh) {
        super(output, registries, blockTagLookup, BrewBlocks.MODID, efh);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Copy sticky ore's block-tag ore membership onto the item form.
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
    }
}
