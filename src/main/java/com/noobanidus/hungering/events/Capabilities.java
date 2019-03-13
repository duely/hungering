package com.noobanidus.hungering.events;

import com.noobanidus.hungering.Hungering;
import com.noobanidus.hungering.init.Items;
import com.noobanidus.hungering.compat.baubles.CapabilityHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid= Hungering.MODID)
public class Capabilities {

    @SubscribeEvent
    public static void onItemCapability (AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() == Items.torc) {
            event.addCapability(new ResourceLocation("hungering", "hunger_charm"), CapabilityHandler.INSTANCE);
        }
    }
}
