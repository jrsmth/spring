package com.jrsmiffy.springguru.solid.dependencyInversion.bad;

public class ElectricPowerSwitch {

    private LightBulb lightBulb;
    // note: D.I is violated as our high-lvl class is directly dependent on a low-lvl one, rather than both depending on an abstraction

    private boolean on;

    public ElectricPowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public void press(){
        boolean checkOn = isOn();

        if (checkOn) {
            lightBulb.turnOff();
            this.on = false;
        } else {
            lightBulb.turnOn();
            this.on = true;
        }
    }

    /**
        Dependency Inversion has been violated here because the high-level ElectricPowerSwitch class is directly dependency on the low-level LightBulb class.
            This is evident by 'LightBulb' being referenced as a dependency on line 5 in ElectricPowerSwitch.
            A Switch should not be tied to a bulb, instead it should be able to turn on/off other devices too - like fans, AC's, etc.
        Instead, we should follow the Dependency Inversion principle and create an abstraction that both ElectricPowerSwitch and LightBulb can depend on.

        To do this, we'll create a Switchable interface that is implemented by LightBulb
            Instead of ElectricPowerSwitch referencing 'LightBulb' as a dependency, it will reference 'Switchable'
     */

}
