package net.luhcarti.blockwar.entity;

import net.luhcarti.blockwar.BlockWar;
import net.luhcarti.blockwar.entity.custom.ThirtyCarbineProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BlockWar.MODID);

    public static final RegistryObject<EntityType<ThirtyCarbineProjectileEntity>> THIRTY_CARBINE_PROJECTILE =
            ENTITY_TYPES.register("thirty_carbine_projectile", () -> EntityType.Builder.<ThirtyCarbineProjectileEntity>of(ThirtyCarbineProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("thirty_carbine_projectile"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

