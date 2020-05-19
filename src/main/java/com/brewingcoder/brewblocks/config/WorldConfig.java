package com.brewingcoder.brewblocks.config;

import net.minecraftforge.common.ForgeConfigSpec;


@SuppressWarnings("unused")
public class WorldConfig {

    //Sticky Ore
    public final ForgeConfigSpec.BooleanValue doStickyOre;
    public final ForgeConfigSpec.IntValue StickyOreChance;
    public final ForgeConfigSpec.IntValue StickyOreClusterSize;
    public final ForgeConfigSpec.IntValue StickyOreMaxY;

    public final ForgeConfigSpec.BooleanValue doAbyssal;
    public final ForgeConfigSpec.IntValue AbyssalChance;
    public final ForgeConfigSpec.IntValue AbyssalClusterSize;
    public final ForgeConfigSpec.IntValue AbyssalMaxY;

    public final ForgeConfigSpec.BooleanValue doClay;
    public final ForgeConfigSpec.IntValue ClayChance;
    public final ForgeConfigSpec.IntValue ClayClusterSize;
    public final ForgeConfigSpec.IntValue ClayMaxY;

    public final ForgeConfigSpec.BooleanValue doWildFlaxCrop;
    public final ForgeConfigSpec.IntValue WildFlaxCropChance;
    public final ForgeConfigSpec.IntValue WildFlaxCropClusterSize;

    public WorldConfig(ForgeConfigSpec.Builder builder){

        builder.push("World_Generation");
        builder.push("Sticky_Ore");
        this.doStickyOre = builder.comment("Enables/Disables Sticky Ore World Generation.").define("stickyOreGeneration",true);
        this.StickyOreChance = builder.comment("Chance that chunk Contains Sticky Ore Vein.").defineInRange("stickyOreGenChance",10,1,64);
        this.StickyOreClusterSize = builder.comment("Size of Sticky Ore Vein.").defineInRange("stickyOreClusterSize",5,1,64);
        this.StickyOreMaxY = builder.comment("Maximum Y value to generate Sticky Ore").defineInRange("stickyOreMaxY",63,1,100);

        builder.pop();
        builder.push("Decoration_Abyssal");
        this.doAbyssal = builder.comment("Enables/Disables Abyssal World Generation.").define("abyssalGeneration",true);
        this.AbyssalChance = builder.comment("Chance that a chunk contains Abyssal vein.").defineInRange("abyssalGenChance",10,1,64);
        this.AbyssalClusterSize = builder.comment("Size of the Abyssal Vein").defineInRange("abyssalClusterSize",25,1,100);
        this.AbyssalMaxY = builder.comment("Maximum Y value to generate Abyssal").defineInRange("abyssalMaxY",63,1,100);

        builder.pop();
        builder.push("Clay_Generation");
        this.doClay = builder.comment("Enables/Disables Clay Generation.").define("clayGeneration",true);
        this.ClayChance = builder.comment("Chance that a chunk contains a Clay Vein.").defineInRange("clayChance",10,1,64);
        this.ClayClusterSize=builder.comment("Average Size of Clay Cluster.").defineInRange("clayClusterSize",16,1,100);
        this.ClayMaxY=builder.comment("Maximum Y value to generate Clay.").defineInRange("clayMaxY",62,1,100);

        builder.pop();
        builder.push("flax_crop");
        this.doWildFlaxCrop = builder.comment("Generate Wild Flax Plants (Plains Only)").define("placeWildFlaxPlants",true);
        this.WildFlaxCropChance = builder.comment("Chance of spawning a Wild Flax Crop").defineInRange("wildFlaxChance",2,1,64);
        this.WildFlaxCropClusterSize = builder.comment("Average Clust Size of Wild Flax Crop").defineInRange("wildFlaxClusterSize",2,1,20);

        builder.pop();
    }
}
