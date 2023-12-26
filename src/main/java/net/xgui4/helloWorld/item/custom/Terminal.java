package net.xgui4.helloWorld.item.custom;

import net.minecraft.client.telemetry.events.WorldLoadEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import java.util.Random;


public class Terminal extends Item {
    public Terminal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (!pContext.getLevel().isClientSide()) {
            assert player != null;
            String msg = RandomString();
            String event = RandomEvent();

            player.sendSystemMessage((Component.literal(event));
            player.sendSystemMessage((Component.literal(msg)));

        }
        return InteractionResult.SUCCESS;
    }

    private static String RandomString(){
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
    private static void RandomEvent(){
        // Créer un tableau de chaînes
        String[] strings = {
                "Day/Night Cycle",
                "TNT Trap",
                "Anvil Trap",
                "Hello_World"
        };
    }
    }
