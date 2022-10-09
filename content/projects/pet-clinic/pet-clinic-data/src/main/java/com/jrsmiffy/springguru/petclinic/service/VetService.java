package com.jrsmiffy.springguru.petclinic.service;

import com.jrsmiffy.springguru.petclinic.model.person.Vet;

public interface VetService extends CrudService<Vet,Long> {

    Vet findByLastName(String lastName);

}
