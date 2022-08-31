package com.jrsmiffy.springguru.introduction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors; // note: the join table stores which authors are matched to which books

}
