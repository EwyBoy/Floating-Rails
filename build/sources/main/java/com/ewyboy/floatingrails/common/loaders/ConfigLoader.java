package com.ewyboy.floatingrails.common.loaders;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by EwyBoy
 */
public class ConfigLoader {

    public static void init(File file) {
        Configuration config = new Configuration(file);

        config.load();
            //Code here
        config.save();
    }

}
