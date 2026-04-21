package com.brewingcoder.brewblocks.block;

import com.brewingcoder.brewblocks.config.Configs;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.valueproviders.UniformInt;

public class StickyOreBlock extends DropExperienceBlock {
    public StickyOreBlock(Properties properties) {
        super(UniformInt.of(0, 2), properties);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state,
                              BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        if (!(level instanceof ServerLevel serverLevel)) return;
        if (!Configs.WORLD.doesStickyOreSpawnSlime.get()) return;

        Entity spawn;
        if (Configs.WORLD.doesStickyOreChanceSpawnCreeper.get()
                && level.random.nextInt(100) < Configs.WORLD.stickyOreSpawnCreeperChance.get()) {
            spawn = EntityType.CREEPER.create(level);
        } else {
            spawn = EntityType.SLIME.create(level);
            if (spawn instanceof Slime slime) {
                slime.setSize(2, true);
            }
        }
        if (spawn == null) return;
        spawn.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0f, 0f);
        if (spawn instanceof Creeper || spawn instanceof Slime) {
            serverLevel.addFreshEntity(spawn);
        }
    }
}
