package com.justinschaaf.yarm.block.block;

import com.justinschaaf.yarm.block.blockentity.CounterBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class CounterBlock extends Block implements BlockEntityProvider {

    public CounterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new CounterBlockEntity();
    }

    // Right Click Action
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        // Gets the right clicked block entity
        CounterBlockEntity be = (CounterBlockEntity) world.getBlockEntity(pos);

        // If the player sneaks when clicking the block, decrease the count
        if (player.isSneaking()) {
            be.decCounter();
            sendCount(be, player);
            be.markDirty();
        } else { // Else, increase the count
            be.incCounter();
            sendCount(be, player);
            be.markDirty(); // Mark dirty to update NBT
        }

        return ActionResult.SUCCESS;

    }

    // Left Click Action -- why u no work!
    /*@Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        // Gets the clicked block entity
        CounterBlockEntity be = (CounterBlockEntity) world.getBlockEntity(pos);

        // If the player is sneaking when clicking the block, send them the count
        if (player.isSneaking()) {
            player.addChatMessage(new TranslatableText("block.yarm.counter.count", be.getCounter()), true);
        } else { // Else, decrease the count
            be.decCounter();
            be.markDirty();
        }

        super.onBreak(world, pos, state, player);

    }*/

    private void sendCount(CounterBlockEntity be, PlayerEntity player) {
        // I'm guessing "bl" is for "below", as in ActionBar text
        player.addChatMessage(new TranslatableText("block.yarm.counter.count", be.getCounter()), true); // Output is doubled for unknown reasons
    }

    // Comparator Output
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {

        CounterBlockEntity be = (CounterBlockEntity) world.getBlockEntity(pos);
        int count = be.getCounter();
        return (count > 15) ? 15 : (count < 0) ? 0 : count; // If the counter is greater than 15, return 15; else if the counter is below 0, return 0; else return the counter

    }

    // Tooltip
    @Override
    public void buildTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("block.yarm.counter.tooltip"));
    }

}
