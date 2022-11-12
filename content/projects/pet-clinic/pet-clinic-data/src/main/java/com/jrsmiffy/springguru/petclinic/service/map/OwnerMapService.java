package com.jrsmiffy.springguru.petclinic.service.map;

import com.jrsmiffy.springguru.petclinic.model.person.Owner;
import com.jrsmiffy.springguru.petclinic.model.pet.Pet;
import com.jrsmiffy.springguru.petclinic.service.OwnerService;
import com.jrsmiffy.springguru.petclinic.service.PetService;
import com.jrsmiffy.springguru.petclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service @RequiredArgsConstructor
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getType() != null) {
                        if (pet.getType().getId() == null) {
                            pet.setType(petTypeService.save(pet.getType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

}
