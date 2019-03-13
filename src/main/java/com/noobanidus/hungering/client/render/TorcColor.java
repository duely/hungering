package com.noobanidus.hungering.client.render;

import com.noobanidus.hungering.init.Items;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class TorcColor implements IItemColor {
    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        if (stack.getItem() == Items.torc) {
            if (Items.torc.isActive(stack)) {
                return 0x00bdf4a8;
            }
        }

        return 0xffffffff;
    }
}
