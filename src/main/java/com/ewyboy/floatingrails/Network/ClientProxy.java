package com.ewyboy.floatingrails.Network;

import com.ewyboy.floatingrails.Render.Renderer.FloatingLavaTorchRender;
import com.ewyboy.floatingrails.Render.Renderer.FloatingTorchRender;
import com.ewyboy.floatingrails.Render.Technical.RenderIDs;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void initRenders() {
        RenderIDs.FloatingTorchRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new FloatingTorchRender());

        RenderIDs.FloatingLavaTorchRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new FloatingLavaTorchRender());
    }
}
