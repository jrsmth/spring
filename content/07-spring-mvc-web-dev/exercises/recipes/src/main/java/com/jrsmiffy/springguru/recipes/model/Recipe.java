package com.jrsmiffy.springguru.recipes.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// Note: @Data is equivalent to @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
// Note: @Data is designed to generate all of the boilerplate code for a POJO, not strictly nec. here (getters & setters would do)
// Note: Actually @Data is not recommended for JPA entities due to performance issues
@Entity @Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @Slf4j
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Note: Relies on Hibernate to generate an Id for us
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    private String description;

    @Lob
    private String directions;

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
    // Note :: we use the Wrapper classes for our primitive types in order to allow them to have `null` values
        // Its also the best-practise that is recommended by the Hibernate team

    @OneToOne(cascade = CascadeType.ALL) // Note: We want delete operations on Recipes to cascade to the related Notes (but not the other way round!)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // Note: mappedBy establishes a bidirectional mapping with Ingredient
//    private Set<Ingredient> ingredients; // = new HashSet<>(); // Note: without the helper method, I would have to initialise the Set() here
    private Set<Ingredient> ingredients = new HashSet<>(); // FixMe :: fixes NPE in testSaveOfDescription()

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
        log.info("Using explicit custom setter");
        // Note: explicit setter required here, as we're also setting the reverse relationship on the notes
    }

    /** Helper method to add ingredients */
    public Recipe addIngredient(Ingredient ingredient){
        if (this.ingredients == null) {
            this.ingredients = new HashSet<>();
        }

        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);

        return this;
    }

}