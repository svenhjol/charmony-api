package svenhjol.charmony.api.stone_chests;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import svenhjol.charmony.api.secret_chests.SecretChestSideEffects;

@SuppressWarnings("unused")
public interface StoneChestBlockEntity {
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
}
