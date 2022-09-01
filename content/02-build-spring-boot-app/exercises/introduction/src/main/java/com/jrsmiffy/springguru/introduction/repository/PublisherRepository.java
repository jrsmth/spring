package com.jrsmiffy.springguru.introduction.repository;

import com.jrsmiffy.springguru.introduction.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Publisher object
 *
 * @author jamessmith
 * @since Thursday 1st September 2022
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
