package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

import java.util.function.Supplier;
import java.util.Map;

import com.mojang.datafixers.types.templates.Named;

public class ScrapForgingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack target = ItemStack.EMPTY;
		ItemStack product = ItemStack.EMPTY;
		boolean Named = false;
		double level = 0;
		String NewName = "";
		String ItemName = "";
		target = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).copy();
		if (target.getItem() == Items.SHIELD) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_SHIELD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.shield").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_LEATHER_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_LEATHER_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_LEATHER_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_LEATHER_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_CHAINMAIL_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_CHAINMAIL_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_CHAINMAIL_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_CHAINMAIL_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_SWORD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_SHOVEL.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_PICKAXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_AXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_IRON_HOE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_SWORD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_SHOVEL.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_PICKAXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_AXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_GOLDEN_HOE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_SWORD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_SHOVEL.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_PICKAXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_AXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_DIAMOND_HOE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_SWORD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_SHOVEL.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_PICKAXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_pick").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_AXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_NETHERITE_HOE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:turtle_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_TURTLE_SHELL_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.turtle_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_SWORD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_SHOVEL.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_PICKAXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_AXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.FORGED_ETHEREAL_HOE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.isEnchanted()) {
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:curse_of_severing")))) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:curse_of_severing"))));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:curse_of_severing"))), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:life_sink")))) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:life_sink"))));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:life_sink"))), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy")))) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy"))));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:lunar_effigy"))), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound")))) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound"))));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("superiorsmithing:soul_bound"))), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), (int) level);
			}
			if (target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE)) != 0) {
				level = target.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE));
				product.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), (int) level);
			}
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = product.copy();
			_setstack.setCount(1);
			((Slot) _slots.get(2)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (!(target.getDamageValue() == product.getDamageValue())) {
			if (entity instanceof Player _player && _player.level() instanceof ServerLevel _serverLevel && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack stack = ((Slot) _slots.get(2)).getItem();
				if (stack != null) {
					stack.hurtAndBreak(target.getDamageValue(), _serverLevel, null, _stkprov -> {
					});
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}
