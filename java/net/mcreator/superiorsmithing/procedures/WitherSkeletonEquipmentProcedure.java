package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;
import net.mcreator.superiorsmithing.init.SuperiorsmithingModGameRules;
import net.mcreator.superiorsmithing.SuperiorsmithingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WitherSkeletonEquipmentProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean pants = false;
		boolean armorenchanted = false;
		boolean armormodified = false;
		boolean weapon = false;
		boolean weaponmodified = false;
		boolean armor = false;
		boolean chestplate = false;
		boolean helmet = false;
		boolean boots = false;
		boolean weaponenchanted = false;
		double type = 0;
		double armoramount = 0;
		double rarity = 0;
		if (entity instanceof WitherSkeleton && !(entity.getDisplayName().getString()).equals("static")) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = ItemStack.EMPTY.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, ItemStack.EMPTY);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
				}
			}
			weapon = false;
			armor = false;
			helmet = false;
			boots = false;
			chestplate = false;
			pants = false;
			weaponenchanted = false;
			armorenchanted = false;
			weaponmodified = false;
			armormodified = false;
			if (world.getDifficulty() == Difficulty.EASY) {
				rarity = Mth.nextInt(RandomSource.create(), 0, 1);
				if (Math.random() < 0.2) {
					armor = true;
					armoramount = Mth.nextInt(RandomSource.create(), 1, 2);
					if (Math.random() < 0.05) {
						armorenchanted = true;
					}
					if (Math.random() < 0.2) {
						armormodified = true;
					}
				}
				if (Math.random() < 0.3) {
					weapon = true;
					if (Math.random() < 0.05) {
						weaponenchanted = true;
					}
					if (Math.random() < 0.2) {
						weaponmodified = true;
					}
				}
			} else if (world.getDifficulty() == Difficulty.NORMAL) {
				rarity = Mth.nextInt(RandomSource.create(), 0, 2);
				if (Math.random() < 0.3) {
					armor = true;
					armoramount = Mth.nextInt(RandomSource.create(), 1, 4);
					if (Math.random() < 0.1) {
						armorenchanted = true;
					}
					if (Math.random() < 0.3) {
						armormodified = true;
					}
				}
				if (Math.random() < 0.4) {
					weapon = true;
					if (Math.random() < 0.2) {
						weaponenchanted = true;
					}
					if (Math.random() < 0.3) {
						weaponmodified = true;
					}
				}
			} else if (world.getDifficulty() == Difficulty.HARD) {
				rarity = Mth.nextInt(RandomSource.create(), 1, 3);
				if (Math.random() < 0.4) {
					armor = true;
					armoramount = Mth.nextInt(RandomSource.create(), 1, 4);
					if (Math.random() < 0.2) {
						armorenchanted = true;
					}
					if (Math.random() < 0.4) {
						armormodified = true;
					}
				}
				if (Math.random() < 0.5) {
					weapon = true;
					if (Math.random() < 0.2) {
						weaponenchanted = true;
					}
					if (Math.random() < 0.4) {
						weaponmodified = true;
					}
				}
			}
			for (int index0 = 0; index0 < (int) armoramount; index0++) {
				type = Mth.nextInt(RandomSource.create(), 0, 3);
				if (type == 0 && Math.random() < 0.3) {
					helmet = true;
				} else if (type == 1) {
					chestplate = true;
				} else if (type == 2) {
					boots = true;
				} else if (type == 3) {
					pants = true;
				}
			}
			if (weapon == true) {
				if (rarity == 0) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.STONE_SWORD).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (rarity == 1) {
					if (weaponmodified == true) {
						if (weaponenchanted == true) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_SWORD.get()), Mth.nextInt(RandomSource.create(), 10, 20),
										(false)
												? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
												: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
										.copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						} else {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_SWORD.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					} else if (weaponenchanted == true) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_SWORD), Mth.nextInt(RandomSource.create(), 10, 20),
									(false)
											? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
											: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
									.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				} else if (rarity == 2) {
					if (weaponmodified == true) {
						if (weaponenchanted == true) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_SWORD.get()), Mth.nextInt(RandomSource.create(), 10, 20),
										(false)
												? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
												: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
										.copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						} else {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_SWORD.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					} else if (weaponenchanted == true) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_SWORD.get()), Mth.nextInt(RandomSource.create(), 10, 20),
									(false)
											? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
											: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
									.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(SuperiorsmithingModItems.GILDED_IRON_SWORD.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				} else if (rarity == 3) {
					if (weaponmodified == true) {
						if (weaponenchanted == true) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_SWORD.get()), Mth.nextInt(RandomSource.create(), 10, 20),
										(false)
												? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
												: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
										.copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						} else {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_SWORD.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					} else if (weaponenchanted == true) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_SWORD), Mth.nextInt(RandomSource.create(), 10, 20),
									(false)
											? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
											: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
									.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			}
			if (helmet == true) {
				if (rarity == 0) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_HELMET.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_HELMET.get()));
						}
					}
				} else if (rarity == 1) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_HELMET.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
					}
				} else if (rarity == 2) {
					if (Math.random() < 0.5) {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_HELMET.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_HELMET.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
								}
							}
						}
					} else {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3, new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_HELMET.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_HELMET.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Items.IRON_HELMET));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
								}
							}
						}
					}
				} else if (rarity == 3) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_HELMET.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_HELMET.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_HELMET), Mth.nextInt(RandomSource.create(), 10, 20),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.DIAMOND_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
							}
						}
					}
				}
			}
			if (chestplate == true) {
				if (rarity == 0) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_CHESTPLATE.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_CHESTPLATE.get()));
						}
					}
				} else if (rarity == 1) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_CHESTPLATE.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_CHESTPLATE), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_CHESTPLATE), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.GOLDEN_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
							}
						}
					}
				} else if (rarity == 2) {
					if (Math.random() < 0.5) {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_CHESTPLATE.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_CHESTPLATE.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_CHESTPLATE), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_CHESTPLATE), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Items.GOLDEN_CHESTPLATE));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
								}
							}
						}
					} else {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_CHESTPLATE.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_CHESTPLATE.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_CHESTPLATE), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_CHESTPLATE), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
								}
							}
						}
					}
				} else if (rarity == 3) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 20, 30),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_CHESTPLATE.get()), Mth.nextInt(RandomSource.create(), 20, 30),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_CHESTPLATE.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_CHESTPLATE), Mth.nextInt(RandomSource.create(), 20, 30),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_CHESTPLATE), Mth.nextInt(RandomSource.create(), 20, 30),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.DIAMOND_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
							}
						}
					}
				}
			}
			if (pants == true) {
				if (rarity == 0) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_LEGGINGS.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_LEGGINGS.get()));
						}
					}
				} else if (rarity == 1) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_LEGGINGS.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_LEGGINGS), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_LEGGINGS), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.GOLDEN_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
							}
						}
					}
				} else if (rarity == 2) {
					if (Math.random() < 0.5) {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_LEGGINGS.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_LEGGINGS.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_LEGGINGS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_LEGGINGS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Items.GOLDEN_LEGGINGS));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
								}
							}
						}
					} else {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1, new ItemStack(SuperiorsmithingModItems.GILDED_CHAINMAIL_ARMOR_LEGGINGS.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SuperiorsmithingModItems.GILDED_CHAINMAIL_ARMOR_LEGGINGS.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_LEGGINGS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_LEGGINGS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
								}
							}
						}
					}
				} else if (rarity == 3) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 20, 30),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_LEGGINGS.get()), Mth.nextInt(RandomSource.create(), 20, 30),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_LEGGINGS.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_LEGGINGS), Mth.nextInt(RandomSource.create(), 20, 30),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_LEGGINGS), Mth.nextInt(RandomSource.create(), 20, 30),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.DIAMOND_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
							}
						}
					}
				}
			}
			if (boots == true) {
				if (rarity == 0) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_BOOTS.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(SuperiorsmithingModItems.BLACK_LEATHER_ARMOR_BOOTS.get()));
						}
					}
				} else if (rarity == 1) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
													(false)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(SuperiorsmithingModItems.GILDED_GOLDEN_ARMOR_BOOTS.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_BOOTS), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_BOOTS), Mth.nextInt(RandomSource.create(), 10, 20),
												(false)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.GOLDEN_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
							}
						}
					}
				} else if (rarity == 2) {
					if (Math.random() < 0.5) {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(0,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.FEET,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(0, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_BOOTS.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_BOOTS.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_BOOTS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_BOOTS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Items.GOLDEN_BOOTS));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
								}
							}
						}
					} else {
						if (armormodified == true) {
							if (armorenchanted == true) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(0,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.FEET,
												(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 10, 20),
														(true)
																? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
																: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									}
								}
							} else {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(0, new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_BOOTS.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(SuperiorsmithingModItems.GILDED_IRON_ARMOR_BOOTS.get()));
									}
								}
							}
						} else if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_BOOTS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_BOOTS), Mth.nextInt(RandomSource.create(), 10, 20),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
								}
							}
						}
					}
				} else if (rarity == 3) {
					if (armormodified == true) {
						if (armorenchanted == true) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 20, 30),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET,
											(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_BOOTS.get()), Mth.nextInt(RandomSource.create(), 20, 30),
													(true)
															? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
															: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								}
							}
						} else {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_BOOTS.get()));
								}
							}
						}
					} else if (armorenchanted == true) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_BOOTS), Mth.nextInt(RandomSource.create(), 20, 30),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.DIAMOND_BOOTS), Mth.nextInt(RandomSource.create(), 20, 30),
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.DIAMOND_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
							}
						}
					}
				}
			}
			SuperiorsmithingMod.queueServerWork(2, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("/data merge entity @e[type=wither_skeleton, sort=nearest, limit=1] {HandDropChances:["
									+ new java.text.DecimalFormat("##.##").format((world.getLevelData().getGameRules().getInt(SuperiorsmithingModGameRules.EQUIPMENT_DROP_CHANCE)) * 0.01) + "f],ArmorDropChances:["
									+ new java.text.DecimalFormat("##.##").format((world.getLevelData().getGameRules().getInt(SuperiorsmithingModGameRules.BOOTS_DROP_CHANCE)) * 0.01) + "f,"
									+ new java.text.DecimalFormat("##.##").format((world.getLevelData().getGameRules().getInt(SuperiorsmithingModGameRules.LEGGINGS_DROP_CHANCE)) * 0.01) + "f,"
									+ new java.text.DecimalFormat("##.##").format((world.getLevelData().getGameRules().getInt(SuperiorsmithingModGameRules.CHESTPLATE_DROP_CHANCE)) * 0.01) + "f,"
									+ new java.text.DecimalFormat("##.##").format((world.getLevelData().getGameRules().getInt(SuperiorsmithingModGameRules.HELMET_DROP_CHANCE)) * 0.01) + "f]}"));
			});
		}
	}
}
