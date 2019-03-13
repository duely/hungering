package com.noobanidus.hungering.recipes.conditions;

import com.google.gson.JsonObject;
import com.noobanidus.hungering.Hungering;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.function.BooleanSupplier;

@SuppressWarnings("unused")
public class ConditionFactory {
    public static class TorcEnabled implements IConditionFactory {

        @Override
        public BooleanSupplier parse(JsonContext context, JsonObject json) {
            return () -> Hungering.CONFIG.RECIPE_ENABLED;
        }
    }
}
