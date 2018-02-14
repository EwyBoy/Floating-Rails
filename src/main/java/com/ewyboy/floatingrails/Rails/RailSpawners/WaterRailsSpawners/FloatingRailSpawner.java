package com.ewyboy.floatingrails.Rails.RailSpawners.WaterRailsSpawners;

import com.ewyboy.floatingrails.CreativeTabs.FloatingRailCreativeTab;
import com.ewyboy.floatingrails.Rails.Technical.RailInfo;
import com.ewyboy.floatingrails.Rails.Technical.Rails;
import com.ewyboy.floatingrails.Textures.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class FloatingRailSpawner extends Item {

    public FloatingRailSpawner() {
        super();
        setCreativeTab(CreativeTabs.tabTransport);
        setCreativeTab(FloatingRailCreativeTab.WaterRailTab);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (movingobjectposition == null)
        {
            return item;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int x = movingobjectposition.blockX;
                int y = movingobjectposition.blockY;
                int z = movingobjectposition.blockZ;

                if (!world.canMineBlock(player, x, y, z))
                {
                    return item;
                }

                if (!player.canPlayerEdit(x, y, z, movingobjectposition.sideHit, item))
                {
                    return item;
                }

                if (world.getBlock(x, y, z) == Blocks.water && world.getBlockMetadata(x, y, z) == 0 && world.isAirBlock(x, y + 1, z )
                        || world.getBlock(x, y, z) == Blocks.flowing_water && world.getBlockMetadata(x, y, z) == 0 && world.isAirBlock(x, y + 1, z ) )
                {
                    world.setBlock(x, y + 1, z, Rails.FloatingRail);

                    if (!player.capabilities.isCreativeMode)
                    {
                        --item.stackSize;
                    }
                }
            }
            return item;
        }
    }

    @SideOnly(Side.CLIENT)
    private IIcon Texture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        Texture = register.registerIcon(TexturePath.TextureLocation + ":" + RailInfo.FloatingRailTexture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return Texture;
    }
}

