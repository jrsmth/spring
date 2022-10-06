package com.jrsmiffy.springguru.solid.interfaceSegregation.bad;

public class ToyHouse implements Toy {

    private double price;
    private String colour;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void move(){} // note: redundant method that violates the Interface Segregation principle

    @Override
    public void fly(){} // note: redundant method that violates the Interface Segregation principle

}
/**
    Whilst a ToyHouse is a type of Toy, it does not have the ability to move() or fly().
        Therefore, those methods have to implemented but are redundant.
    This highlights that the Toy interface is 'fat' and is not fine-grained enough for the classes that will implement it.
        We would be better off splitting the Toy interface into multiple role interfaces each for a specific behavior:
            Such as Movable() or Flyable()

    In summary: The Toy interface violates Interface Segregation by forcing its clients (implementation classes) to depend on methods that they do not use.
 */
