package com.justinschaaf.yarm.block.blockentity;

import com.justinschaaf.yarm.block.ModBlockRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class CounterBlockEntity extends BlockEntity {

    private int counter = 0;

    public CounterBlockEntity() {
        super(ModBlockRegistry.COUNTER_ENTITY);
    }

    // Saves serialized data
    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag); // Gets the NBT Tag

        tag.putInt("counter", counter); // Updates the value

        return tag; // Returns the tag
    }

    // Gets serialized data
    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        counter = tag.getInt("counter"); // Gets the value and updates the variable
    }

    public void incCounter() {
        counter += 1;
    }

    public void decCounter() {
        counter -= 1;
    }

    public int getCounter() {
        return counter;
    }

}
