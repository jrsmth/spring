package com.jrsmiffy.springguru.petclinic.repository;

import com.jrsmiffy.springguru.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Question: no @Repository?
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
