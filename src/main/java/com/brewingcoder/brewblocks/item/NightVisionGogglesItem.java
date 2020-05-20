package com.brewingcoder.brewblocks.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public class NightVisionGogglesItem extends ArmorItem {

    private static final UUID[] ARMOR_MODIFIERS =
            new UUID[] {
                    UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
                    UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
                    UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
                    UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")
            };

    public NightVisionGogglesItem(IArmorMaterial material, Properties properties){
        super(material, EquipmentSlotType.HEAD,properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,240,0,true,false));
    }

    @Override
    @Nonnull
    public Multimap<String, AttributeModifier> getAttributeModifiers(
            @Nullable EquipmentSlotType equipmentSlot) {
        return HashMultimap.create();
    }
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(
            EquipmentSlotType slot, ItemStack stack) {
        if(slot == this.getEquipmentSlot()) {
            Multimap<String,AttributeModifier> multimap = super.getAttributeModifiers(slot);
            multimap.put(
                    SharedMonsterAttributes.MAX_HEALTH.getName(),
                    new AttributeModifier(
                            ARMOR_MODIFIERS[slot.getIndex()],
                            "Max Health",
                            -10,
                            AttributeModifier.Operation.ADDITION));
            return multimap;
        }else{
            return this.getAttributeModifiers(slot);
        }
    }
}
