
package net.mcreator.superiorsmithing.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.Util;

import java.util.List;
import java.util.EnumMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class PinkLeatherArmorItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 1);
				map.put(ArmorItem.Type.LEGGINGS, 2);
				map.put(ArmorItem.Type.CHESTPLATE, 3);
				map.put(ArmorItem.Type.HELMET, 1);
				map.put(ArmorItem.Type.BODY, 3);
			}), 15, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_leather")), () -> Ingredient.of(new ItemStack(Items.LEATHER)),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("superiorsmithing:leatherarmorpink_"))), 0.5f, 0f);
			registerHelper.register(ResourceLocation.parse("superiorsmithing:pink_leather_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public PinkLeatherArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends PinkLeatherArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5)));
		}
	}

	public static class Chestplate extends PinkLeatherArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5)));
		}
	}

	public static class Leggings extends PinkLeatherArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(5)));
		}
	}

	public static class Boots extends PinkLeatherArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(5)));
		}
		@Override
  			public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
  			return true;
  			}
	}
}
