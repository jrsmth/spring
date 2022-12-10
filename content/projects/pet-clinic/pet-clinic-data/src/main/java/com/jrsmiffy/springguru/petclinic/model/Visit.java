package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity @Getter @Setter
public class Visit extends BaseEntity {

    private LocalDate date; // question: would a unix timestamp be better?
    private String description;

    @ManyToOne @JoinColumn(name = "pet_id")
    private Pet pet;

}
