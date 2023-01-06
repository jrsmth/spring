package com.jrsmiffy.springguru.petclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass @Getter @Setter @NoArgsConstructor
public abstract class Person extends BaseEntity {

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

}
