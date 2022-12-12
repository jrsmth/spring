package com.jrsmiffy.springguru.petclinic.repository;

import com.jrsmiffy.springguru.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
