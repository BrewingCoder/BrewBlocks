package com.brewingcoder.brewblocks.registry;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.item.NightVisionGogglesItem;
import com.brewingcoder.brewblocks.item.SlimeBounceBootsItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BrewBlocks.MODID);

    // Auto-register BlockItems for every block we declare. Must run before
    // any field initialization that depends on BlockItem holders.
    static {
        ModBlocks.REGISTRY.getEntries().forEach(blockHolder ->
                REGISTRY.registerSimpleBlockItem(
                        (net.neoforged.neoforge.registries.DeferredBlock<?>) blockHolder));
    }

    public static final DeferredItem<ArmorItem> GOGGLES = REGISTRY.registerItem(
            "goggles",
            props -> new NightVisionGogglesItem(ModArmorMaterials.GOGGLES, ArmorItem.Type.HELMET, props),
            new Item.Properties().stacksTo(1));

    public static final DeferredItem<ArmorItem> SLIME_BOUNCE_BOOTS = REGISTRY.registerItem(
            "slime_bounce_boots",
            props -> new SlimeBounceBootsItem(ModArmorMaterials.SLIME, ArmorItem.Type.BOOTS, props),
            new Item.Properties().stacksTo(1).durability(400));

    @SuppressWarnings("unused")
    public static BlockItem forceInit() { return null; }

    private ModItems() {}
}
