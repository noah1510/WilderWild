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

package net.frozenblock.wilderwild.world.generation.foliage;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.frozenblock.lib.math.api.AdvancedMath;
import net.frozenblock.wilderwild.registry.RegisterBlocks;
import net.frozenblock.wilderwild.registry.RegisterFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class PalmFoliagePlacer extends FoliagePlacer {
	public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
		palmCodec(instance).apply(instance, PalmFoliagePlacer::new)
	);
	private static final double SURROUNDING_LEAF_THRESHOLD = 0.175;
	public final IntProvider fronds;

	public PalmFoliagePlacer(@NotNull IntProvider intProvider, @NotNull IntProvider intProvider2, @NotNull IntProvider fronds) {
		super(intProvider, intProvider2);
		this.fronds = fronds;
	}

	protected static <P extends PalmFoliagePlacer> Products.P3<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, IntProvider> palmCodec(RecordCodecBuilder.Instance<P> builder) {
		return foliagePlacerParts(builder).and((IntProvider.codec(0, 16).fieldOf("fronds")).forGetter(placer -> placer.fronds));
	}

	public static void placeLeavesAtPos(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter blockSetter, @NotNull RandomSource random, @NotNull TreeConfiguration config, @NotNull BlockPos pos, double offX, double offY, double offZ) {
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable().move(BlockPos.containing(offX, offY, offZ));
		BlockPos basePos = mutableBlockPos.immutable();
		tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos);
		if (shouldPlaceAbove(offX)) {
			tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos.move(1, 0, 0));
		}
		if (shouldPlaceBelow(offX)) {
			tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos.set(basePos).move(-1, 0, 0));
		}
		if (shouldPlaceAbove(offY)) {
			tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos.set(basePos).move(0, 1, 0));
		}
		if (shouldPlaceBelow(offY)) {
			tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos.set(basePos).move(0, -1, 0));
		}
		if (shouldPlaceAbove(offZ)) {
			tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos.set(basePos).move(0, 0, 1));
		}
		if (shouldPlaceBelow(offZ)) {
			tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos.set(basePos).move(0, 0, -1));
		}
	}

	public static boolean shouldPlaceAbove(double d) {
		return d > 0.5 + SURROUNDING_LEAF_THRESHOLD;
	}

	public static boolean shouldPlaceBelow(double d) {
		return d < 0.5 - SURROUNDING_LEAF_THRESHOLD;
	}

	@Override
	@NotNull
	protected FoliagePlacerType<?> type() {
		return RegisterFeatures.PALM_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter blockSetter, @NotNull RandomSource random, @NotNull TreeConfiguration config, int i, @NotNull FoliageAttachment foliageAttachment, int j, int k, int l) {
		BlockPos blockPos = foliageAttachment.pos().above(l);
		blockSetter.set(blockPos.below(), RegisterBlocks.PALM_CROWN.defaultBlockState());
		Vec3 origin = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
		double minRadius = this.radius.getMinValue();
		double radius = minRadius + ((this.radius.getMaxValue() - minRadius) * random.nextDouble());
		double minus = (Math.PI * radius) / (radius * radius);
		int fronds = this.fronds.sample(random);
		double rotAngle = 360 / (double) fronds;
		double angle = random.nextDouble() * 360;

		for (int a = 0; a < fronds; a++) {
			Vec3 offsetPos = AdvancedMath.rotateAboutXZ(origin, 1, angle + (((random.nextDouble() * rotAngle) * 0.35) * (random.nextBoolean() ? 1 : -1)));
			double dirX = offsetPos.x - origin.x;
			double dirZ = offsetPos.z - origin.z;
			for (double r = 0; r < radius; r += 0.2) {
				double yOffset = (2 * (Math.sin((Math.PI * (r - 0.1)) / radius) - minus)) + (4.2 * (minus * 0.4));
				placeLeavesAtPos(level, blockSetter, random, config, blockPos, (dirX * r), yOffset, (dirZ * r));
			}
			angle += rotAngle;
		}
	}

	@Override
	public int foliageHeight(@NotNull RandomSource randomSource, int i, @NotNull TreeConfiguration treeConfiguration) {
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(@NotNull RandomSource randomSource, int i, int j, int k, int l, boolean bl) {
		if (j == 0) {
			return (i > 1 || k > 1) && i != 0 && k != 0;
		} else {
			return i == l && k == l && l > 0;
		}
	}
}
