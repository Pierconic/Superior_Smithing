package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SoulBoundBindingProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean slot1taken = false;
		boolean slot2taken = false;
		boolean slot3taken = false;
		boolean slot4taken = false;
		boolean slot5taken = false;
		boolean slot6taken = false;
		boolean slot7taken = false;
		boolean slot8taken = false;
		if (entity instanceof Player) {
			slot1taken = false;
			slot2taken = false;
			slot3taken = false;
			slot4taken = false;
			slot5taken = false;
			slot6taken = false;
			slot7taken = false;
			slot8taken = false;
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot1taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot1taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot2taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem2 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot2taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot3taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem3 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot3taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot4taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem4 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot4taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot5taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem5 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot5taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot6taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem6 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot6taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot7taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem7 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot7taken = true;
					} else if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0
							&& slot8taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.SoulBoundItem8 = itemstackiterator.copy();
							_vars.syncPlayerVariables(entity);
						}
						slot8taken = true;
					}
				}
			}
			if (slot1taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot2taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem2 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot3taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem3 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot4taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem4 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot5taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem5 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot6taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem6 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot7taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem7 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot8taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.SoulBoundItem8 = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
