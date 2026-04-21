package com.brewingcoder.brewblocks.curios;

import com.brewingcoder.brewblocks.BrewBlocks;
import com.brewingcoder.brewblocks.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import top.theillusivec4.curios.api.CuriosCapability;

/**
 * Soft-dep entry point. Only referenced from the main mod class inside a
 * {@code ModList.get().isLoaded("curios")} guard, so the JVM never tries to
 * resolve the {@code top.theillusivec4.*} imports when Curios is absent.
 */
public final class CuriosIntegration {
    public static void init(IEventBus modBus) {
        modBus.addListener(CuriosIntegration::onRegisterCaps);
        BrewBlocks.LOGGER.info("Curios integration enabled");
    }

    private static void onRegisterCaps(RegisterCapabilitiesEvent event) {
        event.registerItem(
                CuriosCapability.ITEM,
                (stack, ctx) -> new GogglesCurio(stack),
                ModItems.GOGGLES.get());
        event.registerItem(
                CuriosCapability.ITEM,
                (stack, ctx) -> new BootsCurio(stack),
                ModItems.SLIME_BOUNCE_BOOTS.get());
    }

    private CuriosIntegration() {}
}
