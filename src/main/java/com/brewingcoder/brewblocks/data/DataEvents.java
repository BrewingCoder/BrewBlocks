package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BrewBlocks.MODID)
public final class DataEvents {
    private DataEvents() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        // Client-side
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(output, efh));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, efh));

        // Server-side
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, registries, efh);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(),
                new ModItemTagsProvider(output, registries, blockTags.contentsGetter(), efh));
        gen.addProvider(event.includeServer(), new ModLootTableProvider(output, registries));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(output, registries));
    }
}
