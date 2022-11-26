package com.jrsmiffy.springguru.recipes.repository;

import com.jrsmiffy.springguru.recipes.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
