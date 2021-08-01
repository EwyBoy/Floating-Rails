package com.ewyboy.floatingrails.world.feature;

import com.ewyboy.floatingrails.register.Register;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class MagmaLilyFeature extends Feature<NoFeatureConfig> {

    public MagmaLilyFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    public BlockState chooseGrassState() {
        return Register.BLOCK.MAGMA_LILY.defaultBlockState();
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
        BlockState BlockState = this.chooseGrassState();
        int tries = 0;

        for (int y = 0; y < 128; ++y) {
            BlockPos blockpos = pos.offset(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (world.isEmptyBlock(blockpos) && BlockState.canSurvive(world, blockpos)) {
                world.setBlock(blockpos, BlockState, 2);
                ++tries;
            }
        }

        return tries > 0;
    }
}
