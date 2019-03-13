package com.noobanidus.hungering.init;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    private final Configuration CONFIG = new Configuration(new File("config", "hungering.cfg"), true);

    public int AUTO_TICK = CONFIG.get("General", "TickTime", 120, "How often (in ticks) the torc should subtract hunger.").getInt();
    public boolean RECIPE_ENABLED = CONFIG.get("General", "TorcRecipe", true, "Set to false to disable the torc recipe").getBoolean();
    public int MAX_DURABILITY = CONFIG.get("General", "Durability", 50, "Base durability. At the default of 2 hunger lost every 6 seconds, the torc will last 5 minutes with a durability of 50.").getInt();
    public int HUNGER_PER = CONFIG.get("General", "HungerPer", 1, "Amount of hunger to remove each time the torc effect triggers.").getInt();
    public boolean LOOT_INJECT = CONFIG.get("General", "Loot", true, "Allow the Torc of Hungering to be found in loot chests").getBoolean();

    public Config() {
    }

    public void save() {
        CONFIG.save();
    }
}
