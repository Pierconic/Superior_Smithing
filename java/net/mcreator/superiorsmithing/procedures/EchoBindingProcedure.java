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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EchoBindingProcedure {
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
					if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot1taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo1 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot1taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot2taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo2 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot2taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot3taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo3 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot3taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot4taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo4 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot4taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot5taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo5 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot5taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot6taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo6 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot6taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot7taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo7 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot7taken = true;
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("forge:echoing")))
							&& !(itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
									|| itemstackiterator.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())
							&& slot8taken == false) {
						{
							SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
							_vars.Echo8 = itemstackiterator;
							_vars.syncPlayerVariables(entity);
						}
						slot8taken = true;
					}
				}
			}
			if (slot1taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo1 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot2taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo2 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot3taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo3 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot4taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo4 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot5taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo5 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot6taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo6 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot7taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo7 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (slot8taken == false) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.Echo8 = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("forge:echoing")))) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.BootsEcho = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.BootsEcho = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("forge:echoing")))) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.PantsEcho = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.PantsEcho = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("forge:echoing")))) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.ChestplateEcho = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.ChestplateEcho = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("forge:echoing")))) {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.HelmetEcho = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
					_vars.HelmetEcho = ItemStack.EMPTY;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
