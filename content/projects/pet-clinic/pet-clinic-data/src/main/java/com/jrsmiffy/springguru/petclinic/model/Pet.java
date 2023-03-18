package com.jrsmiffy.springguru.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Pet extends BaseEntity {

    @Builder
    public Pet(Long id, String name, PetType type, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.birthDate = birthDate;
        if (visits == null || visits.size() > 0 ) this.visits = visits;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ManyToOne @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne @JoinColumn(name = "type_id")
    private PetType type;

    private String name;

//    private Vet vet; // Question: how are we linking Vets and Pets?

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
