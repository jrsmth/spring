package com.jrsmiffy.springguru.petclinic.model.person;

import com.jrsmiffy.springguru.petclinic.model.BaseEntity;
import lombok.*;

@Getter @Setter
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

}
