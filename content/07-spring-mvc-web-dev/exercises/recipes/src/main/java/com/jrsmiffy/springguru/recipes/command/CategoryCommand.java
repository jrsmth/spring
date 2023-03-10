package com.jrsmiffy.springguru.recipes.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String name;
}
