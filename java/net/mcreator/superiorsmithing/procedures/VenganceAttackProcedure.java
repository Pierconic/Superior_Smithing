package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VenganceAttackProcedure {
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
		if (sourceentity instanceof Player) {
			if (sourceentity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).VenganceDamage > 0 && sourceentity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).VenganceTimer > 0) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) sourceentity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).VenganceDamage);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.hurt")), SoundSource.NEUTRAL, (float) 0.5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.hurt")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, x, y, z, (int) (5 * entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).VenganceDamage), 0.2, 0.2, 0.2, 0.03);
			}
		}
	}
}
