package com.jrsmiffy.springguru.petclinic.service.jpa;

import com.jrsmiffy.springguru.petclinic.model.Owner;
import com.jrsmiffy.springguru.petclinic.repository.OwnerRepository;
import com.jrsmiffy.springguru.petclinic.repository.PetRepository;
import com.jrsmiffy.springguru.petclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock OwnerRepository ownerRepository;
    @Mock PetRepository petRepository;
    @Mock PetTypeRepository petTypeRepository;

    @InjectMocks OwnerServiceImpl underTest;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = underTest.findByLastName(lastName);

        assertEquals(lastName, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = underTest.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = underTest.findById(ownerId);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = underTest.findById(ownerId);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(ownerId).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = underTest.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        underTest.delete(returnOwner);

        // Note: the default is wanted number of invocations is 1 anyway
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        underTest.deleteById(ownerId);

        verify(ownerRepository).deleteById(anyLong());
    }
}