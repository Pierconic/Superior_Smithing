
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.superiorsmithing.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.superiorsmithing.block.Pummice3Block;
import net.mcreator.superiorsmithing.block.Pummice2Block;
import net.mcreator.superiorsmithing.block.Pummice1Block;
import net.mcreator.superiorsmithing.block.FakeSmithingTableBlock;
import net.mcreator.superiorsmithing.block.FakeGrindstoneBlock;
import net.mcreator.superiorsmithing.SuperiorsmithingMod;

public class SuperiorsmithingModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SuperiorsmithingMod.MODID);
	public static final DeferredBlock<Block> FAKE_SMITHING_TABLE = REGISTRY.register("fake_smithing_table", FakeSmithingTableBlock::new);
	public static final DeferredBlock<Block> FAKE_GRINDSTONE = REGISTRY.register("fake_grindstone", FakeGrindstoneBlock::new);
	public static final DeferredBlock<Block> PUMMICE_1 = REGISTRY.register("pummice_1", Pummice1Block::new);
	public static final DeferredBlock<Block> PUMMICE_2 = REGISTRY.register("pummice_2", Pummice2Block::new);
	public static final DeferredBlock<Block> PUMMICE_3 = REGISTRY.register("pummice_3", Pummice3Block::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
