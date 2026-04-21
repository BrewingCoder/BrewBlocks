package com.brewingcoder.brewblocks.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NightVisionGogglesItem extends ArmorItem {
    public NightVisionGogglesItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;
        if (player.getItemBySlot(getEquipmentSlot()) != stack) return;
        // 240 ticks = 12s, refreshed every tick so the effect never blinks.
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, true, false, false));
    }
}
