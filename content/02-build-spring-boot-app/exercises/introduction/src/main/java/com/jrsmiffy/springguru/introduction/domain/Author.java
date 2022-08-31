package com.jrsmiffy.springguru.introduction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Represents an Author model
 *
 * @author jamessmith
 * @since Wednesday 31st August 2022
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor // lombok used to save my fingers...
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

}
