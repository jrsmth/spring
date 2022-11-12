package com.jrsmiffy.springguru.petclinic.bootstrap;

import com.jrsmiffy.springguru.petclinic.model.person.Owner;
import com.jrsmiffy.springguru.petclinic.model.person.Specialty;
import com.jrsmiffy.springguru.petclinic.model.person.Vet;
import com.jrsmiffy.springguru.petclinic.model.pet.Pet;
import com.jrsmiffy.springguru.petclinic.model.pet.PetType;
import com.jrsmiffy.springguru.petclinic.service.OwnerService;
import com.jrsmiffy.springguru.petclinic.service.PetTypeService;
import com.jrsmiffy.springguru.petclinic.service.SpecialtyService;
import com.jrsmiffy.springguru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component @Slf4j @RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VetService vetService;

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

    private void loadOwner(){
        Owner ownerOne = new Owner();
        ownerOne.setId(1L);
        ownerOne.setFirstName("Michael");
        ownerOne.setLastName("Weston");
        ownerOne.setAddress("35 Your Mama's House");
        ownerOne.setCity("Miami");
        ownerOne.setTelephone("0123456789");
        ownerService.save(ownerOne);

        Pet mikesPet = new Pet();
        mikesPet.setType(petTypeService.findById(1L)); // note: this is a dog type
        mikesPet.setOwner(ownerOne);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        ownerOne.getPets().add(mikesPet);

        Owner ownerTwo = new Owner();
        ownerTwo.setId(2L);
        ownerTwo.setFirstName("Fiona");
        ownerTwo.setLastName("Glennane");
        ownerOne.setAddress("35 Noneofyour Business");
        ownerOne.setCity("Las Vegas");
        ownerOne.setTelephone("9876543210");
        ownerService.save(ownerTwo);

        Pet fionasPet = new Pet();
        fionasPet.setType(petTypeService.findById(2L)); // note: this is a cat type
        fionasPet.setOwner(ownerTwo);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Jessicat");
        ownerTwo.getPets().add(fionasPet);

        log.info("--- Data Loaded :: Owner     ---");

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
        Vet vetOne = new Vet();
        vetOne.setId(1L);
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetOne.getSpecialties().add(specialtyService.findById(1L)); // note: this is the radiology specialty
        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setId(2L);
        vetTwo.setFirstName("Jessie");
        vetTwo.setLastName("Porter");
        vetTwo.getSpecialties().add(specialtyService.findById(2L)); // note: this is the surgery specialty
        vetService.save(vetTwo);

        log.info("--- Data Loaded :: Vet       ---");

    }

}
