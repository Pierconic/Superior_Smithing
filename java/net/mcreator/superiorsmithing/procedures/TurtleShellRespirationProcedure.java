package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

public class TurtleShellRespirationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!entity.isInWaterOrBubble()) {
			if (itemstack.getItem() == SuperiorsmithingModItems.UNCHARGED_TURTLE_SHELL_HELMET.get()) {
				ChargedArmorConversionProcedure.execute(world, x, y, z, entity, itemstack);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0, false, false));
			} else if (itemstack.getItem() == SuperiorsmithingModItems.CHARGED_TURTLE_SHELL_HELMET.get()) {
				ChargedArmorConversionProcedure.execute(world, x, y, z, entity, itemstack);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0, false, false));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false));
			}
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.ECHOING_TURTLE_SHELL_HELMET.get()) {
			EchoRepairProcedure.execute(itemstack);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.MYSTIC_TURTLE_SHELL_HELMET.get()) {
			MysticEnchantingProcedure.execute(world, x, y, z, entity, itemstack);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.CONCHED_TURTLE_SHELL_HELMET.get()) {
			ConchArmorGraceProcedure.execute(world, entity);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.PHASED_TURTLE_SHELL_HELMET.get()) {
			PhaseArmorAgilityProcedure.execute(world, x, y, z, entity);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.SHELLED_TURTLE_SHELL_HELMET.get()) {
			ShulkerAbilityProcedure.execute(world, entity);
		}
	}
}
