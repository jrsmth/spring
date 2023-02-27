package com.jrsmiffy.springguru.petclinic.service.map;

import com.jrsmiffy.springguru.petclinic.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        Assertions.assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        Assertions.assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        Assertions.assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveWithoutId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        Assertions.assertNotNull(savedOwner);
        Assertions.assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        Assertions.assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        Assertions.assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);

        Assertions.assertNotNull(smith);
        Assertions.assertEquals(1L, smith.getId());
    }

    @Test
    void cannotFindByLastName() {
        Owner turner = ownerMapService.findByLastName("Turner");

        Assertions.assertNull(turner);
    }

    @Test
    void findAllByLastNameLike() {
        // TODO: to be implemented
    }
}