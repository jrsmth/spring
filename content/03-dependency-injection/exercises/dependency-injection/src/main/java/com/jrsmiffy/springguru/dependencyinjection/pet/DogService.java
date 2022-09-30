package com.jrsmiffy.springguru.dependencyinjection.pet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dog", "default"})
// Note :: I don't think 'default' gives you anything... bc the 'default' profile is always active (?)
// Question :: Is this understanding correct?
@Service
public class DogService implements PetService {
    public String getPetType(){
        return "a dog!";
    }

}
