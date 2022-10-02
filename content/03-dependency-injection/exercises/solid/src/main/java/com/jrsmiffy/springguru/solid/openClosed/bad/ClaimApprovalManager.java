package com.jrsmiffy.springguru.solid.openClosed.bad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClaimApprovalManager {

    public void processHealthClaim (HealthInsuranceSurveyor surveyor) {
        if(surveyor.isValidClaim()){
            log.info("ClaimApprovalManager :: Valid claim. Currently processing claim for approval...");
        }
    }

}