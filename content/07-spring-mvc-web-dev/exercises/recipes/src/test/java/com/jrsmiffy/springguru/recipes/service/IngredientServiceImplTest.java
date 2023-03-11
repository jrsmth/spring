package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.converter.IngredientCommandToIngredient;
import com.jrsmiffy.springguru.recipes.converter.IngredientToIngredientCommand;
import com.jrsmiffy.springguru.recipes.converter.UnitCommandToUnit;
import com.jrsmiffy.springguru.recipes.converter.UnitToUnitCommand;
import com.jrsmiffy.springguru.recipes.model.Ingredient;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import com.jrsmiffy.springguru.recipes.repository.UnitRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IngredientServiceImplTest {

    private final IngredientToIngredientCommand toCommand;
    private final IngredientCommandToIngredient fromCommand;

    @Mock RecipeRepository recipeRepository;
    @Mock UnitRepository unitRepository;

    IngredientService ingredientService;

    // Init converters
    public IngredientServiceImplTest() {
        this.toCommand = new IngredientToIngredientCommand(new UnitToUnitCommand());
        this.fromCommand = new IngredientCommandToIngredient(new UnitCommandToUnit());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        ingredientService = new IngredientServiceImpl(toCommand, fromCommand, recipeRepository, unitRepository);
    }

    @Test
    public void findByRecipeIdAndId() throws Exception {}

    @Test
    public void findByRecipeIdAndRecipeIdHappyPath() throws Exception {
        // Given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // When
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        // Then
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());

    }

    @Test
    public void testDeleteById() throws Exception {
        // Given
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(3L);
        recipe.addIngredient(ingredient);
        ingredient.setRecipe(recipe);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // When
        ingredientService.deleteById(1L, 3L);

        // Then
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

}