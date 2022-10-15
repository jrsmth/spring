package com.jrsmiffy.springguru.dependencyinjection.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component @Slf4j
public class PrototypeBean {

    public PrototypeBean() {
        log.info("Prototype Bean created!");
    }

    public String getScope(){
        return "Bean Scope :: Prototype";
    }

}
