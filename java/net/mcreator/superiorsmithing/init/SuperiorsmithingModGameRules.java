
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.superiorsmithing.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SuperiorsmithingModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> ECHOGUARANTEE;
	public static GameRules.Key<GameRules.BooleanValue> MODDED_SMITHING;
	public static GameRules.Key<GameRules.IntegerValue> EQUIPMENT_DROP_CHANCE;
	public static GameRules.Key<GameRules.IntegerValue> HELMET_DROP_CHANCE;
	public static GameRules.Key<GameRules.IntegerValue> CHESTPLATE_DROP_CHANCE;
	public static GameRules.Key<GameRules.IntegerValue> LEGGINGS_DROP_CHANCE;
	public static GameRules.Key<GameRules.IntegerValue> BOOTS_DROP_CHANCE;
	public static GameRules.Key<GameRules.BooleanValue> CRAFTING_PARTICLES;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		ECHOGUARANTEE = GameRules.register("echoGuarantee", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		MODDED_SMITHING = GameRules.register("moddedSmithing", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		EQUIPMENT_DROP_CHANCE = GameRules.register("equipmentDropChance", GameRules.Category.PLAYER, GameRules.IntegerValue.create(30));
		HELMET_DROP_CHANCE = GameRules.register("helmetDropChance", GameRules.Category.PLAYER, GameRules.IntegerValue.create(30));
		CHESTPLATE_DROP_CHANCE = GameRules.register("chestplateDropChance", GameRules.Category.PLAYER, GameRules.IntegerValue.create(20));
		LEGGINGS_DROP_CHANCE = GameRules.register("leggingsDropChance", GameRules.Category.PLAYER, GameRules.IntegerValue.create(30));
		BOOTS_DROP_CHANCE = GameRules.register("bootsDropChance", GameRules.Category.PLAYER, GameRules.IntegerValue.create(40));
		CRAFTING_PARTICLES = GameRules.register("craftingParticles", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
