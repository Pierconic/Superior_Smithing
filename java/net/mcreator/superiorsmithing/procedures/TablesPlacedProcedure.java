package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TablesPlacedProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}
