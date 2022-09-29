package com.jrsmiffy.springguru.dependencyinjection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("spanish")
@Service("i18nService") // note: this renames the bean - used for demo purposes to conflict with EnglishGreetingService
public class SpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Una cálida bienvenida de los españoles";
    }

}
