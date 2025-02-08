package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class DisplayRecipeBookProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingRecipeBook == true) {
			return true;
		}
		return false;
	}
}
