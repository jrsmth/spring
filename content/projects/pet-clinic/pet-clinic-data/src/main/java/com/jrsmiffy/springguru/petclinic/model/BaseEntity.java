package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

 /* Note: @MappedSuperclass
     Relational databases don't have a straightforward way to map class hierarchies onto database tables.
     To address this, the JPA specification provides several strategies, including @MappedSuperclass
         It designates a class whose mapping info is applied to the entities that inherit from it.
         Using the MappedSuperclass strategy, inheritance is only evident in the class but not the entity model.
         Notice that this class has no @Entity annotation, as it won't be persisted in the database by itself
         A mapped superclass has no separate table defined for it.
  */
@MappedSuperclass @Getter @Setter
public class BaseEntity implements Serializable { // Question: Should @MappedSuperclass-annotated classes be abstract?
    // note: Serializable interface allows the state of an object to be converted into a byte stream
    // note: https://www.geeksforgeeks.org/serializable-interface-in-java/
    // note: https://stackoverflow.com/questions/4548816/when-should-we-implement-serializable-interface
    /**
     * It appears that implementing Serializable WAS standard practise on domain models
     *      to use Java's in-built Serialization scheme.
     *          Now, we can use other serialization scheme - such as JSON.
     * <p>
     * TLDR: Implementing Serialization may be req. for legacy code; not needed nowadays...
     */

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // note: Hibernate recommends that we use Wrapper classes instead of primitives
    // note: This is because the 'Boxed' types can be 'null', whereas primitives cannot

}
