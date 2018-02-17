package com.ewyboy.floatingrails.common.loaders;

import com.ewyboy.floatingrails.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by EwyBoy
 */
@GameRegistry.ObjectHolder(Reference.Info.MODID)
public class CreativeTabLoader {

    public static CreativeTabs FloatingRails = new CreativeTabs(Reference.Info.MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.ANVIL);
        }
    };
}
