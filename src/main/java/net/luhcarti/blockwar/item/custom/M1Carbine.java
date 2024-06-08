package net.luhcarti.blockwar.item.custom;

import net.luhcarti.blockwar.entity.custom.ThirtyCarbineProjectileEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class M1Carbine extends Item {
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

        player.swing(hand);
        return InteractionResultHolder.success(itemstack);
    }
}
