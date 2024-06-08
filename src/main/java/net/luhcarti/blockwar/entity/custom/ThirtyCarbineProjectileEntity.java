package net.luhcarti.blockwar.entity.custom;

import net.luhcarti.blockwar.entity.EntityInit;
import net.luhcarti.blockwar.item.ItemInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;

public class ThirtyCarbineProjectileEntity extends ThrowableItemProjectile {
    private final Level level;
    private BlockPos startPos;
    private final double speed = 7.0D;

    public ThirtyCarbineProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.level = pLevel;
        this.startPos = this.blockPosition();
    }

    public ThirtyCarbineProjectileEntity(Level pLevel) {
        super(EntityInit.THIRTY_CARBINE_PROJECTILE.get(), pLevel);
        this.level = pLevel;
        this.startPos = this.blockPosition();
    }

    public ThirtyCarbineProjectileEntity(Level pLevel, Player player) {
        super(EntityInit.THIRTY_CARBINE_PROJECTILE.get(), player, pLevel);
        this.level = pLevel;
        this.startPos = this.blockPosition();
        this.setDeltaMovement(player.getLookAngle().scale(this.speed));
    }


    @Override
    protected Item getDefaultItem() {
        return ItemInit.THIRTY_CARBINE.get();
    }


    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(true);
        if (this.getOwner() instanceof Player) {
            this.setDeltaMovement(this.getOwner().getLookAngle().scale(this.speed));
        }
    }


    @Override
    public void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        float damageToApply = 10.0F;
        entity.hurt(damageSources().thrown(this, this.getOwner()), damageToApply);
    }

}

