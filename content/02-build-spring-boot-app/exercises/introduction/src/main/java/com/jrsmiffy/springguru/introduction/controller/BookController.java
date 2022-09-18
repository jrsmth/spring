package com.jrsmiffy.springguru.introduction.controller;

import com.jrsmiffy.springguru.introduction.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Books Mappings
 *
 * @author jamessmith
 * @since Thursday 15th September 2022
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books/list.html";

    }

}
