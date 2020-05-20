package com.brewingcoder.brewblocks.item;

import com.brewingcoder.brewblocks.entity.player.PlayerBounceHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SlimeBounceBootsItem extends ArmorItem {

    public SlimeBounceBootsItem(IArmorMaterial material, Properties properties) {
        super(material, EquipmentSlotType.FEET, properties);
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event){

        LivingEntity entity = event.getEntityLiving();
        if(entity == null || entity.getType() != EntityType.PLAYER) return;

        ItemStack footArmor = entity.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (footArmor.getItem() != IItems.SLIME_BOUNCE_BOOTS) return;

        if(!entity.isSneaking() && event.getDistance() > 2) {
            footArmor.attemptDamageItem(10,entity.world.rand,null);
            event.setDamageMultiplier(0);
            entity.setMotion(entity.getMotion().x,entity.getMotion().y * -0.9,entity.getMotion().z);
            entity.isAirBorne=true;
            entity.onGround=false;
            double f = 0.91d + 0.04d;
            entity.setMotion(entity.getMotion().x / f,entity.getMotion().y,entity.getMotion().z / f);
            event.setCanceled(true);
            entity.playSound(SoundEvents.ENTITY_SLIME_JUMP,1f,1f);
            PlayerBounceHandler.addBounceHandler(entity,entity.getMotion().y);
        }
        if(entity.isSneaking() && event.getDistance() > 2) {
            event.setDamageMultiplier(0);
            entity.fallDistance =0;
        }
    }
}
