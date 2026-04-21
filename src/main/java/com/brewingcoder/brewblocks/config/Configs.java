package com.brewingcoder.brewblocks.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class Configs {
    public static final WorldConfig WORLD;
    public static final ModConfigSpec COMMON_SPEC;

    static {
        Pair<WorldConfig, ModConfigSpec> pair =
                new ModConfigSpec.Builder().configure(WorldConfig::new);
        WORLD = pair.getLeft();
        COMMON_SPEC = pair.getRight();
    }

    private Configs() {}
}
