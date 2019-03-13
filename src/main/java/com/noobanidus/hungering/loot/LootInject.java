package com.noobanidus.hungering.loot;

import com.google.common.collect.Sets;
import com.noobanidus.hungering.Hungering;
import com.noobanidus.hungering.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid=Hungering.MODID)
public class LootInject {
    private static final Set<ResourceLocation> lootTables = new HashSet<>();
    private static final LootCondition[] NONE = new LootCondition[0];

    static {
        lootTables.addAll(Sets.newHashSet(LootTableList.CHESTS_SIMPLE_DUNGEON, LootTableList.CHESTS_ABANDONED_MINESHAFT, LootTableList.CHESTS_NETHER_BRIDGE, LootTableList.CHESTS_IGLOO_CHEST, LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER, LootTableList.CHESTS_VILLAGE_BLACKSMITH, LootTableList.CHESTS_DESERT_PYRAMID, LootTableList.CHESTS_JUNGLE_TEMPLE, LootTableList.CHESTS_WOODLAND_MANSION, LootTableList.CHESTS_END_CITY_TREASURE));
    }

    @SubscribeEvent
    public static void onLootTableLoad (LootTableLoadEvent event) {
        if (lootTables.contains(event.getName())) {
            LootTable table = event.getTable();
            LootPool pool = new LootPool(new LootEntry[0], NONE, new RandomValueRange(1, 2), new RandomValueRange(0, 0), Hungering.MODNAME);

            LootEntryItem carrot = new LootEntryItem(Items.rottenCarrot, 1, 1, new LootFunction[]{new SetCount(NONE, new RandomValueRange(1, 6))}, new LootCondition[]{new RandomChance(0.3f)}, "hungering:rotten_carrot");
            LootEntryItem torc = new LootEntryItem(Items.rottenCarrot, 1, 1, new LootFunction[0], new LootCondition[]{new RandomChance(0.1f)}, "hungering:torc");

            pool.addEntry(carrot);
            pool.addEntry(torc);

            if (Hungering.CONFIG.LOOT_INJECT && !table.isFrozen()) {
                table.addPool(pool);
            }
        }
    }
}
