package com.ewyboy.floatingrails.common.content;

import com.ewyboy.bibliotheca.client.interfaces.IHasRenderType;
import com.ewyboy.bibliotheca.common.loaders.ContentLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class MagmaLilyBlock extends LilyPadBlock implements IHasRenderType, ContentLoader.IHasNoBlockItem {

    public MagmaLilyBlock() {
        super(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F));
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader reader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.below();
        return this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
    }

    protected boolean mayPlaceOn(BlockState blockState, IBlockReader reader, BlockPos pos) {
        FluidState fluidstate = reader.getFluidState(pos);
        FluidState fluidstate_above = reader.getFluidState(pos.above());
        return (fluidstate.getType() == Fluids.LAVA || blockState.getMaterial() == Material.LAVA) && fluidstate_above.getType() == Fluids.EMPTY;
    }


    @Override
    public RenderType getRenderType() {
        return RenderType.cutoutMipped();
    }
}
