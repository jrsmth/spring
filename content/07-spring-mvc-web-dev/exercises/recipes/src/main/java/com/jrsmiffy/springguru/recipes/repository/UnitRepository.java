package com.jrsmiffy.springguru.recipes.repository;

import com.jrsmiffy.springguru.recipes.model.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit, Long> {

    Optional<Unit> findByName(String name);

}
