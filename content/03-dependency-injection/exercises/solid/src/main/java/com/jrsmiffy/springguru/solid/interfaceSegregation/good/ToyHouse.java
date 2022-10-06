package com.jrsmiffy.springguru.solid.interfaceSegregation.good;

import lombok.Builder;

@Builder
public class ToyHouse implements Toy {

    private double price;
    private String color;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setColour(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return "House :: Price: £" + price + " & Colour: " + color;
    }

}
