package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShelledCyclingProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ItemStack HandItem = ItemStack.EMPTY;
		ItemStack InventoryItem = ItemStack.EMPTY;
		String CorrectTool = "";
		boolean found = false;
		double SlotNumber = 0;
		double ItemNumber = 0;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isCorrectToolForDrops(blockstate))) {
			found = false;
			HandItem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			ItemNumber = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
			InventoryItem = new ItemStack(Blocks.AIR);
			if (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:ores/iron")))
					|| blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:glass"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:storage_blocks/amethyst"))) || false || false
					|| blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:ice"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:anvil")))) {
				CorrectTool = "pickaxe";
			} else if (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:dirt"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:animals_spawnable_on")))
					|| blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:snow"))) || false || false || false) {
				CorrectTool = "shovel";
			} else if (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe"))) || false || false) {
				CorrectTool = "axe";
			} else if (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:leaves"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable_plants")))
					|| blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:tall_flowers"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:underwater_bonemeals"))) || false || false || false || false || false
					|| false) {
				CorrectTool = "hoe";
			} else if (false) {
				CorrectTool = "sword";
			}
			SlotNumber = 0;
			for (int index0 = 0; index0 < 36; index0++) {
				if (!found) {
					if ((CorrectTool).equals("pickaxe") && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).getItem() instanceof PickaxeItem && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_items")))) {
						InventoryItem = (new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SlotNumber, entity));
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = HandItem.copy();
							_setstack.setCount((int) ItemNumber);
							_modHandler.setStackInSlot((int) SlotNumber, _setstack);
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = InventoryItem.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						found = true;
					} else if ((CorrectTool).equals("shovel") && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).getItem() instanceof ShovelItem && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_items")))) {
						InventoryItem = (new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SlotNumber, entity));
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = HandItem.copy();
							_setstack.setCount((int) ItemNumber);
							_modHandler.setStackInSlot((int) SlotNumber, _setstack);
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = InventoryItem.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						found = true;
					} else if ((CorrectTool).equals("axe") && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).getItem() instanceof AxeItem && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_items")))) {
						InventoryItem = (new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SlotNumber, entity));
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = HandItem.copy();
							_setstack.setCount((int) ItemNumber);
							_modHandler.setStackInSlot((int) SlotNumber, _setstack);
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = InventoryItem.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						found = true;
					} else if ((CorrectTool).equals("hoe") && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).getItem() instanceof HoeItem && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_items")))) {
						InventoryItem = (new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SlotNumber, entity));
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = HandItem.copy();
							_setstack.setCount((int) ItemNumber);
							_modHandler.setStackInSlot((int) SlotNumber, _setstack);
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = InventoryItem.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						found = true;
					} else if ((CorrectTool).equals("sword") && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).getItem() instanceof SwordItem && (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								return _modHandler.getStackInSlot(sltid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) SlotNumber, entity)).is(ItemTags.create(ResourceLocation.parse("forge:shelled_items")))) {
						InventoryItem = (new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SlotNumber, entity));
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = HandItem.copy();
							_setstack.setCount((int) ItemNumber);
							_modHandler.setStackInSlot((int) SlotNumber, _setstack);
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = InventoryItem.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						found = true;
					}
					SlotNumber = SlotNumber + 1;
				}
			}
		}
	}
}
