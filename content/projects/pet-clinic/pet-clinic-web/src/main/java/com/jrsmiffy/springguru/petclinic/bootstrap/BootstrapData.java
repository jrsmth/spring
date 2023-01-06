package com.jrsmiffy.springguru.petclinic.bootstrap;

import com.jrsmiffy.springguru.petclinic.model.Owner;
import com.jrsmiffy.springguru.petclinic.model.Specialty;
import com.jrsmiffy.springguru.petclinic.model.Vet;
import com.jrsmiffy.springguru.petclinic.model.Pet;
import com.jrsmiffy.springguru.petclinic.model.PetType;
import com.jrsmiffy.springguru.petclinic.model.Visit;
import com.jrsmiffy.springguru.petclinic.service.OwnerService;
import com.jrsmiffy.springguru.petclinic.service.PetTypeService;
import com.jrsmiffy.springguru.petclinic.service.SpecialtyService;
import com.jrsmiffy.springguru.petclinic.service.VetService;
import com.jrsmiffy.springguru.petclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Component @Slf4j @RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VetService vetService;
    private final VisitService visitService;

    @Override
    public void run(String... args) {
        boolean dataExists = (petTypeService.findAll().size() > 0);
        if (!dataExists) loadData();

    }

    public void loadData() {
        loadPetType();
        loadOwner();
        loadSpecialty();
        loadVet();

    }

    private void loadPetType() {
        PetType dogType = new PetType();
        dogType.setType("Dog");
        petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setType("Cat");
        petTypeService.save(catType);

        log.info("--- Data Loaded :: Pet Type  ---");
    }

    private void loadOwner() { // Note: loadOwner() also creates Pet and Visit objects - Question: Extract them out?
        Owner ownerOne = Owner.builder()
                .id(1L)
                .firstName("Michael")
                .lastName("Weston")
                .address("35 Your Mama's House")
                .city("Miami")
                .telephone("0123456789")
                .build();

        Pet mikesPet = Pet.builder()
                .type(petTypeService.findById(1L)) // Note: This is a dog type
                .owner(ownerOne)
                .birthDate(LocalDate.now())
                .name("Rosco")
                .build();

        ownerOne.setPets(Set.of(mikesPet));
        ownerService.save(ownerOne);

        Owner ownerTwo = Owner.builder()
                .id(2L)
                .firstName("Fiona")
                .lastName("Glennane")
                .address("123 Noneofyour Business")
                .city("Las Vegas")
                .telephone("9876543210")
                .build();

        Pet fionasPet = Pet.builder()
                .type(petTypeService.findById(2L)) // Note: This is a cat type
                .owner(ownerTwo)
                .birthDate(LocalDate.now())
                .name("Jessicat")
                .build();

        ownerTwo.setPets(Set.of(fionasPet));
        ownerService.save(ownerTwo);

        log.info("--- Data Loaded :: Owner     ---");

        Visit visitOne = new Visit();
        visitOne.setPet(mikesPet);
        visitOne.setDate(LocalDate.now());
        visitOne.setDescription("Doggo with a broken leg");
        visitService.save(visitOne);

        log.info("--- Data Loaded :: Visit     ---");
    }

    private void loadSpecialty() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        specialtyService.save(dentistry);

        log.info("--- Data Loaded :: Specialty ---");
    }

    private void loadVet() {
        Vet vetOne = Vet.builder()
                .id(1L)
                .firstName("Sam")
                .lastName("Axe")
                .specialties(Set.of(specialtyService.findById(1L))) // Note: This is the radiology specialty
                .build();

        vetService.save(vetOne);

        Vet vetTwo = Vet.builder()
                .id(2L)
                .firstName("Jessie")
                .lastName("Porter")
                .specialties(Set.of(specialtyService.findById(2L))) // Note: This is the surgery specialty
                .build();

        vetService.save(vetTwo);

        log.info("--- Data Loaded :: Vet       ---");
    }

}
