package com.jrsmiffy.springguru.petclinic.model.person;

import com.jrsmiffy.springguru.petclinic.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter // @Data?
public class Specialty extends BaseEntity {

    private String description;

}
