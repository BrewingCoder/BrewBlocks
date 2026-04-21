package com.brewingcoder.brewblocks.curios;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

/**
 * Thin wrappers over {@link CuriosApi#getCuriosInventory(LivingEntity)} used
 * by the regular item handlers. Methods here must only be invoked after a
 * {@code ModList.get().isLoaded("curios")} check — the caller owns the guard.
 */
public final class CuriosSlots {
    public static boolean isWornAsCurio(LivingEntity entity, Item item) {
        return CuriosApi.getCuriosInventory(entity)
                .flatMap(inv -> inv.findFirstCurio(item))
                .isPresent();
    }

    public static ItemStack findFirstCurio(LivingEntity entity, Item item) {
        return CuriosApi.getCuriosInventory(entity)
                .flatMap(inv -> inv.findFirstCurio(item))
                .map(r -> r.stack())
                .orElse(ItemStack.EMPTY);
    }

    private CuriosSlots() {}
}
