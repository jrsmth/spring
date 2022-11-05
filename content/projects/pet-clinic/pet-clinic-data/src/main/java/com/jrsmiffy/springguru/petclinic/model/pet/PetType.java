package com.jrsmiffy.springguru.petclinic.model.pet;

import com.jrsmiffy.springguru.petclinic.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter // @Data?
public class PetType extends BaseEntity {

    private String type;

}
