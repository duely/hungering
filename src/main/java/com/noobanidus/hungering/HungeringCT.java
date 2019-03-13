package com.noobanidus.hungering;

import com.noobanidus.hungering.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class HungeringCT extends CreativeTabs {
    public HungeringCT(int id, String id2) {
        super(id, id2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack createIcon() {
        return new ItemStack(Items.torc);
    }
}
