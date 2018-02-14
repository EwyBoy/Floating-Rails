package com.ewyboy.floatingrails.Rails.Rail.WaterRails;

import com.ewyboy.floatingrails.Rails.Technical.RailInfo;
import com.ewyboy.floatingrails.Rails.Technical.Rails;
import com.ewyboy.floatingrails.Textures.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class FloatingRail extends BlockRail {

    public FloatingRail() {
        super();
        setCreativeTab(null);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {

        return y >= 0 && y < 256 ? world.getBlock(x, y-1, z) == Blocks.water && world.getBlockMetadata(x, y - 1, z) == 0  || world.getBlock(x,y,z) == Blocks.flowing_water && world.getBlockMetadata(x, y - 1, z) == 0 : false;

    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!world.isRemote)
        {
            return;
        }
    }

    @Override
    public Item getItemDropped(int i, Random random, int idk) {
        return Rails.FloatingRailSpawner;
    }

    @SideOnly(Side.CLIENT)
    private IIcon Texture;

    @SideOnly(Side.CLIENT)
    private IIcon TextureTurn;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        Texture = register.registerIcon(TexturePath.TextureLocation + ":" + RailInfo.FloatingRailTexture);
        TextureTurn = register.registerIcon(TexturePath.TextureLocation + ":" + RailInfo.FloatingRailTurnTexture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta >= 6)
        {
            return TextureTurn;
        }
        else if (meta <= 6)
        {
            return Texture;
        }
        return Texture;
    }
}
