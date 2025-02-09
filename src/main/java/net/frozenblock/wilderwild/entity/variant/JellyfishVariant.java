/*
 * Copyright 2023 FrozenBlock
 * This file is part of Wilder Wild.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.frozenblock.wilderwild.entity.variant;

import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.frozenblock.wilderwild.registry.WilderRegistry;
import net.frozenblock.wilderwild.tag.WilderItemTags;
import net.minecraft.core.Registry;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public record JellyfishVariant(@NotNull ResourceLocation key, @NotNull ResourceLocation texture,
							   @NotNull boolean pearlescent, @NotNull
							   TagKey<Item> reproductionFood) {

	public static final EntityDataSerializer<JellyfishVariant> SERIALIZER = EntityDataSerializer.simpleId(WilderRegistry.JELLYFISH_VARIANT);

	public static final JellyfishVariant BLUE = register(WilderSharedConstants.id("blue"), WilderSharedConstants.id("textures/entity/jellyfish/blue.png"), false, WilderItemTags.JELLYFISH_FOOD);
	public static final JellyfishVariant LIME = register(WilderSharedConstants.id("lime"), WilderSharedConstants.id("textures/entity/jellyfish/lime.png"), false, WilderItemTags.JELLYFISH_FOOD);
	public static final JellyfishVariant PINK = register(WilderSharedConstants.id("pink"), WilderSharedConstants.id("textures/entity/jellyfish/pink.png"), false, WilderItemTags.JELLYFISH_FOOD);
	public static final JellyfishVariant RED = register(WilderSharedConstants.id("red"), WilderSharedConstants.id("textures/entity/jellyfish/red.png"), false, WilderItemTags.JELLYFISH_FOOD);
	public static final JellyfishVariant YELLOW = register(WilderSharedConstants.id("yellow"), WilderSharedConstants.id("textures/entity/jellyfish/yellow.png"), false, WilderItemTags.JELLYFISH_FOOD);

	public static final JellyfishVariant PEARLESCENT_BLUE = register(WilderSharedConstants.id("pearlescent_blue"), WilderSharedConstants.id("textures/entity/jellyfish/pearlescent_blue.png"), true, WilderItemTags.PEARLESCENT_JELLYFISH_FOOD);
	public static final JellyfishVariant PEARLESCENT_PURPLE = register(WilderSharedConstants.id("pearlescent_purple"), WilderSharedConstants.id("textures/entity/jellyfish/pearlescent_purple.png"), true, WilderItemTags.PEARLESCENT_JELLYFISH_FOOD);

	static {
		EntityDataSerializers.registerSerializer(SERIALIZER);
	}

	public JellyfishVariant(@NotNull ResourceLocation key, @NotNull ResourceLocation texture, boolean pearlescent, TagKey<Item> reproductionFood) {
		this.key = key;
		this.texture = texture;
		this.pearlescent = pearlescent;
		this.reproductionFood = reproductionFood;
	}

	@NotNull
	public static JellyfishVariant register(@NotNull ResourceLocation key, @NotNull ResourceLocation texture, boolean pearlescent, TagKey<Item> reproductionFood) {
		return Registry.register(WilderRegistry.JELLYFISH_VARIANT, key, new JellyfishVariant(key, texture, pearlescent, reproductionFood));
	}

	public static void init() {
	}

	@NotNull
	public ResourceLocation key() {
		return this.key;
	}

	@NotNull
	public ResourceLocation texture() {
		return this.texture;
	}

	public boolean isNormal() {
		return !this.pearlescent;
	}
}
