package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

public class EtherealArmorPowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 1, false, false));
		if (Math.random() < 0.15) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 1, 4, 4, 4, 0.1);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.CONCHED_ETHEREAL_ARMOR_HELMET.get() || itemstack.getItem() == SuperiorsmithingModItems.CONCHED_ETHEREAL_ARMOR_CHESTPLATE.get()
				|| itemstack.getItem() == SuperiorsmithingModItems.CONCHED_ETHEREAL_ARMOR_LEGGINGS.get() || itemstack.getItem() == SuperiorsmithingModItems.CONCHED_ETHEREAL_ARMOR_BOOTS.get()) {
			ConchArmorGraceProcedure.execute(world, entity);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.ECHOING_ETHEREAL_ARMOR_HELMET.get() || itemstack.getItem() == SuperiorsmithingModItems.ECHOING_ETHEREAL_ARMOR_CHESTPLATE.get()
				|| itemstack.getItem() == SuperiorsmithingModItems.ECHOING_ETHEREAL_ARMOR_LEGGINGS.get() || itemstack.getItem() == SuperiorsmithingModItems.ECHOING_ETHEREAL_ARMOR_BOOTS.get()) {
			EchoRepairProcedure.execute(itemstack);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.PHASED_ETHEREAL_ARMOR_HELMET.get() || itemstack.getItem() == SuperiorsmithingModItems.PHASED_ETHEREAL_ARMOR_CHESTPLATE.get()
				|| itemstack.getItem() == SuperiorsmithingModItems.PHASED_ETHEREAL_ARMOR_LEGGINGS.get() || itemstack.getItem() == SuperiorsmithingModItems.PHASED_ETHEREAL_ARMOR_BOOTS.get()) {
			PhaseArmorAgilityProcedure.execute(world, x, y, z, entity);
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:chargeable_items")))) {
			ChargedArmorConversionProcedure.execute(world, x, y, z, entity, itemstack);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_HELMET.get() || itemstack.getItem() == SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_CHESTPLATE.get()
				|| itemstack.getItem() == SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_LEGGINGS.get() || itemstack.getItem() == SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_BOOTS.get()) {
			MysticEnchantingProcedure.execute(world, x, y, z, entity, itemstack);
		}
		if (itemstack.getItem() == SuperiorsmithingModItems.SHELLED_ETHEREAL_ARMOR_HELMET.get() || itemstack.getItem() == SuperiorsmithingModItems.SHELLED_ETHEREAL_ARMOR_CHESTPLATE.get()
				|| itemstack.getItem() == SuperiorsmithingModItems.SHELLED_ETHEREAL_ARMOR_LEGGINGS.get() || itemstack.getItem() == SuperiorsmithingModItems.SHELLED_ETHEREAL_ARMOR_BOOTS.get()) {
			ShulkerAbilityProcedure.execute(world, entity);
		}
	}
}
