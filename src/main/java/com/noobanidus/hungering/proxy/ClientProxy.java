package com.noobanidus.hungering.proxy;

import com.noobanidus.hungering.client.render.TorcColor;
import com.noobanidus.hungering.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {

    @SideOnly(Side.CLIENT)
    public void registerTints () {
        Minecraft mc = Minecraft.getMinecraft();
        ItemColors colors = mc.getItemColors();
        colors.registerItemColorHandler(new TorcColor(), Items.torc);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        registerTints();
    }
}
