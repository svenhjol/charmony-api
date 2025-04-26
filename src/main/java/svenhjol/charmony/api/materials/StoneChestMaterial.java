package svenhjol.charmony.api.materials;

import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;

import java.util.Locale;
import java.util.function.IntFunction;

/**
 * Materials for stone chests.
 */
@SuppressWarnings({"NullableProblems", "unused"})
public enum StoneChestMaterial implements StringRepresentable {
    STONE(0, "stone", DyeColor.LIGHT_GRAY),
    DEEPSLATE(1, "deepslate", DyeColor.GRAY),
    PRISMARINE(2, "prismarine", DyeColor.CYAN),
    BLACKSTONE(3, "blackstone", DyeColor.BLACK),
    NETHER_BRICK(4, "nether_brick", DyeColor.BROWN),
    PURPUR(5, "purpur", DyeColor.PINK);

    public static final EnumCodec<StoneChestMaterial> CODEC = StringRepresentable.fromEnum(StoneChestMaterial::values);
    public static final IntFunction<StoneChestMaterial> BY_ID = ByIdMap.continuous(StoneChestMaterial::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

    private final int id;
    private final String name;
    private final DyeColor color;

    StoneChestMaterial(int id, String name, DyeColor color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public static StoneChestMaterial byId(int id) {
        return BY_ID.apply(id);
    }

    public int getId() {
        return id;
    }

    public DyeColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSerializedName() {
        return name.toLowerCase(Locale.ROOT);
    }
}
