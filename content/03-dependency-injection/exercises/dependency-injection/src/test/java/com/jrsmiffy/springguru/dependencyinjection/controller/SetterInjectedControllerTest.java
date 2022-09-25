package com.jrsmiffy.springguru.dependencyinjection.controller;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() { // note: we are playing the role of the framework here by injecting the dependencies manually
        controller = new SetterInjectedController();
        controller.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    @DisplayName("Should get the greeting")
    public void shouldGetGreeting() {
        log.info(controller.getGreeting());
    }

}