package com.brewingcoder.brewblocks.data;

import com.brewingcoder.brewblocks.block.IBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;

import static net.minecraftforge.common.Tags.Blocks.ORES;

public class TagsProvider {
    public static class Blocks extends BlockTagsProvider {
        public Blocks(DataGenerator generatorIn) {
            super(generatorIn);
        }

        @Override
        protected void registerTags() {
            getBuilder(ORES).add(IBlocks.STICKY_ORE);
            getBuilder(ITags.Blocks.STICKY_ORE).add(IBlocks.STICKY_ORE);
        }
    }

    public static class Items extends ItemTagsProvider {
        public Items(DataGenerator generatorIn) {
            super(generatorIn);
        }

        @Override
        protected void registerTags() {
            getBuilder(Tags.Items.ORES).add(IBlocks.STICKY_ORE.asItem());
            getBuilder(ITags.Items.STICKY_ORE).add(IBlocks.STICKY_ORE.asItem());
        }
    }
}