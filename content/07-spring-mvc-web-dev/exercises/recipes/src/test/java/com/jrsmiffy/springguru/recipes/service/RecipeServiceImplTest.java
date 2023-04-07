package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.RecipeCommand;
import com.jrsmiffy.springguru.recipes.converter.RecipeCommandToRecipe;
import com.jrsmiffy.springguru.recipes.converter.RecipeToRecipeCommand;
import com.jrsmiffy.springguru.recipes.exception.NotFoundException;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class RecipeServiceImplTest {

    private RecipeServiceImpl underTest;

    @Mock private RecipeRepository mockRepository;
    @Mock RecipeToRecipeCommand toCommand;
    @Mock RecipeCommandToRecipe fromCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new RecipeServiceImpl(mockRepository, fromCommand, toCommand);
    }

    @Test
    public void getRecipes() {
        // given
        Recipe recipe = new Recipe();
        Set<Recipe> recipes = Set.of(recipe);

        // when
        when(mockRepository.findAll()).thenReturn(recipes);

        Set<Recipe> result = underTest.getRecipes();

        // then
        assertEquals(result.size(), 1);

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    public void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(mockRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = underTest.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(mockRepository, times(1)).findById(anyLong());
        verify(mockRepository, never()).findAll();
    }

    @Test
    public void getRecipeCommandByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(mockRepository.findById(anyLong())).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        when(toCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand commandById = underTest.findCommandById(1L);

        assertNotNull("Null recipe returned", commandById);
        verify(mockRepository, times(1)).findById(anyLong());
        verify(mockRepository, never()).findAll();
    }

    @Test
    public void testDeleteById() throws Exception {
        // Given
        Long idToDelete = 2L;

        // When
        underTest.deleteById(idToDelete);

        //no 'when', since method has void return type

        // Then
        verify(mockRepository, times(1)).deleteById(anyLong());
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() {
        // Given
        Optional<Recipe> emptyRecipe = Optional.empty();

        // When
        when(mockRepository.findById(anyLong())).thenReturn(emptyRecipe);

        // Then
        underTest.findById(1L);
        // Note :: NotFoundException expected
    }

    @Test(expected = NumberFormatException.class)
    public void getRecipeByIdTestNumberFormatException() {
        underTest.findById(Long.valueOf("notNumber"));
        // Note :: NumberFormatException expected
    }

}