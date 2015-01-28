package com.ewyboy.floatingrails.Content.Block;

import com.ewyboy.floatingrails.Content.Technical.BlocksAndItemInfo;
import com.ewyboy.floatingrails.Content.Technical.BlocksAndItems;
import com.ewyboy.floatingrails.Textures.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class LavaLily extends BlockBush {

    public LavaLily()
    {
        float f = 0.5F;
        float f1 = 0.015625F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        setCreativeTab(null);
    }

    public Item getItemDropped(int i, Random r, int i1)
    {
        return BlocksAndItems.LavaLilySpawner;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 23;
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB pool, List list, Entity entity) {
        if (entity == null || !(entity instanceof EntityBoat))
        {
            super.addCollisionBoxesToList(world, x, y, z, pool, list, entity);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
    }

    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.lava;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World world, int x, int y, int z) {
        return y >= 0 && y < 256 ? world.getBlock(x, y - 1, z).getMaterial() == Material.lava && world.getBlockMetadata(x, y - 1, z) == 0 : false;
    }

    @SideOnly(Side.CLIENT)
    private IIcon Texture;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        Texture = register.registerIcon(TexturePath.TextureLocation + ":" + BlocksAndItemInfo.LavaLillyTexture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Texture;
    }

}
