package svenhjol.charmony.api;

import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.List;

@SuppressWarnings("unused")
public interface WandererTradeTier {
    String id();

    List<VillagerTrades.ItemListing> trades();
}
