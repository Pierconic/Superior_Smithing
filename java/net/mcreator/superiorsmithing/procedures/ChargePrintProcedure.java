package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class ChargePrintProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format(entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining))), false);
	}
}
