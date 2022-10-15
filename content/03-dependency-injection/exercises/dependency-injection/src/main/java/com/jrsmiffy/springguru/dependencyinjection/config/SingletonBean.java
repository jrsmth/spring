package com.jrsmiffy.springguru.dependencyinjection.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class SingletonBean {

    public SingletonBean() {
        log.info("Singleton Bean created!");
    }

    public String getScope(){
        return "Bean Scope :: Singleton";
    }

}
