package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity @Getter @Setter
public class Pet extends BaseEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ManyToOne @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne @JoinColumn(name = "type_id")
    private PetType type;

    private String name;

    private Vet vet;

}
