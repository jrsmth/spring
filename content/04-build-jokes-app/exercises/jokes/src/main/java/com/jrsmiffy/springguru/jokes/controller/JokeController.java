package com.jrsmiffy.springguru.jokes.controller;

import com.jrsmiffy.springguru.jokes.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class JokeController {

    private final JokeService jokeService;

    @GetMapping("/joke")
    public String tellJoke(Model model){
        model.addAttribute("joke", jokeService.getJoke());
        return "joke.html";

    }
    // note: By default, the root path in the web context ('/') serves up index.html
    // note: This was observable in the browser but not in the test with MockMvc


}
