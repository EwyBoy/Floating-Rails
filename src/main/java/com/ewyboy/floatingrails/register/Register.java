package com.ewyboy.floatingrails.register;

import com.ewyboy.floatingrails.common.content.*;

public class Register {

    public static final class BLOCK {
        public static final WaterRail FLOATING_RAIL = new WaterRail();
        public static final LavaRail FLOATING_RAIL_LAVA = new LavaRail();

        public static final MagmaLilyBlock MAGMA_LILY = new MagmaLilyBlock();
    }

    public static final class ITEM {
        public static final FloatingRailBlockItem FLOATING_RAIL = new FloatingRailBlockItem(BLOCK.FLOATING_RAIL);
        public static final MagmaLilyBlockItem MAGMA_LILY = new MagmaLilyBlockItem(BLOCK.MAGMA_LILY);
    }

    public static final class TILE {}

}
