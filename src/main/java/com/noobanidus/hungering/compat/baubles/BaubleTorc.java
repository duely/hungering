package com.noobanidus.hungering.compat.baubles;

import baubles.api.BaubleType;
import baubles.api.cap.BaubleItem;
import com.noobanidus.hungering.init.Items;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class BaubleTorc extends BaubleItem {
    public BaubleTorc() {
        super(BaubleType.TRINKET);
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        Items.torc.onUpdate(itemstack, player.world, player, -1, false);
    }
}
