package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.command.UnitCommand;
import com.jrsmiffy.springguru.recipes.model.Ingredient;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = new Long(1L);
    public static final Long UNIT_ID = new Long(2L);

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitCommandToUnit());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setQuantity(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitCommand unitCommand = new UnitCommand();
        unitCommand.setId(UNIT_ID);
        command.setUnit(unitCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUnit());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getQuantity());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UNIT_ID, ingredient.getUnit().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setQuantity(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitCommand unitCommand = new UnitCommand();


        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUnit());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getQuantity());
        assertEquals(DESCRIPTION, ingredient.getDescription());

    }

}