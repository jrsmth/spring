package com.jrsmiffy.springguru.recipes;

import com.jrsmiffy.springguru.recipes.bootstrap.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public String guacamoleDirections() {
        return ResourceReader.readFileToString("guacamoleDirections.txt");
    }

    @Bean
    public String tacoDirections() {
        return ResourceReader.readFileToString("tacoDirections.txt");
    }

}
