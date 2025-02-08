package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MysticCountdownProcedure {
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
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Mysticism == 0) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.Mysticism = 12000;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.Mysticism = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Mysticism - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
