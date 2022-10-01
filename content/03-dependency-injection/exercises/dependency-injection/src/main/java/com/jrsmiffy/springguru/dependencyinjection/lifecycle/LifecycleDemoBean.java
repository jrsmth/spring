package com.jrsmiffy.springguru.dependencyinjection.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component @Slf4j
public class LifecycleDemoBean implements
        InitializingBean,
        DisposableBean,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware {


    public LifecycleDemoBean() {
        log.info("L I F E C Y C L E");
        log.info("Hello from the LifecycleDemoBean Constructor!");
    }

    @Override
    public void destroy() {
        log.info("L I F E C Y C L E");
        log.info("The LifecycleDemoBean has been terminated!");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("L I F E C Y C L E");
        log.info("The LifecycleDemoBean's properties are set!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("L I F E C Y C L E");
        log.info("Bean Factory has been set!");
    }

    @Override
    public void setBeanName(String name) {
        log.info("L I F E C Y C L E");
        log.info("My Bean is called {}", name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("L I F E C Y C L E");
        log.info("The Application context has been set!");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("L I F E C Y C L E");
        log.info("The @PostConstruct-annotated method has been called!");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("L I F E C Y C L E");
        log.info("The @PreDestroy-annotated method has been called!");
    }

    public void beforeInit(){
        log.info("L I F E C Y C L E");
        log.info("Before Init :: called by Bean Post Processor!");
    }

    public void afterInit(){
        log.info("L I F E C Y C L E");
        log.info("After Init :: called by Bean Post Processor!");
    }

}
