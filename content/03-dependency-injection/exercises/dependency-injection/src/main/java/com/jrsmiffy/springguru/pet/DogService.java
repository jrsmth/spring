package com.jrsmiffy.springguru.pet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile({"dog", "default"}) // note: removed as part of Section 5 :: Spring Configuration to demo Factory Beans
// Note :: I don't think 'default' gives you anything... bc the 'default' profile is always active (?)
// Question :: Is this understanding correct?
//@Service // note: removed as part of Section 5 :: Spring Configuration to demo Factory Beans
public class DogService implements PetService {

    public String getPetType(){
        return "a dog!";
    }

}
