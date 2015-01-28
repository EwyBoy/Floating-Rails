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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class FloatingRailSpawnerPowered extends Item {

    public FloatingRailSpawnerPowered() {
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
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(player, i, j, k))
                {
                    return item;
                }

                if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, item))
                {
                    return item;
                }

                if (world.getBlock(i, j, k).getMaterial() == Material.water && world.getBlockMetadata(i, j, k) == 0 && world.isAirBlock(i, j + 1, k))
                {
                    world.setBlock(i, j + 1, k, Rails.FloatingPoweredRail);

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

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        Texture = register.registerIcon(TexturePath.TextureLocation + ":" + RailInfo.FloatingRailPowered0Texture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return Texture;
    }
}