package com.jrsmiffy.springguru.petclinic.repository;

import com.jrsmiffy.springguru.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
