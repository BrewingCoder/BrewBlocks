package com.brewingcoder.brewblocks.entity.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.IdentityHashMap;

public class PlayerBounceHandler {

    private static final IdentityHashMap<Entity,PlayerBounceHandler> bouncingPlayers = new IdentityHashMap<>();
    public final LivingEntity livingEntity;
    private int timer;
    private double bounce;
    private boolean wasInAir;
    private int bounceTick;
    private double lastMovX;
    private double lastMovZ;

    public PlayerBounceHandler(LivingEntity entity, double bounce){
        this.livingEntity=entity;
        timer=0;
        wasInAir=false;
        this.bounce=bounce;
        if(bounce != 0){
            bounceTick = livingEntity.ticksExisted;
        }else{
            bounceTick=0;
        }
        bouncingPlayers.put(livingEntity,this);
    }
    @SubscribeEvent
    public void playerTickPost(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.END && event.player == livingEntity && !event.player.isElytraFlying()) {

            if(event.player.ticksExisted == bounceTick) {
                event.player.setMotion(event.player.getMotion().add(0,bounce,0));
                bounceTick = 0;
            }
            if(!livingEntity.onGround && livingEntity.ticksExisted != bounceTick) {
                if(lastMovX != livingEntity.getMotion().x || lastMovZ != livingEntity.getMotion().z) {
                    double f = 0.91d + 0.025d;
                    Vec3d curMotion = livingEntity.getMotion();
                    Vec3d newMotion = new Vec3d(curMotion.x/f,curMotion.y,curMotion.z/f);
                    livingEntity.setMotion(newMotion);
                    livingEntity.isAirBorne = true;
                    lastMovX = newMotion.x;
                    lastMovZ = newMotion.y;
                }
            }
            if(wasInAir && livingEntity.onGround) {
                if(timer == 0) {
                    timer = livingEntity.ticksExisted;
                }
                else if(livingEntity.ticksExisted - timer > 5) {
                    MinecraftForge.EVENT_BUS.unregister(this);
                    bouncingPlayers.remove(livingEntity);
                }
            }
            else {
                timer = 0;
                wasInAir = true;
            }
        }
    }

    public static void addBounceHandler(LivingEntity entity, double bounce) {
        if(!entity.getType().equals(EntityType.PLAYER)) {
            return;
        }
        PlayerBounceHandler handler = bouncingPlayers.get(entity);
        if(handler == null) {
            MinecraftForge.EVENT_BUS.register(new PlayerBounceHandler(entity, bounce));
        }
        else if(bounce != 0) {
            handler.bounce = bounce;
            handler.bounceTick = entity.ticksExisted;
        }
    }
}
