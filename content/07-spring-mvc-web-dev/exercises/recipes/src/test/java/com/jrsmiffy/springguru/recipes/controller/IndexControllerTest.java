package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** Unit Test for {@link IndexController} */
public class IndexControllerTest {

    private IndexController underTest;

    @Mock private RecipeService mockService;
    @Mock private Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new IndexController(mockService);
    }

    @Test
    public void getIndexPage() {
        // given
        final String template = "index";

        // when
        when(mockService.getRecipes()).thenReturn(Set.of());

        String result = underTest.getIndexPage(model);

        // then
        assertEquals(template,result);

        verify(mockService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());

    }

}