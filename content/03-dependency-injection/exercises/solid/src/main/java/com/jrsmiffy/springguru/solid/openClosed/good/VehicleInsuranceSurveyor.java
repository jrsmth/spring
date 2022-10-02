package com.jrsmiffy.springguru.solid.openClosed.good;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleInsuranceSurveyor extends InsuranceSurveyor {

    public boolean isValidClaim(){
        log.info("VehicleInsuranceSurveyor: Validating vehicle insurance claim...");
        // Logic to validate vehicle insurance claims

        return true;
    }

}