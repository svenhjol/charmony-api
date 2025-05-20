package svenhjol.charmony.api.tint_background;

import net.minecraft.client.gui.render.state.BlitRenderState;
import svenhjol.charmony.api.core.Color;

@SuppressWarnings("unused")
public interface TintedGuiGraphics {
    BlitRenderState tint(Color color);
}
