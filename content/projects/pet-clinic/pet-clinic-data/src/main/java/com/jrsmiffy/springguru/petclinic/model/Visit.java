package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter // @Data?
public class Visit extends BaseEntity {

    private LocalDate date; // question: would a unix timestamp be better?
    private String description;
    private Pet pet;

}
