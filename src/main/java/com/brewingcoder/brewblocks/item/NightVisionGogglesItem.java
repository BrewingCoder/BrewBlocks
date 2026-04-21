package com.brewingcoder.brewblocks.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

/**
 * Night Vision Goggles. Marker subclass of ArmorItem — all gameplay effects
 * (NV buff + MAX_HEALTH debuff) live in {@link GogglesEffectsHandler}, which
 * handles both the head armor slot and the head curio slot in one place.
 */
public class NightVisionGogglesItem extends ArmorItem {
    public NightVisionGogglesItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }
}
