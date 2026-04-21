package com.brewingcoder.brewblocks;

import com.brewingcoder.brewblocks.config.Configs;
import com.brewingcoder.brewblocks.registry.ModArmorMaterials;
import com.brewingcoder.brewblocks.registry.ModBlocks;
import com.brewingcoder.brewblocks.registry.ModItems;
import com.brewingcoder.brewblocks.registry.ModTabs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(BrewBlocks.MODID)
public final class BrewBlocks {
    public static final String MODID = "brewblocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public BrewBlocks(IEventBus modBus, ModContainer container) {
        ModBlocks.REGISTRY.register(modBus);
        ModItems.REGISTRY.register(modBus);
        ModTabs.REGISTRY.register(modBus);
        ModArmorMaterials.REGISTRY.register(modBus);

        container.registerConfig(ModConfig.Type.COMMON, Configs.COMMON_SPEC, MODID + "-common.toml");

        // Curios is an optional dep — only touch the integration class if it's loaded,
        // otherwise the JVM would try to resolve top.theillusivec4.* and fail.
        if (ModList.get().isLoaded("curios")) {
            com.brewingcoder.brewblocks.curios.CuriosIntegration.init(modBus);
        }

        LOGGER.info("BrewBlocks booting on NeoForge 1.21.1");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
