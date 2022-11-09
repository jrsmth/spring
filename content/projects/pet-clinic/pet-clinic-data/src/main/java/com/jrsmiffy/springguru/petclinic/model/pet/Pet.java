package com.jrsmiffy.springguru.petclinic.model.pet;

import com.jrsmiffy.springguru.petclinic.model.BaseEntity;
import com.jrsmiffy.springguru.petclinic.model.person.Owner;
import com.jrsmiffy.springguru.petclinic.model.person.Vet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Pet extends BaseEntity {

    private LocalDate birthDate;
    private String name;
    private Owner owner;
    private PetType type;
    private Vet vet;

}
