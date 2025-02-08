
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.superiorsmithing.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.superiorsmithing.SuperiorsmithingMod;

public class SuperiorsmithingModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, SuperiorsmithingMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> STONECRAFTING = REGISTRY.register("stonecrafting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("superiorsmithing", "stonecrafting")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PAPERCRAFTING = REGISTRY.register("papercrafting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("superiorsmithing", "papercrafting")));
	public static final DeferredHolder<SoundEvent, SoundEvent> METALCRAFTING = REGISTRY.register("metalcrafting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("superiorsmithing", "metalcrafting")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GLASSCRAFTING = REGISTRY.register("glasscrafting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("superiorsmithing", "glasscrafting")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WOODCRAFTING = REGISTRY.register("woodcrafting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("superiorsmithing", "woodcrafting")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GEMCRAFTING = REGISTRY.register("gemcrafting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("superiorsmithing", "gemcrafting")));
}
