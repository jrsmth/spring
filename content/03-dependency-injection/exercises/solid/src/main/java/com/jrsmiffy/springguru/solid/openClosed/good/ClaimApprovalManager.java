package com.jrsmiffy.springguru.solid.openClosed.good;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClaimApprovalManager {

    public void processClaim(InsuranceSurveyor surveyor) {
        if(surveyor.isValidClaim()){
            log.info("ClaimApprovalManager: Valid claim. Currently processing claim for approval...");
        }
    }

}