package com.ewyboy.floatingrails.common.loaders;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by EwyBoy
 */
public class ConfigLoader {

    public static int spawnRateMagmaLilyMin;
    public static int spawnRateMagmaLilyMax;

    public static Configuration config;

    public static void init(File file) {
        config = new Configuration(file);

        config.load();
            spawnRateMagmaLilyMin = config.getInt("Magma Lily minimum spawn rate", Configuration.CATEGORY_GENERAL, 4, 0, 256, "minimum spawn rate");
            spawnRateMagmaLilyMax = config.getInt("Magma Lily maximum spawn rate", Configuration.CATEGORY_GENERAL, 12, 0, 256, "maximum spawn rate");
        if (config.hasChanged()) config.save();
    }

}
