package com.jrsmiffy.springguru.dependencyinjection.controller;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;

public class SetterInjectedController {
    // note: this class, plus its test, showcases how to manually inject dependencies (w/o Spring), using setters
        // Obviously not recommended...

    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }


}
