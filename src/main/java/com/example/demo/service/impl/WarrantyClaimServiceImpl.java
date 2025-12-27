package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private Map<Long, WarrantyClaimRecord> claims = new HashMap<>();

    @Override
    public FraudAlertRecord createFraudAlertFromClaim(WarrantyClaimRecord claim) {
        // Use correct constructor
        return new FraudAlertRecord(
                claim.getId(),
                claim.getSerialNumber(),
                "WarrantyClaimAlert",
                claim.getClaimReason(),
                "ExtraInfo"
        );
    }

    @Override
    public void updateClaimStatus(WarrantyClaimRecord c, String status) {
        c.setStatus(status);
    }
}
