
package net.mcreator.superiorsmithing.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.superiorsmithing.procedures.GiveEchoingRecipeProcedure;

import java.util.List;

public class EchoingTemplateCopyItem extends Item {
	public EchoingTemplateCopyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal(("\u00A77") + "Copied Template"));
		list.add(Component.literal(("\u00A77") + "Material:"));
		list.add(Component.literal(("\u00A79") + " Echo Shard"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GiveEchoingRecipeProcedure.execute(entity);
	}
}
