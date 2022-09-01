package com.jrsmiffy.springguru.introduction.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Publisher model
 *
 * @author jamessmith
 * @since Thursday 1st September 2022
 */

@Entity
@Setter @Getter @RequiredArgsConstructor @NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String name;
    @NonNull private String address;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

}
