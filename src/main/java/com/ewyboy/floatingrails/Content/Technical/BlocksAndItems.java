package com.ewyboy.floatingrails.Content.Technical;

import com.ewyboy.floatingrails.Content.Block.FloatingLavaTorch;
import com.ewyboy.floatingrails.Content.Block.LavaLily;
import com.ewyboy.floatingrails.Content.Item.FloatingLavaTorchSpawner;
import com.ewyboy.floatingrails.Content.Item.LavaLilySpawner;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlocksAndItems {

    public static void Init() {
        registerBlocks();
        registerItems();
        addBlocks();
        addItems();
    }

    public static Block LavaLily;
    public static Item LavaLilySpawner;
    public static Block FloatingTorch;
    public static Item FloatingTorchSpawner;
    public static Block FloatingLavaTorch;
    public static Item FloatingLavaTorchSpawner;

    public static void registerItems() {
        LavaLilySpawner = new com.ewyboy.floatingrails.Content.Item.LavaLilySpawner().setUnlocalizedName(BlocksAndItemInfo.LavaLillySpawnerUnlocalized);
        FloatingTorchSpawner = new com.ewyboy.floatingrails.Content.Item.FloatingTorchSpawner().setUnlocalizedName(BlocksAndItemInfo.FloatingTorchSpawner);
        FloatingLavaTorchSpawner = new FloatingLavaTorchSpawner().setUnlocalizedName(BlocksAndItemInfo.FloatingLavaTorchSpawner);
    }

    public static void registerBlocks() {
        LavaLily = new LavaLily().setBlockName(BlocksAndItemInfo.LavaLillyUnlocalized);
        FloatingTorch = new com.ewyboy.floatingrails.Content.Block.FloatingTorch().setBlockName(BlocksAndItemInfo.FloatingTorch);
        FloatingLavaTorch = new FloatingLavaTorch().setBlockName(BlocksAndItemInfo.FloatingLavaTorch);
    }

    public static void addItems() {
        GameRegistry.registerItem(LavaLilySpawner, BlocksAndItemInfo.LavaLillySpawnerUnlocalized);
        GameRegistry.registerItem(FloatingTorchSpawner, BlocksAndItemInfo.FloatingTorchSpawner);
        GameRegistry.registerItem(FloatingLavaTorchSpawner, BlocksAndItemInfo.FloatingLavaTorchSpawner);
    }

    public static void addBlocks() {
        GameRegistry.registerBlock(LavaLily, BlocksAndItemInfo.LavaLillyUnlocalized);
        GameRegistry.registerBlock(FloatingTorch, BlocksAndItemInfo.FloatingTorch);
        GameRegistry.registerBlock(FloatingLavaTorch, BlocksAndItemInfo.FloatingLavaTorch);
    }
}
