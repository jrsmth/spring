package com.jrsmiffy.springguru.introduction.repository;

import com.jrsmiffy.springguru.introduction.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Book object
 *
 * @author jamessmith
 * @since Thursday 1st September 2022
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}


