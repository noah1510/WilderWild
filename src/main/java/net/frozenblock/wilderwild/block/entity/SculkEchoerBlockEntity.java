package net.frozenblock.wilderwild.block.entity;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.frozenblock.wilderwild.WilderWild;
import net.frozenblock.wilderwild.block.SculkEchoerBlock;
import net.frozenblock.wilderwild.registry.RegisterBlockEntityType;
import net.frozenblock.wilderwild.registry.RegisterParticles;
import net.frozenblock.wilderwild.tag.WildEventTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.BlockPositionSource;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.GameEventListener;
import net.minecraft.world.event.listener.SculkSensorListener;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Objects;

public class SculkEchoerBlockEntity extends BlockEntity implements SculkSensorListener.Callback {
    private static final Logger LOGGER = LogUtils.getLogger();
    private SculkSensorListener listener;
    private int lastVibrationFreq;
    public int echoBubblesLeft;
    public IntArrayList bubbleTicks = new IntArrayList();
    public SculkEchoerBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlockEntityType.SCULK_ECHOER, pos, state);
        this.listener = new SculkSensorListener(new BlockPositionSource(this.pos), ((SculkEchoerBlock)state.getBlock()).getRange(), this, null, 0, 0);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world instanceof ServerWorld server) {
            this.getEventListener().tick(world);
            if (this.echoBubblesLeft > 0) {
                --this.echoBubblesLeft;
                server.spawnParticles(RegisterParticles.ECHOING_BUBBLE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.8D, (double)pos.getZ() + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.05D);
                this.bubbleTicks.add(28);
            }
            if (!bubbleTicks.isEmpty()) {
                for (int i : bubbleTicks) {
                    int index = bubbleTicks.indexOf(i);
                    bubbleTicks.set(index, i - 1);
                    if (i - 1 <= 0) {
                        world.emitGameEvent(null, WilderWild.SCULK_ECHOER_ECHO, pos.add(0.5, 1.5, 0.5));
                        bubbleTicks.removeInt(index);
                    }
                }
            }
        }
    }

    public SculkSensorListener getListener() {
        return this.listener;
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.lastVibrationFreq = nbt.getInt("last_vibration_frequency");
        this.echoBubblesLeft = nbt.getInt("echoBubblesLeft");
        this.bubbleTicks = IntArrayList.wrap(nbt.getIntArray("bubbleTicks"));
        if (nbt.contains("listener", 10)) {
            DataResult<?> var10000 = SculkSensorListener.createCodec(this).parse(new Dynamic<>(NbtOps.INSTANCE, nbt.getCompound("listener")));
            Logger var10001 = LOGGER;
            Objects.requireNonNull(var10001);
            var10000.resultOrPartial(var10001::error).ifPresent((vibrationListener) -> {
                this.listener = (SculkSensorListener) vibrationListener;
            });
        }
    }

    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("last_vibration_frequency", this.lastVibrationFreq);
        nbt.putInt("echoBubblesLeft", this.echoBubblesLeft);
        nbt.putIntArray("bubbleTicks", this.bubbleTicks);
        DataResult<?> var10000 = SculkSensorListener.createCodec(this).encodeStart(NbtOps.INSTANCE, this.listener);
        Logger var10001 = LOGGER;
        Objects.requireNonNull(var10001);
        var10000.resultOrPartial(var10001::error).ifPresent((nbtElement) -> {
            nbt.put("listener", (NbtElement)nbtElement);
        });
    }

    public TagKey<GameEvent> getTag() {
        return WildEventTags.ECHOER_CAN_LISTEN;
    }

    public SculkSensorListener getEventListener() {
        return this.listener;
    }

    public int getLastVibrationFrequency() {
        return this.lastVibrationFreq;
    }

    @Override
    public boolean accepts(ServerWorld world, GameEventListener listener, BlockPos pos, GameEvent event, GameEvent.Emitter arg) {
        return (!pos.equals(this.getPos()) && (event != GameEvent.BLOCK_DESTROY || event != GameEvent.BLOCK_PLACE)) && SculkEchoerBlock.isInactive(this.getCachedState());
    }

    @Override
    public void accept(ServerWorld world, GameEventListener listener, BlockPos pos, GameEvent event, @Nullable Entity entity, @Nullable Entity sourceEntity, int delay) {
        BlockState blockState = this.getCachedState();
        if (SculkEchoerBlock.isInactive(blockState)) {
            this.lastVibrationFreq = SculkEchoerBlock.FREQUENCIES.getInt(event);
            SculkEchoerBlock.setActive(entity, world, this.pos, blockState, 3);
        }
    }


    public void onListen() {
        this.markDirty();
    }

    public static int getPower(int distance, int range) {
        double d = (double)distance / (double)range;
        return Math.max(1, 15 - MathHelper.floor(d * 15.0));
    }
}