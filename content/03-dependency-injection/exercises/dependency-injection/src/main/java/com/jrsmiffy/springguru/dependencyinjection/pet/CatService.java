package com.jrsmiffy.springguru.dependencyinjection.pet;

import org.springframework.stereotype.Service;

@Service("cat")
public class CatService implements PetService {
    @Override
    public String getPetType() {
        return "a cat!";
    }

}
