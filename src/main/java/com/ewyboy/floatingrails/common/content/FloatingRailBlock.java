package com.ewyboy.floatingrails.common.content;

import com.ewyboy.bibliotheca.client.interfaces.IHasRenderType;
import com.ewyboy.bibliotheca.common.loaders.ContentLoader;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class FloatingRailBlock extends RailBlock implements IHasRenderType, ContentLoader.IHasNoBlockItem {

    public FloatingRailBlock() {
        super(AbstractBlock.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL));
    }

    @Override
    public void entityInside(BlockState blockState, World world, BlockPos pos, Entity entity) {
        super.entityInside(blockState, world, pos, entity);
        if (world instanceof ServerWorld && entity instanceof BoatEntity) {
            world.destroyBlock(new BlockPos(pos), true, entity);
        }
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.cutoutMipped();
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean flag) {
        //super.neighborChanged(state, world, pos, block, fromPos, flag);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader reader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.below();
        return this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
    }

    public boolean mayPlaceOn(BlockState blockState, IBlockReader reader, BlockPos pos) {
        FluidState fluidstate = reader.getFluidState(pos);
        FluidState fluidstate_above = reader.getFluidState(pos.above());

        return (fluidstate.getType() == Fluids.WATER || blockState.getMaterial() == Material.ICE) && fluidstate_above.getType() == Fluids.EMPTY;
    }
}
