package svenhjol.charmony.api;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public interface RunestoneDefinition {
    Supplier<? extends Block> runestoneBlock();

    Supplier<? extends Block> baseBlock();

    Optional<RunestoneLocation> location(LevelAccessor level, BlockPos pos, RandomSource random);

    Supplier<ItemLike> sacrifice(LevelAccessor level, BlockPos pos, RandomSource random);
}