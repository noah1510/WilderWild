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

package net.frozenblock.wilderwild.registry;

import net.frozenblock.wilderwild.misc.FlowerColor;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public final class RegisterProperties {
	private RegisterProperties() {
		throw new UnsupportedOperationException("RegisterProperties contains only static declarations.");
	}

    //Osseous Sculk
    public static final IntegerProperty PILLAR_HEIGHT_LEFT = IntegerProperty.create("pillar_height_left", 0, 15);
    public static final BooleanProperty UPSIDE_DOWN = BooleanProperty.create("upside_down");
    public static final IntegerProperty TOTAL_HEIGHT = IntegerProperty.create("total_pillar_height", 0, 16);
    //Hanging Tendril
    public static final BooleanProperty TWITCHING = BooleanProperty.create("twitching");
    public static final BooleanProperty WRINGING_OUT = BooleanProperty.create("wringing_out");
    //Echo Glass
    public static final IntegerProperty DAMAGE = IntegerProperty.create("damage", 0, 3);
    //Shelf Fungus
    public static final IntegerProperty FUNGUS_STAGE = IntegerProperty.create("shelf_fungus_stage", 1, 4);
    //Termite Mound
    public static final BooleanProperty NATURAL = BooleanProperty.create("natural");
	public static final BooleanProperty TERMITES_AWAKE = BooleanProperty.create("termites_awake");
	public static final BooleanProperty CAN_SPAWN_TERMITE = BooleanProperty.create("can_spawn_termites");
    //Glory of The Snow
    public static final EnumProperty<FlowerColor> FLOWER_COLOR = EnumProperty.create("flower_color", FlowerColor.class);
    //Firefly Lantern
    public static final IntegerProperty DISPLAY_LIGHT = IntegerProperty.create("display_light", 0, 15);
    //Stone Chest
    public static final BooleanProperty ANCIENT = BooleanProperty.create("ancient");
    public static final BooleanProperty HAS_SCULK = BooleanProperty.create("has_sculk");
	//Scorched Sand
    public static final BooleanProperty CRACKEDNESS = BooleanProperty.create("crackedness");

    //Vanilla Blocks
    public static final IntegerProperty SOULS_TAKEN = IntegerProperty.create("souls_taken", 0, 2); //Sculk Shrieker
    public static final BooleanProperty HICCUPPING = BooleanProperty.create("hiccupping"); //Sculk Sensor
	public static final BooleanProperty TERMITE_EDIBLE = BooleanProperty.create("termite_edible"); //Wood


	public static void init() {
	}

}
