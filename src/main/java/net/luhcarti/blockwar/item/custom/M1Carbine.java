package net.luhcarti.blockwar.item.custom;

import net.luhcarti.blockwar.BlockWar;
import net.luhcarti.blockwar.entity.custom.ThirtyCarbineProjectileEntity;
import net.luhcarti.blockwar.sound.SoundsInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class M1Carbine extends Item implements GeoItem {

    public M1Carbine(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            ThirtyCarbineProjectileEntity projectile = new ThirtyCarbineProjectileEntity(world, player);
            projectile.setItem(itemstack);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(projectile);
           }

         player.playSound(SoundsInit.CARBINE_SHOOT.get(), 1f, 1f);

        player.swing(hand);
        return InteractionResultHolder.success(itemstack);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return GeckoLibUtil.createInstanceCache(this);
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }
}
