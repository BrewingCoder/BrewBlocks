package com.brewingcoder.brewblocks.block;

import com.brewingcoder.brewblocks.config.Configs;
import com.brewingcoder.brewteamlib.block.OreBlockBase;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

@SuppressWarnings("rawtypes")
public class InfestedOreBlock extends OreBlockBase {

    public InfestedOreBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        super.onPlayerDestroy(worldIn, pos, state);
        if(Configs.WORLD.doesStickyOreSpawnSlime.get()){
            if(Configs.WORLD.doesStickyOreChanceSpawnCreeper.get()){
                int roll = worldIn.getRandom().nextInt(100);
                Entity Spawn;
                if (roll <= Configs.WORLD.StickyOreSpawnCreeperChance.get()){
                    Spawn = EntityType.CREEPER.create(worldIn.getWorld());
                }else{
                    Spawn = EntityType.SLIME.create(worldIn.getWorld());
                }
                if (Spawn != null) {
                    Spawn.setPosition(pos.getX(),pos.getY(),pos.getZ());
                    worldIn.addEntity(Spawn);
                }
            }
        }
    }
}
