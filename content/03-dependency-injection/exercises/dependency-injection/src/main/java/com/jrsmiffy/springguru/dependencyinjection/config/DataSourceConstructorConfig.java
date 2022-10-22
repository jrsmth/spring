package com.jrsmiffy.springguru.dependencyinjection.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("constructor.datasource")
// note: We use `@EnableConfigurationProperties` on a @Configuration class to create this as a Spring component
@Getter @RequiredArgsConstructor
public class DataSourceConstructorConfig {
    // note: this class was created to demonstrate externalising config as part of "Section 6 :: Externalising Properties"

    private final String username;
    private final String password;
    private final String jdbcUrl;

}
