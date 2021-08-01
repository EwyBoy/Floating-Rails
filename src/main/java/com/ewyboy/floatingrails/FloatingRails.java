package com.ewyboy.floatingrails;

import com.ewyboy.bibliotheca.common.loaders.ContentLoader;
import com.ewyboy.floatingrails.register.Register;
import com.ewyboy.floatingrails.world.FloatingRailsFeatures;
import com.ewyboy.floatingrails.world.feature.MagmaLilyFeature;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.ewyboy.floatingrails.FloatingRails.MOD_ID;

@Mod(MOD_ID)
public class FloatingRails {

    public static final String MOD_ID = "floatingrails";

    public FloatingRails() {
        ContentLoader.init(MOD_ID, itemGroup, Register.BLOCK.class, Register.ITEM.class, Register.TILE.class);

        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.HIGH, FloatingRailsFeatures :: onBiomeLoading);
    }

    public static final ItemGroup itemGroup = new ItemGroup(FloatingRails.MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Register.BLOCK.FLOATING_RAIL);
        }
    };

}
