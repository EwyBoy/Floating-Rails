package com.ewyboy.floatingrails.proxy;

import com.ewyboy.bibliotheca.common.compatibilities.CompatibilityHandler;
import com.ewyboy.bibliotheca.common.loaders.BlockLoader;
import com.ewyboy.bibliotheca.common.loaders.ItemLoader;
import com.ewyboy.bibliotheca.common.loaders.TileEntityLoader;
import com.ewyboy.floatingrails.Reference;
import com.ewyboy.floatingrails.common.Register;
import com.ewyboy.floatingrails.common.loaders.RecipeLoader;
import com.ewyboy.floatingrails.common.world.TheWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by EwyBoy
 */
public class CommonProxy {

    public Side getSide() {
        return Side.SERVER;
    }

    public void preInit(FMLPreInitializationEvent event) {
        CompatibilityHandler.registerWaila();
        BlockLoader.init(Reference.Info.MODID, Register.Blocks.class);
        ItemLoader.init(Reference.Info.MODID, Register.Items.class);
        TileEntityLoader.init(Register.Tiles.class);
        RecipeLoader.loadRecipes();
    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new TheWorldGenerator(), 10);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
