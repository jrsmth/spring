package com.jrsmiffy.springguru.solid.dependencyInversion.bad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LightBulb {

    public void turnOn() {
        log.info("LightBulb :: ON!");
    }

    public void turnOff() {
        log.info("LightBulb :: OFF!");
    }

}
