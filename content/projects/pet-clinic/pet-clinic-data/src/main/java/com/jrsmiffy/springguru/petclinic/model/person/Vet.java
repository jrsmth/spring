package com.jrsmiffy.springguru.petclinic.model.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter // @Data?
public class Vet extends Person {

    private Set<Specialty> specialties;

}
