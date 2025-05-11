package svenhjol.charmony.api.glint_colors;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unused")
public final class GlintColorsApi {
    private static GlintColorsApi instance;

    private BiConsumer<ItemStack, DyeColor> applyImpl;
    private Function<ItemStack, Boolean> hasImpl;
    private Consumer<ItemStack> removeImpl;
    private Function<ItemStack, Optional<DyeColor>> getColorImpl;

    private GlintColorsApi() {
        applyImpl = (stack, color) -> {};
        hasImpl = stack -> false;
        removeImpl = stack -> {};
        getColorImpl = stack -> Optional.empty();
    }

    public static GlintColorsApi instance() {
        if (instance == null) {
            instance = new GlintColorsApi();
        }
        return instance;
    }

    public void apply(ItemStack stack, DyeColor color) {
        applyImpl.accept(stack, color);
    }

    public boolean has(ItemStack stack) {
        return hasImpl.apply(stack);
    }

    public void remove(ItemStack stack) {
        removeImpl.accept(stack);
    }

    public Optional<DyeColor> getColor(ItemStack stack) {
        return getColorImpl.apply(stack);
    }

    public void setApplyImpl(BiConsumer<ItemStack, DyeColor> impl) {
        this.applyImpl = impl;
    }

    public void setGetColorImpl(Function<ItemStack, Optional<DyeColor>> impl) {
        this.getColorImpl = impl;
    }

    public void setHasImpl(Function<ItemStack, Boolean> impl) {
        this.hasImpl = impl;
    }

    public void setRemoveImpl(Consumer<ItemStack> impl) {
        this.removeImpl = impl;
    }
}
