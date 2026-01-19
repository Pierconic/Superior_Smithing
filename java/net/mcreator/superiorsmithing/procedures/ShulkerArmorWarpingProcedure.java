package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShulkerArmorWarpingProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack TransferArmor = ItemStack.EMPTY;
		double SlotNumber = 0;
		if (entity instanceof Player) {
			SlotNumber = 0;
			for (int index0 = 0; index0 < 36; index0++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_helmets")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getCount() == 0) {
					TransferArmor = (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_modHandler.setStackInSlot((int) SlotNumber, _setstack);
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, TransferArmor);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, TransferArmor);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
						}
					}
				}
				if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_chestplates")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getCount() == 0) {
					TransferArmor = (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_modHandler.setStackInSlot((int) SlotNumber, _setstack);
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, TransferArmor);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, TransferArmor);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
						}
					}
				}
				if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_leggings")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getCount() == 0) {
					TransferArmor = (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_modHandler.setStackInSlot((int) SlotNumber, _setstack);
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, TransferArmor);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, TransferArmor);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
						}
					}
				}
				if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_boots")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getCount() == 0) {
					TransferArmor = (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_modHandler.setStackInSlot((int) SlotNumber, _setstack);
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, TransferArmor);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, TransferArmor);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
						}
					}
				}
				SlotNumber = SlotNumber + 1;
			}
		}
	}
}
