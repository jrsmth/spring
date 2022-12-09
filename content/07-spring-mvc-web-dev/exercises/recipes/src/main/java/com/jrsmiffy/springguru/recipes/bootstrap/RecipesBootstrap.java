package com.jrsmiffy.springguru.recipes.bootstrap;

import com.jrsmiffy.springguru.recipes.model.Category;
import com.jrsmiffy.springguru.recipes.model.Difficulty;
import com.jrsmiffy.springguru.recipes.model.Ingredient;
import com.jrsmiffy.springguru.recipes.model.Notes;
import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.model.Unit;
import com.jrsmiffy.springguru.recipes.repository.CategoryRepository;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import com.jrsmiffy.springguru.recipes.repository.UnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component @Slf4j
public class RecipesBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    public RecipesBootstrap(
            @Qualifier("guacamoleDirections") String guacamoleDirections,
            @Qualifier("tacoDirections") String tacoDirections, // Note: Lombok does not copy @Qualifier into the constructor
            CategoryRepository categoryRepository,
            RecipeRepository recipeRepository,
            UnitRepository unitRepository) {
        this.guacamoleDirections = guacamoleDirections;
        this.tacoDirections = tacoDirections;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitRepository = unitRepository;
    }

    private final String guacamoleDirections;

    private final String tacoDirections;

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitRepository unitRepository;

    @Override @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
        log.info("Bootstrapping Recipes Data");
    }

    private List<Recipe> getRecipes() {

        Map<String, Unit> units = getUnits();
        Map<String, Category> categories = getCategories();

        // Yummy Guacamole
        Recipe guacamole = Recipe.builder()
                .description("Perfect Guacamole")
                .difficulty(Difficulty.LOW)
                .directions(guacamoleDirections)
                .prepMins(10)
                .cookMins(0)
                .note(new Notes("To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip."))
                .source("Simply Recipes")
                .servings(4)
                .categories(Set.of(categories.get("American"), categories.get("Mexican")))
                .url("https://www.simplyrecipes.com/recipes/perfect_guacamole/")
                .build();

        guacamole.addIngredient(new Ingredient("Ripe avocados", new BigDecimal(2), units.get("Each")));
        guacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), units.get("Teaspoon")));
        guacamole.addIngredient(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(2), units.get("Tablespoon")));
        guacamole.addIngredient(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), units.get("Tablespoon")));
        guacamole.addIngredient(new Ingredient("Serrano chilies, stems and seeds removed, minced", new BigDecimal(2), units.get("Each")));
        guacamole.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), units.get("Tablespoon")));
        guacamole.addIngredient(new Ingredient("Freshly grated black pepper", new BigDecimal(2), units.get("Dash")));
        guacamole.addIngredient(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), units.get("Each")));

        // Yummy Tacos
        Recipe tacos = Recipe.builder()
                .description("Spicy Grilled Chicken Taco")
                .difficulty(Difficulty.MEDIUM)
                .directions(tacoDirections)
                .prepMins(20)
                .cookMins(10)
                .note(new Notes("We have a family motto and it is this: Everything goes better in a tortilla. Any and every kind of leftover can go inside a warm tortilla"))
                .source("Simply Recipes")
                .servings(6)
                .categories(Set.of(categories.get("American"), categories.get("Mexican")))
                .url("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/")
                .build();

        tacos.addIngredient(new Ingredient("Chilli Powder", new BigDecimal(2), units.get("Tablespoon")));
        tacos.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), units.get("Teaspoon")));
        tacos.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), units.get("Teaspoon")));
        tacos.addIngredient(new Ingredient("Sugar", new BigDecimal(1), units.get("Teaspoon")));
        tacos.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), units.get("Teaspoon")));
        tacos.addIngredient(new Ingredient("Clove of Garlic, Chopped", new BigDecimal(1), units.get("Each")));
        tacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), units.get("Tablespoon")));
        tacos.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), units.get("Tablespoon")));
        tacos.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), units.get("Tablespoon")));
        tacos.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), units.get("Tablespoon")));
        tacos.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), units.get("Each")));
        tacos.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), units.get("Cup")));
        tacos.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), units.get("Each")));
        tacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), units.get("Each")));
        tacos.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), units.get("Pint")));
        tacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), units.get("Each")));
        tacos.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), units.get("Each")));
        tacos.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), units.get("Cup")));
        tacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), units.get("Each")));

        return List.of(guacamole, tacos);

    }

    private Map<String, Unit> getUnits() {
        Map <String, Unit> units = new HashMap<>();
        List<String> names = List.of("Each", "Tablespoon", "Teaspoon", "Dash", "Pint", "Cup");

        for (String name : names) {
            try {
                Optional<Unit> unitOptional = unitRepository.findByName(name);

                if (unitOptional.isPresent()) {
                    units.put(name, unitOptional.get());

                } else {
                    throw new RuntimeException(String.format("Expected unit '%s' can not be found!", name));

                }
            } catch (Exception e) {
                log.error(e.toString());

            }
        }

        return units;
    }

    private Map<String, Category> getCategories() {
        Map <String, Category> categories = new HashMap<>();
        List<String> names = List.of("American", "Mexican");

        for (String name : names) {
            try {
                Optional<Category> categoryOptional = categoryRepository.findByName(name);

                if (categoryOptional.isPresent()) {
                    categories.put(name, categoryOptional.get());

                } else {
                    throw new RuntimeException("Expected category not found!");

                }
            } catch (Exception e) {
                log.error(e.toString());

            }
        }

        return categories;
    }


}