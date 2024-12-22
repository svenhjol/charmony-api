package svenhjol.charmony.api;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings({"NullableProblems", "unused"})
public interface StoneCircleDefinition extends StringRepresentable {
    String name();

    TagKey<Block> pillarBlocks();

    Optional<Supplier<? extends Block>> runestoneBlock();

    default Pair<Integer, Integer> pillarHeight() {
        return Pair.of(4, 8);
    }

    default Pair<Integer, Integer> pillarThickness() { return Pair.of(1, 1); }

    default Pair<Integer, Integer> radius() {
        return Pair.of(6, 15);
    }

    default Pair<Integer, Integer> degrees() {
        return Pair.of(45, 45);
    }

    default int circleJitter() {
        return 0;
    }

    default int maxRunestonesPerPillar() {
        return 2;
    }

    default int maxRunestonesPerCircle() {
        return 8;
    }

    default double runestoneChance() {
        return 0.72d;
    }

    default double runestoneQuality() {
        return 0d;
    }

    default double decayChance() {
        return 0.4d;
    }

    default BlockPos ceilingReposition(WorldGenLevel level, BlockPos pos) {
        return new BlockPos(pos.getX(), level.getMinY() + 15, pos.getZ());
    }

    default Runnable addAtCenter(WorldGenLevel level, BlockPos pos) {
        return () -> {};
    }

    default int terrainHeightTolerance() {
        return 20;
    }

    @Override
    default String getSerializedName() {
        return name();
    }
}
