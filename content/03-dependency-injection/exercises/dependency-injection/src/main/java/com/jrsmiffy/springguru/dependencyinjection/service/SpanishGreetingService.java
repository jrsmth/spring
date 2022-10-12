package com.jrsmiffy.springguru.dependencyinjection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("spanish")
//@Service("i18nService") // note: this renames the bean - used for demo purposes to conflict with EnglishGreetingService
// note: ^removed the stereotype annotation to make use of @Configuration (Section 5: Spring Configuration)
public class SpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Una cálida bienvenida de los españoles";
    }

}
