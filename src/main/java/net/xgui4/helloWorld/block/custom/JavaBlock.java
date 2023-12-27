package net.xgui4.helloWorld.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class JavaBlock extends Block {
    public JavaBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        Player player = pPlayer;
        assert player != null;
        String msg = RandomString();
        player.sendSystemMessage((Component.literal(msg)));
        return InteractionResult.SUCCESS;
    }

    private static String RandomString() {
        // Créer un tableau de chaînes
        String[] strings = {
                "Hello World",
                "Process finished with exit code -1",
                "error at line 1 : publics static main(String[] args)",
                "unclosed string literal"
        };
        // Créer un objet de la classe Random
        Random random = new Random();
        // Générer un nombre aléatoire entre 0 et la longueur du tableau - 1
        int index = random.nextInt(strings.length);
        // Renvoyer l'élément du tableau correspondant à l'indice aléatoire
        return strings[index];
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.hello_world.terminal.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
