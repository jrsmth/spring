package com.jrsmiffy.springguru.petclinic.model.person;

import com.jrsmiffy.springguru.petclinic.model.pet.Pet;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter @Setter // @Data?
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;

}
