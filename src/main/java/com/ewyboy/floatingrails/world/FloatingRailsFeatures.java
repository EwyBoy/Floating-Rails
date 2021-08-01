package com.ewyboy.floatingrails.world;

import com.ewyboy.floatingrails.register.Register;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FloatingRailsFeatures {

    protected static final BlockState MAGMA_LILY_STATE = Register.BLOCK.MAGMA_LILY.defaultBlockState();

    public static final ConfiguredFeature<?, ?> PATCH_MAGMA_LILY = register("patch_magma_lily", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MAGMA_LILY_STATE), SimpleBlockPlacer.INSTANCE)).tries(16).build()).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(5, 0, 15)).count(12)));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String path, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, path, configuredFeature);
    }

    public static void onBiomeLoading(BiomeLoadingEvent event) {
        if (event.getCategory() != Biome.Category.THEEND) {
            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PATCH_MAGMA_LILY);
        }
    }
}
