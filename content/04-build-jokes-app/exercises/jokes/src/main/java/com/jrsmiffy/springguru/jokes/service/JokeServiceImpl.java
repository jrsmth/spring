package com.jrsmiffy.springguru.jokes.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes generator;

    @Override
    public String getJoke() {
        return generator.getRandomQuote();
    }

}
