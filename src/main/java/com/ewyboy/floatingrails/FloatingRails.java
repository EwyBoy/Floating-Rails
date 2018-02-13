package com.ewyboy.floatingrails;

import com.ewyboy.floatingrails.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.ewyboy.floatingrails.Reference.Info.*;
import static com.ewyboy.floatingrails.Reference.Path.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class FloatingRails {

    @Mod.Instance(MODID)
    public static FloatingRails instance;

    @SidedProxy(modId = MODID, clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
