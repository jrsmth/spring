package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeControllerIT {

    @Autowired
    RecipeService recipeService;

    RecipeController underTest;
    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new RecipeController(recipeService);

        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldCreateRecipe() throws Exception {
        // Given
        long id = 3L; // Note :: Slight tight-coupling, we are bootstrapping two recipes at runtime and so this recipe will be #3
        String source = "Tradition";

        // When
        mockMvc.perform(post("/recipe/")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("id", "")
                        .param("description", "Porridge")
                        .param("prepMins", "2")
                        .param("cookMins", "3") // Note :: Integer field, will throw a wobbler if you send '3.5' [org.springframework.validation.BindException]
                        .param("servings", "1")
                        .param("source", source)
                        .param("url", "http%3A%2F%2Ftradition.org") // http://tradition.org
                        .param("directions", "Shuv+it+in+t%27microwave") // Shuv it in t'microwave
                        .param("notes.content", "Goes+well+with+a+healthy+spoonful+of+jam"))
                .andDo(print())
//                .andExpect(status().isCreated())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(String.format("redirect:/recipe/%s/show", id)));

        // Then
        Recipe savedRecipe = recipeService.findById(id);
        assertEquals(source, savedRecipe.getSource());

    }

}

