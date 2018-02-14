package com.ewyboy.floatingrails.WorldGen;

import com.ewyboy.floatingrails.Content.Technical.BlocksAndItems;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenLavaLily extends WorldGenerator {

    public boolean generate(World world, Random random, int x, int y, int z) {

        for (int l = 0; l < 10; ++l) {

            int X = x + random.nextInt(8) - random.nextInt(8);
            int Y = y + random.nextInt(4) - random.nextInt(4);
            int Z = z + random.nextInt(8) - random.nextInt(8);

            if (world.isAirBlock(X, Y, Z) && BlocksAndItems.LavaLily.canPlaceBlockAt(world, X, Y, Z)) {
                world.setBlock(X, Y, Z, BlocksAndItems.LavaLily, 0, 2);
            }
        }
        return true;
    }
}
