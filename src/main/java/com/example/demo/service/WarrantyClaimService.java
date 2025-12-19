package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService{


    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);
    WarrantyClaimRecord updateStatus(Long id,string status);
    WarrantyClaimRecord getClaimById(Long id);
    List<WarrantyClaimRecord> getClaimBySerial(String serialNumber);
    List<WarrantyClaimRecord> getAllClaims();
   
}
