package com.brewingcoder.brewblocks.registry;

import com.brewingcoder.brewblocks.BrewBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BrewBlocks.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = REGISTRY.register(
            "main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.brewblocks"))
                    .icon(() -> new ItemStack(ModBlocks.STICKY_ORE.get()))
                    .displayItems((params, out) -> {
                        ModItems.REGISTRY.getEntries().forEach(h -> out.accept(new ItemStack(h.get())));
                    })
                    .build());

    private ModTabs() {}
}
