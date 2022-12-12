package com.jrsmiffy.springguru.petclinic.repository;

import com.jrsmiffy.springguru.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
