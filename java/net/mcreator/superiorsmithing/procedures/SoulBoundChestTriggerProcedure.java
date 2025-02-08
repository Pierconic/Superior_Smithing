package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.SuperiorsmithingMod;

public class SoulBoundChestTriggerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double timer = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:large_containers"))) || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.HOPPER
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SMOKER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLAST_FURNACE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FURNACE) {
			SuperiorsmithingMod.queueServerWork(20, () -> {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty()) {
					SoulBoundChestProcedure.execute(world, x, y, z);
					SoulBoundChestTriggerProcedure.execute(world, x, y, z);
				}
			});
		}
	}
}
