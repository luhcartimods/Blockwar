package net.luhcarti.blockwar.model;

import net.luhcarti.blockwar.BlockWar;
import net.luhcarti.blockwar.item.custom.M1Carbine;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class M1CarbineModel extends GeoModel<M1Carbine> {
    private final ResourceLocation modelResource = new ResourceLocation(BlockWar.MODID, "geo/item/m1_carbine.geo.json");
    private final ResourceLocation textureResource = new ResourceLocation(BlockWar.MODID, "textures/item/m1_carbine.png");
    private final ResourceLocation animationResource = new ResourceLocation(BlockWar.MODID, "animations/m1_carbine/m1_carbine_anims");

    @Override
    public ResourceLocation getModelResource(M1Carbine m1Carbine) {
        return this.modelResource;
    }

    @Override
    public ResourceLocation getTextureResource(M1Carbine m1Carbine) {
        return this.textureResource;
    }

    @Override
    public ResourceLocation getAnimationResource(M1Carbine m1Carbine) {
        return null;
    }
}
