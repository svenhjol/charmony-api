package svenhjol.charmony.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public record RunestoneLocation(Type type, ResourceLocation id) {
    public static final String TYPE_TAG = "type";
    public static final String ID_TAG = "id";

    public boolean is(RunestoneLocation location) {
        return type.equals(location.type()) && id.equals(location.id());
    }

    public CompoundTag save() {
        var tag = new CompoundTag();
        tag.putString(TYPE_TAG, type().name());
        tag.putString(ID_TAG, id().toString());
        return tag;
    }

    public static RunestoneLocation load(CompoundTag tag) {
        var typeString = tag.getString(TYPE_TAG).orElseThrow();
        var idString = tag.getString(ID_TAG).orElseThrow();

        var type = Type.valueOf(typeString);
        var id = ResourceLocation.parse(idString);
        return new RunestoneLocation(type, id);
    }

    public enum Type {
        Biome,
        Player,
        Structure
    }
}
