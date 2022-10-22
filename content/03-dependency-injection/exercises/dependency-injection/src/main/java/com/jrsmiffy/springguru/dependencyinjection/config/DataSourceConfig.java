package com.jrsmiffy.springguru.dependencyinjection.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("datasource") // note: Property Binding
// note: this^ will look for the `datasource` property in the context
// note: It will inject the `datasource` values into the fields below (as long as they match)
@Getter @Setter
public class DataSourceConfig {
    // note: this class was created to demonstrate externalising config as part of "Section 6 :: Externalising Properties"

    private String username;
    private String password;
    private String jdbcUrl;

}
