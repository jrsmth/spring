package com.jrsmiffy.springguru.pet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("cat")
//@Service("cat")
// note: ^^removed as part of Section 5 :: Spring Configuration to demo Factory Beans
public class CatService implements PetService {

    @Override
    public String getPetType() {
        return "a cat!";
    }

}
