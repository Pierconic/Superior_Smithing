package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class DisplayBlankProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingRecipeBook == true
				&& !(DisplayBindingProcedure.execute(entity) || DisplayReinforcementProcedure.execute(entity) || DisplayRivetingProcedure.execute(entity) || DisplayGildingProcedure.execute(entity) || DisplayJewelingProcedure.execute(entity)
						|| DisplayForgingProcedure.execute(entity) || DisplayUpgradeProcedure.execute(entity) || DisplayPhasingProcedure.execute(entity) || DisplayConchingProcedure.execute(entity) || DisplayEchoingProcedure.execute(entity)
						|| DisplayChargingProcedure.execute(entity) || DisplayMysticProcedure.execute(entity) || DisplayShellingProcedure.execute(entity) || DisplayUpgrade2Procedure.execute(entity))) {
			return true;
		}
		return false;
	}
}
