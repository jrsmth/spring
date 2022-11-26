package com.jrsmiffy.springguru.recipes.repository;

import com.jrsmiffy.springguru.recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
