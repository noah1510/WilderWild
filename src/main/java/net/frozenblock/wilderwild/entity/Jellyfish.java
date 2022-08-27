package net.frozenblock.wilderwild.entity;

import net.frozenblock.wilderwild.registry.RegisterWorldgen;
import net.frozenblock.wilderwild.tag.WilderBiomeTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;

public class Jellyfish extends WaterAnimal {
    public float xBodyRot;
    public float xBodyRotO;
    public float zBodyRot;
    public float zBodyRotO;
    public float tentacleMovement;
    public float oldTentacleMovement;
    public float tentacleAngle;
    public float oldTentacleAngle;
    private float speed;
    private float tentacleSpeed;
    private float rotateSpeed;
    private float tx;
    private float ty;
    private float tz;

    public Jellyfish(EntityType<? extends Jellyfish> entityType, Level level) {
        super(entityType, level);
        this.random.setSeed(this.getId());
        this.tentacleSpeed = 1.0f / (this.random.nextFloat() + 1.0f) * 0.2f;
    }
    public static boolean canSpawn(EntityType<Jellyfish> type, LevelAccessor world, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        if (world.getBiome(pos).is(RegisterWorldgen.JELLYFISH_CAVES)) {
            return world.getBrightness(LightLayer.SKY, pos) <= 6;
        }
        return false;
    }

    public static AttributeSupplier.Builder addAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.MOVEMENT_SPEED, 0.05F).add(Attributes.FLYING_SPEED, 0.05F).add(Attributes.FOLLOW_RANGE, 32);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Jellyfish.JellyRandomMovementGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
        return entityDimensions.height * 0.5f;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    protected SoundEvent getSquirtSound() {
        return SoundEvents.SQUID_SQUIRT;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return !this.isLeashed();
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.xBodyRotO = this.xBodyRot;
        this.zBodyRotO = this.zBodyRot;
        this.oldTentacleMovement = this.tentacleMovement;
        this.oldTentacleAngle = this.tentacleAngle;
        this.tentacleMovement += this.tentacleSpeed;
        if ((double)this.tentacleMovement > Math.PI * 2) {
            if (this.level.isClientSide) {
                this.tentacleMovement = (float)Math.PI * 2;
            } else {
                this.tentacleMovement -= (float)Math.PI * 2;
                if (this.random.nextInt(10) == 0) {
                    this.tentacleSpeed = 1.0f / (this.random.nextFloat() + 1.0f) * 0.2f;
                }
                this.level.broadcastEntityEvent(this, (byte)19);
            }
        }
        if (this.isInWaterOrBubble()) {
            if (this.tentacleMovement < (float)Math.PI) {
                float f = this.tentacleMovement / (float)Math.PI;
                this.tentacleAngle = Mth.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25f;
                if ((double)f > 0.75) {
                    this.speed = 1.0f;
                    this.rotateSpeed = 1.0f;
                } else {
                    this.rotateSpeed *= 0.8f;
                }
            } else {
                this.tentacleAngle = 0.0f;
                this.speed *= 0.9f;
                this.rotateSpeed *= 0.99f;
            }
            if (!this.level.isClientSide) {
                this.setDeltaMovement(this.tx * this.speed, this.ty * this.speed, this.tz * this.speed);
            }
            Vec3 vec3 = this.getDeltaMovement();
            double d = vec3.horizontalDistance();
            this.yBodyRot += (-((float)Mth.atan2(vec3.x, vec3.z)) * 57.295776f - this.yBodyRot) * 0.1f;
            this.setYRot(this.yBodyRot);
            this.zBodyRot += (float)Math.PI * this.rotateSpeed * 1.5f;
            this.xBodyRot += (-((float)Mth.atan2(d, vec3.y)) * 57.295776f - this.xBodyRot) * 0.1f;
        } else {
            this.tentacleAngle = Mth.abs(Mth.sin(this.tentacleMovement)) * (float)Math.PI * 0.25f;
            if (!this.level.isClientSide) {
                double e = this.getDeltaMovement().y;
                if (this.hasEffect(MobEffects.LEVITATION)) {
                    e = 0.05 * (double)(this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1);
                } else if (!this.isNoGravity()) {
                    e -= 0.08;
                }
                this.setDeltaMovement(0.0, e * (double)0.98f, 0.0);
            }
            this.xBodyRot += (-90.0f - this.xBodyRot) * 0.02f;
        }
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (super.hurt(damageSource, f) && this.getLastHurtByMob() != null) {
            if (!this.level.isClientSide) {
                this.spawnJelly();
            }
            return true;
        }
        return false;
    }

    private Vec3 rotateVector(Vec3 vec3) {
        Vec3 vec32 = vec3.xRot(this.xBodyRotO * ((float)Math.PI / 180));
        vec32 = vec32.yRot(-this.yBodyRotO * ((float)Math.PI / 180));
        return vec32;
    }

    private void spawnJelly() {
        this.playSound(this.getSquirtSound(), this.getSoundVolume(), this.getVoicePitch());
        Vec3 vec3 = this.rotateVector(new Vec3(0.0, -1.0, 0.0)).add(this.getX(), this.getY(), this.getZ());
        for (int i = 0; i < 30; ++i) {
            Vec3 vec32 = this.rotateVector(new Vec3((double)this.random.nextFloat() * 0.6 - 0.3, -1.0, (double)this.random.nextFloat() * 0.6 - 0.3));
            Vec3 vec33 = vec32.scale(0.3 + (double)(this.random.nextFloat() * 2.0f));
            ((ServerLevel)this.level).sendParticles(this.getJellyParticle(), vec3.x, vec3.y + 0.5, vec3.z, 0, vec33.x, vec33.y, vec33.z, 0.1f);
        }
    }

    protected ParticleOptions getJellyParticle() {
        return ParticleTypes.BUBBLE;
    }

    @Override
    public void travel(Vec3 vec3) {
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 19) {
            this.tentacleMovement = 0.0f;
        } else {
            super.handleEntityEvent(b);
        }
    }

    public void setMovementVector(float f, float g, float h) {
        this.tx = f;
        this.ty = g;
        this.tz = h;
    }

    public boolean hasMovementVector() {
        return this.tx != 0.0f || this.ty != 0.0f || this.tz != 0.0f;
    }

    static class JellyRandomMovementGoal
            extends Goal {
        private final Jellyfish jelly;

        public JellyRandomMovementGoal(Jellyfish jelly) {
            this.jelly = jelly;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            int i = this.jelly.getNoActionTime();
            if (i > 100) {
                this.jelly.setMovementVector(0.0f, 0.0f, 0.0f);
            } else if (this.jelly.getRandom().nextInt(Jellyfish.JellyRandomMovementGoal.reducedTickDelay(50)) == 0 || !this.jelly.wasTouchingWater || !this.jelly.hasMovementVector()) {
                float f = this.jelly.getRandom().nextFloat() * ((float)Math.PI * 2);
                float g = Mth.cos(f) * 0.2f;
                float h = -0.1f + this.jelly.getRandom().nextFloat() * 0.2f;
                float j = Mth.sin(f) * 0.2f;
                this.jelly.setMovementVector(g, h, j);
            }
        }
    }
}
