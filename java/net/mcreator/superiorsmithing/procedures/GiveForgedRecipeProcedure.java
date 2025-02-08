package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;

public class GiveForgedRecipeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("superiorsmithing:forged_template_recipe")));
	}
}
