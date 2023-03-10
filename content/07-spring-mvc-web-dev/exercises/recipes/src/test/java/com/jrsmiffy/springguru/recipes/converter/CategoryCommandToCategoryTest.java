package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.CategoryCommand;
import com.jrsmiffy.springguru.recipes.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String NAME = "name";
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setName(NAME);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assert category != null;
        assertEquals(ID_VALUE, category.getId());
        assertEquals(NAME, category.getName());
    }

}