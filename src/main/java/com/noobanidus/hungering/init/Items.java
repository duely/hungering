package com.noobanidus.hungering.init;

import com.noobanidus.hungering.item.ItemRottenCarrot;
import com.noobanidus.hungering.item.ItemTorc;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@SuppressWarnings("WeakerAccess")
@Mod.EventBusSubscriber
public class Items {
    public static ItemTorc torc;
    public static ItemRottenCarrot rottenCarrot;

    public static void preInit() {
        torc = new ItemTorc();
        torc.setRegistryName("hungering", "torc");

        rottenCarrot = new ItemRottenCarrot();
        rottenCarrot.setRegistryName("hungering", "rotten_carrot");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(torc, rottenCarrot);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(torc, 0, new ModelResourceLocation(new ResourceLocation("hungering", "torc"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(rottenCarrot, 0, new ModelResourceLocation(new ResourceLocation("hungering", "rotten_carrot"), "inventory"));
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
    }
}
