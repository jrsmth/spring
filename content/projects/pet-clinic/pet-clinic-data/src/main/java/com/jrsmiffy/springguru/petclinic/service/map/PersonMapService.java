package com.jrsmiffy.springguru.petclinic.service.map;

import com.jrsmiffy.springguru.petclinic.model.person.Person;
import com.jrsmiffy.springguru.petclinic.service.CrudService;

import java.util.Set;

public class PersonMapService extends AbstractMapService<Person, Long> implements CrudService<Person, Long> {

    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Person save(Person person) {
        return super.save(person);
    }

    @Override
    public void delete(Person person) {
        super.delete(person);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
