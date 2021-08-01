package com.ewyboy.floatingrails.common.content;

import com.ewyboy.floatingrails.FloatingRails;
import net.minecraft.block.Block;
import net.minecraft.item.LilyPadItem;

public class FloatingRailBlockItem extends LilyPadItem {

    public FloatingRailBlockItem(Block block) {
        super(block, new Properties().tab(FloatingRails.itemGroup));
    }

}
