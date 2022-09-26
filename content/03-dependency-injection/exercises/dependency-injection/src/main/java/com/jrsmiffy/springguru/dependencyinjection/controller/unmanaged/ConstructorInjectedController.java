package com.jrsmiffy.springguru.dependencyinjection.controller.unmanaged;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;

// note: controllers in the 'unmanaged' package have not been marked as Spring beans, to showcase manual D.I
public class ConstructorInjectedController {
    // note: this class, plus its test, showcases how to manually inject dependencies (w/o Spring), using constructors
        // Constructor injection is recommended but should be delegated to Spring!

    private final GreetingService greetingService; // note: best practise to use final for our dependencies

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

}
