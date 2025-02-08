package net.mcreator.superiorsmithing.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.superiorsmithing.world.inventory.FakeGrindingGUIMenu;
import net.mcreator.superiorsmithing.network.FakeGrindingGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FakeGrindingGUIScreen extends AbstractContainerScreen<FakeGrindingGUIMenu> {
	private final static HashMap<String, Object> guistate = FakeGrindingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_grind;

	public FakeGrindingGUIScreen(FakeGrindingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("superiorsmithing:textures/screens/fake_grinding_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/thegrindiseternal.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.fake_grinding_gui.label_repair_disenchant"), 8, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.fake_grinding_gui.label_inventory"), 8, 72, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_grind = Button.builder(Component.translatable("gui.superiorsmithing.fake_grinding_gui.button_grind"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FakeGrindingGUIButtonMessage(0, x, y, z));
				FakeGrindingGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 103, this.topPos + 55, 51, 20).build();
		guistate.put("button:button_grind", button_grind);
		this.addRenderableWidget(button_grind);
	}
}
