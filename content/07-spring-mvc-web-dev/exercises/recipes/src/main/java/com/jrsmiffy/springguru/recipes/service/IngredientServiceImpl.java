package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.converter.IngredientToIngredientCommand;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor @Slf4j
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()){
            // TODO :: impl error handling
            log.error("[findByRecipeIdAndIngredientId] recipe id not found [{}]", recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map( ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(ingredientCommandOptional.isEmpty()){
            // TODO :: impl error handling
            log.error("[findByRecipeIdAndIngredientId] Ingredient id not found [{}]", ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
