package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitToUnitCommand uomConverter;

    public IngredientToIngredientCommand(UnitToUnitCommand unitConverter) {
        this.uomConverter = unitConverter;
    }

    @Synchronized @Nullable @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient == null) return null;

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        if (ingredient.getRecipe() != null) ingredientCommand.setRecipeId(ingredient.getRecipe().getId());
        ingredientCommand.setQuantity(ingredient.getQuantity());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUnit(uomConverter.convert(ingredient.getUnit()));
        return ingredientCommand;

    }
}