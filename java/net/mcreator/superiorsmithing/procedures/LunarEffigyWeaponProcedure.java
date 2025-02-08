package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LunarEffigyWeaponProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double level = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy")))) != 0) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy")))) == 0) {
				if (world instanceof Level _lvl4 && _lvl4.isDay()) {
					level = 2;
				} else {
					level = 4;
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy")))) == 1) {
				if (world instanceof Level _lvl7 && _lvl7.isDay()) {
					level = 4;
				} else {
					level = 8;
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy")))) == 2) {
				if (world instanceof Level _lvl10 && _lvl10.isDay()) {
					level = 6;
				} else {
					level = 12;
				}
			}
			if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (14 + level));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 1) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (4 + level));
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 2) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (6 + level));
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 3) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (8 + level));
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 4) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (10 + level));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 5) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (8 + level));
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 6) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (10 + level));
			} else if (world.dimensionType().moonPhase(world.dayTime()) == 7) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) (12 + level));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 20, 0.4, 0.4, 0.4, 0.2);
		}
	}
}
