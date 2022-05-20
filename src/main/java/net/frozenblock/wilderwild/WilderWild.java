package net.frozenblock.wilderwild;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frozenblock.wilderwild.misc.BlockSoundGroupOverwrites;
import net.frozenblock.wilderwild.misc.CameraItem;
import net.frozenblock.wilderwild.mixin.worldgen.TrunkPlacerTypeInvoker;
import net.frozenblock.wilderwild.registry.*;
import net.frozenblock.wilderwild.world.feature.*;
import net.frozenblock.wilderwild.world.gen.WildMusic;
import net.frozenblock.wilderwild.world.gen.WildWorldGen;
import net.frozenblock.wilderwild.world.gen.trunk.FallenTrunkWithLogs;
import net.frozenblock.wilderwild.world.gen.trunk.StraightTrunkWithLogs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WilderWild implements ModInitializer {
    public static final String MOD_ID = "wilderwild";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean DEV_LOGGING = true;

    public static final TrunkPlacerType<StraightTrunkWithLogs> STRAIGHT_TRUNK_WITH_LOGS_PLACER_TYPE = TrunkPlacerTypeInvoker.callRegister("straight_trunk_logs_placer", StraightTrunkWithLogs.CODEC);
    public static final TrunkPlacerType<FallenTrunkWithLogs> FALLEN_TRUNK_WITH_LOGS_PLACER_TYPE = TrunkPlacerTypeInvoker.callRegister("fallen_trunk_logs_placer", FallenTrunkWithLogs.CODEC);
    public static final Feature<ShelfFungusFeatureConfig> SHELF_FUNGUS_FEATURE = new ShelfFungusFeature(ShelfFungusFeatureConfig.CODEC);
    public static final CattailFeature CATTAIL_FEATURE = new CattailFeature(ProbabilityConfig.CODEC);
    public static final CoarsePathFeature COARSE_PATH_FEATURE = new CoarsePathFeature(DefaultFeatureConfig.CODEC);

    @Override
    public void onInitialize() {
        RegisterBlocks.RegisterBlocks();
        RegisterItems.RegisterItems();
        RegisterParticles.RegisterParticles();
        WildConfiguredFeatures.registerConfiguredFeatures();
        WildTreeConfigured.registerTreeConfigured();
        WildTreePlaced.registerTreePlaced();
        WildMiscConfigured.registerMiscPlaced();
        WildWorldGen.generateWildWorldGen();
        WildMusic.playMusic();
        RegisterFlammability.register();
        RegisterGameEvents.RegisterEvents();

        RegisterSounds.init();
        RegisterBlockSoundGroups.init();
        RegisterBlockEntityType.init();
        RegisterEntities.init();
        RegisterEnchantments.init();
        BlockSoundGroupOverwrites.init();

        Registry.register(Registry.FEATURE, new Identifier(WilderWild.MOD_ID, "shelf_fungus_feature"), SHELF_FUNGUS_FEATURE);
        Registry.register(Registry.FEATURE, new Identifier(WilderWild.MOD_ID, "cattail_feature"), CATTAIL_FEATURE);
        Registry.register(Registry.FEATURE, new Identifier(WilderWild.MOD_ID, "coarse_path_feature"), COARSE_PATH_FEATURE);

        //if (FabricLoader.getInstance().isDevelopmentEnvironment()) { /* DEV-ONLY */
            Registry.register(Registry.ITEM, new Identifier(WilderWild.MOD_ID, "camera"), CAMERA_ITEM);
        //}
    }

    public static final Identifier SEED_PACKET = new Identifier("seed_particle_packet");
    public static final Identifier CONTROLLED_SEED_PACKET = new Identifier("controlled_seed_particle_packet");
    public static final Identifier FLOATING_SCULK_BUBBLE_PACKET = new Identifier("floating_sculk_bubble_easy_packet");
    public static final Identifier HORN_PROJECTILE_PACKET_ID = new Identifier(WilderWild.MOD_ID, "ancient_horn_projectile_packet");

    public static final CameraItem CAMERA_ITEM = new CameraItem(new FabricItemSettings());

    public static void log(String string) {
        if (DEV_LOGGING) {
            LOGGER.info(string);
        }
    }
    public static void log(Entity entity, String string) {
        if (DEV_LOGGING) {
            LOGGER.info(entity.toString() + " : " + string + " : " + entity.getPos());
        }
    }
    public static void log(Block block, String string) {
        if (DEV_LOGGING) {
            LOGGER.info(block.toString() + " : " + string + " : ");
        }
    }
    public static void log(Block block, BlockPos pos, String string) {
        if (DEV_LOGGING) {
            LOGGER.info(block.toString() + " : " + string + " : " + pos);
        }
    }

}
