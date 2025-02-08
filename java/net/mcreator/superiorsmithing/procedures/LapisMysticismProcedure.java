package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

import java.util.function.Supplier;
import java.util.Map;

public class LapisMysticismProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double level = 0;
		String ItemName = "";
		ItemStack product = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		target = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_LEATHER_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_LEATHER_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_LEATHER_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:leather_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_LEATHER_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.leather_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_CHAINMAIL_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_CHAINMAIL_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_CHAINMAIL_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:chainmail_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_CHAINMAIL_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.chainmail_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_chestplate")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_SWORD.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_SHOVEL.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_PICKAXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_AXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:iron_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_IRON_HOE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.iron_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_SWORD.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_SHOVEL.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_PICKAXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_AXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:golden_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_GOLDEN_HOE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.golden_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_SWORD.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_SHOVEL.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_PICKAXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_AXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:diamond_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_DIAMOND_HOE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.diamond_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_SWORD.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_SHOVEL.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_PICKAXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_pick").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_AXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:netherite_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_NETHERITE_HOE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:turtle_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_TURTLE_SHELL_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.turtle_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_helmets")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_HELMET.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_chestplates")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_CHESTPLATE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_leggings")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_LEGGINGS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_boots")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_ARMOR_BOOTS.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_armor_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_swords")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_SWORD.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_shovels")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_SHOVEL.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_picks")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_PICKAXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_axes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_AXE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.is(ItemTags.create(ResourceLocation.parse("forge:ethereal_hoes")))) {
			product = new ItemStack(SuperiorsmithingModItems.MYSTIC_ETHEREAL_HOE.get());
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.ethereal_hoe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
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
