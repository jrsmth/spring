package com.jrsmiffy.springguru.dependencyinjection.controller;

import com.jrsmiffy.springguru.dependencyinjection.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class I18nController {
    // note: i18n stands for "internationalisation"; it is a Numeronym, like a11y ("accessibility")

    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String welcome() {
        return greetingService.sayGreeting();
    }

}
