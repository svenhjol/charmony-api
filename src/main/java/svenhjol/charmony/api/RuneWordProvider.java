package svenhjol.charmony.api;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

@SuppressWarnings("unused")
public interface RuneWordProvider {
    /**
     * Gets a list of registered object to register as rune words.
     * @return List of objects to register.
     */
    List<ResourceLocation> getRuneWords();
}
