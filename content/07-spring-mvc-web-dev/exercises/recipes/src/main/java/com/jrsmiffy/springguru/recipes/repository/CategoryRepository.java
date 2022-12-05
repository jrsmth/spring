package com.jrsmiffy.springguru.recipes.repository;

import com.jrsmiffy.springguru.recipes.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);
    // Note: This is called a 'Query Method'
    // Note: Spring Data JPA will handle the Hibernate plumbing behind the scenes and implement this for us
    // Question: What is the equivalent implementation if you do it yourself?

    // Note: Use of Optional<T> was added in Spring 5

}
