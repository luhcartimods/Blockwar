package net.luhcarti.blockwar.entity.custom;

import net.luhcarti.blockwar.entity.EntityInit;
import net.luhcarti.blockwar.item.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class ThirtyCarbineProjectileEntity extends ThrowableItemProjectile {
    private final Level level;
    private final float damage = 10.0F;

    public ThirtyCarbineProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.level = pLevel;
    }

    public ThirtyCarbineProjectileEntity(Level pLevel) {
        super(EntityInit.THIRTY_CARBINE_PROJECTILE.get(), pLevel);
        this.level = pLevel;
    }

    public ThirtyCarbineProjectileEntity(Level pLevel, Player player) {
        super(EntityInit.THIRTY_CARBINE_PROJECTILE.get(), player, pLevel);
        this.level = pLevel;
    }


    @Override
    protected Item getDefaultItem() {
        return ItemInit.THIRTY_CARBINE.get();
    }

    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(true);
    }


}
