package com.jrsmiffy.springguru.jokes.service

import guru.springframework.norris.chuck.ChuckNorrisQuotes
import spock.lang.Specification

class JokeServiceTest extends Specification {

    def generator = Mock(ChuckNorrisQuotes)
    def underTest = new JokeServiceImpl(generator)

    def 'should get a joke'() {
        given:
        def jokeExpected = 'My father has schizophrenia, but he’s good people.'

        when:
        def jokeActual = underTest.getJoke()

        then:
        jokeActual == jokeExpected

        and: 'the joke is "generated" by Spring Guru'
        1 * generator.getRandomQuote() >> jokeExpected

    }

}
