package svenhjol.charmony.api;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    /**
     * Chance of a pillar having a block replaced with air.
     *
     * @return Chance of pillar block replacement with air.
     */
    default double decayChance() {
        return 0.4d;
    }

    /**
     * The maximum tolerated height difference from the starting Y position of the pillars.
     * If the terrain is higher than this value the pillar will not be generated.
     * This should be set quite high if the terrain is noisy, for example in the Nether or a rugged overworld biome.
     *
     * @return Maximum tolerated height difference.
     */
    default int terrainHeightTolerance() {
        return 20;
    }

    /**
     * Chance that debris (such as gravel and suspicious blocks) will be placed around and below each pillar.
     *
     * @return Chance of debris.
     */
    default double debrisChance() {
        return 0.4d;
    }

    /**
     * Number of times to try placing a debris block.
     *
     * @return Number of times to try placing a debris block.
     */
    default int debrisRolls() {
        return 10;
    }

    /**
     * How many blocks away from the pillar a debris block should be placed.
     * This affects the X and Z coordinate placement. The Y is hald the terrain height tolerance.
     *
     * @return Range of debris block placement, in blocks.
     */
    default int debrisRange() {
        return 3;
    }

    default BlockPos ceilingReposition(WorldGenLevel level, BlockPos pos) {
        return new BlockPos(pos.getX(), level.getMinY() + 15, pos.getZ());
    }

    default Runnable addAtCenter(WorldGenLevel level, BlockPos pos) {
        return () -> {};
    }

    /**
     * The loot tables to use if a suspicious block is placed.
     *
     * @return List of loot table resource keys.
     */
    default List<ResourceKey<LootTable>> archaeologyLootTables() {
        return List.of(
            BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON,
            BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE
        );
    }

    /**
     * Map of floor blocks to be replaced with another block from a corresponding list.
     * If a suspicious block is placed, a loot table from the archaeologyLootTable() method will be used.
     *
     * @return Map of floor blocks to their potential replacements.
     */
    default Map<Block, List<Block>> floorReplacements() {
        Map<Block, List<Block>> replacements = new HashMap<>();

        replacements.put(Blocks.GRASS_BLOCK, List.of(Blocks.ROOTED_DIRT, Blocks.COARSE_DIRT));
        replacements.put(Blocks.DIRT, List.of(Blocks.GRAVEL, Blocks.SUSPICIOUS_GRAVEL, Blocks.COARSE_DIRT, Blocks.PODZOL));
        replacements.put(Blocks.SAND, List.of(Blocks.SANDSTONE, Blocks.SUSPICIOUS_SAND));
        replacements.put(Blocks.STONE, List.of(Blocks.COBBLESTONE, Blocks.GRAVEL, Blocks.SUSPICIOUS_GRAVEL));
        replacements.put(Blocks.NETHERRACK, List.of(Blocks.MAGMA_BLOCK, Blocks.BLACKSTONE, Blocks.SOUL_SAND));
        replacements.put(Blocks.SOUL_SAND, List.of(Blocks.BLACKSTONE, Blocks.SOUL_SOIL));

        return replacements;
    }

    @Override
    default String getSerializedName() {
        return name();
    }
}
