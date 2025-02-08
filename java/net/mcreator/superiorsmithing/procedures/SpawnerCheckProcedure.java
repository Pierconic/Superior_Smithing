package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SpawnerCheckProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -4;
		found = false;
		for (int index0 = 0; index0 < 7; index0++) {
			sy = -4;
			for (int index1 = 0; index1 < 7; index1++) {
				sz = -4;
				for (int index2 = 0; index2 < 7; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.TRIAL_SPAWNER) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("ominous") instanceof BooleanProperty _getbp3
								&& (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getValue(_getbp3)) {
							return 2;
						} else {
							return 1;
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		return 0;
	}
}
