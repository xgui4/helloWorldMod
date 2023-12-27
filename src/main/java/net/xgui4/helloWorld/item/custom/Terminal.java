package net.xgui4.helloWorld.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;


public class Terminal extends Item {
    public Terminal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (pContext.getLevel().isClientSide()) { // vérifier si le niveau est côté client
            assert player != null;
            String event = RandomEvent();
            if (event.equals("Random Sound")) {
                pContext.getLevel().playSound(pContext.getPlayer(), pContext.getPlayer(), SoundEvents.VILLAGER_NO, SoundSource.PLAYERS, 10, 1.0F);
            }
            if (event.equals("TNT Trap")) {
                pContext.getLevel().explode(player,player.getX(),player.getY() + 1,player.getZ(),30, Level.ExplosionInteraction.TNT).finalizeExplosion(true);
                pContext.getLevel().playSound(pContext.getPlayer(), pContext.getPlayer(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 10, 1.0F);
            }
            // Utiliser la méthode setBlockEntity() pour placer l'enclume flottante
            if (event.equals("Anvil Trap")) {
                pContext.getLevel().setBlockAndUpdate(new BlockPos((int) player.getX(), (int) (player.getY() + 20), (int) player.getZ()), Blocks.ANVIL.defaultBlockState());// Placer une enclume flottante à la position cliquée
            }
            if (event.equals("Hello World")) {
                System.out.println("Hello World");
            }
            player.sendSystemMessage((Component.literal(event)));
        }
        return super.useOn(pContext); // retourner le résultat de l'interaction
    }
    private static String RandomEvent(){
        // Créer un tableau de chaînes
        String[] strings = {
                "Random Sound",
                "TNT Trap",
                "Anvil Trap",
                "Hello_World"
        };
        Random random = new Random();
        int index = random.nextInt(strings.length);
        // Renvoyer l'élément du tableau correspondant à l'indice aléatoire
        return strings[index];
    }
    }
