package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChargingArmorTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining > 0) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.ChargeRemaining = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining == 1 || entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining == 0) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.ChargeRemaining = -1200;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining == -1) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.ChargeRemaining = 3600;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining < 0) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.ChargeRemaining = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
