package com.brewingcoder.brewblocks.world;

import com.brewingcoder.brewblocks.block.IBlocks;
import com.brewingcoder.brewteamlib.feature.PlantFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class IFeatures {
    public static final List<Feature<?>> FEATURES = new ArrayList<>();

    public static void register() {
        ForgeRegistries.BIOMES.forEach(biome -> {
            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(
                            new OreFeatureConfig(
                                    OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                    IBlocks.STICKY_ORE.getDefaultState(),5))
                            .withPlacement(
                                    Placement.COUNT_RANGE.configure(new CountRangeConfig(40,0,0,254))
                            ));


            if (biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.TAIGA) {
                biome.addFeature(
                        GenerationStage.Decoration.VEGETAL_DECORATION,
                        (
                                new PlantFeature(IBlocks.FLAX_PLANT_WILD.getDefaultState(),1,4)
                                        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                                        .withPlacement(Placement.COUNT_HEIGHT_64.configure(new FrequencyConfig(3)))
                        )
                );
            }
        });
    }
    static Feature<NoFeatureConfig> register(String id, Feature<NoFeatureConfig> feature) {
        feature.setRegistryName(id);
        FEATURES.add(feature);
        return feature;
    }

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Feature<?>> event) {
        FEATURES.forEach(feature -> event.getRegistry().register(feature));
    }
}
