package me.officiallydragon.endified.block.custom;

import me.officiallydragon.endified.block.ModBlocks;
import me.officiallydragon.endified.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EndifiedVinesBodyBlock
extends AbstractPlantBlock
implements Fertilizable,
        EndifiedVines {
    public EndifiedVinesBodyBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BERRIES, false));
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) ModBlocks.ENDIFIED_VINES;
    }

    @Override
    protected BlockState copyState(BlockState from, BlockState to) {
        return (BlockState)to.with(BERRIES, from.get(BERRIES));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.END_BERRIES);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return EndifiedVines.pickBerries(player, state, world, pos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BERRIES);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(BERRIES) == false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(BERRIES, true), Block.NOTIFY_LISTENERS);
    }
}

