package com.jrsmiffy.springguru.petclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass @Getter @Setter
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

}
