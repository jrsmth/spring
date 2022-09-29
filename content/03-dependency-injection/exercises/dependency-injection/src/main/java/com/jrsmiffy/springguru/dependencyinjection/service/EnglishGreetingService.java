package com.jrsmiffy.springguru.dependencyinjection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("english")
@Service("i18nService") // note: this renames the bean - used for demo purposes to conflict with SpanishGreetingService
public class EnglishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "A warm welcome from the English";
    }

}
