package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity @Getter @Setter
public class Specialty extends BaseEntity {
    // Question: Specialty or Speciality? TLDR: both are acceptable
        // https://writingexplained.org/specialty-vs-speciality

    private String description;

}
