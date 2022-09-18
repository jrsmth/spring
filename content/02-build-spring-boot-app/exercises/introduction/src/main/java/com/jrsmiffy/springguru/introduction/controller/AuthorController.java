package com.jrsmiffy.springguru.introduction.controller;

import com.jrsmiffy.springguru.introduction.repository.AuthorRepository;
import com.jrsmiffy.springguru.introduction.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @AllArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list.html";

    }

}
