package com.jrsmiffy.springguru.dependencyinjection.controller;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller @Slf4j
public class ConversationController {

    private final GreetingService greetingService; // note: will use PrimaryGreetingService due to @Primary
    // note: final is best practise for our dependencies

    public ConversationController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        String message = "Hello World";
        log.info(message);

        return message;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

}
