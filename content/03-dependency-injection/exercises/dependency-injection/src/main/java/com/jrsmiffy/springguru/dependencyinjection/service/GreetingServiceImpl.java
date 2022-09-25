package com.jrsmiffy.springguru.dependencyinjection.service;

public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World";
    }

}
