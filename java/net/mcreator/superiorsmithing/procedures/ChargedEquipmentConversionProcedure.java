package net.mcreator.superiorsmithing.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.network.SuperiorsmithingModVariables;
import net.mcreator.superiorsmithing.init.SuperiorsmithingModItems;

public class ChargedEquipmentConversionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, double slot) {
		if (entity == null)
			return;
		String ItemName = "";
		ItemStack target = ItemStack.EMPTY;
		ItemStack product = ItemStack.EMPTY;
		double level = 0;
		double damage = 0;
		double armorslot = 0;
		target = itemstack;
		product = new ItemStack(Blocks.AIR);
		if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining > 0 && target.is(ItemTags.create(ResourceLocation.parse("forge:uncharged")))) {
			if (target.getItem() instanceof SwordItem) {
				if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_IRON_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_IRON_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_iron_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_GOLDEN_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_GOLDEN_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_golden_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_DIAMOND_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_DIAMOND_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_diamond_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_NETHERITE_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_NETHERITE_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_netherite_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_ETHEREAL_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_ETHEREAL_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_ethereal_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof AxeItem) {
				if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_IRON_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_IRON_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_iron_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_GOLDEN_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_GOLDEN_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_golden_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_DIAMOND_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_DIAMOND_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_diamond_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_NETHERITE_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_NETHERITE_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_netherite_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_ETHEREAL_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_ETHEREAL_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_ethereal_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof PickaxeItem) {
				if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_IRON_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_IRON_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_iron_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_GOLDEN_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_GOLDEN_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_golden_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_DIAMOND_PICK.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_DIAMOND_PICK.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_diamond_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_NETHERITE_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_NETHERITE_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_netherite_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_ETHEREAL_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_ETHEREAL_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_ethereal_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof ShovelItem) {
				if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_IRON_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_IRON_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_iron_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_GOLDEN_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_GOLDEN_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_golden_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_DIAMOND_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_DIAMOND_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_diamond_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_NETHERITE_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_NETHERITE_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_netherite_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_ETHEREAL_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_ETHEREAL_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_ethereal_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof HoeItem) {
				if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_IRON_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_IRON_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_iron_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_GOLDEN_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_GOLDEN_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_golden_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_DIAMOND_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_DIAMOND_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_diamond_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_NETHERITE_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_NETHERITE_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_netherite_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.UNCHARGED_ETHEREAL_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.CHARGED_ETHEREAL_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.uncharged_ethereal_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			}
		} else if (entity.getData(SuperiorsmithingModVariables.PLAYER_VARIABLES).ChargeRemaining < 0 && target.is(ItemTags.create(ResourceLocation.parse("forge:charged")))) {
			if (target.getItem() instanceof SwordItem) {
				if (target.getItem() == SuperiorsmithingModItems.CHARGED_IRON_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_IRON_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_iron_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_GOLDEN_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_GOLDEN_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_golden_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_DIAMOND_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_DIAMOND_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_diamond_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_NETHERITE_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_NETHERITE_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_netherite_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_ETHEREAL_SWORD.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_ETHEREAL_SWORD.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_ethereal_sword").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof AxeItem) {
				if (target.getItem() == SuperiorsmithingModItems.CHARGED_IRON_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_IRON_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_iron_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_GOLDEN_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_GOLDEN_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_golden_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_DIAMOND_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_DIAMOND_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_diamond_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_NETHERITE_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_NETHERITE_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_netherite_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_ETHEREAL_AXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_ETHEREAL_AXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_ethereal_axe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof PickaxeItem) {
				if (target.getItem() == SuperiorsmithingModItems.CHARGED_IRON_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_IRON_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_iron_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_GOLDEN_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_GOLDEN_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_golden_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_DIAMOND_PICK.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_DIAMOND_PICK.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_diamond_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_NETHERITE_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_NETHERITE_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_netherite_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_ETHEREAL_PICKAXE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_ETHEREAL_PICKAXE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_ethereal_pickaxe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof ShovelItem) {
				if (target.getItem() == SuperiorsmithingModItems.CHARGED_IRON_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_IRON_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_iron_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_GOLDEN_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_GOLDEN_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_golden_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_DIAMOND_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_DIAMOND_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_diamond_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_NETHERITE_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_NETHERITE_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_netherite_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_ETHEREAL_SHOVEL.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_ETHEREAL_SHOVEL.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_ethereal_shovel").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			} else if (target.getItem() instanceof HoeItem) {
				if (target.getItem() == SuperiorsmithingModItems.CHARGED_IRON_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_IRON_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_iron_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_GOLDEN_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_GOLDEN_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_golden_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_DIAMOND_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_DIAMOND_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_diamond_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_NETHERITE_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_NETHERITE_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_netherite_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				} else if (target.getItem() == SuperiorsmithingModItems.CHARGED_ETHEREAL_HOE.get()) {
					product = new ItemStack(SuperiorsmithingModItems.UNCHARGED_ETHEREAL_HOE.get());
					if (!(target.getDisplayName().getString()).equals("[" + Component.translatable("item.superiorsmithing.charged_ethereal_hoe").getString() + "]")) {
						ItemName = target.getDisplayName().getString();
						product.set(DataComponents.CUSTOM_NAME, Component.literal(((ItemName.replace("[", "")).replace("]", ""))));
					}
				}
			}
		}
		if (!(product.getItem() == Blocks.AIR.asItem())) {
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
			if (target.isDamaged()) {
				product.setDamageValue(target.getDamageValue());
			}
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				ItemStack _setstack = product.copy();
				_setstack.setCount(1);
				_modHandler.setStackInSlot((int) slot, _setstack);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY() + 0.6), (entity.getZ()), 5, 0.2, 0.2, 0.2, 0.15);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, (float) 0.3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
				}
			}
		}
	}
}
