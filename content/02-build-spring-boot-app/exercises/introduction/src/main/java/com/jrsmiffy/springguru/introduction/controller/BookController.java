package com.jrsmiffy.springguru.introduction.controller;

import com.jrsmiffy.springguru.introduction.repository.BookRepository;

/**
 * Controller for Books
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

        return "books";
    }
}
