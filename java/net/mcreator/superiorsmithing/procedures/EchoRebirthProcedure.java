package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;
import net.mcreator.superiorsmithing.init.SuperiorsmithingModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EchoRebirthProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) == false) {
			if (world.getLevelData().getGameRules().getBoolean(SuperiorsmithingModGameRules.ECHOGUARANTEE) == true) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo1.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo2.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo3.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo4.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo5.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo6.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo7.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo8.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).HelmetEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).HelmetEcho);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChestplateEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChestplateEcho);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).PantsEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).PantsEcho);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).BootsEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).BootsEcho);
					}
				}
				if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).HelmetEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChestplateEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).PantsEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).BootsEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo1.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("superiorsmithing:cant_take_it_with_you"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else {
				if (entity instanceof Player _player) {
					ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo1.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (Math.random() < 0.9) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo2.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (Math.random() < 0.8) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo3.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (Math.random() < 0.7) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo4.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (Math.random() < 0.6) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo5.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (Math.random() < 0.5) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo7.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (Math.random() < 0.4) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo8.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).HelmetEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).HelmetEcho);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChestplateEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChestplateEcho);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).PantsEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).PantsEcho);
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).BootsEcho);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).BootsEcho);
					}
				}
				if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).HelmetEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChestplateEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).PantsEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).BootsEcho.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
						|| entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).Echo1.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("superiorsmithing:cant_take_it_with_you"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			}
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo1 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo2 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo3 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo4 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo5 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo6 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo7 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		{
			SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
			_vars.Echo8 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
	}
}
