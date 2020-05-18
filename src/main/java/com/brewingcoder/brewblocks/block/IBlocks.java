package com.brewingcoder.brewblocks.block;

import com.brewingcoder.brewblocks.item.ItemGroups;
import com.brewingcoder.brewteamlib.block.CropBlockBase;
import com.brewingcoder.brewteamlib.block.IBlock;
import com.brewingcoder.brewteamlib.block.OreBlockBase;
import com.brewingcoder.brewteamlib.block.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.util.ArrayList;
import java.util.List;

public class IBlocks {
    public static final List<BlockItem> BLOCK_ITEMS  = new ArrayList<>();
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block STICKY_ORE = register("sticky_ore", new OreBlockBase(Properties.rock(1.0f,8.0f)));

    //Wild plant needs special treatment to start mature and be viable on any dirt.
    public static final Block FLAX_PLANT_WILD = registerCrop(
            "flax_plant_wild",
            new CropBlockBase(
                    Block.Properties.create(Material.PLANTS)
                            .doesNotBlockMovement()
                            .tickRandomly()
                            .hardnessAndResistance(0)
                            .sound(SoundType.CROP),"flax_plant_wild",true));
    //Growable crop, starts at stage 0, must be on farmland
    public static final Block FLAX_PLANT = registerCrop(
            "flax_plant",
            new CropBlockBase(
                    Block.Properties.create(Material.PLANTS)
                            .doesNotBlockMovement()
                            .tickRandomly()
                            .hardnessAndResistance(0)
                            .sound(SoundType.CROP),"flax_plant",false));


    ///Crop blocks don't get associated itemBlock, but separate Named item defined elsewhere from seed
    static <T extends CropsBlock> T registerCrop(final String name, final T cropBlock){
        cropBlock.setRegistryName(name);
        IBlocks.BLOCKS.add(cropBlock);
        return cropBlock;
    }

    @SuppressWarnings("SameParameterValue")
    static <T extends net.minecraft.block.Block> T register(final String name, final T block) {
        final BlockItem itemBlock = ((IBlock)block).getBlockItem(new Item.Properties(), ItemGroups.MAIN);
        itemBlock.setRegistryName(name);
        block.setRegistryName(name);
        IBlocks.BLOCK_ITEMS.add(itemBlock);
        IBlocks.BLOCKS.add(block);
        return block;
    }

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<Block> event) {
        IBlocks.BLOCKS.forEach(block ->event.getRegistry().register(block));
        if(FMLEnvironment.dist == Dist.CLIENT)
        {
            RenderTypeLookup.setRenderLayer(IBlocks.FLAX_PLANT, RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(IBlocks.FLAX_PLANT_WILD,RenderType.getCutoutMipped());
        }
    }
}
