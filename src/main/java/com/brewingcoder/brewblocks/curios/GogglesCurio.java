package com.brewingcoder.brewblocks.curios;

import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurio;

/**
 * Minimal ICurio impl for Night Vision Goggles. The NV effect and max-health
 * debuff are both applied by {@link com.brewingcoder.brewblocks.item.GogglesEffectsHandler},
 * a global PlayerTickEvent handler that already knows about both wear paths —
 * no {@code curioTick} override needed here.
 */
public final class GogglesCurio implements ICurio {
    private final ItemStack stack;

    public GogglesCurio(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getStack() {
        return stack;
    }
}
