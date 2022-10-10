package com.jrsmiffy.springguru.pet;

import org.springframework.stereotype.Controller;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String getFavouritePetType() {
        return petService.getPetType();
    }

}
