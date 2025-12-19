package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService{


    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);
    WarrantyClaimRecord updateStatus(Long id,string status);
    WarrantyClaimRecord getClaimById(WarrantyClaimRecord id);
    WarrantyClaimRecord getClaimBySerial(WarrantyClaimRecord serialNumber);
    WarrantyClaimRecord getAllClaims();
   
}
