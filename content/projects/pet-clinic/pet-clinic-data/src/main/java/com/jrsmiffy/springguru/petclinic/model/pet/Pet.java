package com.jrsmiffy.springguru.petclinic.model.pet;

import com.jrsmiffy.springguru.petclinic.model.person.Owner;
import com.jrsmiffy.springguru.petclinic.model.person.Vet;

import java.time.LocalDate;

public class Pet {

    private LocalDate birthDate;
    private Owner owner;
    private PetType pet;
    private Vet vet;

}