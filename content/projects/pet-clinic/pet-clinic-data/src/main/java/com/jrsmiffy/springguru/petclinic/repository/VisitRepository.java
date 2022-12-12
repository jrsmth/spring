package com.jrsmiffy.springguru.petclinic.repository;

import com.jrsmiffy.springguru.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}