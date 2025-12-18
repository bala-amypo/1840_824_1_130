package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.WarrantyClaim;

public interface WarrantyClaimService


{
    public WarrantyClaim registerUser(WarrantyClaim req);
    public WarrantyClaim loginUser(WarrantyClaim req);
}