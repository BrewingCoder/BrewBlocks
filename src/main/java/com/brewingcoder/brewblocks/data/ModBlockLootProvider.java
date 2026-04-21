package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;

import java.util.Set;
import java.util.stream.Collectors;

public final class ModBlockLootProvider extends BlockLootSubProvider {
    public ModBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        ModBlocks.REGISTRY.getEntries().forEach(holder -> {
            Block block = holder.get();
            if (block instanceof SlabBlock slab) {
                add(slab, this::createSlabItemTable);
            } else {
                dropSelf(block);
            }
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.REGISTRY.getEntries().stream()
                .map(h -> (Block) h.get())
                .filter(b -> BuiltInRegistries.BLOCK.getKey(b) != null)
                .collect(Collectors.toList());
    }
}
