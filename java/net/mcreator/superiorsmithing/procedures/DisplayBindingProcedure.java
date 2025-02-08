package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

public class DisplayBindingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingRecipeBook == true && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SmithingRecipePage == 0 && new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, ResourceLocation.parse("superiorsmithing:binding_template_recipe"))) {
			return true;
		}
		return false;
	}
}
