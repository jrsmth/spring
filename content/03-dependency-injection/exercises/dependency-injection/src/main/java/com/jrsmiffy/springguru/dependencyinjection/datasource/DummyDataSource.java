package com.jrsmiffy.springguru.dependencyinjection.datasource;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DummyDataSource {
    // note: this class was created to demonstrate externalising config as part of "Section 6 :: Externalising Properties"

    private String username;
    private String password;
    private String jdbcUrl;

}
