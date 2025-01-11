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

    default void activate(Player player) {
        // no op
    }

    default void deactivate(Player player) {
        // no op
    }

    default void tick(Player player) {
        // no op
    }

    default int interval() {
        return 40;
    }

    default Component component() {
        return Component.translatable("power.charmony-runic-tomes." + id());
    }

    default int textColor() {
        return 0xffffff;
    }

    default LinkedList<ItemStack> resources() {
        LinkedList<ItemStack> list = new LinkedList<>();
        list.add(new ItemStack(Items.DIRT, 1));
        list.add(new ItemStack(Items.COBBLESTONE, 1));
        return list;
    }

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
