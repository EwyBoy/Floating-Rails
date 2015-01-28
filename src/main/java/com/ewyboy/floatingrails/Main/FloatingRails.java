package com.ewyboy.floatingrails.Main;

import com.ewyboy.floatingrails.Content.Technical.BlocksAndItems;
import com.ewyboy.floatingrails.Crafting.CraftingRecipes;
import com.ewyboy.floatingrails.CreativeTabs.FloatingRailCreativeTab;
import com.ewyboy.floatingrails.Info.ModInfo;
import com.ewyboy.floatingrails.Network.ClientProxy;
import com.ewyboy.floatingrails.Network.CommonProxy;
import com.ewyboy.floatingrails.Rails.Technical.Rails;
import com.ewyboy.floatingrails.Utillity.LogHelper;
import com.ewyboy.floatingrails.WorldGen.LavaLilyGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ModInfo.ID, name = ModInfo.Name, version = ModInfo.Version)

public class FloatingRails {

    @Mod.Instance(ModInfo.ID)
    public static FloatingRails instance;

    @SidedProxy(modId = ModInfo.ID, clientSide = "com.ewyboy.floatingrails.Network.ClientProxy", serverSide = "com.ewyboy.floatingrails.Network.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void load (FMLInitializationEvent event) {
        Rails.Init();
        BlocksAndItems.Init();
        CraftingRecipes.Init();
        proxy.initRenders();
        MinecraftForge.TERRAIN_GEN_BUS.register(new LavaLilyGenerator());
        LogHelper.info("Initialization Complete!");
        FloatingRailCreativeTab.Init();
    }

    @Mod.EventHandler
    public void modsLoaded (FMLPreInitializationEvent event){
        LogHelper.info("Post Initialization Complete!");
    }

}
