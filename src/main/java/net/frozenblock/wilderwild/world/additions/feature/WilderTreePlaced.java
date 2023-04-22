/*
 * Copyright 2022-2023 FrozenBlock
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

package net.frozenblock.wilderwild.world.additions.feature;

import java.util.List;
import net.frozenblock.lib.worldgen.feature.api.FrozenPlacedFeature;
import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.frozenblock.wilderwild.registry.RegisterBlocks;
import static net.frozenblock.wilderwild.world.additions.feature.WilderPlacementUtils.register;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import static net.minecraft.data.worldgen.placement.TreePlacements.SNOW_TREE_FILTER_DECORATOR;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public final class WilderTreePlaced {
	private WilderTreePlaced() {
		throw new UnsupportedOperationException("WilderTreePlaced contains only static declarations.");
	}

    //BIRCH
    public static final FrozenPlacedFeature BIRCH_CHECKED = register("birch_checked");

    public static final FrozenPlacedFeature BIRCH_BEES_0004 = register("birch_bees_0004");

	public static final FrozenPlacedFeature BIRCH_BEES_025 = register("birch_bees_025");

	public static final FrozenPlacedFeature DYING_BIRCH = register("dying_birch");

    public static final FrozenPlacedFeature SHORT_BIRCH = register("short_birch");

    public static final FrozenPlacedFeature DYING_SHORT_BIRCH = register("dying_short_birch");

    public static final FrozenPlacedFeature SHORT_BIRCH_BEES_0004 = register("short_birch_bees_0004");

    public static final FrozenPlacedFeature DYING_SUPER_BIRCH = register("dying_super_birch");

    public static final FrozenPlacedFeature SUPER_BIRCH_BEES_0004 = register("super_birch_bees_0004");

    public static final FrozenPlacedFeature SUPER_BIRCH_BEES = register("super_birch_bees");

	public static final FrozenPlacedFeature SUPER_BIRCH = register("super_birch");

	public static final FrozenPlacedFeature FALLEN_BIRCH_CHECKED = register("fallen_birch_checked");

	public static final FrozenPlacedFeature MOSSY_FALLEN_BIRCH_CHECKED = register("mossy_fallen_birch_checked");

	public static final FrozenPlacedFeature SNAPPED_BIRCH_CHECKED = register("snapped_birch_checked");

    //OAK
    public static final FrozenPlacedFeature OAK_CHECKED = register("oak_checked");

    public static final FrozenPlacedFeature DYING_OAK_CHECKED = register("dying_oak_checked");

    public static final FrozenPlacedFeature OAK_BEES_0004 = register("oak_bees_00004");

    public static final FrozenPlacedFeature SHORT_OAK_CHECKED = register("short_oak_checked");

    public static final FrozenPlacedFeature FANCY_OAK_CHECKED = register("fancy_oak_checked");

    public static final FrozenPlacedFeature DYING_FANCY_OAK_CHECKED = register("dying_fancy_oak_checked");

    public static final FrozenPlacedFeature DYING_FANCY_OAK_BEES_0004 = register("dying_fancy_oak_bees_0004");

    public static final FrozenPlacedFeature FANCY_OAK_BEES_0004 = register("fancy_oak_bees_0004");

	public static final FrozenPlacedFeature DYING_FANCY_OAK_BEES_025 = register("dying_fancy_oak_bees_025");

	public static final FrozenPlacedFeature FANCY_OAK_BEES_025 = register("fancy_oak_bees_025");

	public static final FrozenPlacedFeature FANCY_OAK_BEES = register("fancy_oak_bees");

    public static final FrozenPlacedFeature FALLEN_OAK_CHECKED = register("fallen_oak_checked");

	public static final FrozenPlacedFeature FALLEN_OAK_NO_MOSS_CHECKED = register("fallen_oak_no_moss_checked");

	public static final FrozenPlacedFeature MOSSY_FALLEN_OAK_CHECKED = register("mossy_fallen_oak_checked");

	public static final FrozenPlacedFeature MOSSY_FALLEN_STRAIGHT_OAK_CHECKED = register("mossy_fallen_straight_oak_checked");

	public static final FrozenPlacedFeature MOSSY_FALLEN_SPRUCE_CHECKED = register("mossy_fallen_spruce_checked");

	public static final FrozenPlacedFeature OLD_DYING_FANCY_OAK_BEES_0004 = register("old_dying_fancy_oak_bees_0004");

	public static final FrozenPlacedFeature SNAPPED_OAK_CHECKED = register("snapped_oak_checked");

	//DARK OAK
    public static final FrozenPlacedFeature TALL_DARK_OAK_CHECKED = register("tall_dark_oak_checked");

	public static final FrozenPlacedFeature FANCY_TALL_DARK_OAK_CHECKED = register("fancy_tall_dark_oak_checked");

    public static final FrozenPlacedFeature DYING_TALL_DARK_OAK_CHECKED = register("dying_tall_dark_oak_checked");

	public static final FrozenPlacedFeature DYING_FANCY_TALL_DARK_OAK_CHECKED = register("dying_fancy_tall_dark_oak_checked");

    public static final FrozenPlacedFeature DYING_DARK_OAK_CHECKED = register("dying_dark_oak_checked");

	public static final FrozenPlacedFeature COBWEB_TALL_DARK_OAK_CHECKED = register("cobweb_tall_dark_oak_checked");

	public static final FrozenPlacedFeature COBWEB_FANCY_TALL_DARK_OAK_CHECKED = register("cobweb_fancy_tall_dark_oak_checked");

    //SWAMP TREE
    public static final FrozenPlacedFeature SWAMP_TREE_CHECKED = register("swamp_tree_checked");

    //SPRUCE
    public static final FrozenPlacedFeature SPRUCE_CHECKED = register("spruce_checked");

    public static final FrozenPlacedFeature SPRUCE_ON_SNOW = register("spruce_on_snow");

    public static final FrozenPlacedFeature SPRUCE_SHORT_CHECKED = register("spruce_short_checked");

    public static final FrozenPlacedFeature FUNGUS_PINE_CHECKED = register("fungus_pine_checked");

    public static final FrozenPlacedFeature DYING_FUNGUS_PINE_CHECKED = register("dying_fungus_pine_checked");

    public static final FrozenPlacedFeature FUNGUS_PINE_ON_SNOW = register("fungus_pine_on_snow");

    public static final FrozenPlacedFeature MEGA_FUNGUS_SPRUCE_CHECKED = register("mega_fungus_spruce_checked");

    public static final FrozenPlacedFeature MEGA_FUNGUS_PINE_CHECKED = register("mega_fungus_pine_checked");

    public static final FrozenPlacedFeature DYING_MEGA_FUNGUS_PINE_CHECKED = register("dying_mega_fungus_pine_checked");

    public static final FrozenPlacedFeature FALLEN_SPRUCE_CHECKED = register("fallen_spruce_checked");

	public static final FrozenPlacedFeature SHORT_MEGA_SPRUCE_CHECKED = register("short_mega_spruce_checked");

	public static final FrozenPlacedFeature SHORT_MEGA_FUNGUS_SPRUCE_CHECKED = register("short_mega_fungus_spruce_checked");

	public static final FrozenPlacedFeature SHORT_MEGA_DYING_FUNGUS_SPRUCE_CHECKED = register("short_mega_dying_fungus_spruce_checked");

	public static final FrozenPlacedFeature SHORT_MEGA_DYING_SPRUCE_CHECKED = register("short_mega_dying_spruce_checked");

	public static final FrozenPlacedFeature SHORT_MEGA_SPRUCE_ON_SNOW = register("short_mega_spruce_on_snow");

	public static final FrozenPlacedFeature SHORT_MEGA_FUNGUS_SPRUCE_ON_SNOW = register("short_mega_fungus_spruce_on_snow");

	public static final FrozenPlacedFeature SHORT_MEGA_DYING_FUNGUS_SPRUCE_ON_SNOW = register("short_mega_dying_fungus_spruce_on_snow");

	public static final FrozenPlacedFeature SHORT_MEGA_DYING_SPRUCE_ON_SNOW = register("short_mega_dying_spruce_on_snow");

	public static final FrozenPlacedFeature SNAPPED_SPRUCE_CHECKED = register("snapped_spruce_checked");

	public static final FrozenPlacedFeature SNAPPED_SPRUCE_ON_SNOW = register("snapped_spruces_on_snow");

	//BAOBAB
    public static final FrozenPlacedFeature BAOBAB = register("baobab");

    public static final FrozenPlacedFeature BAOBAB_TALL = register("baobab_tall");

    //CYPRESS
    public static final FrozenPlacedFeature CYPRESS = register("cypress");

    public static final FrozenPlacedFeature FUNGUS_CYPRESS = register("fungus_cypress");

    public static final FrozenPlacedFeature SHORT_CYPRESS = register("short_cypress");

    public static final FrozenPlacedFeature SHORT_FUNGUS_CYPRESS = register("short_fungus_cypress");

    public static final FrozenPlacedFeature SWAMP_CYPRESS = register("swamp_cypress");

    public static final FrozenPlacedFeature FALLEN_CYPRESS_CHECKED = register("fallen_cypress_checked");

	public static final FrozenPlacedFeature SNAPPED_CYPRESS_CHECKED = register("snapped_cypress_checked");

	//TREE ON SAND
	public static final BlockPredicate SAND_GRASS_TREE_PREDICATE = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.RED_SAND, Blocks.SAND, Blocks.GRASS);

	public static final List<PlacementModifier> SAND_TREE_FILTER_DECORATOR = List.of(
			EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.SANDSTONE)), 8),
			BlockPredicateFilter.forPredicate(SAND_GRASS_TREE_PREDICATE)
	);

	//SHRUB
	public static final FrozenPlacedFeature BIG_SHRUB_CHECKED = register("big_shrub_checked");

	public static final FrozenPlacedFeature BIG_SHRUB_GRASS_CHECKED = register("big_shrub_grass_checked");

	//PALM
	public static final FrozenPlacedFeature PALM_CHECKED = register("palm_checked");

	public static final FrozenPlacedFeature TALL_PALM_CHECKED = register("tall_palm_checked");

	public static final FrozenPlacedFeature TALL_WINE_PALM_CHECKED = register("tall_wine_palm_checked");

	public static final FrozenPlacedFeature SMALL_WINE_PALM_CHECKED = register("small_wine_palm_checked");

	public static final FrozenPlacedFeature FALLEN_PALM_CHECKED = register("fallen_palm_checked");

	//JUNIPER
	public static final FrozenPlacedFeature JUNIPER = register("juniper");

	//JUNGLE
	public static final FrozenPlacedFeature FALLEN_JUNGLE_CHECKED = register("fallen_jungle_checked");

	public static final FrozenPlacedFeature SNAPPED_JUNGLE_CHECKED = register("snapped_jungle_checked");

	//ACACIA
	public static final FrozenPlacedFeature FALLEN_ACACIA_CHECKED = register("fallen_acacia_checked");

	public static final FrozenPlacedFeature SNAPPED_ACACIA_CHECKED = register("snapped_acacia_checked");

	//MANGROVE
	public static final FrozenPlacedFeature FALLEN_MANGROVE_CHECKED = register("fallen_mangrove_checked");

	//TREE ON GRASS
	public static final FrozenPlacedFeature PALM_CHECKED_DIRT = register("palm_checked_dirt");

	public static final FrozenPlacedFeature TALL_PALM_CHECKED_DIRT = register("tall_palm_checked_dirt");

	public static final FrozenPlacedFeature TALL_WINE_PALM_CHECKED_DIRT = register("tall_wine_palm_checked_dirt");

	public static final FrozenPlacedFeature SMALL_WINE_PALM_CHECKED_DIRT = register("small_wine_palm_checked_dirt");

	static {
		registerTreePlaced();
	}

	public static void init() {
	}

	public static void registerTreePlaced() {

        WilderSharedConstants.logWild("Registering WilderTreePlaced for", true);

		// BIRCH

		BIRCH_CHECKED.makeAndSetHolder(WilderTreeConfigured.BIRCH_TREE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		BIRCH_BEES_0004.makeAndSetHolder(WilderTreeConfigured.BIRCH_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		BIRCH_BEES_025.makeAndSetHolder(WilderTreeConfigured.BIRCH_BEES_025.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		DYING_BIRCH.makeAndSetHolder(WilderTreeConfigured.DYING_BIRCH.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		SHORT_BIRCH.makeAndSetHolder(WilderTreeConfigured.SHORT_BIRCH.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		DYING_SHORT_BIRCH.makeAndSetHolder(WilderTreeConfigured.SHORT_DYING_BIRCH.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		SHORT_BIRCH_BEES_0004.makeAndSetHolder(WilderTreeConfigured.SHORT_BIRCH_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		DYING_SUPER_BIRCH.makeAndSetHolder(WilderTreeConfigured.DYING_SUPER_BIRCH.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		SUPER_BIRCH_BEES_0004.makeAndSetHolder(WilderTreeConfigured.SUPER_BIRCH_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		SUPER_BIRCH_BEES.makeAndSetHolder(WilderTreeConfigured.SUPER_BIRCH_BEES.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		SUPER_BIRCH.makeAndSetHolder(WilderTreeConfigured.SUPER_BIRCH.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		FALLEN_BIRCH_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_BIRCH_TREE.getHolder());

		MOSSY_FALLEN_BIRCH_CHECKED.makeAndSetHolder(WilderTreeConfigured.MOSSY_FALLEN_BIRCH_TREE.getHolder());

		SNAPPED_BIRCH_CHECKED.makeAndSetHolder(WilderTreeConfigured.SNAPPED_BIRCH.getHolder(),
			PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)
		);

		// OAK

		OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		DYING_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.DYING_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		OAK_BEES_0004.makeAndSetHolder(WilderTreeConfigured.OAK_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		SHORT_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.SHORT_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		FANCY_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.FANCY_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		DYING_FANCY_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.FANCY_DYING_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		DYING_FANCY_OAK_BEES_0004.makeAndSetHolder(WilderTreeConfigured.FANCY_DYING_OAK_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		FANCY_OAK_BEES_0004.makeAndSetHolder(WilderTreeConfigured.FANCY_OAK_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		DYING_FANCY_OAK_BEES_025.makeAndSetHolder(WilderTreeConfigured.FANCY_DYING_OAK_BEES_025.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		FANCY_OAK_BEES_025.makeAndSetHolder(WilderTreeConfigured.FANCY_OAK_BEES_025.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		FANCY_OAK_BEES.makeAndSetHolder(WilderTreeConfigured.FANCY_OAK_BEES.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		FALLEN_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_OAK_TREE.getHolder());

		FALLEN_OAK_NO_MOSS_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_OAK_TREE_NO_MOSS.getHolder());

		MOSSY_FALLEN_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.MOSSY_FALLEN_OAK_TREE.getHolder());

		MOSSY_FALLEN_STRAIGHT_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.MOSSY_FALLEN_STRAIGHT_OAK_TREE.getHolder());

		MOSSY_FALLEN_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.MOSSY_FALLEN_SPRUCE_TREE.getHolder());

		OLD_DYING_FANCY_OAK_BEES_0004.makeAndSetHolder(WilderTreeConfigured.OLD_FANCY_DYING_OAK_BEES_0004.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		SNAPPED_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.SNAPPED_OAK.getHolder(),
			PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		// DARK OAK

		TALL_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.TALL_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);

		FANCY_TALL_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.FANCY_TALL_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);
		DYING_TALL_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.DYING_TALL_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);
		DYING_FANCY_TALL_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.DYING_FANCY_TALL_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);

		DYING_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.DYING_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);


		COBWEB_TALL_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.COBWEB_TALL_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);
		COBWEB_FANCY_TALL_DARK_OAK_CHECKED.makeAndSetHolder(WilderTreeConfigured.COBWEB_FANCY_TALL_DARK_OAK.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING)
		);

		// SWAMP TREE

		SWAMP_TREE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SWAMP_TREE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE)
		);

		// SPRUCE

		SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SPRUCE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		SPRUCE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.SPRUCE.getHolder(),
				SNOW_TREE_FILTER_DECORATOR
		);

		SPRUCE_SHORT_CHECKED.makeAndSetHolder(WilderTreeConfigured.SPRUCE_SHORT.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		FUNGUS_PINE_CHECKED.makeAndSetHolder(WilderTreeConfigured.FUNGUS_PINE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		DYING_FUNGUS_PINE_CHECKED.makeAndSetHolder(WilderTreeConfigured.DYING_FUNGUS_PINE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		FUNGUS_PINE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.FUNGUS_PINE.getHolder(),
				SNOW_TREE_FILTER_DECORATOR
		);

		MEGA_FUNGUS_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.MEGA_FUNGUS_SPRUCE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		MEGA_FUNGUS_PINE_CHECKED.makeAndSetHolder(WilderTreeConfigured.MEGA_FUNGUS_PINE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		DYING_MEGA_FUNGUS_PINE_CHECKED.makeAndSetHolder(WilderTreeConfigured.DYING_MEGA_FUNGUS_PINE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		FALLEN_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_SPRUCE_TREE.getHolder());

		SHORT_MEGA_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_SPRUCE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		SHORT_MEGA_FUNGUS_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_FUNGUS_SPRUCE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		SHORT_MEGA_DYING_FUNGUS_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_DYING_FUNGUS_SPRUCE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		SHORT_MEGA_DYING_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_DYING_SPRUCE.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		SHORT_MEGA_SPRUCE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_SPRUCE.getHolder(),
				SNOW_TREE_FILTER_DECORATOR
		);

		SHORT_MEGA_FUNGUS_SPRUCE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_FUNGUS_SPRUCE.getHolder(),
				SNOW_TREE_FILTER_DECORATOR
		);

		SHORT_MEGA_DYING_FUNGUS_SPRUCE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_DYING_FUNGUS_SPRUCE.getHolder(),
				SNOW_TREE_FILTER_DECORATOR
		);

		SHORT_MEGA_DYING_SPRUCE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.SHORT_MEGA_DYING_SPRUCE.getHolder(),
				SNOW_TREE_FILTER_DECORATOR
		);

		SNAPPED_SPRUCE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SNAPPED_SPRUCE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)
		);

		SNAPPED_SPRUCE_ON_SNOW.makeAndSetHolder(WilderTreeConfigured.SNAPPED_SPRUCE.getHolder(),
			SNOW_TREE_FILTER_DECORATOR
		);

		// BAOBAB

		BAOBAB.makeAndSetHolder(WilderTreeConfigured.BAOBAB.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.BAOBAB_NUT)
		);

		BAOBAB_TALL.makeAndSetHolder(WilderTreeConfigured.BAOBAB_TALL.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.BAOBAB_NUT)
		);

		// CYPRESS

		CYPRESS.makeAndSetHolder(WilderTreeConfigured.CYPRESS.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.CYPRESS_SAPLING)
		);

		FUNGUS_CYPRESS.makeAndSetHolder(WilderTreeConfigured.FUNGUS_CYPRESS.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.CYPRESS_SAPLING)
		);

		SHORT_CYPRESS.makeAndSetHolder(WilderTreeConfigured.SHORT_CYPRESS.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.CYPRESS_SAPLING)
		);

		SHORT_FUNGUS_CYPRESS.makeAndSetHolder(WilderTreeConfigured.SHORT_FUNGUS_CYPRESS.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.CYPRESS_SAPLING)
		);

		SWAMP_CYPRESS.makeAndSetHolder(WilderTreeConfigured.SWAMP_CYPRESS.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.CYPRESS_SAPLING)
		);

		FALLEN_CYPRESS_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_CYPRESS_TREE.getHolder());

		SNAPPED_CYPRESS_CHECKED.makeAndSetHolder(WilderTreeConfigured.SNAPPED_CYPRESS.getHolder(),
			PlacementUtils.filteredByBlockSurvival(RegisterBlocks.CYPRESS_SAPLING)
		);

		// SHRUB

		BIG_SHRUB_CHECKED.makeAndSetHolder(WilderTreeConfigured.BIG_SHRUB.getHolder(),
				SAND_TREE_FILTER_DECORATOR
		);

		BIG_SHRUB_GRASS_CHECKED.makeAndSetHolder(WilderTreeConfigured.BIG_SHRUB.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		// PALM

		PALM_CHECKED.makeAndSetHolder(WilderTreeConfigured.PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.COCONUT)
		);

		TALL_PALM_CHECKED.makeAndSetHolder(WilderTreeConfigured.TALL_PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.COCONUT)
		);

		TALL_WINE_PALM_CHECKED.makeAndSetHolder(WilderTreeConfigured.TALL_WINE_PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.COCONUT)
		);

		SMALL_WINE_PALM_CHECKED.makeAndSetHolder(WilderTreeConfigured.SMALL_WINE_PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(RegisterBlocks.COCONUT)
		);

		FALLEN_PALM_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_PALM.getHolder());

		// JUNIPER

		JUNIPER.makeAndSetHolder(WilderTreeConfigured.JUNIPER.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		//JUNGLE

		FALLEN_JUNGLE_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_JUNGLE_TREE.getHolder());

		SNAPPED_JUNGLE_CHECKED.makeAndSetHolder(WilderTreeConfigured.SNAPPED_JUNGLE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING)
		);

		//ACACIA

		FALLEN_ACACIA_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_ACACIA_TREE.getHolder());

		SNAPPED_ACACIA_CHECKED.makeAndSetHolder(WilderTreeConfigured.SNAPPED_ACACIA.getHolder(),
			PlacementUtils.filteredByBlockSurvival(Blocks.ACACIA_SAPLING)
		);

		//MANGROVE

		FALLEN_MANGROVE_CHECKED.makeAndSetHolder(WilderTreeConfigured.FALLEN_MANGROVE_TREE.getHolder());

		// TREE ON GRASS

		PALM_CHECKED_DIRT.makeAndSetHolder(WilderTreeConfigured.PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		TALL_PALM_CHECKED_DIRT.makeAndSetHolder(WilderTreeConfigured.TALL_PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		TALL_WINE_PALM_CHECKED_DIRT.makeAndSetHolder(WilderTreeConfigured.TALL_WINE_PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);

		SMALL_WINE_PALM_CHECKED_DIRT.makeAndSetHolder(WilderTreeConfigured.SMALL_WINE_PALM.getHolder(),
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)
		);
    }
}
