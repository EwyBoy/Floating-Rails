package com.ewyboy.floatingrails.common.world;

import com.ewyboy.bibliotheca.common.world.WorldGenUtilities;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by EwyBoy
 */
public class TheWorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;

        switch(world.provider.getDimension()) {
            case -1: generateNether(world, random, blockX, blockZ); break;
            case 0: generateWorld(world, random, blockX, blockZ); break;
        }
    }

    private WorldGenerator magmalilyGen = new MagmalilyGenerator();

    private void generateWorld(World world, Random random, int blockX, int blockZ) {
        WorldGenUtilities.generate(magmalilyGen, world, random, blockX, blockZ, 0, 4, 12);
    }

    private void generateNether(World world, Random random, int blockX, int blockZ) {
        WorldGenUtilities.generate(magmalilyGen, world, random, blockX, blockZ, 0, 4, 12);
    }
}
