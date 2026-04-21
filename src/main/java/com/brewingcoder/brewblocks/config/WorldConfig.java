package com.brewingcoder.brewblocks.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class WorldConfig {
    public final ModConfigSpec.BooleanValue doesStickyOreSpawnSlime;
    public final ModConfigSpec.BooleanValue doesStickyOreChanceSpawnCreeper;
    public final ModConfigSpec.IntValue stickyOreSpawnCreeperChance;

    public WorldConfig(ModConfigSpec.Builder builder) {
        builder.push("sticky_ore");
        doesStickyOreSpawnSlime = builder
                .comment("Does Sticky Ore spawn a Slime when broken?")
                .define("doesStickyOreSpawnSlime", true);
        doesStickyOreChanceSpawnCreeper = builder
                .comment("Does Sticky Ore have a chance to spawn a Creeper instead of a Slime?")
                .define("doesStickyOreChanceSpawnCreeper", true);
        stickyOreSpawnCreeperChance = builder
                .comment("Percent chance that a Creeper will spawn instead of a Slime (0-100).")
                .defineInRange("stickyOreSpawnCreeperChance", 5, 0, 100);
        builder.pop();
    }
}
