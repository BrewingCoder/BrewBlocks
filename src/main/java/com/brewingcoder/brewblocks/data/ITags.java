package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.BrewBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ITags {
    public static class Blocks {
        public static final Tag<Block> ORE = new BlockTags.Wrapper(new ResourceLocation("forge", "ores/sticky_ore"));
        public static final Tag<Block> STICKY_ORE = tag("ores/sticky_ore");


        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation(BrewBlocks.MODID, name));
        }
    }

    public static class Items {
        public static final Tag<Item> ORE = new ItemTags.Wrapper(new ResourceLocation("forge", "ores/sticky_ore"));

        public static final Tag<Item> STICKY_ORE = tag("ores/sticky_ore");

        private static Tag<Item> tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation(BrewBlocks.MODID, name));
        }
    }
}