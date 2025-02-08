
package net.mcreator.superiorsmithing.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.world.inventory.SuperiorSmithingGUIMenu;
import net.mcreator.superiorsmithing.procedures.ToggleStandDisplayProcedure;
import net.mcreator.superiorsmithing.procedures.ToggleRecipeBookProcedure;
import net.mcreator.superiorsmithing.procedures.SubtractPageProcedure;
import net.mcreator.superiorsmithing.procedures.AdvancePageProcedure;
import net.mcreator.superiorsmithing.SuperiorsmithingMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SuperiorSmithingGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SuperiorSmithingGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SuperiorsmithingMod.MODID, "superior_smithing_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SuperiorSmithingGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SuperiorSmithingGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SuperiorSmithingGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SuperiorSmithingGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SuperiorSmithingGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SuperiorSmithingGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ToggleRecipeBookProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SubtractPageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			AdvancePageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ToggleStandDisplayProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SuperiorsmithingMod.addNetworkMessage(SuperiorSmithingGUIButtonMessage.TYPE, SuperiorSmithingGUIButtonMessage.STREAM_CODEC, SuperiorSmithingGUIButtonMessage::handleData);
	}
}
