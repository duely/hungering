package com.noobanidus.hungering.item;

import baubles.api.IBauble;
import com.noobanidus.hungering.Hungering;
import com.noobanidus.hungering.compat.baubles.BaubleTorc;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTorc extends Item {
    public static IBauble bauble = new BaubleTorc();

    public ItemTorc() {
        this.setMaxStackSize(1);
        this.setMaxDamage(Hungering.CONFIG.MAX_DURABILITY);
        this.setTranslationKey("torc");
        this.setCreativeTab(Hungering.TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        String line;
        if (this.isActive(stack)) {
            line = TextFormatting.GREEN + "" + TextFormatting.BOLD + "Active.";
        } else {
            line = TextFormatting.DARK_RED + "" + TextFormatting.BOLD + "Inactive.";
        }

        int every = Hungering.CONFIG.AUTO_TICK / 20;

        tooltip.add(line);
        tooltip.add("");
        tooltip.add(String.format(TextFormatting.BOLD + "Sneak-Right-Click" + TextFormatting.RESET + " to toggle hunger every %ds.", every));
        tooltip.add(TextFormatting.BOLD + "Right-Click" + TextFormatting.RESET + " to consume immediately.");
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

    private void tickHunger(EntityPlayer player, ItemStack stack) {
        FoodStats stats = player.getFoodStats();
        int level = stats.getFoodLevel();
        stats.setFoodLevel(Math.max(0, level - Hungering.CONFIG.HUNGER_PER));

        if (stack != null) {
            stack.damageItem(1, player);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ItemStack item = player.getHeldItem(handIn);
        if (!world.isRemote) {
            if (player.isSneaking()) {
                toggleItem(item);
                player.world.playSound(null, player.getPosition(), SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.PLAYERS, 0.1F, 0.5F * ((player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.7F + 1.2F));
            } else {
                tickHunger(player, item);
                player.world.playSound(null, player.getPosition(), SoundEvents.ITEM_HOE_TILL, SoundCategory.PLAYERS, 0.1F, 0.5F * ((player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.7F + 1.2F));
            }
        } else if (!player.isSneaking()) {
            tickHunger(player, null);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, item);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean f) {
        if (!this.isActive(stack)) return;

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.ticksExisted % Hungering.CONFIG.AUTO_TICK == 0) {
                if (!world.isRemote) {
                    tickHunger(player, stack);
                } else {
                    tickHunger(player, null);
                }
            }
        }
    }

    private void toggleItem(ItemStack item) {
        NBTTagCompound tag = item.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            item.setTagCompound(tag);
        }
        if (!tag.hasKey("active")) {
            tag.setBoolean("active", true);
        } else {
            boolean current = tag.getBoolean("active");
            tag.setBoolean("active", !current);
        }
    }

    public boolean isActive(ItemStack item) {
        NBTTagCompound tag = item.getTagCompound();
        if (tag == null) return false;
        return tag.getBoolean("active");
    }
}
