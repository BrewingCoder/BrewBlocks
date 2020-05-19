package com.brewingcoder.brewblocks;

import com.brewingcoder.brewblocks.config.Configs;
import com.brewingcoder.brewblocks.world.IFeatures;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.brewingcoder.brewteamlib.BrewTeamLib.addModListener;

@SuppressWarnings("unused")
@Mod(BrewBlocks.MODID)
public class BrewBlocks
{
    public static final String MODID = "brewblocks";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public BrewBlocks() {
        addModListener(this::commonSetup);
        addModListener(this::clientSetup);
        Configs.register();
    }

     void commonSetup(final FMLCommonSetupEvent event) {
        IFeatures.register();
    }

    void clientSetup(final FMLClientSetupEvent event) {
    }

}
