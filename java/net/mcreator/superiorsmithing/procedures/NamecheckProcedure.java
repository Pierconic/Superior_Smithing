package net.mcreator.superiorsmithing.procedures;

import net.minecraft.world.entity.Entity;

public class NamecheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getDisplayName().getString()).contains("a") || (entity.getDisplayName().getString()).contains("b") || (entity.getDisplayName().getString()).contains("c") || (entity.getDisplayName().getString()).contains("d")
				|| (entity.getDisplayName().getString()).contains("e") || (entity.getDisplayName().getString()).contains("f") || (entity.getDisplayName().getString()).contains("g") || (entity.getDisplayName().getString()).contains("h")
				|| (entity.getDisplayName().getString()).contains("i") || (entity.getDisplayName().getString()).contains("j") || (entity.getDisplayName().getString()).contains("k") || (entity.getDisplayName().getString()).contains("l")
				|| (entity.getDisplayName().getString()).contains("m") || (entity.getDisplayName().getString()).contains("n") || (entity.getDisplayName().getString()).contains("o") || (entity.getDisplayName().getString()).contains("p")
				|| (entity.getDisplayName().getString()).contains("q") || (entity.getDisplayName().getString()).contains("r") || (entity.getDisplayName().getString()).contains("s") || (entity.getDisplayName().getString()).contains("t")
				|| (entity.getDisplayName().getString()).contains("u") || (entity.getDisplayName().getString()).contains("v") || (entity.getDisplayName().getString()).contains("w") || (entity.getDisplayName().getString()).contains("x")
				|| (entity.getDisplayName().getString()).contains("y") || (entity.getDisplayName().getString()).contains("z")) {
			return true;
		}
		return false;
	}
}
