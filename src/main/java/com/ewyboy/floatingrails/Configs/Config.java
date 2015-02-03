package com.ewyboy.floatingrails.Configs;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static int spawnRate, spawnLevel;

    public static void init (File file) {

        Configuration config = new Configuration(file);

        config.load();
            spawnRate = config.getInt("SpawnRate", "Lava Lily Generation", 5, 1, 128, "Sets the spawn chance for a Lava Lily");
            spawnLevel = config.getInt("SpawnLevel", "Lava Lily Generation", 70, 1, 256, "Sets the allowed Y-level for the Lava Lily to spawn below");
        config.save();
    }
}

