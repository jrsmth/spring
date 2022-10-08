package com.jrsmiffy.springguru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class BaseEntity implements Serializable {
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

    private Long id;
    // note: Hibernate recommends that we use Wrapper classes instead of primitives
    // note: This is because the 'Boxed' types can be 'null', whereas primitives cannot

}
