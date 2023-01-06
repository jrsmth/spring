package com.jrsmiffy.springguru.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter @NoArgsConstructor
// Note: SF Guru uses @Table(name = "vets") but I don't regard that as good practise
    // Note: Hibernate will automatically create a table named "vet" - singular table names are conventional
public class Vet extends Person {

    @Builder // Note: Constructor-level annotation will also include the properties to be supplied to the parent
    public Vet(Long id, String firstName, String lastName, Set<Specialty> specialties) {
        super(id, firstName, lastName);
        this.specialties = specialties;
    }

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
