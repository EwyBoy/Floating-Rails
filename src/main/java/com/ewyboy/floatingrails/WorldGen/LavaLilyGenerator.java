package com.ewyboy.floatingrails.WorldGen;

import com.ewyboy.floatingrails.Configs.Config;
import com.ewyboy.floatingrails.Content.Technical.BlocksAndItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class LavaLilyGenerator {

    public static int spawnRate = Config.spawnRate;
    public static int spawnLevel = Config.spawnLevel;

    @SubscribeEvent()
    public void onWorldDecoration(DecorateBiomeEvent.Decorate event) {
        if (event.rand.nextInt(3) == 0) {
            int x = event.chunkX + event.rand.nextInt(16) + 8;
            int z = event.chunkZ + event.rand.nextInt(16) + 8;
            int y;
            for (y = spawnLevel; y >= 0; y = y - 1) {
                if (event.world.getBlock(x, y, z) == Blocks.lava) {
                    for (int j = 0; j < spawnRate; j++) {
                        int x1 = x + event.rand.nextInt(8) - event.rand.nextInt(8);
                        int z1 = z + event.rand.nextInt(8) - event.rand.nextInt(8);
                        if (event.world.isAirBlock(x1, y + 1, z1) && BlocksAndItems.LavaLily.canBlockStay(event.world, x1, y+1, z1))
                            event.world.setBlock(x1, y + 1, z1, BlocksAndItems.LavaLily, 0, 2);
                    }
                }
            }
        }
    }
}
