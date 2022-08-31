package com.jrsmiffy.springguru.introduction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a Book model
 *
 * @author jamessmith
 * @since Wednesday 31st August 2022
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor // lombok used to save my fingers...
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
