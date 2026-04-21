package com.brewingcoder.brewblocks.item;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.curios.CuriosSlots;
import com.brewingcoder.brewblocks.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Single source of truth for Night Vision Goggles effects.
 *
 * The goggles can be worn in two places: the head armor slot (vanilla) or a
 * head curio slot (with Curios installed). Rather than duplicating the effect
 * logic in {@code ArmorItem#inventoryTick}, {@code ICurio#curioTick}, and an
 * attribute component, we run one check per tick here and apply/remove both
 * the NV effect and the MAX_HEALTH debuff as a unit.
 *
 * Original 1.15 behavior: "significantly reduce your health while worn" — we
 * restore that as a -10 MAX_HEALTH attribute modifier.
 */
@EventBusSubscriber(modid = BrewBlocks.MODID)
public final class GogglesEffectsHandler {
    private static final boolean CURIOS_LOADED = ModList.get().isLoaded("curios");

    private static final ResourceLocation HEALTH_MOD_ID =
            BrewBlocks.id("goggles_health_penalty");
    private static final double HEALTH_PENALTY = -10.0;

    private GogglesEffectsHandler() {}

    @SubscribeEvent
    public static void onPlayerTickPost(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide) return;

        boolean worn = isWearingGoggles(player);

        AttributeInstance health = player.getAttribute(Attributes.MAX_HEALTH);
        if (health == null) return;

        if (worn) {
            if (health.getModifier(HEALTH_MOD_ID) == null) {
                health.addTransientModifier(new AttributeModifier(
                        HEALTH_MOD_ID,
                        HEALTH_PENALTY,
                        AttributeModifier.Operation.ADD_VALUE));
            }
            player.addEffect(new MobEffectInstance(
                    MobEffects.NIGHT_VISION, 240, 0, true, false, false));
        } else if (health.getModifier(HEALTH_MOD_ID) != null) {
            health.removeModifier(HEALTH_MOD_ID);
        }
    }

    private static boolean isWearingGoggles(Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.GOGGLES.get()) {
            return true;
        }
        return CURIOS_LOADED && CuriosSlots.isWornAsCurio(player, ModItems.GOGGLES.get());
    }
}
