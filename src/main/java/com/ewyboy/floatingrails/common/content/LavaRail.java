package com.ewyboy.floatingrails.common.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LavaRail extends FloatingRailBlock {

    public LavaRail() {}

    @Override
    public boolean mayPlaceOn(BlockState blockState, IBlockReader reader, BlockPos pos) {
        FluidState fluidstate = reader.getFluidState(pos);
        FluidState fluidstate_above = reader.getFluidState(pos.above());

        return (fluidstate.getType() == Fluids.LAVA || blockState.getMaterial() == Material.LAVA) && fluidstate_above.getType() == Fluids.EMPTY;
    }
}
