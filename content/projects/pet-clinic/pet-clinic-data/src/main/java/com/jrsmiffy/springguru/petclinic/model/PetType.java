package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity @Getter @Setter // Note: @Builder doesn't seem worth it here
public class PetType extends BaseEntity {

    private String type;

}
