package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService{


    WarrantyClaimRecord updateClaimStatus(WarrantyClaim claimId,status);
    WarrantyClaimRecord updateClaimStatus(WarrantyClaim claimId,status);
    WarrantyClaimRecord getClaimById(WarrantyClaim id);
    WarrantyClaimRecord getClaimBySerial(WarrantyClaim serialNumber);
    WarrantyClaimRecord getAllClaims();
   
}
