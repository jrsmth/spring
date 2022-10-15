package com.jrsmiffy.springguru.petclinic.bootstrap;

import com.jrsmiffy.springguru.petclinic.model.person.Owner;
import com.jrsmiffy.springguru.petclinic.model.person.Vet;
import com.jrsmiffy.springguru.petclinic.service.OwnerService;
import com.jrsmiffy.springguru.petclinic.service.VetService;
import com.jrsmiffy.springguru.petclinic.service.map.OwnerMapService;
import com.jrsmiffy.springguru.petclinic.service.map.VetMapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class BootstrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public BootstrapData() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) {
        Owner ownerOne = new Owner();
        ownerOne.setId(1L);
        ownerOne.setFirstName("Michael");
        ownerOne.setLastName("Weston");
        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setId(2L);
        ownerTwo.setFirstName("Fiona");
        ownerTwo.setLastName("Glennane");
        ownerService.save(ownerTwo);

        log.info("--- Data Loaded :: Owner ---");

        Vet vetOne = new Vet();
        vetOne.setId(1L);
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setId(1L);
        vetTwo.setFirstName("Sam");
        vetTwo.setLastName("Axe");
        vetService.save(vetTwo);

        log.info("--- Data Loaded :: Vet   ---");

    }


}
