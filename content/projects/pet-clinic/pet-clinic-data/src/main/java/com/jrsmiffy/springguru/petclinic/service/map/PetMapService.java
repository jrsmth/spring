package com.jrsmiffy.springguru.petclinic.service.map;

import com.jrsmiffy.springguru.petclinic.model.pet.Pet;
import com.jrsmiffy.springguru.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() { return super.findAll(); }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
