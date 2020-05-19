package com.brewingcoder.brewblocks.block;

import com.brewingcoder.brewblocks.item.ItemGroups;
import com.brewingcoder.brewteamlib.block.*;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "rawtypes"})
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IBlocks {
    public static final List<BlockItem> BLOCK_ITEMS  = new ArrayList<>();
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block STICKY_ORE                = register("sticky_ore", new OreBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL                    = register("abyssal",    new DecoBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICKS             = register("abyssal_bricks", new DecoBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICKS_CRACKED     = register("abyssal_bricks_cracked", new DecoBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_COBBLE             = register("abyssal_cobble",new DecoBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_SMOOTH             = register("abyssal_smooth", new DecoBlockBase(Properties.rock(1.0f,8.0f)));

    public static final Block ABYSSAL_STAIRS                 = register("abyssal_stairs", new StairBlockBase(IBlocks.ABYSSAL.getDefaultState(), Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICK_STAIRS           = register("abyssal_brick_stairs",new StairBlockBase(IBlocks.ABYSSAL_BRICKS.getDefaultState(), Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICK_CRACKED_STAIRS   = register("abyssal_brick_cracked_stairs",new StairBlockBase(IBlocks.ABYSSAL_BRICKS_CRACKED.getDefaultState(), Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_COBBLE_STAIRS          = register("abyssal_cobble_stairs",new StairBlockBase(IBlocks.ABYSSAL_COBBLE.getDefaultState(), Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_SMOOTH_STAIRS          = register("abyssal_smooth_stairs",new StairBlockBase(IBlocks.ABYSSAL_SMOOTH.getDefaultState(), Properties.rock(1.0f,8.0f)));

    public static final Block ABYSSAL_SLAB                   = register("abyssal_slab", new SlabBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICKS_SLAB            = register("abyssal_brick_slab", new SlabBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICKS_CRACKED_SLAB    = register("abyssal_brick_cracked_slab", new SlabBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_COBBLE_SLAB            = register("abyssal_cobble_slab", new SlabBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_SMOOTH_SLAB            = register("abyssal_smooth_slab", new SlabBlockBase(Properties.rock(1.0f,8.0f)));

    public static final Block ABYSSAL_WALL                   = register("abyssal_wall", new WallBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICK_WALL             = register("abyssal_brick_wall",new WallBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_BRICK_CRACKED_WALL     = register("abyssal_brick_cracked_wall",new WallBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_COBBLE_WALL            = register("abyssal_cobble_wall", new WallBlockBase(Properties.rock(1.0f,8.0f)));
    public static final Block ABYSSAL_SMOOTH_WALL            = register("abyssal_smooth_wall", new WallBlockBase(Properties.rock(1.0f,8.0f)));

//    public static final Block ABYSSAL_PILLAR                 = register("abyssal_pillar", new PillarBlockBase(Properties.rock(1.0f,8.0f)));
//    public static final Block ABYSSAL_BRICK_PILLAR           = register("abyssal_brick_pillar", new PillarBlockBase(Properties.rock(1.0f,8.0f)));
//    public static final Block ABYSSAL_BRICK_CRACKED_PILLAR   = register("abyssal_brick_cracked_pillar", new PillarBlockBase(Properties.rock(1.0f,8.0f)));
//    public static final Block ABYSSAL_COBBLE_PILLAR          = register("abyssal_cobble_pillar", new PillarBlockBase(Properties.rock(1.0f,8.0f)));
//    public static final Block ABYSSAL_SMOOTH_PILLAR          = register("abyssal_smooth_pillar", new PillarBlockBase(Properties.rock(1.0f,8.0f)));
    //public static final Block QUARRIED          =register("quarried",   new DecoBlockBase(Properties.rock(1.0f,8.0f)));


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
