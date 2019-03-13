package com.noobanidus.hungering.proxy;

import com.noobanidus.hungering.HungeringCT;
import com.noobanidus.hungering.Hungering;
import com.noobanidus.hungering.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy implements ISidedProxy {
    public void preInit(FMLPreInitializationEvent event) {
        Hungering.TAB = new HungeringCT(CreativeTabs.getNextID(), Hungering.MODID);
        Items.preInit();
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    public void loadComplete(FMLLoadCompleteEvent event) {
        Hungering.LOG.info("Hungering: Load Complete.");
        Hungering.CONFIG.save();
    }

    public void serverStarting(FMLServerStartingEvent event) {
    }

    public void serverStarted(FMLServerStartedEvent event) {
    }
}
