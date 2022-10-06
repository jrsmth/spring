package com.jrsmiffy.springguru.solid.interfaceSegregation.good;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ToyBuilderTest {

    @Test
    public void testBuildToyHouse() {
        ToyHouse toyHouse = ToyHouse.builder().color("white").price(450_000).build();
        log.info(toyHouse.toString());
    }

    @Test
    public void testBuildToyCar() {
        ToyCar toyCar = ToyCar.builder().colour("red").price(7_500).build();
        log.info(toyCar.toString());

        toyCar.move();
    }

    @Test
    public void testBuildToyPlane() {
        ToyPlane toyPlane = ToyPlane.builder().colour("white").price(22_000_000).build();
        log.info(toyPlane.toString());

        toyPlane.fly();
        toyPlane.move();
    }

}
