package svenhjol.charmony.api;

import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

/**
 * Attach to a class to let it determine if a player can automatically pick up an item after harvesting it.
 */
public interface AutoPickupItemProvider {
    Function<Player, Boolean> getAutoPickupItemChecks();
}
