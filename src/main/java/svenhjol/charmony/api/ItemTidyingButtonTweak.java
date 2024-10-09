package svenhjol.charmony.api;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.gui.screens.Screen;

/**
 * Definition for a screen and its container offset.
 */
@SuppressWarnings("unused")
public interface ItemTidyingButtonTweak {
    Class<? extends Screen> getScreen();

    Pair<Integer, Integer> getXYOffset();
}
