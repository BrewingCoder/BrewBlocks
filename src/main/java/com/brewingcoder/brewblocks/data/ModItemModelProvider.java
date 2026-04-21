package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, BrewBlocks.MODID, efh);
    }

    @Override
    protected void registerModels() {
        // Flat "generated" item models for armor. Textures live at
        // assets/brewblocks/textures/item/<name>.png.
        basicItem(ModItems.GOGGLES.getId());
        basicItem(ModItems.SLIME_BOUNCE_BOOTS.getId());
    }
}
