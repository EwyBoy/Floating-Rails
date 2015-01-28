package com.ewyboy.floatingrails.Render.Renderer;

import com.ewyboy.floatingrails.Render.Technical.RenderIDs;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class FloatingTorchRender implements ISimpleBlockRenderingHandler {

    public FloatingTorchRender() {
        super();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);

        renderer.renderBlockAsItem(Blocks.waterlily, 1 , 10F);
        renderer.renderBlockAsItem(Blocks.redstone_torch, 10 , 10F);
        renderer.setRenderBounds(0.0, 0.0 ,0.0,  1.0 ,10.0 ,1.0);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        renderer.renderBlockAllFaces(Blocks.redstone_torch, x,y,z);
        renderer.renderBlockAllFaces(Blocks.waterlily, x,y,z);
        //renderer.renderBlockAllFaces(BlocksAndItems.LavaLily, x,y,z);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return RenderIDs.FloatingTorchRenderID;
    }
}
