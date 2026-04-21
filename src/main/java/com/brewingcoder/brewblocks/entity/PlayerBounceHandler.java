package com.brewingcoder.brewblocks.entity;

import com.brewingcoder.brewblocks.BrewBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.IdentityHashMap;
import java.util.Map;

public final class PlayerBounceHandler {
    private static final Map<Entity, PlayerBounceHandler> BOUNCING = new IdentityHashMap<>();

    private final LivingEntity entity;
    private double bounce;
    private int bounceTick;
    private int timer;
    private boolean wasInAir;
    private double lastMovX;
    private double lastMovZ;

    private PlayerBounceHandler(LivingEntity entity, double bounce) {
        this.entity = entity;
        this.bounce = bounce;
        this.bounceTick = bounce != 0 ? entity.tickCount : 0;
    }

    public static void addBounceHandler(LivingEntity entity, double bounce) {
        if (entity.getType() != EntityType.PLAYER) return;
        PlayerBounceHandler handler = BOUNCING.get(entity);
        if (handler == null) {
            BOUNCING.put(entity, new PlayerBounceHandler(entity, bounce));
        } else if (bounce != 0) {
            handler.bounce = bounce;
            handler.bounceTick = entity.tickCount;
        }
    }

    @EventBusSubscriber(modid = BrewBlocks.MODID)
    public static final class Events {
        @SubscribeEvent
        public static void onPlayerTickPost(PlayerTickEvent.Post event) {
            Player player = event.getEntity();
            PlayerBounceHandler h = BOUNCING.get(player);
            if (h == null) return;
            if (player.isFallFlying()) return;

            if (player.tickCount == h.bounceTick) {
                Vec3 m = player.getDeltaMovement();
                player.setDeltaMovement(m.x, m.y + h.bounce, m.z);
                h.bounceTick = 0;
            }
            if (!player.onGround() && player.tickCount != h.bounceTick) {
                Vec3 m = player.getDeltaMovement();
                if (h.lastMovX != m.x || h.lastMovZ != m.z) {
                    double f = 0.91d + 0.025d;
                    Vec3 nm = new Vec3(m.x / f, m.y, m.z / f);
                    player.setDeltaMovement(nm);
                    player.hasImpulse = true;
                    h.lastMovX = nm.x;
                    h.lastMovZ = nm.z;
                }
            }
            if (h.wasInAir && player.onGround()) {
                if (h.timer == 0) {
                    h.timer = player.tickCount;
                } else if (player.tickCount - h.timer > 5) {
                    BOUNCING.remove(player);
                }
            } else {
                h.timer = 0;
                h.wasInAir = true;
            }
        }
    }

    @SuppressWarnings("unused")
    private static void keepNeoForgeImport() { NeoForge.EVENT_BUS.hashCode(); }
}
