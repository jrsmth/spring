package com.jrsmiffy.springguru.jokes.controller

import com.jrsmiffy.springguru.jokes.service.JokeService
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view

class JokeControllerTest extends Specification {
    // note: https://www.youtube.com/watch?v=LxIps9yx4nw
    // note: How to test a Thymeleaf view in Spring MVC

    def jokeService = Stub(JokeService)
    def underTest = new JokeController(jokeService)
    def mockMvc = MockMvcBuilders.standaloneSetup(underTest).build()

    def 'should redirect to joke page'() {
        expect:
        mockMvc.perform(get('/api/joke'))
        .andExpect(status().isOk())
        .andExpect(view().name('joke.html'))

    }

}
