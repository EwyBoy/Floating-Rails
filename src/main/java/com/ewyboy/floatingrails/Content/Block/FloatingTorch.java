package com.ewyboy.floatingrails.Content.Block;

import com.ewyboy.floatingrails.Content.Technical.BlocksAndItems;
import com.ewyboy.floatingrails.CreativeTabs.FloatingRailCreativeTab;
import com.ewyboy.floatingrails.Rails.Technical.Rails;
import com.ewyboy.floatingrails.Render.Renderer.FloatingTorchRender;
import com.ewyboy.floatingrails.Render.Technical.RenderIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class FloatingTorch extends BlockRedstoneTorch implements IItemRenderer {

    public FloatingTorch() {
        super(true);
        setCreativeTab(CreativeTabs.tabRedstone);
        setCreativeTab(FloatingRailCreativeTab.WaterRailTab);
        setTickRandomly(true);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i, int j, int k) {
        if (world.getBlock(i, j, k).getMaterial() == Material.water && world.getBlockMetadata(i, j, k) == 0 && world.isAirBlock(i, j + 1, k))
        {
            world.setBlock(i, j + 1, k, BlocksAndItems.FloatingTorch);
        }

        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote) {
            return;
        }
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return y >= 0 && y < 256 ? world.getBlock(x, y-1, z).getMaterial() == Material.water && world.getBlockMetadata(x, y - 1, z) == 0 : false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        double pool = 0.90;
        return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1), ((double) (y + 1) - pool), (double) (z + 1));
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        return getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, start, end);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess block, int x, int y, int z, int something) {
        return false;
    }

    // Witch size you want to render the block in inside your inventory and hand. This is full size
    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0,0,0,0,0,0);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
        setBlockBounds(0,0,0,1,1,1);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return RenderIDs.FloatingTorchRenderID;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();

        GL11.glScalef(-1F,-1F,-1F);

        GL11.glPopMatrix();
    }
}
