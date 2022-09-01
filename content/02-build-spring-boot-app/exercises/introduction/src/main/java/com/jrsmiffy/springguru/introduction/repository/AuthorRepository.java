package com.jrsmiffy.springguru.introduction.repository;

import com.jrsmiffy.springguru.introduction.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Author object
 *
 * @author jamessmith
 * @since Thursday 1st September 2022
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
