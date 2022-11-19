package com.jrsmiffy.springguru.recipes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity @Getter @Setter
public class Ingredient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal quantity;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private Unit unit;

}
