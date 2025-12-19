package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.WarrantyClaim;

public interface WarrantyClaimService


{
    public WarrantyClaim updateClaimStatus(WarrantyClaim claimId,status);
    public WarrantyClaim getClaimById(WarrantyClaim id);
    public WarrantyClaim getClaimBySerial(WarrantyClaim serialNumber);
    public WarrantyClaim getAllClaims();
}