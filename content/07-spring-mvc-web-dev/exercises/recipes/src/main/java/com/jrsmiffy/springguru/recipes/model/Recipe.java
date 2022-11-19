package com.jrsmiffy.springguru.recipes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Data // Note: Equivalent to @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
// Note: @Data is designed to generate all of the boilerplate code for a POJO, not strictly nec. here (getters & setters would do)
// Note: Actually @Data is not recommended for JPA entities due to performance issues
@Entity @Getter @Setter
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Note: Relies on Hibernate to generate an Id for us
    private Long id;

    private String description;
    private Integer prepMins;
    private Integer cookMins;
    private Integer servings;
    private String source;
    private String url;
    private Difficulty difficulty;

    @Lob // Note: Defines a BLOB (Binary Large Object)
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) // Note: We want delete operations on Recipes to cascade to the related Notes (but not the other way round!)
    private Notes note;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // Note: mappedBy establishes a bidirectional mapping with Ingredient
    private Set<Ingredient> ingredients;

}