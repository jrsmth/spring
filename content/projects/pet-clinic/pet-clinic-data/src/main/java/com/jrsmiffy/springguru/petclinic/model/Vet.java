package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
// Note: SF Guru uses @Table(name = "vets") but I don't regard that as good practise
    // Note: Hibernate will automatically create a table named "vet" - singular table names are conventional
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id")
    )
    private Set<Specialty> specialties = new HashSet<>();
    // Note: SF Guru uses @Column(name = "specialities") but I don't regard that as good practise
        // Note: Hibernate will automatically create a column name "specialities" and convert camelCase to snake_case if required

}
