package com.jrsmiffy.springguru.recipes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        final Long id = 1L;
        category.setId(id);

        assertEquals(id, category.getId());
    }

}