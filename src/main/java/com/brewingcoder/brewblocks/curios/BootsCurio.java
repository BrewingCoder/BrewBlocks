package com.brewingcoder.brewblocks.curios;

import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurio;

/**
 * Minimal ICurio impl for Slime Bounce Boots. Fall-bounce logic lives in
 * {@link com.brewingcoder.brewblocks.item.SlimeBounceBootsItem.Events},
 * which checks both the feet armor slot and the feet curio slot via
 * {@link CuriosSlots}.
 */
public final class BootsCurio implements ICurio {
    private final ItemStack stack;

    public BootsCurio(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getStack() {
        return stack;
    }
}
