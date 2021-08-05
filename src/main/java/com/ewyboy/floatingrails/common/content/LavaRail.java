package com.ewyboy.floatingrails.common.content;

import com.ewyboy.floatingrails.util.ModLogger;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LavaRail extends FloatingRailBlock {

    public LavaRail() {}

    @Override
    public void onMinecartPass(BlockState state, World world, BlockPos pos, AbstractMinecartEntity cart) {
        PlayerEntity player = (PlayerEntity) cart.getControllingPassenger();
        if (player != null && player.isOnFire()) {
            player.clearFire();
            ModLogger.info("YESS ?!?");
        }
    }

    @Override
    public void entityInside(BlockState blockState, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity) {
            entity.clearFire();
            entity.fireImmune();
            ModLogger.info("FIRE: " + entity.getName());
        }
    }

    @Override
    public boolean mayPlaceOn(BlockState blockState, IBlockReader reader, BlockPos pos) {
        FluidState fluidstate = reader.getFluidState(pos);
        FluidState fluidstate_above = reader.getFluidState(pos.above());

        return (fluidstate.getType() == Fluids.LAVA || blockState.getMaterial() == Material.LAVA) && fluidstate_above.getType() == Fluids.EMPTY;
    }
}
