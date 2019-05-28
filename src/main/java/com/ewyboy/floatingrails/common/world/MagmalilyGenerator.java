package com.ewyboy.floatingrails.common.world;

import com.ewyboy.bibliotheca.common.world.WorldGenUtilities;
import com.ewyboy.floatingrails.common.Register;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by EwyBoy
 */
public class MagmalilyGenerator extends WorldGenerator {

    @Override
    public boolean generate(World world, Random random, BlockPos pos) {
        int y = world.provider.getDimension() == -1 ? WorldGenUtilities.getBlockFromAbove(world, pos.getX(), pos.getZ(), Blocks.LAVA, 35) : WorldGenUtilities.getBlockFromAbove(world, pos.getX(), pos.getZ(), Blocks.LAVA, 70);

        if (y >= pos.getY()) {
            BlockPos targetPos = new BlockPos(pos.getX(), y + 1, pos.getZ());
            if (world.isAirBlock(targetPos)) {
                if (!world.getBlockState(targetPos.down()).getBlock().equals(Blocks.FLOWING_LAVA)) {
                    world.setBlockState(targetPos, Register.Blocks.magmalily.getDefaultState(), 2);
                }
            }
        }

        return true;
    }
}
