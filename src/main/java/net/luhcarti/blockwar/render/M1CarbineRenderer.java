package net.luhcarti.blockwar.render;

import net.luhcarti.blockwar.item.custom.M1Carbine;
import net.luhcarti.blockwar.model.M1CarbineModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class M1CarbineRenderer extends GeoItemRenderer<M1Carbine> {

    public M1CarbineRenderer() {
        super(new M1CarbineModel());
    }
}
