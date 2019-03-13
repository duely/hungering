package com.noobanidus.hungering.item;

import com.noobanidus.hungering.Hungering;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRottenCarrot extends ItemFood {
    public ItemRottenCarrot() {
        super(0, false);
        this.setAlwaysEdible();
        this.setCreativeTab(Hungering.TAB);
        this.setTranslationKey("rotten_carrot");
        this.setPotionEffect(new PotionEffect(MobEffects.HUNGER, 120), 1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_RED + "ᴅᴏ ɴᴏᴛ ᴘᴜᴛ ᴀʟʟ ʏᴏᴜʀ ᴛʀᴜꜱᴛ ɪɴ ʀᴏᴏᴛ ᴠᴇɢᴇᴛᴀʙʟᴇꜱ.");
    }
}
