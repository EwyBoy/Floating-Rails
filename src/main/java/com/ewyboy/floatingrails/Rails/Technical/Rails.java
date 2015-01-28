package com.ewyboy.floatingrails.Rails.Technical;

import com.ewyboy.floatingrails.Rails.Rail.LavaRails.FloatingDetectorRailLava;
import com.ewyboy.floatingrails.Rails.Rail.WaterRails.FloatingDetectorRail;
import com.ewyboy.floatingrails.Rails.Rail.WaterRails.FloatingRail;
import com.ewyboy.floatingrails.Rails.RailSpawners.LavaRailsSpawners.FloatingRailLavaSpawnerActivated;
import com.ewyboy.floatingrails.Rails.RailSpawners.LavaRailsSpawners.FloatingRailLavaSpawnerDetector;
import com.ewyboy.floatingrails.Rails.RailSpawners.LavaRailsSpawners.FloatingRailLavaSpawnerPowered;
import com.ewyboy.floatingrails.Rails.RailSpawners.WaterRailsSpawners.FloatingRailSpawner;
import com.ewyboy.floatingrails.Rails.RailSpawners.WaterRailsSpawners.FloatingRailSpawnerActivated;
import com.ewyboy.floatingrails.Rails.RailSpawners.WaterRailsSpawners.FloatingRailSpawnerDetector;
import com.ewyboy.floatingrails.Rails.RailSpawners.WaterRailsSpawners.FloatingRailSpawnerPowered;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Rails {

    public static Block FloatingTorch;

    public static Block FloatingRail;
    public static Block FloatingRailLava;
    public static Item FloatingRailSpawner;
    public static Item FloatingRailLavaSpawner;

    public static Block FloatingPoweredRail;
    public static Block FloatingPoweredLavaRail;
    public static Item FloatingRailSpawnerPowered;
    public static Item FloatingRailSpawnerLavaPowered;

    public static Block FloatingDetectionRail;
    public static Block FloatingDetectionLavaRail;
    public static Item FloatingRailSpawnerDetection;
    public static Item FloatingRailSpawnerLavaDetection;

    public static Block FloatingActivatedRail;
    public static Block FloatingActivatedLavaRail;
    public static Item FloatingRailSpawnerActivation;
    public static Item FloatingRailSpawnerLavaActivation;

    public static void Init() {
        registerRails();
        addRails();
    }

    public static void registerRails() {
        
        FloatingRail = new FloatingRail().setBlockName(RailInfo.FloatingRailUnlocalized);
        FloatingRailLava = new com.ewyboy.floatingrails.Rails.Rail.LavaRails.FloatingRailLava().setBlockName(RailInfo.FloatingRailLavaUnlocalized);
        FloatingRailSpawner = new FloatingRailSpawner().setUnlocalizedName(RailInfo.FloatingRailSpawnerUnlocalized);
        FloatingRailLavaSpawner = new com.ewyboy.floatingrails.Rails.RailSpawners.LavaRailsSpawners.FloatingRailLavaSpawner().setUnlocalizedName(RailInfo.FloatingRailLavaSpawnerUnlocalized);

        FloatingDetectionRail = new FloatingDetectorRail().setBlockName(RailInfo.FloatingRailDetectorUnlocalized);
        FloatingDetectionLavaRail = new FloatingDetectorRailLava().setBlockName(RailInfo.FloatingRailDetectorLavaUnlocalized);
        FloatingRailSpawnerDetection = new FloatingRailSpawnerDetector().setUnlocalizedName(RailInfo.FloatingRailDetectorSpawnerUnlocalized);
        FloatingRailSpawnerLavaDetection = new FloatingRailLavaSpawnerDetector().setUnlocalizedName(RailInfo.FloatingRailDetectorLavaSpawnerUnlocalized);

        FloatingPoweredRail = new com.ewyboy.floatingrails.Rails.Rail.WaterRails.FloatingPoweredRail().setBlockName(RailInfo.FloatingRailPoweredUnlocalized);
        FloatingPoweredLavaRail = new com.ewyboy.floatingrails.Rails.Rail.LavaRails.FloatingPoweredRailLava().setBlockName(RailInfo.FloatingRailPoweredUnlocalized);
        FloatingRailSpawnerPowered = new FloatingRailSpawnerPowered().setUnlocalizedName(RailInfo.FloatingRailPoweredSpawnerUnlocalized);
        FloatingRailSpawnerLavaPowered = new FloatingRailLavaSpawnerPowered().setUnlocalizedName(RailInfo.FloatingRailPoweredLavaSpawnerUnlocalized);

        FloatingActivatedRail = new com.ewyboy.floatingrails.Rails.Rail.WaterRails.FloatingActivatedRail().setBlockName(RailInfo.FloatingRailActivatedUnlocalized);
        FloatingActivatedLavaRail = new FloatingDetectorRailLava().setBlockName(RailInfo.FloatingRailActivatedLavaUnlocalized);
        FloatingRailSpawnerActivation = new FloatingRailSpawnerActivated().setUnlocalizedName(RailInfo.FloatingRailActivatedSpawnerUnlocalized);
        FloatingRailSpawnerLavaActivation = new FloatingRailLavaSpawnerActivated().setUnlocalizedName(RailInfo.FloatingRailActivatedLavaSpawnerUnlocalized);


    }

    public static void addRails() {

        GameRegistry.registerBlock(FloatingRail, RailInfo.FloatingRailUnlocalized);
        GameRegistry.registerBlock(FloatingRailLava, RailInfo.FloatingRailLavaUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawner, RailInfo.FloatingRailSpawnerUnlocalized);
        GameRegistry.registerItem(FloatingRailLavaSpawner, RailInfo.FloatingRailLavaSpawnerUnlocalized);

        GameRegistry.registerBlock(FloatingDetectionRail, RailInfo.FloatingRailDetectorUnlocalized);
        GameRegistry.registerBlock(FloatingDetectionLavaRail, RailInfo.FloatingRailDetectorLavaUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawnerDetection, RailInfo.FloatingRailDetectorSpawnerUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawnerLavaDetection, RailInfo.FloatingRailDetectorLavaSpawnerUnlocalized);

        GameRegistry.registerBlock(FloatingPoweredRail, RailInfo.FloatingRailPoweredUnlocalized);
        GameRegistry.registerBlock(FloatingPoweredLavaRail, RailInfo.FloatingRailPoweredLavaUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawnerPowered, RailInfo.FloatingRailPoweredSpawnerUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawnerLavaPowered, RailInfo.FloatingRailPoweredLavaSpawnerUnlocalized);

        GameRegistry.registerBlock(FloatingActivatedRail, RailInfo.FloatingRailActivatedUnlocalized);
        GameRegistry.registerBlock(FloatingActivatedLavaRail, RailInfo.FloatingRailActivatedLavaUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawnerActivation, RailInfo.FloatingRailActivatedSpawnerUnlocalized);
        GameRegistry.registerItem(FloatingRailSpawnerLavaActivation, RailInfo.FloatingRailActivatedLavaSpawnerUnlocalized);
    }
}
