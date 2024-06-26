package me.officiallydragon.endified.datagen;

import me.officiallydragon.endified.block.ModBlocks;
import me.officiallydragon.endified.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.ORE_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.ENDINIUM_DEBRIS)
                .add(ModBlocks.SULFUR_ORE)


                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ENDINIUM_DEBRIS)
                .add(ModBlocks.ENDINIUM_BLOCK)
                .add(ModBlocks.SULFUR_ORE)
                .add(ModBlocks.END_STONE_WALL)
                .add(ModBlocks.END_STONE_SLAB)
                .add(ModBlocks.END_STONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.END_STONE_WALL)
                .add(ModBlocks.END_STONE_SLAB)
                .add(ModBlocks.END_STONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENDINIUM_DEBRIS)
                .add(ModBlocks.ENDINIUM_BLOCK)
                .add(ModBlocks.SULFUR_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));
                //Add netherite required block here

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")));
                //Add endinium required block here

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.END_STONE_STAIRS);

         getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.END_STONE_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.END_STONE_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.DAHLIA_PLACEABLE)
                .add(Blocks.END_STONE);

    }
}
