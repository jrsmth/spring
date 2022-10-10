package com.jrsmiffy.springguru.dependencyinjection.service;

import org.springframework.stereotype.Service;

//@Service
// note: ^removed the stereotype annotation to make use of @Configuration (Section 5: Spring Configuration)
public class ConstructorGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello Controller!";
    }

}
