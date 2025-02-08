package net.mcreator.superiorsmithing.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.superiorsmithing.SuperiorsmithingMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SuperiorsmithingModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, SuperiorsmithingMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SuperiorsmithingMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.SoulBoundItem = original.SoulBoundItem;
			clone.SoulBoundItem2 = original.SoulBoundItem2;
			clone.SoulBoundItem3 = original.SoulBoundItem3;
			clone.SoulBoundItem4 = original.SoulBoundItem4;
			clone.SoulBoundItem5 = original.SoulBoundItem5;
			clone.SoulBoundItem6 = original.SoulBoundItem6;
			clone.SoulBoundItem7 = original.SoulBoundItem7;
			clone.SoulBoundItem8 = original.SoulBoundItem8;
			clone.Echo1 = original.Echo1;
			clone.Echo2 = original.Echo2;
			clone.Echo3 = original.Echo3;
			clone.Echo4 = original.Echo4;
			clone.Echo5 = original.Echo5;
			clone.Echo6 = original.Echo6;
			clone.Echo7 = original.Echo7;
			clone.Echo8 = original.Echo8;
			clone.HelmetEcho = original.HelmetEcho;
			clone.ChestplateEcho = original.ChestplateEcho;
			clone.PantsEcho = original.PantsEcho;
			clone.BootsEcho = original.BootsEcho;
			clone.SmithingRecipeBook = original.SmithingRecipeBook;
			clone.SmithingRecipePage = original.SmithingRecipePage;
			clone.SmithingDisplay = original.SmithingDisplay;
			clone.VenganceDamage = original.VenganceDamage;
			if (!event.isWasDeath()) {
				clone.ChargeRemaining = original.ChargeRemaining;
				clone.Mysticism = original.Mysticism;
				clone.VenganceTimer = original.VenganceTimer;
				clone.MomentumCooldown = original.MomentumCooldown;
				clone.MomentumTier = original.MomentumTier;
				clone.ReachExtension = original.ReachExtension;
				clone.StepExtension = original.StepExtension;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public ItemStack SoulBoundItem = ItemStack.EMPTY;
		public ItemStack SoulBoundItem2 = ItemStack.EMPTY;
		public ItemStack SoulBoundItem3 = ItemStack.EMPTY;
		public ItemStack SoulBoundItem4 = ItemStack.EMPTY;
		public ItemStack SoulBoundItem5 = ItemStack.EMPTY;
		public ItemStack SoulBoundItem6 = ItemStack.EMPTY;
		public ItemStack SoulBoundItem7 = ItemStack.EMPTY;
		public ItemStack SoulBoundItem8 = ItemStack.EMPTY;
		public ItemStack Echo1 = ItemStack.EMPTY;
		public ItemStack Echo2 = ItemStack.EMPTY;
		public ItemStack Echo3 = ItemStack.EMPTY;
		public ItemStack Echo4 = ItemStack.EMPTY;
		public ItemStack Echo5 = ItemStack.EMPTY;
		public ItemStack Echo6 = ItemStack.EMPTY;
		public ItemStack Echo7 = ItemStack.EMPTY;
		public ItemStack Echo8 = ItemStack.EMPTY;
		public ItemStack HelmetEcho = ItemStack.EMPTY;
		public ItemStack ChestplateEcho = ItemStack.EMPTY;
		public ItemStack PantsEcho = ItemStack.EMPTY;
		public ItemStack BootsEcho = ItemStack.EMPTY;
		public boolean SmithingRecipeBook = false;
		public double SmithingRecipePage = 0;
		public double ChargeRemaining = 3600.0;
		public double Mysticism = 0.0;
		public boolean SmithingDisplay = false;
		public double VenganceDamage = 0;
		public double VenganceTimer = 0;
		public double MomentumCooldown = 0;
		public double MomentumTier = 0;
		public boolean ReachExtension = false;
		public boolean StepExtension = false;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.put("SoulBoundItem", SoulBoundItem.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem2", SoulBoundItem2.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem3", SoulBoundItem3.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem4", SoulBoundItem4.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem5", SoulBoundItem5.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem6", SoulBoundItem6.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem7", SoulBoundItem7.saveOptional(lookupProvider));
			nbt.put("SoulBoundItem8", SoulBoundItem8.saveOptional(lookupProvider));
			nbt.put("Echo1", Echo1.saveOptional(lookupProvider));
			nbt.put("Echo2", Echo2.saveOptional(lookupProvider));
			nbt.put("Echo3", Echo3.saveOptional(lookupProvider));
			nbt.put("Echo4", Echo4.saveOptional(lookupProvider));
			nbt.put("Echo5", Echo5.saveOptional(lookupProvider));
			nbt.put("Echo6", Echo6.saveOptional(lookupProvider));
			nbt.put("Echo7", Echo7.saveOptional(lookupProvider));
			nbt.put("Echo8", Echo8.saveOptional(lookupProvider));
			nbt.put("HelmetEcho", HelmetEcho.saveOptional(lookupProvider));
			nbt.put("ChestplateEcho", ChestplateEcho.saveOptional(lookupProvider));
			nbt.put("PantsEcho", PantsEcho.saveOptional(lookupProvider));
			nbt.put("BootsEcho", BootsEcho.saveOptional(lookupProvider));
			nbt.putBoolean("SmithingRecipeBook", SmithingRecipeBook);
			nbt.putDouble("SmithingRecipePage", SmithingRecipePage);
			nbt.putDouble("ChargeRemaining", ChargeRemaining);
			nbt.putDouble("Mysticism", Mysticism);
			nbt.putBoolean("SmithingDisplay", SmithingDisplay);
			nbt.putDouble("VenganceDamage", VenganceDamage);
			nbt.putDouble("VenganceTimer", VenganceTimer);
			nbt.putDouble("MomentumCooldown", MomentumCooldown);
			nbt.putDouble("MomentumTier", MomentumTier);
			nbt.putBoolean("ReachExtension", ReachExtension);
			nbt.putBoolean("StepExtension", StepExtension);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			SoulBoundItem = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem"));
			SoulBoundItem2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem2"));
			SoulBoundItem3 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem3"));
			SoulBoundItem4 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem4"));
			SoulBoundItem5 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem5"));
			SoulBoundItem6 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem6"));
			SoulBoundItem7 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem7"));
			SoulBoundItem8 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SoulBoundItem8"));
			Echo1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo1"));
			Echo2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo2"));
			Echo3 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo3"));
			Echo4 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo4"));
			Echo5 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo5"));
			Echo6 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo6"));
			Echo7 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo7"));
			Echo8 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Echo8"));
			HelmetEcho = ItemStack.parseOptional(lookupProvider, nbt.getCompound("HelmetEcho"));
			ChestplateEcho = ItemStack.parseOptional(lookupProvider, nbt.getCompound("ChestplateEcho"));
			PantsEcho = ItemStack.parseOptional(lookupProvider, nbt.getCompound("PantsEcho"));
			BootsEcho = ItemStack.parseOptional(lookupProvider, nbt.getCompound("BootsEcho"));
			SmithingRecipeBook = nbt.getBoolean("SmithingRecipeBook");
			SmithingRecipePage = nbt.getDouble("SmithingRecipePage");
			ChargeRemaining = nbt.getDouble("ChargeRemaining");
			Mysticism = nbt.getDouble("Mysticism");
			SmithingDisplay = nbt.getBoolean("SmithingDisplay");
			VenganceDamage = nbt.getDouble("VenganceDamage");
			VenganceTimer = nbt.getDouble("VenganceTimer");
			MomentumCooldown = nbt.getDouble("MomentumCooldown");
			MomentumTier = nbt.getDouble("MomentumTier");
			ReachExtension = nbt.getBoolean("ReachExtension");
			StepExtension = nbt.getBoolean("StepExtension");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SuperiorsmithingMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
