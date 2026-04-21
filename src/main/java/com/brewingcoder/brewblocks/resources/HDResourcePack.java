package com.brewingcoder.brewblocks.resources;

import com.brewingcoder.brewblocks.BrewBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@EventBusSubscriber(modid = BrewBlocks.MODID)
public final class HDResourcePack {
    private HDResourcePack() {}

    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;
        event.addPackFinders(
                BrewBlocks.id("resourcepacks/brewblocks_hd"),
                PackType.CLIENT_RESOURCES,
                Component.translatable("pack.brewblocks.hd.name"),
                PackSource.BUILT_IN,
                false,
                Pack.Position.TOP);
    }
}
