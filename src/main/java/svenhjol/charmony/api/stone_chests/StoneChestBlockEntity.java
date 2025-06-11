package svenhjol.charmony.api.stone_chests;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import svenhjol.charmony.api.secret_chests.SecretChestSideEffects;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface StoneChestBlockEntity {
    void setLootTable(@Nullable ResourceKey<LootTable> lootTable);

    void setChanged();

    void lock(String puzzleMenuId);

    void setUnlockedLootTable(ResourceKey<LootTable> lootTable);

    void setDifficultyAmplifier(int amplifier);

    void setSideEffect(SecretChestSideEffects sideEffect);

    void unlock();

    boolean isLocked();

    ResourceKey<LootTable> getUnlockedLootTable();

    int getDifficultyAmplifier();

    SecretChestSideEffects getSideEffects();

    String puzzleMenuId();

    StoneChestMaterial getMaterial();

    BlockPos getBlockPos();
}
