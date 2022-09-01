package com.jrsmiffy.springguru.introduction.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents an Author model
 *
 * @author jamessmith
 * @since Wednesday 31st August 2022
 */
@Entity
@Setter @Getter @RequiredArgsConstructor @NoArgsConstructor // lombok used to save my fingers...
// note: @Data introduces a circular dependency on its implementation of toString()/hashCode() and caused a StackOverflowErr
// note: therefore used @Setter @Getter instead: https://stackoverflow.com/questions/17445657/hibernate-onetomany-java-lang-stackoverflowerror
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull private String firstName; // note: @RequiredArgsConstructor applies to final fields and those annotated with @NonNull
    @NonNull private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

}
