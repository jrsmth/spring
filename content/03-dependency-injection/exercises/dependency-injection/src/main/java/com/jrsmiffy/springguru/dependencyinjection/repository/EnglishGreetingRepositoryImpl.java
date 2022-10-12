package com.jrsmiffy.springguru.dependencyinjection.repository;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

    @Override
    public String sayGreeting() {
        return "A warm welcome from the English";
    }

}
