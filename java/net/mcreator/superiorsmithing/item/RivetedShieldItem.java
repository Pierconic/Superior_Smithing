
package net.mcreator.superiorsmithing.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.superiorsmithing.procedures.ShieldSoundEffectProcedure;
import net.mcreator.superiorsmithing.procedures.DefenseResetProcedure;

import java.util.List;

public class RivetedShieldItem extends ShieldItem {
	public RivetedShieldItem() {
		super(new Item.Properties().durability(420));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ShieldSoundEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), ar.getObject());
		return ar;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal(("\u00A77") + "When Blocking:"));
		list.add(Component.literal(("\u00A72") + " 3 Defense"));
		list.add(Component.literal(("\u00A72") + " x0.8 Recovery Speed"));
		list.add(Component.literal(("\u00A72") + " 8.0s Break Recovery"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DefenseResetProcedure.execute(entity, itemstack);
	}
}
