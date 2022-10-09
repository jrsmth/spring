package com.jrsmiffy.springguru.petclinic.service;

import com.jrsmiffy.springguru.petclinic.model.person.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
