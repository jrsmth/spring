package com.jrsmiffy.springguru.solid.dependencyInversion.good.lowLevel;

import com.jrsmiffy.springguru.solid.dependencyInversion.good.highLevel.Switchable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LightBulb implements Switchable {

    @Override
    public void turnOn() {
        log.info("LightBulb :: ON!");
    }

    @Override
    public void turnOff() {
        log.info("LightBulb :: OFF!");
    }

}
