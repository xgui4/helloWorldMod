package net.xgui4.helloWorld.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.Event;

import java.awt.*;

public class RadiumOreBlock extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
    private final boolean spawnParticles;
    private final int fireDamage;

    public RadiumOreBlock(boolean pSpawnParticles, int pFireDamage, BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.spawnParticles = pSpawnParticles;
        this.fireDamage = pFireDamage;
    }
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {{
            pEntity.hurt(pLevel.damageSources().inFire(), (float)this.fireDamage);
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
            if (pRandom.nextInt(10) == 0) {
                pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 0.5F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.6F, false);
            }
            if (this.spawnParticles && pRandom.nextInt(5) == 0) {
                for(int i = 0; i < pRandom.nextInt(1) + 1; ++i) {
                    pLevel.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, (double)(pRandom.nextFloat() / 2.0F), 5.0E-5D, (double)(pRandom.nextFloat() / 2.0F));
                    makeParticles(pLevel, pPos, true);
                }
            }
    }

    public static void makeParticles(Level pLevel, BlockPos pPos, boolean pIsSignalFire) {
        RandomSource randomsource = pLevel.getRandom();
        SimpleParticleType simpleparticletype = pIsSignalFire ? ParticleTypes.SONIC_BOOM: ParticleTypes.SMOKE;
        pLevel.addAlwaysVisibleParticle(simpleparticletype, true, (double)pPos.getX() + 0.5D + randomsource.nextDouble() / 3.0D * (double)(randomsource.nextBoolean() ? 1 : -1), (double)pPos.getY() + randomsource.nextDouble() + randomsource.nextDouble(), (double)pPos.getZ() + 0.5D + randomsource.nextDouble() / 3.0D * (double)(randomsource.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        pLevel.addParticle(ParticleTypes.SQUID_INK, (double)pPos.getX() + 0.5D + randomsource.nextDouble() / 4.0D * (double)(randomsource.nextBoolean() ? 1 : -1), (double)pPos.getY() + 0.4D, (double)pPos.getZ() + 0.5D + randomsource.nextDouble() / 4.0D * (double)(randomsource.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT, SIGNAL_FIRE);
    }

}
