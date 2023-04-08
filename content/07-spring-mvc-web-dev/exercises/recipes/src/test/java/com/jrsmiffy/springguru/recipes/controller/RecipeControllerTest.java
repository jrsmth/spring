package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.command.RecipeCommand;
import com.jrsmiffy.springguru.recipes.exception.NotFoundException;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController underTest;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest)
                .setControllerAdvice(new ControllerExceptionHandler()).build();
    }

    @Test
    public void testGetRecipe() throws Exception {
        long id = 1L;

        Recipe recipe = new Recipe();
        recipe.setId(id);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get(String.format("/recipe/%s/show", id)))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void testGetRecipeNotFound() throws Exception {
        when(recipeService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("error/not-found"));
    }

    @Test
    public void testGetRecipeNumberFormatException() throws Exception {
        String notNumber = "notNumber";

        mockMvc.perform(get("/recipe/"+ notNumber + "/show"))
                .andExpect(status().isBadRequest())
                .andExpect(view().name("error/bad-request"));
    }
    // Note :: here we invoke the @ExceptionHandler within our @ControllerAdvice-annotated-class
    // Note :: MockMVC needs to be set up with the @ControllerAdvice-annotated-class

    @Test
    public void testGetNewRecipeForm() throws Exception {
        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipe-form"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void testPostNewRecipeForm() throws Exception {
        RecipeCommand command = new RecipeCommand();
        command.setId(2L);

        when(recipeService.saveRecipeCommand(any())).thenReturn(command);

        mockMvc.perform(post("/recipe")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "3")
                .param("description", "some string")
                .param("directions", "bung it in t' oven"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/show"));
    }

    @Test
    public void testPostNewRecipeFormValidationFail() throws Exception {
        // Given
        when(recipeService.saveRecipeCommand(any()))
                .thenReturn(RecipeCommand.builder().id(1L).build());

        // When
        var result = mockMvc.perform(post("/recipe")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", ""));

        // Then
        result.andExpect(status().is3xxRedirection())
              .andExpect(model().attributeExists("recipe"))
              .andExpect(view().name("recipe/recipe-form"));

    }

    @Test
    public void testGetUpdateView() throws Exception {
        RecipeCommand command = new RecipeCommand();
        command.setId(2L);

        when(recipeService.findCommandById(anyLong())).thenReturn(command);

        mockMvc.perform(get("/recipe/1/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipe-form"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void testDeleteAction() throws Exception {
        // Note :: HTML forms do not allow you to use the DELETE verb (without the use of JavaScript)
        mockMvc.perform(get("/recipe/1/delete")) // Question :: at risk of test leakage with the UPDATE from previous test?
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(recipeService, times(1)).deleteById(anyLong());
    }
}