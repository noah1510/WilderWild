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

package net.frozenblock.wilderwild.mixin.sodium;

import com.mojang.blaze3d.vertex.PoseStack;
import me.jellysquid.mods.sodium.client.render.immediate.CloudRenderer;
import net.frozenblock.lib.wind.api.ClientWindManager;
import net.frozenblock.wilderwild.config.MiscConfig;
import net.frozenblock.wilderwild.misc.wind.WilderClientWindManager;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(CloudRenderer.class)
public class CloudRendererMixin {

	@Unique
	private boolean wilderWild$useWind;

	@Unique
	private static boolean wilderWild$useWind() {
		return MiscConfig.get().cloudMovement && ClientWindManager.shouldUseWind();
	}

	@ModifyVariable(method = "render", at = @At(value = "STORE"), ordinal = 2)
	private float wilderWild$modifyY(float original, @Nullable ClientLevel world, LocalPlayer player, PoseStack matrices, Matrix4f projectionMatrix, float ticks, float tickDelta, double cameraX, double cameraY, double cameraZ) {
		return (this.wilderWild$useWind = wilderWild$useWind())
			? (float) (original + 0.33D + Mth.clamp(WilderClientWindManager.getCloudY(tickDelta) * 12, -10, 10))
			: original;
	}

	@ModifyVariable(method = "render", at = @At(value = "STORE"), ordinal = 4)
	private double wilderWild$modifyX(double original, @Nullable ClientLevel world, LocalPlayer player, PoseStack matrices, Matrix4f projectionMatrix, float ticks, float tickDelta, double cameraX, double cameraY, double cameraZ) {
		return this.wilderWild$useWind
			? cameraX - WilderClientWindManager.getCloudX(tickDelta) * 12
			: original;
	}

	@ModifyVariable(method = "render", at = @At("STORE"), ordinal = 5)
	private double wilderWild$modifyZ(double original, @Nullable ClientLevel world, LocalPlayer player, PoseStack matrices, Matrix4f projectionMatrix, float ticks, float tickDelta, double cameraX, double cameraY, double cameraZ) {
		return this.wilderWild$useWind
			? (cameraZ + 0.33D) - WilderClientWindManager.getCloudZ(tickDelta) * 12
			: original;
	}
}
