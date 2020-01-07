package com.justinschaaf.yarm.block;

import com.justinschaaf.yarm.block.block.CounterBlock;
import com.justinschaaf.yarm.block.blockentity.CounterBlockEntity;
import com.justinschaaf.yarm.main.Reference;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockRegistry {

    // Chromatic Block
    public static final Block CHROMATIC_BLOCK = new Block(FabricBlockSettings.of(Material.GLASS).breakByHand(true).hardness(0.5f).lightLevel(15).build());

    // Counter
    public static final Block COUNTER = new CounterBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f, 2.0f).build());
    public static BlockEntityType<CounterBlockEntity> COUNTER_ENTITY;

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(Reference.MODID, "chromatic_block"), ModBlockRegistry.CHROMATIC_BLOCK);

        // Counter
        Registry.register(Registry.BLOCK, new Identifier(Reference.MODID, "counter"), ModBlockRegistry.COUNTER);
        Registry.register(Registry.BLOCK_ENTITY, new Identifier(Reference.MODID, "counter"), BlockEntityType.Builder.create(CounterBlockEntity::new, ModBlockRegistry.COUNTER).build(null));

    }

}
