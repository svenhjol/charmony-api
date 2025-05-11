package svenhjol.charmony.api.tweaks;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

@SuppressWarnings("unused")
public interface TotemInventoryCheckProvider {
    /**
     * Find a totem in any player inventory and return the found itemstack.
     * @param player Reference to the player to search inventory.
     * @param type Totem type to find.
     * @return ItemStack of the found totem.
     */
    Optional<ItemStack> findTotemFromInventory(Player player, TotemType type);
}
