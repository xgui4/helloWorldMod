package net.xgui4.helloWorld.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().alwaysEat().meat().nutrition(5).fast()
            .saturationMod(10).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5), 1f).build();
}
