package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModBlocks;

public class PummiceDegradationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SuperiorsmithingModBlocks.PUMMICE_1.get()) {
			if (Math.random() < 0.25) {
				world.setBlock(BlockPos.containing(x, y, z), SuperiorsmithingModBlocks.PUMMICE_2.get().defaultBlockState(), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SuperiorsmithingModBlocks.PUMMICE_2.get()) {
			world.setBlock(BlockPos.containing(x, y, z), SuperiorsmithingModBlocks.PUMMICE_3.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SuperiorsmithingModBlocks.PUMMICE_3.get()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
		}
	}
}
