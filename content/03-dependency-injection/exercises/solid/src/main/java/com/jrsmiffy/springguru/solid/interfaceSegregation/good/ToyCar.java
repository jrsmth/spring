package com.jrsmiffy.springguru.solid.interfaceSegregation.good;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Builder
public class ToyCar implements Toy, Movable {

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
        log.info("Car :: *MOVING*");
    }

    @Override
    public String toString(){
        return "Car :: Price: " + price + " & Colour: " + colour;
    }

}
