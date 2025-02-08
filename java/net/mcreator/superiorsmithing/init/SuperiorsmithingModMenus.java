
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.superiorsmithing.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.superiorsmithing.world.inventory.SuperiorSmithingGUIMenu;
import net.mcreator.superiorsmithing.world.inventory.FakeGrindingGUIMenu;
import net.mcreator.superiorsmithing.SuperiorsmithingMod;

public class SuperiorsmithingModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, SuperiorsmithingMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<FakeGrindingGUIMenu>> FAKE_GRINDING_GUI = REGISTRY.register("fake_grinding_gui", () -> IMenuTypeExtension.create(FakeGrindingGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SuperiorSmithingGUIMenu>> SUPERIOR_SMITHING_GUI = REGISTRY.register("superior_smithing_gui", () -> IMenuTypeExtension.create(SuperiorSmithingGUIMenu::new));
}
