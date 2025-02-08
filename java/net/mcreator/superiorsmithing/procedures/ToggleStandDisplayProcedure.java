package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class ToggleStandDisplayProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingDisplay) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.SmithingDisplay = false;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.SmithingDisplay = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
