package com.brewingcoder.brewblocks.item;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.block.IBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroups {
    public static final ItemGroup MAIN = new ItemGroup(BrewBlocks.MODID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(IBlocks.STICKY_ORE);
        }
    };
}

