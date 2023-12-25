package net.xgui4.helloWorld.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;


public class Terminal extends Item {
    public Terminal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (!pContext.getLevel().isClientSide()) {
            assert player != null;
            player.sendSystemMessage((Component.literal("Écriver un commande ici")));
        }
        return InteractionResult.SUCCESS;
    }
};
