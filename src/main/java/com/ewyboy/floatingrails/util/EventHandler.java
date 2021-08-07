package com.ewyboy.floatingrails.util;

import com.ewyboy.floatingrails.register.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public static void onDamage(LivingAttackEvent event) {
        LivingEntity entity = event.getEntityLiving();
        DamageSource damageSource = event.getSource();
        if (damageSource == DamageSource.ON_FIRE || damageSource == DamageSource.LAVA) {
            if (entity.isPassenger()) {
                Entity minecart = entity.getVehicle();
                if (minecart instanceof AbstractMinecartEntity) {
                    AxisAlignedBB aabb = entity.getBoundingBox();
                    // Look through all the blockposes that our passenger occupies to see if they
                    // collide with the obsidian lily rail.
                    // This is not ideal but without mixins it might not be possible.
                    boolean foundRail = false;
                    for (int x = (int) Math.floor(aabb.minX); x < Math.ceil(aabb.maxX); x++) {
                        for (int z = (int) Math.floor(aabb.minZ); z < Math.ceil(aabb.maxZ); z++) {
                            for (int y = (int) Math.floor(aabb.minY); y < Math.ceil(aabb.maxY); y++) {
                                BlockPos pos = new BlockPos(x, y, z);
                                if (minecart.level.getBlockState(pos).is(Register.BLOCK.FLOATING_RAIL_LAVA)) {
                                    foundRail = true;
                                }
                            }
                        }
                    }

                    if (foundRail) {
                        if (entity.isOnFire()) {
                            entity.setRemainingFireTicks(0);
                        }
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

}
