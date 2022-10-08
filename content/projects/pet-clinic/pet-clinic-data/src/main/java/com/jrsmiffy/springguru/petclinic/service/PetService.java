package com.jrsmiffy.springguru.petclinic.service;

import com.jrsmiffy.springguru.petclinic.model.pet.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
