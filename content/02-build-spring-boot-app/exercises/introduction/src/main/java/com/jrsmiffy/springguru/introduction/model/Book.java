package com.jrsmiffy.springguru.introduction.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Book model
 *
 * @author jamessmith
 * @since Wednesday 31st August 2022
 */
@Entity
@Setter @Getter @RequiredArgsConstructor @NoArgsConstructor // lombok used to save my fingers...
// note: @Data introduces a circular dependency on its implementation of toString()/hashCode() and caused a StackOverflowErr
// note: therefore used @Setter @Getter instead: https://stackoverflow.com/questions/17445657/hibernate-onetomany-java-lang-stackoverflowerror
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull private String title; // note: @RequiredArgsConstructor applies to final fields and those annotated with @NonNull
    @NonNull private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>(); // note: the join table stores which authors are matched to which books

    // note: I've included the overriding of hashCode, equals() and toString() for future reference although probably YAGNI
    /**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
     */

}
