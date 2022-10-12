package com.jrsmiffy.springguru.pet;

// note: Section 5 :: Spring Configuration - we will pretend that PetServiceFactory is a 3rd-party utility and use Java-based Config to define our Bean
public class PetServiceFactory {

    public PetService getPetService(String petType) {
        switch (petType) {
            case "cat":
                return new CatService();
            case "dog":
                return new DogService();
            default:
                return null;
        }
    }

}
