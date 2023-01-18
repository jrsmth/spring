package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    private RecipeServiceImpl underTest;

    @Mock
    private RecipeRepository mockRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new RecipeServiceImpl(mockRepository);
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

}