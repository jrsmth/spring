package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.command.RecipeCommand;
import com.jrsmiffy.springguru.recipes.service.IngredientService;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import com.jrsmiffy.springguru.recipes.service.UnitService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IngredientControllerTest {

    @Mock RecipeService recipeService;
    @Mock IngredientService ingredientService;
    @Mock UnitService unitService;


    IngredientController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        controller = new IngredientController(recipeService, ingredientService, unitService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testListIngredients() throws Exception {
        // Given
        RecipeCommand recipeCommand = new RecipeCommand();
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        // When
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        // Then
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testShowIngredient() throws Exception {
        // Given
        IngredientCommand ingredientCommand = new IngredientCommand();

        // When
        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);

        // Then
        mockMvc.perform(get("/recipe/1/ingredient/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/show"))
                .andExpect(model().attributeExists("ingredient"));
    }

    @Test
    public void testNewIngredientForm() throws Exception {
        // Given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        // When
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);
        when(unitService.listAllUnits()).thenReturn(new HashSet<>());

        // Then
        mockMvc.perform(get("/recipe/1/ingredient/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredient-form"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("unitList"));

        verify(recipeService, times(1)).findCommandById(anyLong());

    }

    @Test
    public void testUpdateIngredientForm() throws Exception {
        // Given
        IngredientCommand ingredientCommand = new IngredientCommand();

        // When
        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);
        when(unitService.listAllUnits()).thenReturn(new HashSet<>());

        // Then
        mockMvc.perform(get("/recipe/1/ingredient/2/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredient-form"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("unitList"));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        // Given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        // When
        when(ingredientService.saveIngredientCommand(any())).thenReturn(command);

        // Then
        mockMvc.perform(post("/recipe/2/ingredient")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "")
                        .param("description", "some string")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredient/3/show"));

    }

}