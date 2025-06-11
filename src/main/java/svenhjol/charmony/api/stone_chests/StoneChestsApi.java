package svenhjol.charmony.api.stone_chests;

import java.util.Optional;
import java.util.function.Function;

@SuppressWarnings("unused")
public final class StoneChestsApi {
    private static StoneChestsApi instance;

    private Function<StoneChestMaterial, Optional<StoneChestBlock>> getBlockImpl;

    public static StoneChestsApi instance() {
        if (instance == null) {
            instance = new StoneChestsApi();
        }
        return instance;
    }

    private StoneChestsApi() {
        getBlockImpl = material -> Optional.empty();
    }

    public Optional<StoneChestBlock> getBlock(StoneChestMaterial material) {
        return getBlockImpl.apply(material);
    }

    public static class Impl {
        public static void _getBlock(Function<StoneChestMaterial, Optional<StoneChestBlock>> impl) {
            instance().getBlockImpl = impl;
        }
    }
}
