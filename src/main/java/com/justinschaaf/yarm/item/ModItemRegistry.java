package com.justinschaaf.yarm.item;

import com.justinschaaf.yarm.block.ModBlockRegistry;
import com.justinschaaf.yarm.main.Reference;
import com.justinschaaf.yarm.main.YetAnotherRandomMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItemRegistry {

    // Chromatic Stuff
    public static final Item CHROMATIC_DYE = new Item(new Item.Settings().group(YetAnotherRandomMod.YARM_GROUP));
    public static final Item CHROMATIC_BLOCK = new BlockItem(ModBlockRegistry.CHROMATIC_BLOCK, new Item.Settings().group(YetAnotherRandomMod.YARM_GROUP));

    // Counter
    public static final Item COUNTER = new BlockItem(ModBlockRegistry.COUNTER, new Item.Settings().group(YetAnotherRandomMod.YARM_GROUP));

    public static void registerItems() {

        // Chromatic Stuff
        Registry.register(Registry.ITEM, new Identifier(Reference.MODID, "chromatic_dye"), CHROMATIC_DYE);
        Registry.register(Registry.ITEM, new Identifier(Reference.MODID, "chromatic_block"), CHROMATIC_BLOCK);

        // Counter
        Registry.register(Registry.ITEM, new Identifier(Reference.MODID, "counter"), COUNTER);

    }

}
