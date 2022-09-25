package com.jrsmiffy.springguru.dependencyinjection.controller;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;

public class PropertyInjectedController {
    // note: this class, plus its test, showcases how to manually inject dependencies (w/o Spring), using properties
        // Obviously not recommended...

    public GreetingService greetingService; // note: public to allow direct access in the test (demo purposes)

    public String getGreeting() {
        return greetingService.sayGreeting();
    }


}
