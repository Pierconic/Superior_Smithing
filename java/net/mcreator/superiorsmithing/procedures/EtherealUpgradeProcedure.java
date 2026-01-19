package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

import java.util.function.Supplier;
import java.util.Map;

public class EtherealUpgradeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double level = 0;
		String ItemName = "";
		ItemStack product = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		target = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).copy();
		if (target.getItem() == Items.SHIELD) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_SHIELD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.shield").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		}
		if (target.getItem() == Items.NETHERITE_HELMET) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_ARMOR_HELMET.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_helmet").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_CHESTPLATE) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_ARMOR_CHESTPLATE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_chestplate").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_LEGGINGS) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_ARMOR_LEGGINGS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_leggings").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_BOOTS) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_ARMOR_BOOTS.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_boots").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_SWORD) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_SWORD.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_sword").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_SHOVEL) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_SHOVEL.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_shovel").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_PICKAXE) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_PICKAXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_pickaxe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_AXE) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_AXE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_axe").getString() + "]")) {
				ItemName = target.getDisplayName().getString();
				product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
			}
		} else if (target.getItem() == Items.NETHERITE_HOE) {
			product = new ItemStack(SuperiorsmithingModItems.ETHEREAL_HOE.get()).copy();
			if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.minecraft.netherite_hoe").getString() + "]")) {
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
