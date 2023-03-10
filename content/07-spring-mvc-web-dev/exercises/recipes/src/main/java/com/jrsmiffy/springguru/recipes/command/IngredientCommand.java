package com.jrsmiffy.springguru.recipes.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal quantity;
    private UnitCommand unit;

}
