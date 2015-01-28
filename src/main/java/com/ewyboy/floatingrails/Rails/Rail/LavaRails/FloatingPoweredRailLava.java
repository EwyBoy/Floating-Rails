package com.ewyboy.floatingrails.Rails.Rail.LavaRails;

import com.ewyboy.floatingrails.Rails.Technical.RailInfo;
import com.ewyboy.floatingrails.Rails.Technical.Rails;
import com.ewyboy.floatingrails.Textures.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailDetector;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class FloatingPoweredRailLava extends BlockRailPowered {

    public FloatingPoweredRailLava() {
        super();
        setCreativeTab(null);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return y >= 0 && y < 256 ? world.getBlock(x, y-1, z).getMaterial() == Material.lava && world.getBlockMetadata(x, y - 1, z) == 0 : false;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote) {
            return;
        }
    }

    @Override
    public Item getItemDropped(int i, Random random, int idk) {
        return Rails.FloatingRailSpawnerLavaPowered;
    }

    @SideOnly(Side.CLIENT)
    private IIcon Texture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        Texture = register.registerIcon(TexturePath.TextureLocation + ":" + RailInfo.FloatingRailLavaPowered0Texture);
        //TexturePowered = register.registerIcon(TexturePath.TextureLocation + ":" + RailInfo.FloatingRailLavaPowered1Texture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta >= 6)
        {
            return Texture;
        }
        else if (meta <= 6)
        {
            return Texture;
        }
        return Texture;
    }
}
