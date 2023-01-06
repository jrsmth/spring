package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity @Getter @Setter // Note: @Builder doesn't seem worth it here
public class Visit extends BaseEntity {

    private LocalDate date; // question: would a unix timestamp be better?
    private String description;

    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "pet_id")
    private Pet pet;
    // NOTE: Bootstrap data was giving -> `org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing`
    // NOTE: So I had to add `cascade = CascadeType.ALL` to the Pet Mapping
    // NOTE: https://stackoverflow.com/questions/2302802/how-to-fix-the-hibernate-object-references-an-unsaved-transient-instance-save

}
