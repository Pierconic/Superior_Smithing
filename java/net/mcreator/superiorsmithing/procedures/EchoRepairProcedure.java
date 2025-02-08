package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.item.ItemStack;

public class EchoRepairProcedure {
	public static void execute(ItemStack itemstack) {
		if (Math.random() < 0.0005 && itemstack.getDamageValue() != 0) {
			itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
		}
	}
}
