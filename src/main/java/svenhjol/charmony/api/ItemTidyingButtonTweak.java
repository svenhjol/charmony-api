package svenhjol.charmony.api;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.gui.screens.Screen;

/**
 * Definition for a screen and its container offset.
 */
@SuppressWarnings("unused")
public interface ItemTidyingButtonTweak {
    Class<? extends Screen> getScreen();

    /**
     * @deprecated since 1.15.0
     */
    Pair<Integer, Integer> getXYOffset();

    /**
     * Provide hardcoded container inventory X and Y base coordinates for the given screen.
     */
    Pair<Integer, Integer> getContainerXYOffset();

    /**
     * Provide hardcoded player inventory X and Y base coordinates for the given screen.
     */
    Pair<Integer, Integer> getPlayerXYOffset();
}
