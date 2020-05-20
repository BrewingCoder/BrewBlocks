package com.brewingcoder.brewblocks.item;

import com.brewingcoder.brewblocks.block.IBlocks;
import com.brewingcoder.brewblocks.material.ModArmorMaterial;
import com.brewingcoder.brewteamlib.item.SeedItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IItems {
    public static final List<Item> ITEMS = new ArrayList<>(IBlocks.BLOCK_ITEMS);

    public static final Item FLAX_SEED = register("flax_seed", new SeedItemBase(IBlocks.FLAX_PLANT,(new Item.Properties().group(ItemGroups.MAIN))));
    public static final Item NIGHT_VISION_GOGGLES = register("goggles", new NightVisionGogglesItem(ModArmorMaterial.GOOGLES,(new Item.Properties().group(ItemGroups.MAIN))));
    public static final Item SLIME_BOUNCE_BOOTS = register("slime_bounce_boots", new SlimeBounceBootsItem(ModArmorMaterial.SLIME,(new Item.Properties().group(ItemGroups.MAIN))));

    static <T extends net.minecraft.item.Item> T register(final String name, final T item) {
        item.setRegistryName(name);
        IItems.ITEMS.add(item);
        return item;
    }

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<Item> event) {
        IItems.ITEMS.forEach(item -> event.getRegistry().register(item));
    }
}