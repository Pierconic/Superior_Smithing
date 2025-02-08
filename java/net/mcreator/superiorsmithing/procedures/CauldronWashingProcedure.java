package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CauldronWashingProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack product = ItemStack.EMPTY;
		ItemStack grounditem = ItemStack.EMPTY;
		double enchantlevel = 0;
		double damagelevel = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER_CAULDRON
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("forge:leathery")))) {
			grounditem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			if (grounditem.getItem() instanceof SwordItem) {
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_swords")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_SWORD.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_swords")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_SWORD.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_swords")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_SWORD.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_swords")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_SWORD.get());
				}
			} else if (grounditem.getItem() instanceof PickaxeItem) {
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_picks")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_PICKAXE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_picks")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_PICKAXE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_picks")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_PICKAXE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_picks")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_PICKAXE.get());
				}
			} else if (grounditem.getItem() instanceof AxeItem) {
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_axes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_AXE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_axes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_AXE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_axes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_AXE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_axes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_AXE.get());
				}
			} else if (grounditem.getItem() instanceof ShovelItem) {
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_shovels")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_SHOVEL.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_shovels")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_SHOVEL.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_shovels")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_SHOVEL.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_shovels")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_SHOVEL.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_shovels")))) {
					product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_SHOVEL.get());
				}
			} else if (grounditem.getItem() instanceof HoeItem) {
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_hoes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_HOE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_hoes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_HOE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_hoes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_HOE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_hoes")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_HOE.get());
				}
			} else {
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_ARMOR_HELMET.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_chestplates")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_ARMOR_CHESTPLATE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_leggings")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_ARMOR_LEGGINGS.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:diamond_boots")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_DIAMOND_ARMOR_BOOTS.get());
				}
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_ARMOR_HELMET.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_chestplates")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_ARMOR_CHESTPLATE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_leggings")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_ARMOR_LEGGINGS.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:golden_boots")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_GOLDEN_ARMOR_BOOTS.get());
				}
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_ARMOR_HELMET.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_chestplates")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_ARMOR_CHESTPLATE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_leggings")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_ARMOR_LEGGINGS.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:iron_boots")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_IRON_ARMOR_BOOTS.get());
				}
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_CHAINMAIL_ARMOR_HELMET.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_chestplates")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_CHAINMAIL_ARMOR_CHESTPLATE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_leggings")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_CHAINMAIL_ARMOR_LEGGINGS.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_boots")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_CHAINMAIL_ARMOR_BOOTS.get());
				}
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_ARMOR_HELMET.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_chestplates")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_ARMOR_CHESTPLATE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_leggings")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_ARMOR_LEGGINGS.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:netherite_boots")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_NETHERITE_ARMOR_BOOTS.get());
				}
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:leather_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_LEATHER_ARMOR_HELMET.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:leather_chestplates")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_LEATHER_ARMOR_CHESTPLATE.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:leather_leggings")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_LEATHER_ARMOR_LEGGINGS.get());
				} else if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:leather_boots")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_LEATHER_ARMOR_BOOTS.get());
				}
				if (grounditem.is(ItemTags.create(ResourceLocation.parse("forge:turtle_helmets")))) {
					product = new ItemStack(SuperiorsmithingModItems.BOUND_TURTLE_SHELL_HELMET.get());
				}
			}
			if (grounditem.isDamaged()) {
				product.setDamageValue(grounditem.getDamageValue());
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = product.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 8, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.splash")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.splash")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honeycomb.wax_on")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honeycomb.wax_on")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _getip64 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip64) : -1) == 1) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = Blocks.CAULDRON.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else {
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _getip67
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip67)
							: -1) - 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("superiorsmithing:laundry_day"));
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
