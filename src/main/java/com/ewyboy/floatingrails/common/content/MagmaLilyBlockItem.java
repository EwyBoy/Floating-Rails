package com.ewyboy.floatingrails.common.content;

import com.ewyboy.floatingrails.FloatingRails;
import net.minecraft.block.Block;
import net.minecraft.item.LilyPadItem;

public class MagmaLilyBlockItem extends LilyPadItem {

    public MagmaLilyBlockItem(Block block) {
        super(block, new Properties().tab(FloatingRails.itemGroup));
    }

}
