package com.ewyboy.floatingrails.common.blocks.rails;

import com.ewyboy.floatingrails.common.blocks.rails.base.BlockFloatingRailBase;
import com.ewyboy.floatingrails.common.items.ItemFloatingRail;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by EwyBoy
 */
public class BlockFloatingRail extends BlockFloatingRailBase {

    public BlockFloatingRail() {
        super();
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        if (!world.isRemote) {
            BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = getRailDirection(world, pos, world.getBlockState(pos), null);
            boolean flag = false;

            if (!world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP) && (world.getBlockState(pos.down()).getMaterial() != Material.WATER)) {
                flag = true;
            }

            if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.ASCENDING_EAST && !world.getBlockState(pos.east()).isSideSolid(world, pos.east(), EnumFacing.UP)) {
                flag = true;
            } else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.ASCENDING_WEST && !world.getBlockState(pos.west()).isSideSolid(world, pos.west(), EnumFacing.UP)) {
                flag = true;
            } else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.ASCENDING_NORTH && !world.getBlockState(pos.north()).isSideSolid(world, pos.north(), EnumFacing.UP)) {
                flag = true;
            } else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.ASCENDING_SOUTH && !world.getBlockState(pos.south()).isSideSolid(world, pos.south(), EnumFacing.UP)) {
                flag = true;
            }

            if (flag && !world.isAirBlock(pos)) {
                this.dropBlockAsItem(world, pos, state, 0);
                world.setBlockToAir(pos);
            } else {
                this.updateState(state, world, pos, block);
            }
        }
    }

    @Override
    public ItemBlock getItemBlock() {
        return new ItemFloatingRail(this);
    }

}
