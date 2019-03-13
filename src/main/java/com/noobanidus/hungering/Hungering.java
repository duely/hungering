package com.noobanidus.hungering;

import com.noobanidus.hungering.init.Config;
import com.noobanidus.hungering.proxy.ISidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(modid = Hungering.MODID, name = Hungering.MODNAME, version = Hungering.VERSION, dependencies = Hungering.DEPENDS)
@SuppressWarnings("WeakerAccess")
public class Hungering {
    public static final String MODID = "hungering";
    public static final String MODNAME = "Hungering";
    public static final String VERSION = "GRADLE:VERSION";
    public static final String DEPENDS = "required-after:baubles;";

    @SuppressWarnings("unused")
    public final static Logger LOG = LogManager.getLogger(MODID);
    public final static Config CONFIG = new Config();

    @SidedProxy(modId = MODID, clientSide = "com.noobanidus.hungering.proxy.ClientProxy", serverSide = "com.noobanidus.hungering.proxy.CommonProxy")
    public static ISidedProxy proxy;

    public static HungeringCT TAB;

    @Mod.Instance(Hungering.MODID)
    public static Hungering instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        proxy.loadComplete(event);
    }

}
