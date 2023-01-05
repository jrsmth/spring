package com.jrsmiffy.springguru.recipes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Notes {

    public Notes(String content) {
        this.content = content;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // Note: This denotes a 'Large object' - by default Hibernate limits Strings to 255 characters
    private String content; // Note: LOB's are related to BLOB's (Binary Large Objects) and CLOB's (Character Large Objects)

    @OneToOne
    private Recipe recipe;

}
