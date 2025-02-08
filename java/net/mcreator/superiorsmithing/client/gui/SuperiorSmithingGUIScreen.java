package net.mcreator.superiorsmithing.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.superiorsmithing.world.inventory.SuperiorSmithingGUIMenu;
import net.mcreator.superiorsmithing.procedures.TooltipTwoProcedure;
import net.mcreator.superiorsmithing.procedures.TooltipThreeProcedure;
import net.mcreator.superiorsmithing.procedures.TooltipOneProcedure;
import net.mcreator.superiorsmithing.procedures.ProvideStandModelProcedure;
import net.mcreator.superiorsmithing.procedures.PageCounterProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayUpgradeProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayUpgrade2Procedure;
import net.mcreator.superiorsmithing.procedures.DisplayTemplateOutlineProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayStandProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayShellingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayRivetingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayReinforcementProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayRecipeBookProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayPhasingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayNopeProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayMysticProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayJewelingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayGildingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayForgingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayEchoingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayConchingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayChargingProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayBlankProcedure;
import net.mcreator.superiorsmithing.procedures.DisplayBindingProcedure;
import net.mcreator.superiorsmithing.network.SuperiorSmithingGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SuperiorSmithingGUIScreen extends AbstractContainerScreen<SuperiorSmithingGUIMenu> {
	private final static HashMap<String, Object> guistate = SuperiorSmithingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_guirecipebookoff;
	ImageButton imagebutton_arrow3;
	ImageButton imagebutton_arrow4;
	ImageButton imagebutton_armor_display_button;

	public SuperiorSmithingGUIScreen(SuperiorSmithingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("superiorsmithing:textures/screens/superior_smithing_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ProvideStandModelProcedure.execute(world, entity) instanceof LivingEntity livingEntity) {
			if (DisplayStandProcedure.execute(entity))
				this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -39, this.topPos + 120, 50, 0f + (float) Math.atan((this.leftPos + -39 - mouseX) / 40.0), (float) Math.atan((this.topPos + 71 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (TooltipOneProcedure.execute(entity))
			if (mouseX > leftPos + 47 && mouseX < leftPos + 71 && mouseY > topPos + 23 && mouseY < topPos + 47)
				guiGraphics.renderTooltip(font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.tooltip_insert_armor_weapon_or_tool"), mouseX, mouseY);
		if (TooltipTwoProcedure.execute(entity))
			if (mouseX > leftPos + 95 && mouseX < leftPos + 119 && mouseY > topPos + 14 && mouseY < topPos + 38)
				guiGraphics.renderTooltip(font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.tooltip_insert_required_material"), mouseX, mouseY);
		if (TooltipThreeProcedure.execute(entity))
			if (mouseX > leftPos + 95 && mouseX < leftPos + 119 && mouseY > topPos + 39 && mouseY < topPos + 63)
				guiGraphics.renderTooltip(font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.tooltip_insert_smithing_template_or_copy"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/fake_smithing_gui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		if (DisplayRecipeBookProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/smithingrecipeblank.png"), this.leftPos + 168, this.topPos + 1, 0, 0, -1, -1, -1, -1);
		}
		if (DisplayBindingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/smithingrecipebinding.png"), this.leftPos + 168, this.topPos + 1, 0, 0, -1, -1, -1, -1);
		}
		if (DisplayRecipeBookProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/smithing_tall_tab.png"), this.leftPos + 170, this.topPos + 0, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayRivetingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newrivetingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayGildingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newgildingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayReinforcementProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newenforcingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayJewelingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newjewlingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayForgingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newforgingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayConchingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newconchingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayPhasingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newphasedrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayUpgradeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newnetheriterecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayBindingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newbindingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayMysticProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newmysticrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayChargingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newchargingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayUpgrade2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newetherealrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayBlankProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newblankrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayShellingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newshellingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayEchoingProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newechoingrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayBlankProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/newblankrecipe.png"), this.leftPos + 168, this.topPos + -4, 0, 0, 120, 166, 120, 166);
		}
		if (DisplayStandProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/smithing_side_tab.png"), this.leftPos + -89, this.topPos + 0, 0, 0, 100, 166, 100, 166);
		}
		if (DisplayNopeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/nope.png"), this.leftPos + 117, this.topPos + 27, 0, 0, 28, 18, 28, 18);
		}
		if (DisplayTemplateOutlineProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("superiorsmithing:textures/screens/templateoutline.png"), this.leftPos + 98, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_repair_disenchant"), 8, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_inventory"), 7, 72, -12829636, false);
		if (DisplayBindingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_30_durability"), 181, 50, -16751104, false);
		if (DisplayBindingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_cold_resist"), 181, 70, -12829636, false);
		if (DisplayBindingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_speed"), 181, 60, -16751104, false);
		if (DisplayBindingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_dyeable"), 181, 80, -12829636, false);
		if (DisplayRecipeBookProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					PageCounterProcedure.execute(entity), 215, 119, -1, false);
		if (DisplayReinforcementProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_durability"), 181, 50, -16751104, false);
		if (DisplayRivetingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_durability1"), 181, 50, -16751104, false);
		if (DisplayRivetingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_protection"), 181, 60, -16751104, false);
		if (DisplayRivetingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_efficency"), 181, 70, -16751104, false);
		if (DisplayRivetingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_damage"), 181, 80, -16751104, false);
		if (DisplayRivetingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_speed1"), 181, 89, -10092544, false);
		if (DisplayBindingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_toughness"), 181, 89, -12829636, false);
		if (DisplayGildingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_enchantability"), 181, 50, -16751104, false);
		if (DisplayGildingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_efficency1"), 181, 60, -16751104, false);
		if (DisplayGildingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_speed2"), 181, 70, -16751104, false);
		if (DisplayGildingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_durability2"), 181, 80, -10092544, false);
		if (DisplayGildingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_pacification"), 181, 89, -12829636, false);
		if (DisplayJewelingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_damage1"), 181, 50, -16751104, false);
		if (DisplayJewelingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_efficency2"), 181, 60, -16751104, false);
		if (DisplayJewelingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_speed3"), 181, 70, -16751104, false);
		if (DisplayJewelingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_protection1"), 181, 80, -16751104, false);
		if (DisplayJewelingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_toughness1"), 181, 89, -12829636, false);
		if (DisplayForgingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_damage2"), 181, 50, -16751104, false);
		if (DisplayForgingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_durability3"), 181, 60, -16751104, false);
		if (DisplayForgingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_toughness2"), 181, 70, -12829636, false);
		if (DisplayForgingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_weight"), 181, 80, -12829636, false);
		if (DisplayForgingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_heat_resist"), 181, 89, -12829636, false);
		if (DisplayPhasingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_speed4"), 181, 50, -16751104, false);
		if (DisplayPhasingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_damage3"), 181, 60, -16751104, false);
		if (DisplayPhasingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_durability4"), 181, 70, -10092544, false);
		if (DisplayPhasingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_protection2"), 181, 80, -10092544, false);
		if (DisplayPhasingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_agility"), 181, 89, -12829636, false);
		if (DisplayConchingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_swim_boost"), 181, 50, -12829636, false);
		if (DisplayConchingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_aqua_affinity"), 181, 60, -12829636, false);
		if (DisplayEchoingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_enchanting"), 181, 50, -16751104, false);
		if (DisplayEchoingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_experience"), 181, 60, -16751104, false);
		if (DisplayEchoingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_regrowth"), 181, 70, -12829636, false);
		if (DisplayEchoingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_memory"), 181, 80, -12829636, false);
		if (DisplayMysticProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_arcana"), 181, 50, -12829636, false);
		if (DisplayChargingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_toggling"), 181, 50, -12829636, false);
		if (DisplayChargingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_2_protection"), 181, 60, -12829636, false);
		if (DisplayChargingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_2_attack"), 181, 70, -12829636, false);
		if (DisplayChargingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_efficency3"), 181, 80, -12829636, false);
		if (DisplayChargingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_attack_speed"), 181, 89, -12829636, false);
		if (DisplayShellingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_30_durability1"), 181, 50, -16751104, false);
		if (DisplayShellingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_cycling"), 181, 60, -12829636, false);
		if (DisplayShellingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_throwback"), 181, 70, -12829636, false);
		if (DisplayReinforcementProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_05_reach"), 181, 60, -16751104, false);
		if (DisplayPhasingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_10_reach"), 181, 99, -16751104, false);
		if (DisplayShellingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.superiorsmithing.superior_smithing_gui.label_05_reach1"), 181, 80, -16751104, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_guirecipebookoff = new ImageButton(this.leftPos + 150, this.topPos + 52, 20, 18,
				new WidgetSprites(ResourceLocation.parse("superiorsmithing:textures/screens/guirecipebookoff.png"), ResourceLocation.parse("superiorsmithing:textures/screens/guirecipebookon.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SuperiorSmithingGUIButtonMessage(0, x, y, z));
						SuperiorSmithingGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_guirecipebookoff", imagebutton_guirecipebookoff);
		this.addRenderableWidget(imagebutton_guirecipebookoff);
		imagebutton_arrow3 = new ImageButton(this.leftPos + 182, this.topPos + 116, 11, 17,
				new WidgetSprites(ResourceLocation.parse("superiorsmithing:textures/screens/arrow3.png"), ResourceLocation.parse("superiorsmithing:textures/screens/arrow2.png")), e -> {
					if (DisplayRecipeBookProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new SuperiorSmithingGUIButtonMessage(1, x, y, z));
						SuperiorSmithingGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (DisplayRecipeBookProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow3", imagebutton_arrow3);
		this.addRenderableWidget(imagebutton_arrow3);
		imagebutton_arrow4 = new ImageButton(this.leftPos + 266, this.topPos + 116, 11, 17,
				new WidgetSprites(ResourceLocation.parse("superiorsmithing:textures/screens/arrow4.png"), ResourceLocation.parse("superiorsmithing:textures/screens/arrow1.png")), e -> {
					if (DisplayRecipeBookProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new SuperiorSmithingGUIButtonMessage(2, x, y, z));
						SuperiorSmithingGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (DisplayRecipeBookProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow4", imagebutton_arrow4);
		this.addRenderableWidget(imagebutton_arrow4);
		imagebutton_armor_display_button = new ImageButton(this.leftPos + 13, this.topPos + 52, 20, 18,
				new WidgetSprites(ResourceLocation.parse("superiorsmithing:textures/screens/armor_display_button.png"), ResourceLocation.parse("superiorsmithing:textures/screens/armor_display_buttonon.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SuperiorSmithingGUIButtonMessage(3, x, y, z));
						SuperiorSmithingGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_armor_display_button", imagebutton_armor_display_button);
		this.addRenderableWidget(imagebutton_armor_display_button);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
