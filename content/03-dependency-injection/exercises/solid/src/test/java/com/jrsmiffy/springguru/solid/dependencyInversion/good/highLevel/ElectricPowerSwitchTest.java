package com.jrsmiffy.springguru.solid.dependencyInversion.good.highLevel;

import com.jrsmiffy.springguru.solid.dependencyInversion.good.lowLevel.Fan;
import com.jrsmiffy.springguru.solid.dependencyInversion.good.lowLevel.LightBulb;
import org.junit.jupiter.api.Test;

public class ElectricPowerSwitchTest {

    @Test
    public void testPress() {
        Switchable switchableBulb = new LightBulb();
        Switch bulbPowerSwitch = new ElectricPowerSwitch(switchableBulb);
        bulbPowerSwitch.press();
        bulbPowerSwitch.press();

        Switchable switchableFan = new Fan();
        Switch fanPowerSwitch = new ElectricPowerSwitch(switchableFan);
        fanPowerSwitch.press();
        fanPowerSwitch.press();

    }

}