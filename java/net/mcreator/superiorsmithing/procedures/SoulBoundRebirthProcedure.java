package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SoulBoundRebirthProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem2.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem3.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem4.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem5.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem6.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem7.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).SoulBoundItem8.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem2 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem3 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem4 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem5 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem6 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem7 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.SoulBoundItem8 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
	}
}
