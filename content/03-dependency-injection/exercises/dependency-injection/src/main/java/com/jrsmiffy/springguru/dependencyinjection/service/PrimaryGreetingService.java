package com.jrsmiffy.springguru.dependencyinjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service @Primary
// note: ^removed the stereotype annotation to make use of @Configuration (Section 5: Spring Configuration)
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello Primary!";
    }
}