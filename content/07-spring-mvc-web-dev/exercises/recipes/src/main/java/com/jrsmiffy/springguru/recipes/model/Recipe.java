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

    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    private String description;

    @Enumerated(value = EnumType.STRING)
    // Note: the value of an enum field defaults to ORDINAL (0, 1, 2, ...) but STRING will persist the exact value (EASY)
    // Note: this is useful, if we choose to add new values that would disturb the ORDINAL sequence (ex: EASY, MED, KINDA_HARD, HARD)
    private Difficulty difficulty;

    private Integer prepMins;
    private Integer cookMins;
    private Integer servings;
    private String source;
    private String url;

    @Lob // Note: Defines a BLOB (Binary Large Object)
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) // Note: We want delete operations on Recipes to cascade to the related Notes (but not the other way round!)
    private Notes note;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // Note: mappedBy establishes a bidirectional mapping with Ingredient
    private Set<Ingredient> ingredients;

}