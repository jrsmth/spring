package com.jrsmiffy.springguru.recipes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Notes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // Note: This denotes a 'Large object' - by default Hibernate limits Strings to 255 characters
    String content; // Note: LOB's are related to BLOB's (Binary Large Objects) and CLOB's (Character Large Objects)

}
