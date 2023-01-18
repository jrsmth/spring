package com.jrsmiffy.springguru.recipes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;
    private Long id = 1L;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        category.setId(id);

        assertEquals(id, category.getId());
    }

    @Test
    public void getName() {
    }

    @Test
    public void getRecipes() {
    }
}