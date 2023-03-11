package com.jrsmiffy.springguru.recipes.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private Long recipeId; // Note :: used in the template as hidden <input> value in the form
    private String description;
    private BigDecimal quantity;
    private UnitCommand unit;

}
