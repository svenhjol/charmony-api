package svenhjol.charmony.api.tint_background;

import net.minecraft.client.gui.GuiGraphics;
import svenhjol.charmony.api.core.Color;

@SuppressWarnings("unused")
public interface TintedGuiGraphics {
    GuiGraphics tint(Color color);
}
