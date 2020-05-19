package com.brewingcoder.brewblocks.config;

import com.brewingcoder.brewteamlib.config.Config;
import com.brewingcoder.brewteamlib.config.IConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

@SuppressWarnings("unused")
public class Configs {
    public static final WorldConfig WORLD;
    public static final ForgeConfigSpec WORLD_SPEC;

    public static void register() {
        final String path = Config.createConfigDir("brewblocks");

        Config.registerCommon(WORLD_SPEC,path + "/world_generation.toml");
    }

    static <T extends IConfig> T register(final T config) {
        return config;
    }

    static {
        final Pair<WorldConfig,ForgeConfigSpec> worldGenPair = Config.get(WorldConfig::new);
        WORLD = worldGenPair.getLeft();
        WORLD_SPEC =worldGenPair.getRight();
    }

}
