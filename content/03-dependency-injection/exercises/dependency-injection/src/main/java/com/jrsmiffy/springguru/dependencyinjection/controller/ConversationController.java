package com.jrsmiffy.springguru.dependencyinjection.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller @Slf4j
public class ConversationController {

    public String sayHello() {
        String message = "Hello World";
        log.info(message);

        return message;

    }

}
