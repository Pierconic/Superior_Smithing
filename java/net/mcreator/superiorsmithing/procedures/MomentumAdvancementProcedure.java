package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MomentumAdvancementProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double maxspeed = 0;
		if (entity instanceof Player) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) != 0) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) == 3) {
					maxspeed = 32;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:momentum")))) == 2) {
					maxspeed = 17;
				} else {
					maxspeed = 9;
				}
				if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier < maxspeed) {
					{
						SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
						_vars.MomentumTier = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lodestone.place")), SoundSource.NEUTRAL, 1,
									(float) (0.8 * entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier * 0.1));
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lodestone.place")), SoundSource.NEUTRAL, 1,
									(float) (0.8 * entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier * 0.1), false);
						}
					}
				}
				if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).MomentumTier <= 2) {
					{
						SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
						_vars.MomentumCooldown = 80;
						_vars.syncPlayerVariables(entity);
					}
				} else {
					{
						SuperiorsmithingModVariables.PlayerVariables _vars = entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES);
						_vars.MomentumCooldown = 40;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
