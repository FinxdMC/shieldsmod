package com.finxd.shieldsmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ShieldsMod.MODID)
public class ShieldsMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "shieldsmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ShieldsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModItems.addCustomItemProperties();
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.WOODEN_SHIELD);
            event.accept(ModItems.GOLDEN_SHIELD);
            event.accept(ModItems.COPPER_SHIELD);
            event.accept(ModItems.IRON_SHIELD);
            event.accept(ModItems.DIAMOND_SHIELD);
            event.accept(ModItems.NETHERITE_SHIELD);
        }
    }
}
