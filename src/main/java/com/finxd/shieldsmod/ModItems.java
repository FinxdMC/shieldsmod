package com.finxd.shieldsmod;

import com.finxd.shieldsmod.util.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ShieldsMod.MODID);

    public static final RegistryObject<Item> WOODEN_SHIELD = ITEMS.register("wooden_shield", () -> new WoodenShieldItem((new Item.Properties()).durability(55)));
    public static final RegistryObject<Item> GOLDEN_SHIELD = ITEMS.register("golden_shield", () -> new GoldenShieldItem((new Item.Properties()).durability(77)));
    public static final RegistryObject<Item> COPPER_SHIELD = ITEMS.register("copper_shield", () -> new CopperShieldItem((new Item.Properties()).durability(125)));
    public static final RegistryObject<Item> IRON_SHIELD = ITEMS.register("iron_shield", () -> new IronShieldItem((new Item.Properties()).durability(337)));
    public static final RegistryObject<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> new DiamondShieldItem((new Item.Properties()).durability(563)));
    public static final RegistryObject<Item> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> new NetheriteShieldItem((new Item.Properties()).durability(637).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void addCustomItemProperties() {

        makeShield(WOODEN_SHIELD.get());
        makeShield(GOLDEN_SHIELD.get());
        makeShield(COPPER_SHIELD.get());
        makeShield(IRON_SHIELD.get());
        makeShield(DIAMOND_SHIELD.get());
        makeShield(NETHERITE_SHIELD.get());
    }

    private static void makeShield(Item item) {

        ItemProperties.register(item, new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) -> {
            return p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F;
        });
    }
}
