package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MomentumMiningProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumCooldown > 0) {
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.MomentumCooldown = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumCooldown - 1;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (!(entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 0)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.lodestone_compass.lock")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.lodestone_compass.lock")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.8, false);
					}
				}
			}
			{
				SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
				_vars.MomentumTier = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) == 1) {
			if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 9) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 0, false, false));
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) == 2) {
			if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier > 10 && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 16) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 17) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 1, false, false));
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) == 3) {
			if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 8) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier > 14 && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 24) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier > 14 && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 32) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 1, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 32) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 2, false, false));
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) == 4) {
			if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 10) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier > 18 && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 28) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 0, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier > 18 && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 36) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 1, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier > 18 && entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < 49) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 2, false, false));
			} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier == 50) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 3, false, false));
			}
		}
	}
}
