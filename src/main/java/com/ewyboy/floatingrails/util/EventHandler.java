package com.ewyboy.floatingrails.util;

import com.ewyboy.floatingrails.register.Register;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public static void onDamage(LivingAttackEvent event)  {

        LivingEntity entity = event.getEntityLiving();
        DamageSource damageSource = event.getSource();

        if (damageSource == DamageSource.ON_FIRE || damageSource == DamageSource.LAVA) {

            if (entity.isPassenger()) {

                Entity minecart = entity.getVehicle();

                if (minecart instanceof AbstractMinecartEntity) {
                    int x = MathHelper.floor(minecart.getX());
                    int y = MathHelper.floor(minecart.getY());
                    int z = MathHelper.floor(minecart.getZ());

                    if (minecart.level.getBlockState(new BlockPos(x, y - 1, z)).is(BlockTags.RAILS)) {
                        --y;
                    }

                    BlockPos blockpos = new BlockPos(x, y, z);
                    BlockState blockstate = minecart.level.getBlockState(blockpos);

                    if (blockstate.is(Register.BLOCK.FLOATING_RAIL_LAVA)) {

                        ModLogger.info("Damage src :: " + damageSource);

                        if (entity.isOnFire()) {
                            entity.setRemainingFireTicks(0);
                        }

                        ModLogger.info("onDamage() :: Canceled");
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

}
