package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.CategoryCommand;
import com.jrsmiffy.springguru.recipes.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String NAME = "name";
    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setName(NAME);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assert categoryCommand != null;
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(NAME, categoryCommand.getName());

    }

}