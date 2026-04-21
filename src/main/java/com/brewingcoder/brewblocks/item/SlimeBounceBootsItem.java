package com.brewingcoder.brewblocks.item;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.curios.CuriosSlots;
import com.brewingcoder.brewblocks.entity.PlayerBounceHandler;
import com.brewingcoder.brewblocks.registry.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

public class SlimeBounceBootsItem extends ArmorItem {
    public SlimeBounceBootsItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @EventBusSubscriber(modid = BrewBlocks.MODID)
    public static final class Events {
        private static final boolean CURIOS_LOADED = ModList.get().isLoaded("curios");

        @SubscribeEvent
        public static void onLivingFall(LivingFallEvent event) {
            LivingEntity entity = event.getEntity();
            if (!(entity instanceof Player player)) return;

            ItemStack boots = findBoots(player);
            if (boots.isEmpty()) return;
            if (event.getDistance() <= 2) return;

            if (player.isShiftKeyDown()) {
                event.setDamageMultiplier(0);
                player.fallDistance = 0;
                return;
            }

            boots.hurtAndBreak(10, player, EquipmentSlot.FEET);
            event.setDamageMultiplier(0);

            Vec3 m = player.getDeltaMovement();
            player.setDeltaMovement(m.x, -m.y * 0.9, m.z);
            player.hasImpulse = true;

            double f = 0.91d + 0.04d;
            Vec3 m2 = player.getDeltaMovement();
            player.setDeltaMovement(m2.x / f, m2.y, m2.z / f);

            event.setCanceled(true);
            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.SLIME_JUMP, player.getSoundSource(), 1f, 1f);
            PlayerBounceHandler.addBounceHandler(player, player.getDeltaMovement().y);
        }

        /** Look in the feet armor slot first, then feet curio slot if Curios is installed. */
        private static ItemStack findBoots(Player player) {
            ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);
            if (feet.getItem() == ModItems.SLIME_BOUNCE_BOOTS.get()) return feet;
            if (CURIOS_LOADED) {
                ItemStack curio = CuriosSlots.findFirstCurio(player, ModItems.SLIME_BOUNCE_BOOTS.get());
                if (!curio.isEmpty()) return curio;
            }
            return ItemStack.EMPTY;
        }
    }

    @SuppressWarnings("unused")
    private static void silenceUnusedImports(DamageSource ignored) {}
}
