package com.jrsmiffy.springguru.dependencyinjection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"spanish", "default"})
// note: we can use the "default" profile to ensure the bean is wired into the ctx even when the other profile is inactive
@Service("i18nService") // note: this renames the bean - used for demo purposes to conflict with EnglishGreetingService
public class SpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Una cálida bienvenida de los españoles";
    }

}
