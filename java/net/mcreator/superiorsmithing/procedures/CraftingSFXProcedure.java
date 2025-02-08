package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModGameRules;
import net.mcreator.superiorsmithing.SuperiorsmithingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CraftingSFXProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getCrafting());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		execute(null, world, x, y, z, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (itemstack.getItem() instanceof BlockItem && world.getLevelData().getGameRules().getBoolean(SuperiorsmithingModGameRules.CRAFTING_PARTICLES) && !itemstack.is(ItemTags.create(ResourceLocation.parse("forge:priceless_vases")))
				&& !itemstack.is(ItemTags.create(ResourceLocation.parse("forge:craft_sfx_exempt")))) {
			SuperiorsmithingMod.queueServerWork(2, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId((itemstack.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState())));
			});
		} else {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:glass_sfx"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("forge:glass_test"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("forge:priceless_vases")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:glasscrafting")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:glasscrafting")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:gem_sfx")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:gemcrafting")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:gemcrafting")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:wooden_sfx"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("forge:wood_sfx")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:woodcrafting")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:woodcrafting")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:stone_sfx")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:stonecrafting")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:stonecrafting")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:metal_sfx"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("forge:respawn_items")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:metalcrafting")), SoundSource.NEUTRAL, (float) 0.6, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:metalcrafting")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:textiles_sfx")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:papercrafting")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:papercrafting")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:weird_sfx"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("forge:totems")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:rainbow_sfx_vanilla"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("forge:rainbow_sfx_modded")))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.dye.use")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.dye.use")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:woodcrafting")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("superiorsmithing:woodcrafting")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
