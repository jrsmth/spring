package com.jrsmiffy.springguru.dependencyinjection.controller.unmanaged;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;

// note: controllers in the 'unmanaged' package have not been marked as Spring beans, to showcase manual D.I
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
