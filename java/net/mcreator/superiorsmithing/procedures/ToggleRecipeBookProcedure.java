package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class ToggleRecipeBookProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingRecipeBook == false) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.SmithingRecipeBook = true;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.SmithingRecipeBook = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
