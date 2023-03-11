package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.converter.IngredientCommandToIngredient;
import com.jrsmiffy.springguru.recipes.converter.IngredientToIngredientCommand;
import com.jrsmiffy.springguru.recipes.model.Ingredient;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import com.jrsmiffy.springguru.recipes.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @RequiredArgsConstructor @Slf4j
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final RecipeRepository recipeRepository;
    private final UnitRepository unitRepository;

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()){
            // TODO :: impl error handling
            log.error("Recipe id not found [{}]", recipeId);
            // Note :: Conventionally, the [methodName] is omitted for log.error()
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map( ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (ingredientCommandOptional.isEmpty()){
            // TODO :: impl error handling
            log.error("Ingredient id not found [{}]", ingredientId);
        }

        return ingredientCommandOptional.get();
    }

    @Override @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());

        if (recipeOptional.isEmpty()){
            // TODO :: impl error handling
            log.error("Recipe not found for id [{}]", command.getRecipeId());
            return new IngredientCommand();
        } else {
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if (ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setQuantity(command.getQuantity());
                ingredientFound.setUnit(unitRepository
                        .findById(command.getUnit().getId())
                        .orElseThrow(() -> new RuntimeException("UNIT NOT FOUND"))); // TODO :: address this
            } else {
                Ingredient ingredient = ingredientCommandToIngredient.convert(command);
                ingredient.setRecipe(recipe); // TODO :: err handle?
                recipe.addIngredient(ingredient);
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
                    .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId()))
                    .findFirst();

            // Check by description
            if (savedIngredientOptional.isEmpty()){
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(recipeIngredients -> recipeIngredients.getDescription().equals(command.getDescription()))
                        .filter(recipeIngredients -> recipeIngredients.getQuantity().equals(command.getQuantity()))
                        .filter(recipeIngredients -> recipeIngredients.getUnit().getId().equals(command.getUnit().getId()))
                        .findFirst();
            }

            // TODO :: err handle?
            return ingredientToIngredientCommand.convert(savedIngredientOptional.get());
        }

    }

    @Override
    public void deleteById(Long recipeId, Long idToDelete) {
        log.debug("[deleteById] Deleting ingredient with id [{}] from recipe with id [{}]", idToDelete, recipeId);
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isPresent()){
            Recipe recipe = recipeOptional.get();
            log.debug("[deleteById] Found recipe");

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(idToDelete))
                    .findFirst();

            if (ingredientOptional.isPresent()){
                log.debug("[deleteById] Found Ingredient");
                Ingredient ingredientToDelete = ingredientOptional.get();
                ingredientToDelete.setRecipe(null);

                recipe.getIngredients().remove(ingredientOptional.get());
                recipeRepository.save(recipe);
            }

        } else {
            log.debug("[deleteById] Can not find recipe with id [{}]", recipeId);
        }
    }

}
