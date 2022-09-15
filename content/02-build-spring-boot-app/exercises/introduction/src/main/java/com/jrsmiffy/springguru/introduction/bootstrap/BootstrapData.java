package com.jrsmiffy.springguru.introduction.bootstrap;

import com.jrsmiffy.springguru.introduction.model.Author;
import com.jrsmiffy.springguru.introduction.model.Book;
import com.jrsmiffy.springguru.introduction.model.Publisher;
import com.jrsmiffy.springguru.introduction.repository.AuthorRepository;
import com.jrsmiffy.springguru.introduction.repository.BookRepository;
import com.jrsmiffy.springguru.introduction.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Sets up data for our application
 *
 * @author jamessmith
 * @since Thursday 1st September 2022
 */
@Component
@AllArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception { // note: I think it is better practise to seed the database with a data.sql

        Publisher publisher = new Publisher("foo", "12th Street, LA");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(publisher);

        log.info("Started in Bootstrap");
        log.info("Publisher Count: {}", publisherRepository.count());
        log.info("Book Count: {}", bookRepository.count());
        log.info("Publisher Number of Books: {}", publisher.getBooks().size());

    }

}
