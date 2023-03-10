package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitCommandToUnit unitConverter;

    public IngredientCommandToIngredient(UnitCommandToUnit unitConverter) {
        this.unitConverter = unitConverter;
    }

    @Synchronized @Nullable @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) return null;

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setQuantity(source.getQuantity());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnit(unitConverter.convert(source.getUnit()));
        return ingredient;
    }
}