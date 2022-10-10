package com.jrsmiffy.springguru.dependencyinjection.config;

import com.jrsmiffy.springguru.dependencyinjection.service.ConstructorGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // note: tells Spring that we are defining Beans here
public class GreetingServiceConfig {

    @Bean // note: the method name here drives the Bean name in the Spring Context ("constructorGreetingService")
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

}
