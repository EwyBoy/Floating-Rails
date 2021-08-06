package com.ewyboy.floatingrails;

import com.ewyboy.bibliotheca.common.loaders.ContentLoader;
import com.ewyboy.floatingrails.register.Register;
import com.ewyboy.floatingrails.util.EventHandler;
import com.ewyboy.floatingrails.util.ModLogger;
import com.ewyboy.floatingrails.world.FloatingRailsFeatures;
import com.ewyboy.floatingrails.world.feature.MagmaLilyFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
        forgeBus.addListener(EventPriority.HIGH, EventHandler :: onDamage);
    }

    public static final ItemGroup itemGroup = new ItemGroup(FloatingRails.MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Register.BLOCK.FLOATING_RAIL);
        }
    };

}
