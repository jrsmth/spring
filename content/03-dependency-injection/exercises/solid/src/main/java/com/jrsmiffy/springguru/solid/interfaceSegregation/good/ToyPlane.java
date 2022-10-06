package com.jrsmiffy.springguru.solid.interfaceSegregation.good;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Builder
public class ToyPlane implements Toy, Movable, Flyable {

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
    public void move(){
        log.info("Plane :: *MOVING*");
    }

    @Override
    public void fly(){
        log.info("Plane :: *FLYING*");
    }

    @Override
    public String toString(){
        return "Plane :: Price: £" + price + " & Colour: " + colour;
    }

}
