package com.brewingcoder.brewblocks.registry;

import com.brewingcoder.brewblocks.BrewBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> REGISTRY =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, BrewBlocks.MODID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> GOGGLES_MATERIAL = REGISTRY.register(
            "goggles", () -> new ArmorMaterial(
                    defenseMap(0, 0, 0, 0, 0),
                    0,
                    Holder.direct(SoundEvents.ARMOR_EQUIP_LEATHER.value()),
                    () -> Ingredient.of(Items.LEATHER),
                    List.of(new ArmorMaterial.Layer(BrewBlocks.id("goggles"))),
                    0.0f,
                    0.0f));

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> SLIME_MATERIAL = REGISTRY.register(
            "slime", () -> new ArmorMaterial(
                    defenseMap(0, 0, 0, 0, 0),
                    0,
                    Holder.direct(SoundEvents.ARMOR_EQUIP_LEATHER.value()),
                    () -> Ingredient.of(Items.SLIME_BALL),
                    List.of(new ArmorMaterial.Layer(BrewBlocks.id("slime"))),
                    0.0f,
                    0.0f));

    // Resolved Holders used by ArmorItem constructors.
    public static final Holder<ArmorMaterial> GOGGLES = GOGGLES_MATERIAL;
    public static final Holder<ArmorMaterial> SLIME = SLIME_MATERIAL;

    private static EnumMap<ArmorItem.Type, Integer> defenseMap(int helmet, int chestplate,
                                                               int leggings, int boots, int body) {
        EnumMap<ArmorItem.Type, Integer> map = new EnumMap<>(ArmorItem.Type.class);
        map.put(ArmorItem.Type.HELMET, helmet);
        map.put(ArmorItem.Type.CHESTPLATE, chestplate);
        map.put(ArmorItem.Type.LEGGINGS, leggings);
        map.put(ArmorItem.Type.BOOTS, boots);
        map.put(ArmorItem.Type.BODY, body);
        return map;
    }

    private ModArmorMaterials() {}
}
