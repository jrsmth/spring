package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/** Unit Test for {@link IndexController} */
public class IndexControllerTest {

    private IndexController underTest;

    @Mock private RecipeService mockService;
    @Mock private Model model;

    private static final String TEMPLATE = "index";

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new IndexController(mockService);
    }

    @Test
    public void getIndexPage() {
        // given
        final Set<Recipe> recipes = Set.of(new Recipe(), new Recipe());

        // when
        when(mockService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String result = underTest.getIndexPage(model);

        // then
        assertEquals(TEMPLATE, result);

        verify(mockService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> recipesArgument = argumentCaptor.getValue();
        assertEquals(2, recipesArgument.size());

    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(TEMPLATE));
    }

}