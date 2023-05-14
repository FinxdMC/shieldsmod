package com.finxd.shieldsmod.util;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class GoldenShieldItem extends ShieldItem {
    public static final int EFFECTIVE_BLOCK_DELAY = 5;
    public static final float MINIMUM_DURABILITY_DAMAGE = 3F;

    public GoldenShieldItem(Properties p_43089_) {
        super(p_43089_);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public UseAnim getUseAnimation(ItemStack p_43105_) {
        return UseAnim.BLOCK;
    }

    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    public InteractionResultHolder<ItemStack> use(Level p_43099_, Player p_43100_, InteractionHand p_43101_) {
        ItemStack itemstack = p_43100_.getItemInHand(p_43101_);
        p_43100_.startUsingItem(p_43101_);
        return InteractionResultHolder.consume(itemstack);
    }

    public boolean isValidRepairItem(ItemStack p_43091_, ItemStack p_43092_) {
        return p_43092_.is(Items.GOLD_INGOT) || super.isValidRepairItem(p_43091_, p_43092_);
    }

    /* ******************** FORGE START ******************** */

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }
}

