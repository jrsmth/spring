package com.jrsmiffy.springguru.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "types")
public class PetType extends BaseEntity {

    @Builder
    public PetType(Long id, String type) {
        super(id);
        this.type = type;
    }

    @Column(name = "type")
    private String type;


    @Override
    public String toString() {
        return type;
    }
}
