package com.justinschaaf.yarm.main;

import com.justinschaaf.yarm.block.ModBlockRegistry;
import com.justinschaaf.yarm.item.ModItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class YetAnotherRandomMod implements ModInitializer {

	public static final ItemGroup YARM_GROUP = FabricItemGroupBuilder.build(new Identifier(Reference.MODID, "yarm_group"), () -> new ItemStack(ModItemRegistry.CHROMATIC_DYE));

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItemRegistry.registerItems();
		ModBlockRegistry.registerBlocks();

	}

}
