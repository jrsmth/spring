package com.jrsmiffy.springguru.dependencyinjection.repository;

public interface EnglishGreetingRepository {
    // note: with dependency injection (D.I), it is best practise to code to an interface

    String sayGreeting();

}
