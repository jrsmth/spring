package com.jrsmiffy.springguru.solid.dependencyInversion.good.highLevel;

public class ElectricPowerSwitch implements Switch {

    private Switchable client;
    // note: instead of depending directly on LightBulb, we're depending on an abstraction
    // note: this decouples them and allows for polymorphism at runtime

    private boolean on;

    public ElectricPowerSwitch(Switchable client) {
        this.client = client;
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public void press(){
        boolean checkOn = isOn();

        if (checkOn) {
            client.turnOff();
            this.on = false;
        } else {
            client.turnOn();
            this.on = true;
        }
    }

}
