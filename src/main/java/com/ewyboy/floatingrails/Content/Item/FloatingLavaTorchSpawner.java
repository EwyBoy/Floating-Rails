package com.ewyboy.floatingrails.Content.Item;

import com.ewyboy.floatingrails.Content.Technical.BlocksAndItems;
import com.ewyboy.floatingrails.CreativeTabs.FloatingRailCreativeTab;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class FloatingLavaTorchSpawner extends Item {

    public FloatingLavaTorchSpawner() {
        super();
        setCreativeTab(FloatingRailCreativeTab.LavaRailTabTab);
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

                if (world.getBlock(i, j, k).getMaterial() == Material.lava && world.getBlockMetadata(i, j, k) == 0 && world.isAirBlock(i, j + 1, k ))
                {
                    world.setBlock(i, j + 1, k, BlocksAndItems.FloatingLavaTorch);

                    if (!player.capabilities.isCreativeMode)
                    {
                        --item.stackSize;
                    }
                }
            }
            return item;
        }
    }
}