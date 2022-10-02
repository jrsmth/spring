package com.jrsmiffy.springguru.solid.openClosed.bad;

import lombok.extern.slf4j.Slf4j;

/**
 * Responsible for approving health insurance claims
 */
@Slf4j
public class ClaimApprovalManager {

    public void processHealthClaim (HealthInsuranceSurveyor surveyor) {
        if(surveyor.isValidClaim()){
            log.info("ClaimApprovalManager :: Valid claim. Currently processing claim for approval...");
        }
    }

    /**
     * This class risks violating the Open Close Principle:
     * Consider a new requirement to process a new type of insurance claims, e.g. Vehicle
     * We could add a new 'VehicleInsuranceSurveyor' (fine)
     * but need to modify ClaimApprovalManager to now handle the new claim types - this violates Open Closed
     * Instead, we could have designed a ClaimApprovalManager::processClaim() method to rely on an abstract class
     */

    /*
 note: Modification of the ClaimApprovalManager functionality violates Open Closed
//    public void processVehicleClaim (VehicleInsuranceSurveyor surveyor)    {
//        if(surveyor.isValidClaim()){
//            System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
//        }
//    }
    */

}