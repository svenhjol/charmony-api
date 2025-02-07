package svenhjol.charmony.api;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.LinkedList;

@SuppressWarnings("unused")
public interface RunicPower {
    String id();

    Mode mode();

    /**
     * Setup event listeners.
     */
    default void init() {
        // no op
    }

    /**
     * Fired when the power is first activated.
     */
    default void activate(Player player) {
        // no op
    }

    /**
     * Fired when the power is directly or indirectly deactivated.
     */
    default void deactivate(Player player) {
        // no op
    }

    /**
     * Fired every time this power consumes a resource.
     */
    default void consume(Player player) {
        // no op
    }

    /**
     * Fired every player tick.
     */
    default void tick(Player player) {
        // no op
    }

    /**
     * Check if this power is still valid.
     * The power can set this to false to be automatically deactivated by the ticker.
     */
    default boolean isValid(Player player) {
        return true;
    }

    /**
     * For continuous powers this is the interval at which a resource will be consumed to keep the power active.
     * For one-shot powers this is the cooldown period.
     */
    default int interval() {
        return 40;
    }

    /**
     * The default translation key.
     */
    default Component component() {
        return Component.translatable("power.charmony-runic-tomes." + id());
    }

    /**
     * Color used for the power's name in the HUD.
     */
    default int textColor() {
        return 0xffffff;
    }

    /**
     * List of resources to be consumed to activate or maintain the power.
     * This is a prioritised list of resources. The first item is attempted, falling back to the second and so on.
     * Use the itemstack's count attribute to define how many of the item will be consumed.
     */
    default LinkedList<ItemStack> resources() {
        LinkedList<ItemStack> list = new LinkedList<>();
        list.add(new ItemStack(Items.DIRT, 1));
        list.add(new ItemStack(Items.COBBLESTONE, 1));
        return list;
    }

    /**
     * Default item registration ID.
     */
    default String pageId() {
        return "page_of_" + id();
    }

    enum Mode {
        OneShot,
        Continous
    }

    RunicPower EMPTY = new RunicPower() {
        @Override
        public String id() {
            return "empty";
        }

        @Override
        public Mode mode() {
            return Mode.OneShot;
        }
    };
}
