
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.superiorsmithing.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.superiorsmithing.client.gui.SuperiorSmithingGUIScreen;
import net.mcreator.superiorsmithing.client.gui.FakeGrindingGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SuperiorsmithingModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(SuperiorsmithingModMenus.FAKE_GRINDING_GUI.get(), FakeGrindingGUIScreen::new);
		event.register(SuperiorsmithingModMenus.SUPERIOR_SMITHING_GUI.get(), SuperiorSmithingGUIScreen::new);
	}
}
