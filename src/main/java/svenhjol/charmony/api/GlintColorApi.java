package svenhjol.charmony.api;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unused")
public class GlintColorApi {
    private static GlintColorApi instance;
    private BiConsumer<ItemStack, DyeColor> apply = (i, d) -> {};
    private Function<ItemStack, Boolean> has = i -> false;
    private Consumer<ItemStack> remove = i -> {};

    private GlintColorApi() {}

    public static GlintColorApi instance() {
        if (instance == null) {
            instance = new GlintColorApi();
        }
        return instance;
    }

    public void apply(ItemStack stack, DyeColor color) {
        apply.accept(stack, color);
    }

    public boolean has(ItemStack stack) {
        return has.apply(stack);
    }

    public void remove(ItemStack stack) {
        remove.accept(stack);
    }

    public void setApply(BiConsumer<ItemStack, DyeColor> apply) {
        this.apply = apply;
    }

    public void setHas(Function<ItemStack, Boolean> has) {
        this.has = has;
    }

    public void setRemove(Consumer<ItemStack> remove) {
        this.remove = remove;
    }
}
