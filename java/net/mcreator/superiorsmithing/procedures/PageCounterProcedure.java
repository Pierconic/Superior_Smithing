package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class PageCounterProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##.##").format(entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingRecipePage + 1) + "/14";
	}
}
