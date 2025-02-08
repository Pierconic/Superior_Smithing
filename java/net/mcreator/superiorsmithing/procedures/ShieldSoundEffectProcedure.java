package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

public class ShieldSoundEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (itemstack.getItem() == SuperiorsmithingModItems.RIVETED_SHIELD.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_iron")), SoundSource.PLAYERS, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_iron")), SoundSource.PLAYERS, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		} else if (itemstack.getItem() == SuperiorsmithingModItems.GILDED_SHIELD.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_gold")), SoundSource.PLAYERS, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_gold")), SoundSource.PLAYERS, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		} else if (itemstack.getItem() == SuperiorsmithingModItems.JEWELED_SHIELD.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_diamond")), SoundSource.PLAYERS, (float) 0.3,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_diamond")), SoundSource.PLAYERS, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		} else if (itemstack.getItem() == SuperiorsmithingModItems.FORGED_SHIELD.get() || itemstack.getItem() == SuperiorsmithingModItems.ETHEREAL_SHIELD.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_netherite")), SoundSource.PLAYERS, (float) 0.3,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_netherite")), SoundSource.PLAYERS, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		}
	}
}
