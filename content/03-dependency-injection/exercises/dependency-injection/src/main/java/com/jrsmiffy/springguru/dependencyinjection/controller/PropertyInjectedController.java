package com.jrsmiffy.springguru.dependencyinjection.controller;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired // note: GreetingService must be a bean to be autowired -> requires @Service
    @Qualifier("propertyGreetingService") // note: With @Qualifier, we provide the bean name (CamelCase with a leading lower)
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }


}

