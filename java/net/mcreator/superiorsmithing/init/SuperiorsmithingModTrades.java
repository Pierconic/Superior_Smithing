
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.superiorsmithing.init;

import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@EventBusSubscriber
public class SuperiorsmithingModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(SuperiorsmithingModItems.CHARGED_TEMPLATE_COPY.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(SuperiorsmithingModItems.MYSTIC_TEMPLATE_COPY.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(SuperiorsmithingModItems.BINDING_TEMPLATE_COPY.get()), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(Items.COPPER_INGOT), new ItemStack(SuperiorsmithingModItems.REINFORCED_IRON_ARMOR_HELMET.get()), 3, 2, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.COPPER_INGOT), new ItemStack(SuperiorsmithingModItems.REINFORCED_IRON_ARMOR_CHESTPLATE.get()), 3, 2, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.COPPER_INGOT), new ItemStack(SuperiorsmithingModItems.REINFORCED_IRON_ARMOR_LEGGINGS.get()), 3, 2, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_IRON_ARMOR_HELMET.get()), 3, 4, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_IRON_ARMOR_CHESTPLATE.get()), 3, 4, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_IRON_ARMOR_LEGGINGS.get()), 3, 4, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_ARMOR_HELMET.get()), 3, 6, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_ARMOR_CHESTPLATE.get()), 3, 6, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_ARMOR_LEGGINGS.get()), 3, 6, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_DIAMOND_ARMOR_HELMET.get()), 3, 6, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_DIAMOND_ARMOR_CHESTPLATE.get()), 3, 6, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_DIAMOND_ARMOR_LEGGINGS.get()), 3, 6, 0.05f));
		}
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.COPPER_INGOT), new ItemStack(SuperiorsmithingModItems.REINFORCED_IRON_HOE.get()), 5, 4, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.COPPER_INGOT), new ItemStack(SuperiorsmithingModItems.REINFORCED_IRON_PICKAXE.get()), 5, 4, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.COPPER_INGOT), new ItemStack(SuperiorsmithingModItems.REINFORCED_IRON_SHOVEL.get()), 5, 4, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_HOE.get()), 5, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_SHOVEL.get()), 5, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_PICKAXE.get()), 5, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_SHOVEL.get()), 5, 6, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 22), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_PICKAXE.get()), 5, 6, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_SHOVEL.get()), 5, 6, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 26), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_DIAMOND_SHOVEL.get()), 5, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 28), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_DIAMOND_PICKAXE.get()), 5, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 22), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_DIAMOND_HOE.get()), 5, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(SuperiorsmithingModItems.ENFORCING_TEMPLATE_COPY.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_IRON_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_IRON_AXE.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 13), new ItemStack(Items.GOLD_INGOT), new ItemStack(SuperiorsmithingModItems.GILDED_IRON_AXE.get()), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 13), new ItemStack(Items.DIAMOND), new ItemStack(SuperiorsmithingModItems.JEWELED_IRON_AXE.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 17), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_DIAMOND_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(Items.IRON_INGOT), new ItemStack(SuperiorsmithingModItems.RIVETED_DIAMOND_AXE.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(SuperiorsmithingModItems.RIVETING_TEMPLATE_COPY.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.LEATHERWORKER) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Items.IRON_SWORD), new ItemStack(SuperiorsmithingModItems.BOUND_IRON_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Items.IRON_PICKAXE), new ItemStack(SuperiorsmithingModItems.BOUND_IRON_PICKAXE.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(SuperiorsmithingModItems.BOUND_IRON_ARMOR_CHESTPLATE.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Items.IRON_HELMET), new ItemStack(SuperiorsmithingModItems.BOUND_IRON_ARMOR_HELMET.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(SuperiorsmithingModItems.LIGHT_GRAY_IRON_ARMOR_CHESTPLATE.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(Items.IRON_LEGGINGS), new ItemStack(SuperiorsmithingModItems.LIGHT_GRAY_IRON_ARMOR_LEGGINGS.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(Items.IRON_SWORD), new ItemStack(SuperiorsmithingModItems.LIGHT_GRAY_IRON_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(Items.IRON_PICKAXE), new ItemStack(SuperiorsmithingModItems.LIGHT_GRAY_IRON_PICKAXE.get()), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.GOLDEN_PICKAXE), new ItemStack(SuperiorsmithingModItems.ORANGE_GOLDEN_PICKAXE.get()), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.GOLDEN_SWORD), new ItemStack(SuperiorsmithingModItems.ORANGE_GOLDEN_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.GOLDEN_CHESTPLATE), new ItemStack(SuperiorsmithingModItems.ORANGE_GOLDEN_ARMOR_CHESTPLATE.get()), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.GOLDEN_HELMET), new ItemStack(SuperiorsmithingModItems.ORANGE_GOLDEN_ARMOR_HELMET.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.DIAMOND_SWORD), new ItemStack(SuperiorsmithingModItems.CYAN_DIAMOND_SWORD.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.DIAMOND_PICKAXE), new ItemStack(SuperiorsmithingModItems.CYAN_DIAMOND_PICKAXE.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(SuperiorsmithingModItems.CYAN_DIAMOND_ARMOR_CHESTPLATE.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.DIAMOND_LEGGINGS), new ItemStack(SuperiorsmithingModItems.CYAN_DIAMOND_ARMOR_LEGGINGS.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(SuperiorsmithingModItems.BINDING_TEMPLATE_COPY.get()), 10, 5, 0.05f));
		}
	}
}
