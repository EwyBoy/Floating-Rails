package com.ewyboy.floatingrails.common.items;

import com.ewyboy.floatingrails.common.Register;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * Created by EwyBoy
 */
public class ItemMagmaLily extends ItemBlock {

    public ItemMagmaLily(Block block) {
        super(block);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        RayTraceResult raytraceresult = this.rayTrace(world, player, true);

        if (raytraceresult == null) {
            return new ActionResult<>(EnumActionResult.PASS, itemstack);
        } else {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = raytraceresult.getBlockPos();
                if (!world.isBlockModifiable(player, blockpos) || !player.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack)) {
                    return new ActionResult<>(EnumActionResult.FAIL, itemstack);
                }

                BlockPos blockpos1 = blockpos.up();
                IBlockState iblockstate = world.getBlockState(blockpos);

                if (iblockstate.getMaterial() == Material.LAVA && iblockstate.getValue(BlockLiquid.LEVEL) == 0 && world.isAirBlock(blockpos1)) {
                    BlockSnapshot blocksnapshot = BlockSnapshot.getBlockSnapshot(world, blockpos1);
                    world.setBlockState(blockpos1, Register.Blocks.magmalily.getDefaultState());
                    if (ForgeEventFactory.onPlayerBlockPlace(player, blocksnapshot, EnumFacing.UP, hand).isCanceled()) {
                        blocksnapshot.restore(true, false);
                        return new ActionResult<>(EnumActionResult.FAIL, itemstack);
                    }
                    world.setBlockState(blockpos1, Register.Blocks.magmalily.getDefaultState(), 11);
                    if (player instanceof EntityPlayerMP) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, blockpos1, itemstack);
                    }
                    if (!player.capabilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }
                    player.addStat(StatList.getObjectUseStats(this));
                    world.playSound(player, blockpos, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
                }
            }
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        }
    }
}
