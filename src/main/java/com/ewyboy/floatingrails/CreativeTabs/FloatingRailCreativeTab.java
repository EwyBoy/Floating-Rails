package com.ewyboy.floatingrails.CreativeTabs;

import com.ewyboy.floatingrails.Rails.Technical.Rails;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FloatingRailCreativeTab {

    public static void Init() {
        AddCreativeTabs();
    }

    public static void AddCreativeTabs() {
    }

        public static CreativeTabs WaterRailTab = new CreativeTabs ("Water Rails") {
            public ItemStack getIconItemStack() {
                return new ItemStack(Rails.FloatingRail);
            }

            @Override
            public Item getTabIconItem() {
                return null;
            }
        };

        public static CreativeTabs LavaRailTabTab = new CreativeTabs ("Lava Rails") {
            public ItemStack getIconItemStack() {
                return new ItemStack(Rails.FloatingRailLava);
            }

            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
}
