package com.jrsmiffy.springguru.recipes.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UnitCommand {
    private Long id;
    private String name;
}