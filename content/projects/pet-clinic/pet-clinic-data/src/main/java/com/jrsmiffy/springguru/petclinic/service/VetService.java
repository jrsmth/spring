package com.jrsmiffy.springguru.petclinic.service;

import com.jrsmiffy.springguru.petclinic.model.person.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long> {
    
    Vet findByLastName(String lastName);

}
